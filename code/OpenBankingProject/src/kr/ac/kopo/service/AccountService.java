package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.dao.AccountDAO;
import kr.ac.kopo.vo.AccountVO;

public class AccountService {
	
	AccountDAO dao = new AccountDAO();
	
	// 계좌 개설 : createAccount
	public void createAccount(AccountVO vo) {
		
		// 계좌 개설
		dao.createAccount(vo);
		
		// 통합 계좌 시스템에 등록
		dao.registerHistory(vo.getAccountNumber());
		
	}
	
	
	// 계좌 번호 생성
	public String getNewAcntNum(int choice) {
		
		// 앞 3자리 = 지점
		String front = "111"; // 온라인 지점은 111로 고정,  오프라인 프로그램까지 만든다면 테이블 생성 필요..
		
		// 중간 9자리 => 시퀀스		
		String middle = dao.getMidAcntNum();
		
		// 마지막 2자리 = 상품 유형
		String product = "";
		
		switch(choice) {
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
	
	
	// 내 계좌 전체 리스트 찾기
	public List<AccountVO> searchMyAll() {
		
		List<AccountVO> list = new ArrayList<>();
		
		list = dao.searchMyAll();
		
		return list;
	}
}
