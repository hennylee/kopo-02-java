package kr.ac.kopo.day02;

import java.util.Scanner;

public class OperationMain02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// "정수를 입력하세요" 문장 출력
		System.out.print("정수를 입력하세요 : ");
		
		// 키보드로 정수 입력받기
		int num = sc.nextInt();
		
		// 결과 출력
		boolean result = (num > 0 && num % 2 == 0); 
		System.out.println(num + "의 짝수 유무 : " + result);
		
		sc.close();
	}

}
