package kr.ac.kopo.day08.homework;

import java.util.Scanner;

public class Caculator {
	
	// 멤버변수
	int num1;
	int num2;
	
	// 숫자 입력받기
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 : ");
	}
	
	// 더하기
	void plus() {
		System.out.println("num1 + num2 = " + (num1 + num2));
	}
	
	// 빼기
	void minus() {
		System.out.println("num1 - num2 = " + (num1 - num2));
		
	}
	
	// 곱하기
	void multiple() {
		System.out.println("num1 * num2 = " + (num1 * num2));
		
	}
	
	// 나누기
	void divide() {
		System.out.println("num1 / num2 = " + (String.format("%.2f",(num1 / num2))));
		
	}
	
	// 소수체크
	void checkPrime() {
		boolean isPrime = true;
		
		for(int i = 0; i < num; i++) {
			if(num % i == 0) isPrime = false;
		}
		
		
		System.out.println("소수 체크" + isPrime);
		
	}
}
