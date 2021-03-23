package kr.ac.kopo.day12.exception;

import java.util.Random;

public class ExceptionMain02 {

	public static void main(String[] args) {

		/**
		 * 0 ~ 2 사이의 난수를 발생시켜서
		 * 10을 난수 나눈 나머지를 출력한다.
		 * 단, 난수가 0일때 예외처리를 한다.
		 */
		System.out.println("main start...");
		System.out.println("==========================================");
		
		// 1. 난수 발생
		Random r = new Random();
		int num = r.nextInt(3);
		System.out.println("num: " + num);
		
		// 2. 10을 난수로 나누기(0일때는 예외처리)
		try {
			System.out.println("10 / num : "+10 / num);
		} catch (ArithmeticException ae) {
			System.out.println("catch블록 진입...");
			System.out.println("0으로 나눌 수 없습니다");
			System.out.println("ae : " + ae);
			System.out.println("ae Message : " + ae.getMessage());
			ae.printStackTrace();
		}
		
		System.out.println("==========================================");
		System.out.println("main end...");

	}

}
