package kr.ac.kopo.day02.homework;

import java.util.Scanner;

public class HomeworkMain04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		sc.close();
		
		// 조건연산자
		System.out.println("<조건연산자>");
		System.out.print(num1 + "이 " + num2 + "의 배수인지 판단결과 : ");
		System.out.println(num2 <= 0? "false" : (num1 % num2 == 0? "true" : "false"));
		
		
		// if문
		System.out.println("<if문>");
		System.out.print(num1 + "이 " + num2 + "의 배수인지 판단결과 : ");
		if(num2 == 0) {
			System.out.println("false");
		} else {
			if(num1 % num2 == 0) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
		
		// 정답------------------------------------------------------------------------------------------
		
		/* 결과가 어차피 true와 false로 나오니까  
		 * 굳이 세 가지 경우로 나누지 않아도 된다.
		 */
		
		boolean bool = num2 > 0 && num1 % num2 == 0;
		
		System.out.print(num1 + "이 " + num2 + "의 배수인지 판단결과 : ");
		System.out.println(bool);
		
		// --------------------------------------------------------------------------------------------
		
	}

}
