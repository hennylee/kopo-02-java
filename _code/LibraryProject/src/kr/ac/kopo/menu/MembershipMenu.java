package kr.ac.kopo.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kr.ac.kopo.object.Member;

/**
 * 회원가입, 탈퇴, 로그인, 로그아웃 등 멤버십과 관련된 메뉴
 * @author HP
 *
 */
public class MembershipMenu {
	
	public static int membershipNumber = 1; 
	Member member = new Member();
	
	// 회원가입
	public void SignUp() throws IOException {
		
		/*
		  	private String name;
			private int membershipNumber;
			private String phone;
			private String addr;
			private String sex;
		 */
		
		// 회원 정보 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름을 입력하세요 : ");
		String name = br.readLine();
		
		System.out.print("전화번호를 입력하세요 : ");
		String phone = br.readLine();
		
		System.out.print("주소를 입력하세요 : ");
		String addr = br.readLine();
		
		System.out.print("성별을 입력하세요 : ");
		String sex = br.readLine();
		
		
		// 입력 받은 회원 정보 member 클래스에 넣기
		member.setMembershipNumber(membershipNumber++);

		member.setName(name);

		member.setPhone(phone);

		member.setAddr(addr);

		member.setSex(sex);	
		
		// 회원가입 완료 여부 확인하기
		System.out.println("회원가입을 완료하시겠습니까? [1] 예 [2] 아니오");
		String next = br.readLine();
		System.out.println(next);
		
		if(Integer.parseInt(next) == 1) {
			System.out.println("회원 가입이 완료되었습니다.");
		} else {
			System.out.println("회원 가입이 취소되었습니다.");
			membershipNumber--;
		}
	}
	
	// 로그인
	public void login() {
		
	}
	
	// if 로그인 => 로그아웃
	
	// if 로그인 => 탈퇴하기 
	
	
	
}