package kr.ac.kopo.day02.homework;

import java.util.Scanner;

public class HomeworkMain03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("물건값과 지불할 금액을 입력하세요 : ");
		// 물건값
		int total = sc.nextInt();
		
		// 지불한 액수
		int pay = sc.nextInt();
		
		sc.close();
		
		// 거스름돈
		int change = pay - total;
		
		// 거스름돈 단위 구하기
		int thousand = change / 1000;
		int fiveHundred = change % 1000 / 500 ;
		int oneHundred = change % 1000 % 500 / 100;
		int fifty = change % 1000 % 500 % 100 / 50;
		int ten = change % 1000 % 500 % 100 % 50 / 10;
		
		System.out.println();
		// 방식 1
		System.out.println("<방식1>");
		
		if(total <= pay) {
			
			System.out.println("거스름돈 : " + change);
			System.out.println();
			
			System.out.println("1000원 : " + thousand + "\n"
							+ "500원 : " + fiveHundred + "\n"
							+ "100원 : " + oneHundred + "\n"
							+ "50원 : " + fifty + "\n"
							+ "10원 : " + ten + "\n"
							);
		} else {
			System.out.println((total - pay) + "원이 부족합니다.");
		}
		
		System.out.println("------------------------------------------");
		
		// 방식2
		System.out.println("<방식2>");
		
		if(total <= pay) {
			
			System.out.println("거스름돈 : " + change);
			System.out.println();
			
			System.out.println(thousand == 0? "":"1000원 : " + thousand);
			System.out.print(fiveHundred == 0? "":"500원 : " + fiveHundred + "\n");
			System.out.print(oneHundred == 0? "":"100원 : " + oneHundred + "\n");
			System.out.print(fifty == 0? "":"50원 : " + fifty + "\n");
			System.out.print(ten == 0? "":"10원 : " + ten);
			
		} else {
			System.out.println((total - pay) + "원이 부족합니다.");
		}

	}
	

}
