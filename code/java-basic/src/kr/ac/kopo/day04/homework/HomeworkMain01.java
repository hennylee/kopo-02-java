package kr.ac.kopo.day04.homework;

import java.util.Scanner;

/*

1. 3개의 정수를 입력받아 큰수에서 작은수순으로 출력
   3개의 정수를 입력하세요 : 12 7 39
   
   39  12  7
   
=> 조건문 5개 

 */
public class HomeworkMain01 {

	public static void main(String[] args) {
		// 3개의 정수 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1:");
		int num1 = sc.nextInt();
		System.out.print("정수 2:");
		int num2 = sc.nextInt();
		System.out.print("정수 3:");
		int num3 = sc.nextInt();
	
		sc.close();
		
		// num1 vs num2 비교
		int max = num1 > num2? num1: num2;
		
		// max와 num3 비교
		max = max > num3? max: num3;
		
		System.out.println(max);
		

	}

}
