package kr.ac.kopo.day04.homework;

import java.io.InterruptedIOException;
import java.util.Scanner;

/*

6. 10개의 정수를 입력받아 다음과 같이 출력하는 코드를 작성		

	1's 정수 : 12
	2's 정수 : 3
	3's 정수 : 45
	4's 정수 : 7
	5's 정수 : 23
	6's 정수 : 56
	7's 정수 : 10
	8's 정수 : 8 
	9's 정수 : 3
	10's 정수 : 55
	
	< 짝수 >
	12  56  10  8
	짝수 총합 : XXXX 
	< 홀수 >
	3  45  7  23  3  55
	홀수의 총합 : XXXX
	
 */
public class HomeworkMain06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sumEven = 0;
		int sumOdd = 0;
		int[] arrNum = new int[10];
		
		for(int i = 0; i < 10; i++) {
			System.out.print(i+1+"'s 정수 : ");
			arrNum[i] = sc.nextInt();
			
			if(arrNum[i] % 2 == 0) {
				sumEven += arrNum[i];
			} else {
				sumOdd += arrNum[i];
			}
		}
		
		System.out.println("< 짝수 >");
		
		for(int i = 0; i < 10; i++) {
			if(arrNum[i] % 2 == 0) {
				System.out.print(arrNum[i] + " ");
			}
		}
		System.out.println();
		System.out.println("짝수 총합 : " + sumEven);

	
		System.out.println("< 홀수 >");
		
		for(int i = 0; i < 10; i++) {
			if(arrNum[i] % 2 != 0) {
				System.out.print(arrNum[i] + " ");
			}
		}
		System.out.println();
		System.out.println("홀수 총합 : "+sumOdd);
		
		
		

	}

}
