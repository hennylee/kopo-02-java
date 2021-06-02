package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.DBConnectionFactory;
import kr.ac.kopo.util.SessionFactory;
import kr.ac.kopo.vo.AccountVO;

public class AccountDAO {
	
	// 계좌 개설 : 자주쓰는 계좌 등록
	public void createAccount(AccountVO vo) {
		
		StringBuilder sb = new StringBuilder();
		
		// 출금 제한액 디폴트 10만원
		sb.append("INSERT INTO HANA_ACCOUNT( ");
		sb.append("ACCOUNT_NUMBER, MEMBER_ID, ACCOUNT_PW, BALANCE, ALIAS, OFTEN_USED) ");
		sb.append("VALUSE(?, ?, ?, ?, ?, ?)");
		
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getAccountNumber());
			pstmt.setString(2, vo.getMemberID());
			pstmt.setInt(3, vo.getAccountPW());
			pstmt.setInt(4, vo.getBalance());
			pstmt.setString(5, vo.getAlias());
			pstmt.setString(6, vo.getOftenUsed());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AccountDAO.createAccount 오류...");
			e.printStackTrace();
		}
		
	}
	
	
	// 계좌 중간 번호 생성
	public String getMidAcntNum() {
		String midNum = "";
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT TO_CHAR(HANA_ACNT_CODE_SEQ.NEXTVAL, 'FM000000000') FROM DUAL");
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			midNum = rs.getString(1);
			
		} catch (Exception e) {
			System.out.println("AccountDAO.getMidAcntNum 오류");
			e.printStackTrace();
		}
		
		return midNum;
	}
	
	
	// 계좌 마지막 2자리 번호 생성 : 상품 코드 받기
	public String getTypeCode(String product) {
		String typeCode = "";
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT TO_CHAR(CODE, 'FM000') FROM HANA_PRODUCT WHERE NAME = ? ");
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, product);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			typeCode = rs.getString(1);
			
		} catch (Exception e) {
			System.out.println("AccountDAO.getLastAcntNum 오류");
			e.printStackTrace();
		}
		
		return typeCode;
	}
	
	
	// 개설한 계좌 통합 시스템에 등록하기 registerHistory()
	public void registerHistory(String accountNum) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO OPENING_HISTORY VALUSE( ");
		sb.append("SELECT RESIDENT_NUMBER, ACCOUNT_NUMBER, 0 , OPENING_DATE, NAME ");
		sb.append("FROM HANA_MEMBER, HANA_ACCOUNT ");
		sb.append("WHERE ID = (SELECT MEMBER_ID FROM HANA_ACCOUNT WHERE ACCOUNT_NUMBER = ?)) ");
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, accountNum);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AccountDAO.registerHistory 오류...");
			e.printStackTrace();
		}
		
	}
	
	
	
	// 전체 내 계좌 찾기
	public List<AccountVO> searchMyAll() {
		
		List<AccountVO> list = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM HANA_ACCOUNT WHERE MEMBER_ID = ? ");
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, new SessionFactory().getSession().getId());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AccountVO vo = new AccountVO();
				
				vo.setAccountNumber(rs.getString(1));
				vo.setMemberID(rs.getString(2));
				vo.setAccountPW(rs.getInt(3));
				vo.setBalance(rs.getInt(4));
				vo.setAlias(rs.getString(5));
				vo.setOftenUsed(rs.getString(6));
				vo.setLimitAmount(rs.getInt(7));
				vo.setOpeningDate(rs.getDate(8));
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			System.out.println("AccountDAO.searchMyAll() 오류...");
			e.printStackTrace();
		}
		
		return list;
		
	}
}
