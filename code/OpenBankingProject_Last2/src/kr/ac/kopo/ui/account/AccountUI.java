package kr.ac.kopo.ui.account;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.ui.ExitUI;
import kr.ac.kopo.ui.IBankUI;

public class AccountUI extends BaseUI {

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
			case 5:
				ui = new RegisterUI();
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
		System.out.println("통합계좌 관리시스템(계좌관리)");
		System.out.println("-------------------------------");
		System.out.println("\t1. 계좌 조회");
		System.out.println("\t2. 계좌 해지");
		System.out.println("\t3. 계좌 수정");
		System.out.println("\t4. 계좌 개설");
		System.out.println("\t5. 계좌 등록");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("ㅁ 메뉴 중 원하는 항목을 선택하세요 : ", "^[0-5]{1}$");
		
		return type;
	}
	
}
