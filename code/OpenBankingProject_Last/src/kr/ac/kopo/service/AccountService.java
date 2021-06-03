package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.dao.AccountDAO;
import kr.ac.kopo.vo.AccountVO;

public class AccountService extends BaseService {
	
	AccountDAO dao = new AccountDAO();
	
	// 계좌 개설 : createAccount
	public void createAccount(AccountVO vo) {
		
		// 은행명 코드로 변환하기
		int bankCode = dao.findBankCode(vo.getBankName());
		vo.setBankCode(bankCode);
		
		// 현재 로그인 중인 id 넣기
		vo.setMemberID(session.getId());
		
		// 계좌 개설
		dao.createAccount(vo);
		
		// 통합 계좌 시스템에 등록
		dao.registerHistory(vo.getAccountNumber());
		
	}
	

	// 한달 내 개좌 개설한 적 없는지 확인하기 : getHistory()
	public int getHistory() {
		return dao.getHistory();
	}
	
	// 계좌 번호 생성
	public String getNewAcntNum(int type) {
		
		// 앞 3자리 = 지점
		String front = "111"; // 온라인 지점은 111로 고정,  오프라인 프로그램까지 만든다면 테이블 생성 필요..
		
		// 중간 9자리 => 시퀀스		
		String middle = dao.getMidAcntNum();
		
		// 마지막 2자리 = 상품 유형
		String product = "";
		
		switch(type) {
			case 1:
				product = "자유입출금";
				break;
			case 2:
				product = "정기예금";
				break;
			case 3:
				product = "급여";
				break;
		}
		
		String last = dao.getTypeCode(product);
		
		String newAcntNum = front +"-" + middle +"-"  + last;
		System.out.println(newAcntNum);
	
		return newAcntNum;
		
	}
	// 은행명으로 검색하기 searchByBankNum(bankName)
	public List<AccountVO> searchByBankName(String bankName) {
		
		List<AccountVO> list = new ArrayList<>();
		
		System.out.println(session.getId());
		list = dao.searchByBankName(session.getId(), bankName);
		
		return list;
	}
	
	// ID로 찾기
	public List<AccountVO> searchByID() {
		
		List<AccountVO> list = new ArrayList<>();
		list = dao.searchByID(session.getId());
		
		return list;
	}
	
	// 계좌번호로 찾기 searchOne
	public List<AccountVO> searchByAcntNum(String searchNum) {
		
		List<AccountVO> list = dao.searchByAcntNum(session.getId(), searchNum);
		
		return list;
	}
	
	// 별칭 수정하기 updateAlias
	public void updateAlias(String targetAcnt, String newName) {
		dao.updateAlias(targetAcnt, newName);
	}
	
	
	// 계좌 해지하기 deleteAcnt(targetAcnt, targetPW)
	public String deleteAcnt(String targetAcnt, String targetPW) {
		
		// 잔액이 존재하는지 확인 : 존재하면, 해지 불가! 존재하지 않으면 해지 가능
		int balance = dao.checkBalance(targetAcnt, targetPW);
		
		if(balance > 0) {
			System.out.println();
			return "fail";
		}
		
		dao.deleteAcnt(targetAcnt, targetPW);
		return "success";
	}
	
	// 계좌 등록 
	public String register(String bankName, String acntNum) {
		
		String msg = "";
		
		int cnt = dao.register(bankName, acntNum, session.getId());
		
		if(cnt == 0) {
			msg = "등록에 실패하였습니다.";
		}
		
		return msg;
		
	}
	
	// 계좌 등록 
	public List<AccountVO> notRegistered() {
		
		// 아직 등록 안한 계좌 리스트
		List<AccountVO> list = dao.notRegistered(session.getId());
		
		return list;
		
	}
	
}
