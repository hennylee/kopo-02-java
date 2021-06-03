package kr.ac.kopo.ui;

import kr.ac.kopo.ui.account.CreateAccountUI;
import kr.ac.kopo.ui.account.DeleteAccountUI;
import kr.ac.kopo.ui.account.SearchAccountUI;
import kr.ac.kopo.ui.account.UpdateAccountUI;

public class MyAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		while(true) {
			
			int type = menu();
			IBankUI ui = null;
			
			switch(type) {
			case 1:
				ui = new SearchAccountUI();
				break;
			case 2:
				ui = new DeleteAccountUI();
				break;
			case 3:
				ui = new UpdateAccountUI();
				break;
			case 4:
				ui = new CreateAccountUI();
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
		System.out.println("\t하나계좌 관리시스템");
		System.out.println("-------------------------------");
		System.out.println("\t1. 계좌 조회");
		System.out.println("\t2. 계좌 해지");
		System.out.println("\t3. 계좌 수정");
		System.out.println("\t4. 계좌 개설");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}
	
}
