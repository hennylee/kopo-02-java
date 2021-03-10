package kr.ac.kopo.day02;

import java.util.Scanner;

/*
 * 1부터 3 사이의 숫자를 입력받기
 * 
 * 입력받은 숫자의 영어표기 출력하기
 * 
 * 범위를 초과하면 error 출력받기
 * */

public class SwitchMain01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 - 3 사이의 정수 : ");
		int num = sc.nextInt();
		
		// if ~ else문
		if(num == 1) {
			System.out.println("ONE");
		} else if(num == 2) {
			System.out.println("TWO");
		} else if(num == 3) {
			System.out.println("THREE");
		} else {
		System.out.println("ERROR");
		}
		
		// switch문
		switch(num) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		default :
			System.out.println("ERROR");
		case 3:
			System.out.println("THREE");
			break;
		}
			
		
	}

}
