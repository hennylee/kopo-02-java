package kr.ac.kopo.ui;

public class HanaMemberUI extends BaseUI{
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			
			int type = menu();
			IBankUI ui = null;
			
			switch(type) {
			case 1:
				// ui = new oftenAccountUI();
				break;
			case 2:
				ui = new MyAccountUI();
				break;
			case 3:
				ui = new OpenBankingUI();
				break;
			case 4:
				ui = new MyMemberUI();
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
		System.out.println("\t하나은행 온라인 뱅킹 회원 시스템");
		System.out.println("-------------------------------");
		System.out.println("\t1. 자주 쓰는 계좌");
		System.out.println("\t2. 하나계좌 서비스");
		System.out.println("\t3. 통합계좌 서비스");
		System.out.println("\t4. 내 회원정보 관리");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}
}
