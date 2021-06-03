package kr.ac.kopo.ui;

import kr.ac.kopo.ui.member.JoinUI;
import kr.ac.kopo.ui.member.LoginUI;

public class onlineUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		// 온라인 뱅킹 메인
		while(true) {
			
			int type = menu();
			IBankUI ui = null;
			
			switch(type) {
			case 1:
				ui = new LoginUI();
				break;
			case 2:
				ui = new JoinUI();
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
		System.out.println("통합계좌 관리시스템(메인)");
		System.out.println("-------------------------------");
		System.out.println("\t1. 로그인");
		System.out.println("\t2. 회원가입");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("ㅁ 메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}
}
