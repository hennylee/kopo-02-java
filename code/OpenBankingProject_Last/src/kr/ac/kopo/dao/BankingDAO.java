package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.DBConnectionFactory;
import kr.ac.kopo.vo.BankingVO;
import kr.ac.kopo.vo.LogVO;

public class BankingDAO extends BaseDAO{

	// 계좌 비밀번호 확인
	public int checkPw(String myBank, String myAcnt, int pw) {
		
		int cnt = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*) FROM HANA_ACCOUNT A, BANK B WHERE B.CODE = A.BANK_CODE ");
		sb.append("AND A.ACCOUNT_NUMBER = ? ");
		sb.append("AND B.NAME =  ? ");
		sb.append("AND A.ACCOUNT_PW = ? ");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, myAcnt);
			pstmt.setString(2, myBank);
			pstmt.setInt(3, pw);
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
	
	
	// 통합 계좌에서 상대방 조회 => 존재 안하면 = 0이면 에러
	public int searchTarget(BankingVO vo) {
		int cnt = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*) ");
		sb.append("FROM HANA_ACCOUNT A, BANK B ");
		sb.append("WHERE B.CODE = A.BANK_CODE ");
		sb.append("AND (B.NAME = ? AND ACCOUNT_NUMBER = ?) "); // 검색할 계좌
		sb.append("AND NOT(B.NAME = ? AND ACCOUNT_NUMBER = ?) "); // 내 계좌 제외
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, vo.getTargetBank());
			pstmt.setString(2, vo.getTargetAccount());
			pstmt.setString(3, vo.getOwnerBank());
			pstmt.setString(4, vo.getOwnerAccount());
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("searchTarget 에러...");
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int searchOwner(String myAcnt, String myBank, String id) {
		int cnt = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT COUNT(*) ");
		sb.append("FROM HANA_ACCOUNT A, BANK B ");
		sb.append("WHERE B.CODE = A.BANK_CODE ");
		sb.append("AND (B.NAME = ? AND ACCOUNT_NUMBER = ? AND A.MEMBER_ID = ?) "); // 검색할 계좌
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, myBank);
			pstmt.setString(2, myAcnt);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("searchOwner 에러...");
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	
	// 잔액이 부족하지 않은지 확인
	public int nextBalance(BankingVO vo) {
		int balance = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT (A.BALANCE - ?) ");
		sb.append("FROM HANA_ACCOUNT A, BANK B ");
		sb.append("WHERE B.CODE = A.BANK_CODE ");
		sb.append("AND (B.NAME = ? AND ACCOUNT_NUMBER = ?) "); // 검색할 계좌
		sb.append("AND NOT(B.NAME = ? AND ACCOUNT_NUMBER = ?) "); // 내 계좌 제외
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setInt(1, vo.getAmount());
			pstmt.setString(2, vo.getTargetBank());
			pstmt.setString(3, vo.getTargetAccount());
			pstmt.setString(4, vo.getOwnerBank());
			pstmt.setString(5, vo.getOwnerAccount());
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			balance = rs.getInt(1);
			
		} catch(Exception e){
			System.out.println("nextBalance 에러...");
			e.printStackTrace();
		}
		return balance;
	}
	
	// 기존 잔액 구하기
	public int getBalance(String account, String bankName) {
		
		int balance = -1;
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT A.BALANCE  FROM HANA_ACCOUNT A, BANK B ");
		sb.append("WHERE A.BANK_CODE = B.CODE AND A.ACCOUNT_NUMBER = ? AND B.NAME = ? ");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			
			pstmt.setString(1, account);
			pstmt.setString(2, bankName);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			balance = rs.getInt(1);
			
			
		} catch(Exception e){
			System.out.println("getBalance 에러...");
			e.printStackTrace();
		}
		return balance;
	}
	
	// deposit
	public String deposit(BankingVO vo) {
		String msg = "";
		
		// 내 계좌 잔액 변경하기
		StringBuilder sb = new StringBuilder();
		
		sb.append("UPDATE HANA_ACCOUNT ");
		sb.append("SET BALANCE = (? + ?) ");
		sb.append("WHERE ACCOUNT_NUMBER = ? AND BANK_CODE = ?  ");
		
		// 내 계좌 출금 내역에 추가하기
		StringBuilder sb2 = new StringBuilder();
		
		sb2.append("INSERT INTO HANA_BANKING_LOG( ");
		sb2.append("SEQ, OWNER_CODE, OWNER_ACCOUNT, TARGET_CODE, TARGET_ACCOUNT, AMOUNT, TYPE_CODE) ");
		sb2.append("VALUES( ");
		sb2.append("    H_BANKING_LOG_SEQ.NEXTVAL, ");
		sb2.append("    (SELECT CODE FROM BANK WHERE NAME = ? ), ? ,  ");
		sb2.append("    (SELECT CODE FROM BANK WHERE NAME = ?), ? ,  ? , ");
		sb2.append("    (SELECT CODE FROM BANKING_TYPE WHERE NAME = '입금')) ");
		
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
				PreparedStatement pstmt2 = conn.prepareStatement(sb2.toString());
		) {
			conn.setAutoCommit(false);
			
			// 내 계좌 잔액 변경하기
			pstmt.setInt(1, vo.getOwnerBalance());
			pstmt.setInt(2, vo.getAmount());
			pstmt.setString(3, vo.getOwnerAccount());
			pstmt.setInt(4, vo.getOwnerCode());

			try {
				pstmt.executeUpdate();
			} catch (Exception e) {
				msg = "내 계좌에서 입금 처리 시 에러가 발생하였습니다.";
			}
			
			// 내 계좌 출금 내역에 추가하기
			pstmt2.setString(1, vo.getOwnerBank());
			pstmt2.setString(2, vo.getOwnerAccount());
			pstmt2.setString(3, vo.getTargetBank());
			pstmt2.setString(4, vo.getTargetAccount());
			pstmt2.setInt(5, vo.getAmount());
			try {
				pstmt2.executeUpdate();
			} catch (Exception e) {
				msg = "내 계좌 로그 기록 중 에러가 발생하였습니다.";
			}
			
			if(msg.isEmpty()) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
			
			
		} catch (Exception e) {
			System.out.println("withdraw 오류...");
			e.printStackTrace();
		}
		return msg;
	}
	
	
	
	// withdraw
	public String withdraw(BankingVO vo) {
		String msg = "";
		
		// 내 계좌 잔액 변경하기
		StringBuilder sb = new StringBuilder();
		
		sb.append("UPDATE HANA_ACCOUNT ");
		sb.append("SET BALANCE = (? - ?) ");
		sb.append("WHERE ACCOUNT_NUMBER = ? AND BANK_CODE = ?  ");
		
		// 내 계좌 출금 내역에 추가하기
		StringBuilder sb2 = new StringBuilder();
		
		sb2.append("INSERT INTO HANA_BANKING_LOG( ");
		sb2.append("SEQ, OWNER_CODE, OWNER_ACCOUNT, TARGET_CODE, TARGET_ACCOUNT, AMOUNT, TYPE_CODE) ");
		sb2.append("VALUES( ");
		sb2.append("    H_BANKING_LOG_SEQ.NEXTVAL, ");
		sb2.append("    (SELECT CODE FROM BANK WHERE NAME = ? ), ? ,  ");
		sb2.append("    (SELECT CODE FROM BANK WHERE NAME = ?), ? ,  ? , ");
		sb2.append("    (SELECT CODE FROM BANKING_TYPE WHERE NAME = '출금')) ");
		
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
				PreparedStatement pstmt2 = conn.prepareStatement(sb2.toString());
		) {
			conn.setAutoCommit(false);
			
			// 내 계좌 잔액 변경하기
			pstmt.setInt(1, vo.getOwnerBalance());
			pstmt.setInt(2, vo.getAmount());
			pstmt.setString(3, vo.getOwnerAccount());
			pstmt.setInt(4, vo.getOwnerCode());

			try {
				pstmt.executeUpdate();
			} catch (Exception e) {
				msg = "내 계좌에서 출금 처리 시 에러가 발생하였습니다.";
			}
			
			// 내 계좌 출금 내역에 추가하기
			pstmt2.setString(1, vo.getOwnerBank());
			pstmt2.setString(2, vo.getOwnerAccount());
			pstmt2.setString(3, vo.getTargetBank());
			pstmt2.setString(4, vo.getTargetAccount());
			pstmt2.setInt(5, vo.getAmount());
			try {
				pstmt2.executeUpdate();
			} catch (Exception e) {
				msg = "내 계좌 로그 기록 중 에러가 발생하였습니다.";
			}
			
			if(msg.isEmpty()) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
			
			
		} catch (Exception e) {
			System.out.println("withdraw 오류...");
			e.printStackTrace();
		}
		return msg;
	}
	
	public String transfer(BankingVO vo) {
		String msg = "";
		
		// 내 계좌 잔액 변경하기
		StringBuilder sb = new StringBuilder();
		
		sb.append("UPDATE HANA_ACCOUNT ");
		sb.append("SET BALANCE = (? - ?) ");
		sb.append("WHERE ACCOUNT_NUMBER = ? AND BANK_CODE = ?  ");
		
		// 내 계좌 출금 내역에 추가하기
		StringBuilder sb2 = new StringBuilder();
		
		sb2.append("INSERT INTO HANA_BANKING_LOG( ");
		sb2.append("SEQ, OWNER_CODE, OWNER_ACCOUNT, TARGET_CODE, TARGET_ACCOUNT, AMOUNT, TYPE_CODE) ");
		sb2.append("VALUES( ");
		sb2.append("    H_BANKING_LOG_SEQ.NEXTVAL, ");
		sb2.append("    (SELECT CODE FROM BANK WHERE NAME = ? ), ? ,  ");
		sb2.append("    (SELECT CODE FROM BANK WHERE NAME = ?), ? ,  ? , ");
		sb2.append("    (SELECT CODE FROM BANKING_TYPE WHERE NAME = '계좌이체(출금)')) ");
		
		
		// 상대 계좌 잔액 증가 : autocommit = false
		StringBuilder sb3 = new StringBuilder();
		sb3.append("UPDATE HANA_ACCOUNT ");
		sb3.append("SET BALANCE = (? + ?) ");
		sb3.append("WHERE ACCOUNT_NUMBER = ? AND BANK_CODE = ?  ");
		
		// 상대 계좌 입금 내역에 추가하기
		StringBuilder sb4 = new StringBuilder();
		sb4.append("INSERT INTO HANA_BANKING_LOG( ");
		sb4.append("SEQ, OWNER_CODE, OWNER_ACCOUNT, TARGET_CODE, TARGET_ACCOUNT, AMOUNT, TYPE_CODE) ");
		sb4.append("VALUES( ");
		sb4.append("    H_BANKING_LOG_SEQ.NEXTVAL, ");
		sb4.append("    (SELECT CODE FROM BANK WHERE NAME = ? ), ? ,  ");
		sb4.append("    (SELECT CODE FROM BANK WHERE NAME = ?), ? ,  ? , ");
		sb4.append("    (SELECT CODE FROM BANKING_TYPE WHERE NAME = '계좌이체(입금)')) ");
		
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
				PreparedStatement pstmt2 = conn.prepareStatement(sb2.toString());
				PreparedStatement pstmt3 = conn.prepareStatement(sb3.toString());
				PreparedStatement pstmt4 = conn.prepareStatement(sb4.toString());
		) {
			conn.setAutoCommit(false);
			
			// 내 계좌 잔액 변경하기
			pstmt.setInt(1, vo.getOwnerBalance());
			pstmt.setInt(2, vo.getAmount());
			pstmt.setString(3, vo.getOwnerAccount());
			pstmt.setInt(4, vo.getOwnerCode());

			try {
				pstmt.executeUpdate();
			} catch (Exception e) {
				msg = "내 계좌 계좌이체 처리 시 에러가 발생하였습니다.";
			}
			// 내 계좌 출금 내역에 추가하기
			pstmt2.setString(1, vo.getOwnerBank());
			pstmt2.setString(2, vo.getOwnerAccount());
			pstmt2.setString(3, vo.getTargetBank());
			pstmt2.setString(4, vo.getTargetAccount());
			pstmt2.setInt(5, vo.getAmount());
			try {
				pstmt2.executeUpdate();
			} catch (Exception e) {
				msg = "내 계좌 로그 기록 중 에러가 발생하였습니다.";
			}
			
			// 상대 계좌 잔액 증가 : autocommit = false
			pstmt3.setInt(1, vo.getTargetBalance());
			pstmt3.setInt(2, vo.getAmount());
			pstmt3.setString(3, vo.getTargetAccount());
			pstmt3.setInt(4, vo.getTargetCode());
			
			try {
				pstmt3.executeUpdate();
			} catch (Exception e) {
				msg = "상대 계좌에 계좌이체를 실패하였습니다.";
			}
			
			// 상대 계좌 입금 내역에 추가하기
			pstmt4.setString(1, vo.getTargetBank());
			pstmt4.setString(2, vo.getTargetAccount());
			pstmt4.setString(3, vo.getOwnerBank());
			pstmt4.setString(4, vo.getOwnerAccount());
			pstmt4.setInt(5, vo.getAmount());
			try {
				pstmt4.executeUpdate();
			} catch (Exception e) {
				msg = "상대 계좌 로그 기록 중 에러가 발생하였습니다.";
			}
			
			if(msg.isEmpty()) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
			
			
		} catch (Exception e) {
			System.out.println("transfer 오류...");
			e.printStackTrace();
		}
		return msg;
	}
	
	// 로그
	public List<LogVO> getLog(String myAcnt, String myBank) {
		
		List<LogVO> list = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT LOG_DATE, AMOUNT, B.NAME, T.NAME ");
		sb.append("FROM HANA_BANKING_LOG L, BANKING_TYPE T, BANK B   ");
		sb.append("WHERE L.TYPE_CODE = T.CODE AND L.OWNER_CODE = B.CODE ");
		sb.append("AND L.OWNER_ACCOUNT = ? ");
		sb.append("AND B.NAME = ?  ORDER BY L.LOG_DATE DESC ");
		
		try(
				Connection conn = new DBConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		) {
			pstmt.setString(1, myAcnt);
			pstmt.setString(2, myBank);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LogVO vo = new LogVO();
				
				vo.setDate(rs.getDate(1));
				vo.setAmount(rs.getInt(2));
				vo.setBankName(rs.getString(3));
				vo.setLogName(rs.getString(4));
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			System.out.println("AccountDAO.searchByID() 오류...");
			e.printStackTrace();
		}
		
		return list;
		
	}
}
