package kr.ac.kopo.menu;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {


	public static void main(String[] args) throws IOException {
		
		// 1단계 : 로그인/회원가입 선택
		
		while(true) {			
			System.out.println("안녕하세요. 원하시는 서비스를 선택하세요. [1] 로그인 [2] 회원가입");
			
			MembershipMenu mm = new MembershipMenu();
			
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				//mm.Login();
				break;
			case 2:
				mm.SignUp();
				continue;
			}
		}
		
		
		
	}
}