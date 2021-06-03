package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import kr.ac.kopo.util.DBConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {

	// 아이디 체크
	public int idExist(String id) {
		
		int cnt = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*) FROM HANA_MEMBER WHERE ID = ?");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, id);
			ResultSet rs = null;
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("idCheckDAO 에러...");
			e.printStackTrace();
		}
		return cnt;
	}
	
	// 패스워드 체크
	public int pwExist(String id, String pw) {
		
		int cnt = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*) FROM HANA_MEMBER WHERE ID = ? AND PW = ?");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = null;
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("pwCheckDAO 에러...");
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	// 회원가입
	public void join(MemberVO member) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO HANA_MEMBER(ID, PW, RESIDENT_NUMBER, NAME, AGE, SEX)");
		sb.append("VALUES(?, ?, ?, ?, ? , ?)");

		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
				
		) {
			
			String id = member.getId() ;
			String pw = member.getPw();
			String residentNumber = member.getResidentNumber();
			String name = member.getName();
			int age = member.getAge();
			String sex = member.getSex();
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, residentNumber);
			pstmt.setString(4, name);
			pstmt.setInt(5, age);
			pstmt.setString(6, sex);
			
			pstmt.executeUpdate();
			
		} catch(Exception e){
			System.out.println("joinDAO 에러...");
			e.printStackTrace();
		}
	}
	
	

	// 로그인
	public MemberVO login(String id, String pw) {

		MemberVO member = new MemberVO();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM HANA_MEMBER WHERE ID = ? AND pw = ?");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
				
		) {

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs = pstmt.executeQuery();
			
			boolean hasFound = rs.next();
			
			if(!hasFound) {
				return null;
			}
			
			String residentNumber = rs.getString("RESIDENT_NUMBER");
			String name = rs.getString("NAME");
			int age = rs.getInt("AGE");
			String sex = rs.getString("SEX");
			Date joinDate = rs.getDate("JOIN_DATE");
			
			member.setId(id);
			member.setPw(pw);
			member.setResidentNumber(residentNumber);
			member.setName(name);
			member.setAge(age);
			member.setSex(sex);
			member.setJoinDate(joinDate);
			
		} catch(Exception e){
			System.out.println("loginDAO 에러...");
			e.printStackTrace();
		}
		return member;
	}
}
