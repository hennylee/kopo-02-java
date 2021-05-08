package menu;

import util.InputUtil;

public class MainMenu {
	

	public static void main(String[] args) {
		MemberMenu mm = new MemberMenu();
		AdminMenu am = new AdminMenu();

		// 첫 접속 화면 : 1. 관리자 2. 일반회원 
		int mode = InputUtil.InputInt("원하는 모드를 선택하세요 ( 1. 일반, 2. 관리자 )");
		
		while(true) {
			switch(mode) {
				// 1. 일반회원
				case 1:
					mm.notLoginMemberMenu();
					break;
				// 2. 관리자
				case 2:
					am.notLoginAdminMenu();
					break;
				default:
					return;
			}
		}
	}
	
	
	
	
	
	
	
	
}
