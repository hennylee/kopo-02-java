package kr.ac.kopo.day10.homework;

import java.util.Scanner;

public class IcecreamMarket extends Icecream{

	Scanner sc = new Scanner(System.in);
	
	static int totalCustom = 1;
	static int totalCnt;
	static int totalPrice;
		
	void buy() {
		System.out.print("아이스크림 몇 개 구입할래?  ");
		int count = sc.nextInt();
		sc.nextLine();
		
		if(count > 0) {

			for(int i = 0; i < count; i++) {
				System.out.println("============" + (i+1) + "번째 주문============");
				inputName();
				inputPrice();
			}
			nextCustomer();
			
		}
		else System.out.println("0개 이상의 갯수를 입력하세요");
	}
	
	
	
	String inputName() {
		System.out.print("아이스크림명 : ");
		String name = sc.next();
		sc.nextLine();
		
		if(name==null || name.equals(""))
			System.out.println("한 글자 이상 입력하세요.");
		
		totalCnt++;
		return name;
	}
	
	
	int inputPrice() {
		System.out.print("아이스크림 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		if(price > 0) totalPrice += price;
		else System.out.println("0원 이상의 금액을 입력하세요");
		
		return price;
	}
	
	void nextCustomer() {
		System.out.println("------------------------");
		System.out.print("계속 구매할래?(Y/N) => ");
		String next = sc.next();
		sc.nextLine();
		
		if(next.equalsIgnoreCase("y") ) {
			++totalCustom;
			buy();
		}
		else {
			printTotal();
		}
	}
	
	void printTotal() {
		System.out.println("==================================== 총계 ===============================");
		System.out.println("총 " + totalCustom + "명의 고객이 아이스크림을 구매했습니다.");
		System.out.println("판매된 아이스크림 총 개수 : " + totalCnt + "개");
		System.out.println("총 판매액 : " + totalPrice +"원");
	}
	
}
