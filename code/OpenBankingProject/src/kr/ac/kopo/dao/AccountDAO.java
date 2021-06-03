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
		sb.append("ACCOUNT_NUMBER, MEMBER_ID, ACCOUNT_PW, BALANCE, ALIAS, OFTEN_USED, TYPE) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
		
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getAccountNumber());
			pstmt.setString(2, vo.getMemberID());
			pstmt.setInt(3, vo.getAccountPW());
			pstmt.setInt(4, vo.getBalance());
			pstmt.setString(5, vo.getAlias());
			pstmt.setString(6, vo.getOftenUsed());
			pstmt.setInt(7, vo.getType());
			
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
	// 한달 내 계좌 개설한 적 있는지 확인하기 : getHistory
	public int getHistory() {
		
		int cnt = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*) FROM OPENING_HISTORY ");
		sb.append("WHERE RESIDENT_NUMBER = ? ");
		sb.append("AND OPENING_DATE + 30 > SYSDATE ");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, new SessionFactory().getSession().getResidentNumber());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("getHistoryDAO 에러...");
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	// 개설한 계좌 통합 시스템에 등록하기 registerHistory()
	public void registerHistory(String accountNum) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO OPENING_HISTORY VALUSE( ");
		sb.append("SELECT OPENING_HISTORY_SEQ.NEXTVAL ,RESIDENT_NUMBER, ACCOUNT_NUMBER, 0 , OPENING_DATE, NAME ");
		sb.append("FROM HANA_MEMBER M, HANA_ACCOUNT A ");
		sb.append("WHERE M.ID = A.MEMBER_ID AND A.ACCOUNT_NUMBER = ? ) ");
		
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
	public List<AccountVO> searchByID() {
		
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
				vo.setType(rs.getInt(9));
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			System.out.println("AccountDAO.searchMyAll() 오류...");
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	// 계좌 번호로 찾기 : searchByAcntNum
	public AccountVO searchByAcntNum(String searchNum) {
		
		AccountVO vo = new AccountVO();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM HANA_ACCOUNT WHERE ACCOUNT_NUMBER = ? ");
		sb.append("AND MEMBER_ID = ? ");
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, searchNum);
			pstmt.setString(2, new SessionFactory().getSession().getId());
			
			ResultSet rs = pstmt.executeQuery();
			
			boolean hasFound = rs.next();
			
			if(!hasFound) {
				return null;
			}
			
			vo.setAccountNumber(rs.getString(1));
			vo.setMemberID(rs.getString(2));
			vo.setAccountPW(rs.getInt(3));
			vo.setBalance(rs.getInt(4));
			vo.setAlias(rs.getString(5));
			vo.setOftenUsed(rs.getString(6));
			vo.setLimitAmount(rs.getInt(7));
			vo.setOpeningDate(rs.getDate(8));
			vo.setType(rs.getInt(9));
		
			
			
		} catch (Exception e) {
			System.out.println("AccountDAO.searchByAcntNum() 오류...");
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
	// 계좌 별칭 수정하기
	public void updateAlias(String targetAcnt, String newName) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("UPDATE HANA_ACCOUNT SET ALIAS = ? WHERE ACCOUNT_NUMBER = ? AND MEMBER_ID = ?");
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, newName);
			pstmt.setString(2, targetAcnt);
			pstmt.setString(3, new SessionFactory().getSession().getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AccountDAO.updateAlias 오류...");
			e.printStackTrace();
		}
		
	}
	
	// 계좌 잔액 존재하는지 확인 : checkBalance(targetAcnt, targetPW)
	public int checkBalance(String targetAcnt, String targetPW) {
		
		int balance = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT BALANCE FROM HANA_ACCOUNT ");
		sb.append("WHERE ACCOUNT_NUMBER = ? AND ACCOUNT_PW = ? AND MEMBER_ID = ?");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, targetAcnt);
			pstmt.setString(2, targetPW);
			pstmt.setString(3, new SessionFactory().getSession().getId());
			
			ResultSet rs = pstmt.executeQuery();
			
			boolean hasFound = rs.next();
			
			if(!hasFound) {
				return -1;
			}
			
			balance = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("checkBalance 에러...");
			e.printStackTrace();
		}
		return balance;
	}
	
	// 계좌 삭제하기
	public void deleteAcnt(String targetAcnt, String targetPW) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM HANA_ACCOUNT WHERE ACCOUNT_NUMBER = ? AND ACCOUNT_PW = ? AND MEMBER_ID = ? ");
		
		try {
			Connection conn = new DBConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, targetAcnt);
			pstmt.setString(2, targetPW);
			pstmt.setString(3, new SessionFactory().getSession().getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("AccountDAO.deleteAcnt 오류...");
			e.printStackTrace();
		}
		
	}
	
	
}
