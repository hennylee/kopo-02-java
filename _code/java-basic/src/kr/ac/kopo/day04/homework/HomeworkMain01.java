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
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
	
		sc.close();
		
		// num1이 가장 클 때
		if(num1 > num2 && num1 > num3) {
			
		}
		// num2이 가장 클 때
		else if(num2 > num1 && num2 > num3) {
			
		}
		// num3이 가장 클 때
		else if(num3 > num1 && num3 > num2) {
			
		}
		
		

	}

}
