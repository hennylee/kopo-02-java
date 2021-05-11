package menu;

import manager.AdminManager;
import manager.BookManager;
import util.InputUtil;

public class AdminMenu {
	
	AdminManager am = new AdminManager();
	BookManager bm = new BookManager();
	
	/**
	 * 관리자 첫 접속 메뉴 :  1.로그인  2. 회원가입 
	 */
	public void notLoginAdminMenu() {
		//  1.로그인  2. 회원가입 
		int menu = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1.로그인 2. 회원가입) ");
		
		while(true) {
			switch(menu) {
				// 1. 로그인
				case 1:
					am.AdminLogIn();
					
					// 로그인 성공했을 때
					if(am.loginStatus) {
						LoginAdminMenu();
					}
					
					break;
				// 2. 회원가입
				case 2:
					am.MyAdminJoin();
					break;	
				default:
					return;
			}
			break;
		}
	
	}	
	
	/**
	 * 로그인 되었을 때( 1.회원관리  2. 도서관리  3. 로그아웃)
	 */
	public void LoginAdminMenu() {
		int menu = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1. 회원 관리  2. 도서관리  3. 로그아웃 ) ");
		
		while(true) {
			switch(menu) {
				// 1. 회원 관리
				case 1:
					AdminUserMenu();
					break;
				// 2. 도서관리
				case 2:
					AdminBookMenu();
					break;
				// 3. 로그아웃
				case 3:
					am.AdminLogOut();
					break;
				default:
					return;
			}
			break;
		}
		
		
	}
	/**
	 * [로그인 되었을 때 - 회원 관리] 선택했을 때 메뉴( 1.내 정보관리  2. 일반회원 관리 3. 관리자 관리 4. 로그아웃)
	 * @param args
	 */
	public void AdminUserMenu() {
		int choice;
		while(am.loginStatus) {
			choice = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1.내 정보관리  2. 일반회원 관리 3. 관리자 관리 4. 로그아웃) ");
			
			switch(choice) {
			case 1:
				// 내정보 관리
				myAdminMenu();
				break;
			case 2:
				// 일반회원 관리
				MemberMenu();
				break;
			case 3:
				// 관리자 관리
				AdminMenu();
				break;
			case 4:
				// 로그아웃
				am.AdminLogOut();
				break;
			default:
				return;
			}
			
		}
	}	
	

	/**
	 * [로그인 되었을 때 - 회원 관리 - 일반회원 관리] 선택했을 때 메뉴( 1.회원 추가  2. 회원 삭제 3. 회원 수정  4. 로그아웃)
	 * @param args
	 */
	public void MemberMenu() {
		int choice;
		while(am.loginStatus) {
			choice = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1.회원 추가  2. 회원 삭제 3. 회원 수정  4. 로그아웃) ");
			
			switch(choice) {
			case 1:
				am.MemberJoin();
				break;
			case 2:
				am.MemberOut();
				break;
			case 3:
				am.MemberEdit();
				break;
			case 4:
				// 로그아웃
				am.AdminLogOut();
				break;
			default:
				continue;
			}
			
		}
	}	
	/**
	 * [로그인 되었을 때 - 회원 관리 - 관리자 회원 관리] 선택했을 때 메뉴( 1.관리자 추가   2. 관리자 삭제  3. 관리자 수정  4. 로그아웃)
	 * @param args
	 */
	public void AdminMenu() {
		int choice;
		while(am.loginStatus) {
			choice = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1.관리자 추가   2. 관리자 삭제  3. 관리자 수정  4. 로그아웃) ");
			
			switch(choice) {
			case 1:
				am.AdminJoin();
				break;
			case 2:
				am.AdminOut();
				break;
			case 3:
				am.AdminEdit();
				break;
			case 4:
				am.AdminLogOut();
				break;
			default:
				return;
			}
			
		}
	}	
	/**
	 * [로그인 되었을 때 - 회원 관리 - 개인정보 관리] 선택했을 때 메뉴( 1.회원 탈퇴  2. 회원정보 수정 3. 로그아웃)
	 * @param args
	 */
	public void myAdminMenu() {
		int choice;
		while(am.loginStatus) {
			choice = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1.회원 탈퇴  2. 회원정보 수정 3. 로그아웃) ");
			
			switch(choice) {
			case 1:
				// 회원탈퇴
				am.MyAdminOut();
				break;
			case 2:
				// 회원정보 수정
				am.MyAdminEdit();
				break;
			case 3:
				// 로그아웃
				am.AdminLogOut();
				break;
			default:
				return;
			}
			
		}
	}	

	
	
	/**
	 * [로그인 되었을 때 - 도서관리] 선택했을 때 메뉴( 1. 도서 등록  2. 도서 삭제 	3. 연체 조회 	4. 대출조회 )
	 */
	public void AdminBookMenu() {
		int choice;
		while(am.loginStatus) {
			choice = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1. 도서 등록  2. 도서 삭제 	3. 연체 조회 	4. 대출조회 	5. 도서 검색  6. 로그아웃) ");
			
			switch(choice) {
			case 1:
				am.registerBook();
				break;
			case 2:
				am.deleteBook();
				break;
			case 3:
				am.getOverdueList();
				break;
			case 4:
				am.getReserveList();
				break;
			case 5:
				// 도서 검색
				bm.searchBook();	
				break;
			case 6:
				// 로그아웃
				am.AdminLogOut();	
				break;
			default:
				return;
			}
			
		}
	}
	
	
		
}
