package kr.ac.kopo.ui;

public class MyMemberUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		while(true) {
			
			int type = menu();
			IBankUI ui = null;
			
			switch(type) {
			case 1:
				ui = new onlineUI();
				break;
			case 2:
				ui = new AtmUI();
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
		System.out.println("\t하나은행 뱅킹 시스템");
		System.out.println("-------------------------------");
		System.out.println("\t1. 온라인뱅킹");
		System.out.println("\t2. ATM");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}
	
}
