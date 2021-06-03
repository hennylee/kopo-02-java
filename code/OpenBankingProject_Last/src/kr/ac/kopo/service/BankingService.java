package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.dao.AccountDAO;
import kr.ac.kopo.dao.BankingDAO;
import kr.ac.kopo.vo.BankingVO;
import kr.ac.kopo.vo.LogVO;

public class BankingService extends BaseService{
	BankingDAO dao = new BankingDAO();
	AccountDAO acntDao = new AccountDAO();
	
	// 거래 주체 검색
	public int searchOwner(String myAcnt, String myBank) {
		return dao.searchOwner(myAcnt, myBank);
	}
	
	// 입금
	public String deposit(BankingVO vo) {
		
		String msg = "";
			
		// 0원보다 적으면 에러
		if(vo.getAmount() < 0) {
			msg = "0원 이상만 입금 가능 합니다.";
		}
		else {
			
			// 내 은행명 코드로 변환하기
			int ownerBankCode = acntDao.findBankCode(vo.getOwnerBank());
			vo.setOwnerCode(ownerBankCode);

			int targetBankCode = ownerBankCode;
			vo.setTargetCode(targetBankCode);
			
			// 내 기존 잔액 구하기
			int ownerOldBal= dao.getBalance(vo.getOwnerAccount(), vo.getOwnerBank());
			vo.setOwnerBalance(ownerOldBal);
			
			msg = dao.deposit(vo);
			
			if(msg.isEmpty()) {
				msg = "정상 처리 되었습니다.";
			}
		}
	
		return msg;	
		
	}	
	
	// 출금
	public String withdraw(BankingVO vo) {
		
		String msg = "";
		
		// 내 잔액보다 보낼 금액이 많으면 에러
		if(dao.getBalance(vo.getOwnerAccount(), vo.getOwnerBank()) < 0) {
			msg = "잔액이 부족합니다.";
		}
		else {
			
			// 내 은행명 코드로 변환하기
			int ownerBankCode = acntDao.findBankCode(vo.getOwnerBank());
			vo.setOwnerCode(ownerBankCode);

			int targetBankCode = ownerBankCode;
			vo.setTargetCode(targetBankCode);
			
			// 내 기존 잔액 구하기
			int ownerOldBal= dao.getBalance(vo.getOwnerAccount(), vo.getOwnerBank());
			vo.setOwnerBalance(ownerOldBal);
			
			msg = dao.withdraw(vo);
			
			if(msg.isEmpty()) {
				msg = "정상 처리 되었습니다.";
			}
		}
	
		
		return msg;	
		
	}
	
	// 계좌이체
	public String transfer(BankingVO vo) {
		
		String msg = "";
		
		// OPENING_HISTORY에서 상대방 조회 => 존재 안하면 에러
		int cnt = dao.searchTarget(vo);
		
		// 상대 계좌가 존재하지 않는 경우
		if(cnt == 0) {
			msg = "상대 계좌가 존재하지 않습니다.";
		}
		else {
			
			// 내 잔액보다 보낼 금액이 많으면 에러
			if(dao.nextBalance(vo) < 0) {
				msg = "잔액이 부족합니다.";
			}
			else {
				
				// 내 은행명 코드로 변환하기
				int ownerBankCode = acntDao.findBankCode(vo.getOwnerBank());
				vo.setOwnerCode(ownerBankCode);
				
				// 내 기존 잔액 구하기
				int ownerOldBal = dao.getBalance(vo.getOwnerAccount(), vo.getOwnerBank());
				vo.setOwnerBalance(ownerOldBal);
				
				// 상대 은행명 코드로 변환하기
				int targetBankCode = acntDao.findBankCode(vo.getTargetBank());
				vo.setTargetCode(targetBankCode);
				
				// 상대 기존 잔액 구하기
				int targetOldBal = dao.getBalance(vo.getOwnerAccount(), vo.getOwnerBank());
				vo.setTargetBalance(targetOldBal);
				
				msg = dao.transfer(vo);
				
				if(msg.isEmpty()) {
					msg = "정상 처리 되었습니다.";
				}
			}
		}
		
		return msg;	
	}
	
	// 거래 내역 getLog(myAcnt, myBank, session.getId()
	public List<LogVO> getLog(String myAcnt, String myBank) {
		
		List<LogVO> list = new ArrayList<>();
		list = dao.getLog(myAcnt, myBank);
		
		return list;
	}
}
