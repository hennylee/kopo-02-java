package kr.ac.kopo.day04.homework;

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
		
		int num = sc.nextInt();
		int sum = 0;
		int sum2 = 0;
		for(int i = 1; i < 10; i++) {
			
			if(num % 2 == 0) sum += num;
			else sum2 += num;
			num = sc.nextInt();
		}
		System.out.println("짝수 총합 : "+ sum);
		System.out.println("홀수 총합 : "+ sum2);

	}

}
