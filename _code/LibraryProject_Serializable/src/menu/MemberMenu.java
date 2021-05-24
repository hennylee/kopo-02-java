package menu;

import manager.MemberManager;
import util.*;

public class MemberMenu {
	MemberManager mm = new MemberManager();

	/**
	 * 일반 회원 첫 접속 메뉴 :  1.로그인  2. 회원가입 
	 */
	public void notLoginMemberMenu() {
		//  1.로그인  2. 회원가입 
		int menu = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1.로그인  2. 회원가입 ) ");
		
		while(true) {
			switch(menu) {
				// 1. 로그인
				case 1:
					mm.MemberLogIn();
					
					// 로그인 성공했을 때
					if(mm.loginStatus) {
						LoginUserMenu();
					}
					
					break;
				// 2. 회원가입
				case 2:
					mm.MemberJoin();
					break;
				default:
					return;
			}
			break;
		}
	
	}
	
	
	/**
	 * 로그인 되었을 때( 1.회원 관리  2. 도서관리 3. 로그아웃)
	 */
	public void LoginUserMenu() {
		int menu = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1.회원 관리  2. 도서관리 3. 로그아웃) ");
		
		while(true) {
			switch(menu) {
				// 1. 회원 관리
				case 1:
					myMemberMenu();
					break;
				// 2. 도서관리
				case 2:
					MemberBookMenu();
					break;
				// 3. 로그아웃
				case 3:
					mm.MemberLogOut();
					break;
				default:
					return;
			}
			break;
		}
		
		
	}
	
	
	/**
	 * [로그인 되었을 때 - 개인정보 관리] 선택했을 때 메뉴( 1.회원 탈퇴  2. 회원정보 수정 3. 로그아웃)
	 * @param args
	 */
	public void myMemberMenu() {
		int choice;
		while(mm.loginStatus) {
			choice = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1.회원 탈퇴  2. 회원정보 수정 3. 로그아웃) ");
			
			switch(choice) {
			case 1:
				// 회원탈퇴
				mm.MemberOut();
				break;
			case 2:
				// 회원정보 수정
				mm.MemberEdit();
				break;
			case 3:
				// 로그아웃
				mm.MemberLogOut();
				break;
			default:
				return;
			}
			
		}
	}
	
	/**
	 * [로그인 되었을 때 - 도서관리] 선택했을 때 메뉴( 1. 도서 대출  2. 나의 대출 관리 3. 도서 반납 4. 로그아웃 )
	 */
	public void MemberBookMenu() {
		int choice;
		while(mm.loginStatus) {
			choice = InputUtil.InputInt("[ 원하는 메뉴를 선택하세요 ] ( 1. 도서 대출  2. 나의 대출 목록 3. 도서 반납  4. 책검색  5. 로그아웃  ) ");
			
			switch(choice) {
			case 1:
				mm.ReserveBook();
				break;
			case 2:
				mm.MyReserveList();
				break;
			case 3:
				mm.MemberReturnBook();
				break;
			case 4:
				mm.SearchBook();
				break;
			case 5:
				mm.MemberLogOut();
				break;
			default:
				return;
			}
			
		}
	}
	
	
	
}
