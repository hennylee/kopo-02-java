package kr.ac.kopo.practice;

import java.util.Scanner;

public class Day02_Exam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("두 개의 정수를 입력하세요");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		sc.close();
		System.out.println("첫 번째 정수 : " + num1);
		System.out.println("두 번째 정수 : " + num2);
		System.out.println();
		
		// 더하기
		System.out.printf("%d + %d = %d", num1, num2, num1+num2);
		System.out.println();
		
		// 빼기
		System.out.printf("%d - %d = %d", num1, num2, num1-num2);
		System.out.println();
		
		// 곱하기
		System.out.printf("%d * %d = %d", num1, num2, num1*num2);
		System.out.println();
		
		// 나누기
		
		/*
		 * printf 형식에서 소수점 자리수 설정하는 방법 : %.소수점자리수f
		 */
		System.out.printf("%d / %d = %.2f", num1, num2, num1/(double)num2);
		System.out.println();
		
		// 나머지
		
		/*
		 * printf format에서 %기호 사용하는 방법 : %%로 작성한다. 
		 */
		System.out.printf("%d %% %d = %d", num1, num2, num1%num2);
		System.out.println();
		
	
	}
}
