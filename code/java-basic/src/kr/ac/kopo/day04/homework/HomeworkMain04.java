package kr.ac.kopo.day04.homework;

import java.util.Scanner;

/*
   
   
4. 소수 : 1과 자기자신 외에는 약수가 존재하지 않는 양의정수   
	정수를 입력 : 23
	23은 소수입니다
	
	정수를 입력 : 12
	12는 소수가 아닙니다
	
	
	1.
	약수의 갯수가 2개인 것?
	입력받은 정수보다 작은 수들까지 계속 나머지가 0이 나오는게 있는지 확인하면 된다. 
	
	2.
	1과 자기자신 제외한 수들 중에 약수가 0개이면 소수???
	
	3.
	나
 */
public class HomeworkMain04 {

	public static void main(String[] args) {
		
		
		int i = 2;

		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		while(i <= num && num % i != 0) {
//			System.out.println(i);
			i++;
		}
		
		if(i == num) {
			System.out.println("소수입니다.");
		} else {
			System.out.println("소수가 아닙니다.");
		}
		
		
		
	}

}
