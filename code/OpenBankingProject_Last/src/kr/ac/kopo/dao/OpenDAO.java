package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.DBConnectionFactory;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.TotalAcntVo;

public class OpenDAO {
	
	// 서비스 가입 내역 확인
	public int hasRegister(String id) {
		
		int cnt = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*) FROM HANA_OPEN_BANKING_MEMBER WHERE MEMBER_ID = ?");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, id);
			ResultSet rs =  pstmt.executeQuery();
			
			rs.next();
			cnt = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("OpenDAO.hasRegister 에러...");
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	// 서비스 가입
	public void joinOpen(MemberVO vo, int pw) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO HANA_OPEN_BANKING_MEMBER ");
		sb.append("VALUES(? , ? )");

		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
				
		) {
			
			pstmt.setString(1, vo.getId() );
			pstmt.setInt(2, pw);
			
			pstmt.executeUpdate();
			
		} catch(Exception e){
			System.out.println("joinOpen 에러...");
			e.printStackTrace();
		}
	}
	
	// 전체은행 계좌 확인 getTotal
	public List<TotalAcntVo> getTotal(String resiNum) {
		
		List<TotalAcntVo> list = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT RESIDENT_NUMBER,ACCOUNT_NUMBER, B.NAME , O.NAME ");
		sb.append("FROM OPENING_HISTORY O, BANK B ");
		sb.append("WHERE O.BANK_CODE = B.CODE ");
		sb.append("AND RESIDENT_NUMBER = ? ");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, resiNum);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TotalAcntVo vo = new TotalAcntVo();
				
				vo.setResidentNumber(rs.getString(1));
				vo.setAccountNumber(rs.getString(2));
				vo.setBankName(rs.getString(3));
				vo.setName(rs.getString(4));

				list.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("AccountDAO.searchMyAll() 오류...");
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	// 통합계좌에 등록 가능한지 확인 alreadyRegist(bankName, acntNum, id)
	public int alreadyRegist(String bankName, String acntNum, String id) {
		
		int cnt = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*) FROM HANA_OPEN_BANKING_ACCOUNT A, BANK B ");
		sb.append("WHERE A.BANK_CODE = B.CODE ");
		sb.append("AND B.NAME = ? ");
		sb.append("AND A.ACCOUNT_NUMBER = ? ");
		sb.append("AND A.MEMBER_ID = ? ");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, bankName);
			pstmt.setString(2, acntNum);
			pstmt.setString(3, id);
			
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("alreadyRegist 에러...");
			e.printStackTrace();
		}
		return cnt;
	}
	
	// registerAcnt(bankName, acntNum, id)
	public void registerAcnt(String bankName, String acntNum, String residentNum ,String id) {
		
		StringBuilder sb = new StringBuilder();
		
		// 출금 제한액 디폴트 10만원
		sb.append("INSERT INTO HANA_OPEN_BANKING_ACCOUNT ");
		sb.append("(OPEN_ACNT_SEQ, MEMBER_ID, BANK_CODE, ACCOUNT_NUMBER) ");
		sb.append("SELECT OPEN_B_ACNT_SEQ.NEXTVAL, A.MEMBER_ID, B.CODE, H.ACCOUNT_NUMBER ");
		sb.append("FROM OPENING_HISTORY H , BANK B, HANA_ACCOUNT A ");
		sb.append("WHERE H.BANK_CODE = B.CODE ");
		sb.append("AND B.NAME = ? ");
		sb.append("AND H.ACCOUNT_NUMBER = ? ");
		sb.append("AND H.RESIDENT_NUMBER = ? ");
		sb.append("AND A.MEMBER_ID = ? ");
		
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, bankName);
			pstmt.setString(2, acntNum);
			pstmt.setString(3, residentNum);
			pstmt.setString(4, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("registerAcnt 오류...");
			e.printStackTrace();
		}
		
	}
	
	
}
