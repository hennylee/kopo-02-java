package kr.ac.kopo.day07.homework.solution;
/*
 * 누군가가 아이스크림을 사러왔을 떄
 * 아이스크림명과 가격을 알고 있는 것이 이 클래스의 목적이다.  
 * 그래서 멤버변수로 ice크림 정보 객체를 배열로 가지고 있어야 한다. 
 */

import java.util.Scanner;

public class IcecreamMarket {
	Icecream[] iceArr; // 마켓이 알고 있어야할 정보 : 멤버변수
	
	// 소비자가 구매할 정보 입력 => Icecream.java 클래스에서 입력 받아도 된다. 
	Scanner sc = new Scanner(System.in);
	
	int inputInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	
	String inputString(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	
	// 손님이 아이스크림을 구매하면 구매정보 출력하는 매소드
	void doSomething() {

		// 손님이 아이스크림 구매
		buy();
		
		// 구매 정보 출력
		info();
	}
	
	void info() {
		System.out.println("<총 " + iceArr.length + "개 구매 정보 출력>");
		System.out.println("번호\t아이스크림\t아이스크림가격");
		
		int no = 1;
		for(Icecream ice : iceArr) {
			
			/*
			System.out.println(no++ + "\t" + ice.name + "\t" + ice.price);
			
			[문제점] ice.name처럼 객체의 멤버변수로 통신하는 방식이 문제이다. 메소드로 통신하는 방법이 좋다. 
			[이유] ice의 변수명을 name이 아니라 iceName으로 바꾸면, 해당 코드를 다 변경시켜야하기 때문이다. 
			*/
			
			System.out.println(no++ + "\t" + ice.getName() + "\t" + ice.getPrice());
		
		}
		
	}
	
	/**
	 * 아이스크림 구매와 관련된 메소드
	 */
	void buy() {
		
		// 몇 개 구매?
		int count = inputInt("아이스크림 몇 개 구입할래? : ");
		iceArr = new Icecream[count];
		
		// 구매할 아이스크림 정보 입력 받기
		for(int i = 0; i < iceArr.length; i++) {
			
			System.out.println("*** " + (i+1) +"번째 아이스크림 구매 정보 입력 ***");
			
			// 아이스크림 객체 생성
			iceArr[i] = new Icecream(); 
			
			// 아이스크림 정보 입력받기
			String name = inputString("아이스크림명 : ");
			int price = inputInt("아이스크림가격 : ");
			
			// 아이스크림 객체에 입력받은 정보 넣기 : set 메소드는 Icecream 클래스에 정의되어 있어야한다. 
			iceArr[i].set(name, price);
			
		}
	}
	
}
