package kr.ac.kopo.practice;

import java.util.Scanner;

public class Day02_Exam02 {

	final static double PI = 3.14;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반지름 입력 : ");
		
		int radius = sc.nextInt(); // 반지름
		sc.close();
		
		double circleLength = PI * radius; // 원둘레
		double circleArea = PI * radius * radius; // 원넓이
		
		System.out.println("반지름이 " + radius + "일때, "
						+ "원둘레는 " + circleLength + "이고, "
						+ "원 넓이는 " + circleArea + "이다.");
		
		

	}

}
