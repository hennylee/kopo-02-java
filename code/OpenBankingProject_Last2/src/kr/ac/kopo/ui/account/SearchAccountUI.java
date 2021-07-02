package kr.ac.kopo.ui.account;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.ui.ExitUI;
import kr.ac.kopo.ui.IBankUI;

public class SearchAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		while(true) {
		
			int type = menu();
			IBankUI ui = null;
			
			switch(type) {
			case 1:
				ui = new SearchAllAcntUI();
				break;
			case 2:
				ui = new SearchNumAcntUI();
				break;
			case 3:
				ui = new SearchBankAcntUI();
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
		System.out.println("통합계좌 관리시스템(계좌조회)");
		System.out.println("-------------------------------");
		System.out.println("\t1. 전체 계좌 조회");
		System.out.println("\t2. 계좌번호로 검색");
		System.out.println("\t3. 은행으로 검색");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("ㅁ 메뉴 중 원하는 항목을 선택하세요 : ", "^[0-3]{1}$");
		
		return type;
	}
	
}
