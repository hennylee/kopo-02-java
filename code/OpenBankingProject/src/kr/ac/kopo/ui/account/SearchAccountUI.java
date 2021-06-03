package kr.ac.kopo.ui.account;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.ui.ExitUI;
import kr.ac.kopo.ui.IBankUI;

public class SearchAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		/*
		List<AccountVO> list = new ArrayList<>();
		
		
		// 나의 전체 계좌 리스트
		startLine(new SessionFactory().getSession().getId() + "님의 전체 계좌 목록입니다.");
		list = accountService.searchByID();
		
		System.out.printf("%-20s %-8s %-10s %-15s %-23s", "계좌번호", "별칭", "잔액", "자주쓰는 계좌", "이체 한도");
		System.out.println();
		for(AccountVO vo : list) {
			System.out.printf("%-20s %-8s %-20d %-15s %-20d", 
					vo.getAccountNumber() ,vo.getAlias() , vo.getBalance() , vo.getOftenUsed(), vo.getLimitAmount());
			System.out.println();
		}
		
		endLine("");
		
		*/
		
		while(true) {
			
			int type = menu();
			IBankUI ui = null;
			
			switch(type) {
			case 1:
				ui = new SearchAllAcntUI();
				break;
			case 2:
				ui = new SearchOneAcntUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}
			
			ui.execute();
			
		}
		
		
	}
	private int menu() {
		System.out.println("-------------------------------");
		System.out.println("\t하나은행 계좌 조회 시스템");
		System.out.println("-------------------------------");
		System.out.println("\t1. 전체 계좌 조회");
		System.out.println("\t2. 계좌 번호로 검색");
		System.out.println("\t4. 계좌 개설");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}
	
}
