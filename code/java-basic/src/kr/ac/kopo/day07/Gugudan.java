package kr.ac.kopo.day07;

import java.util.Scanner;

/**
 *  구구단에 필요한 기능을 모아둔 기능클래스
 * @author HP
 *
 */
public class Gugudan {
	
	
	// 멤버변수
	Scanner sc = new Scanner(System.in);
	
	
	/**
	 * 입력받은 dan의 구구단을 출력하는 메소드
	 * @param dan 입력받은 구구단 단
	 */
	void print(int dan) {
		System.out.println("***** " + dan + "단 *****");
		
		for(int i = 1; i < 10; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
		
		System.out.println();
	}
	
	/**
	 *  전체 구구단을 출력하는 메소드
	 */
	void print() {
		
		
		for(int dan = 2; dan <= 9; dan++) {
			/*
			System.out.println("*** " + dan +"단 ***");
			for(int i = 1; i < 10; i++) {
				System.out.println(dan + " * " + i + " = " + (dan * i));
				System.out.println(dan + " * " + i + " = " + (dan * i));
			}
			System.out.println();
			*/
			
			// 같은 클래스 내의 메소드를 호출할때는 인스턴스 객체를 만들 필요가 없다. 호출메소드가 이미 객체를 생성했을 것이기 때문이다.
			print(dan);
		}
		
		// 위의 전체 구구단을 출력하는 코드는 print(2, 9)로 대체할 수 있다.
		
		
	}
	
	/**
	 * 시작단과 종료단을 입력받아 구구단을 출력
	 * @param startDan 시작단
	 * @param endDan 종료단
	 */
	void print(int startDan, int endDan) {
		for(int dan = startDan; dan <= endDan; dan++) {
		
			// 같은 클래스 내의 메소드를 호출할때는 인스턴스 객체를 만들 필요가 없다. 호출메소드가 이미 객체를 생성했을 것이기 때문이다.
			print(dan);
			
		}
	}
	
	/**
	 * 단을 입력받는 메소드
	 * @return 입력받은 단
	 */
	int getDan() {
		
		int dan = sc.nextInt();
		sc.nextLine(); // 버퍼 비워주기
		
		return dan;
		
	}
	
	/**
	 * 메세지와 단을 만드는 클래스
	 * @param msg
	 * @return
	 */
	int getDan(String msg) {
		System.out.println(msg);
		
		int dan = getDan();
		
		return dan;
		
	}
	
}
