package kr.ac.kopo.ui;

import kr.ac.kopo.ui.openbank.*;

public class OpenBankingUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		IBankUI ui = null;
		
		// 오픈 뱅킹 서비스 미가입자
		if(openService.hasRegister() == 0) {
			// 서비스 가입
			ui = new JoinOpenUI();
			ui.execute();
		}
		
		// 오픈 뱅킹 서비스 가입자
		while(true) {
			
			int type = menu();
			
			switch(type) {
			case 1:
				ui = new SearchOpenUI();
				break;
			case 2:
				ui = new DeleteOpenUI();
				break;
			case 3:
				ui = new UpdateOpenUI();
				break;
			case 4:
				ui = new RegisterOpenUI();
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
		System.out.println("\t통합계좌 관리시스템");
		System.out.println("-------------------------------");
		System.out.println("\t1. 통합계좌 조회");
		System.out.println("\t2. 통합계좌 삭제");
		System.out.println("\t3. 통합계좌 수정");
		System.out.println("\t4. 통합계좌 등록");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}
	
}
