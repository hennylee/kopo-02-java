package kr.ac.kopo.day05.homework;
/*

입력받은 숫자를 REVERSE 시켜서 출력하시오


	1. 0-99사이의 정수를 5개 입력받아 다음과 같이 출력하는 코드를 작성하시오
		1's 정수 : 36
		2's 정수 : 1000
	//	0-99사이의 정수만 입력하세요
		2's 정수 : 92
		3's 정수 : 20
		4's 정수 : 8
		5's 정수 : -2
		5's 정수 : 200
		5's 정수 : 62
		
		< PRINT >
		36  92  20  8  62
		
		< REVERSE >
		26  80  2  29  63


 */

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkMain01 {

	public static void main(String[] args) {
		
		// 입력받기
		Scanner sc = new Scanner(System.in);

		System.out.println("0-99사이의 정수를 5개 입력하세요");
		
		int[] arr = new int[5];
		
		int count = 0;
		
		while(count < 5) {
			
			int temp = sc.nextInt();
			
			// 0 ~ 99 사이의 정수인지 확인하기
			if(temp >= 0 && temp < 100) {
				arr[count] = temp;
				count++;
			} else {
			
				System.out.println("0-99사이의 정수만 입력하세요");
			}
			
		}
		
		System.out.println("< PRINT >");
		System.out.println(Arrays.toString(arr));
		
		
		// 입력받은 정수의 각 자리수 바꾸기 (10으로 나눴을때 몫이 첫번째 수 / 나머지가 일의 자리 수 => 두 개 바꾸기)
		
		int[] tempArr = new int[arr.length];
		
		for(int i = 0; i <arr.length; i++) {
			int first = arr[i]/10; 		// 10의 자리
			int second = arr[i]%10;		// 1의 자리 
			
			tempArr[4 - i] = second * 10 + first;
			
			// temp 배열을 만들지 않으면 기존 배열 값이 바뀌어 버려서 1, 2, n/2 번째 값은 원본을 기억하지 못해서 오류가 발생함!
		}
		
		/*
				 0		4
				 1		3
				 2		2
				 3		1
				 4		0
		 */
		
		System.out.println("< REVERSE >");
		System.out.println(Arrays.toString(tempArr));
		

	}

}
