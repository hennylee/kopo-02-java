package kr.ac.kopo.ui;

import kr.ac.kopo.ui.account.AccountUI;
import kr.ac.kopo.ui.banking.BankingUI;

public class MemberUI extends BaseUI{
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			
			int type = menu();
			IBankUI ui = null;
			
			switch(type) {
			case 1:
				ui = new AccountUI();
				break;
			case 2:
				ui = new BankingUI();
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
		System.out.println("통합계좌 관리시스템(회원 시스템)");
		System.out.println("-------------------------------");
		System.out.println("\t1. 계좌관리 서비스");
		System.out.println("\t2. 은행거래 서비스");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("ㅁ 메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}
}
