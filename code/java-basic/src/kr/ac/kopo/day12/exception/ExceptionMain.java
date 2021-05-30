package kr.ac.kopo.day12.exception;

import java.util.Random;

public class ExceptionMain {

	public static void main(String[] args) {

		/**
		 * 0 ~ 2 사이의 난수를 발생시켜서
		 * 10을 난수 나눈 나머지를 출력한다.
		 */
		System.out.println("main start...");
		System.out.println("==========================================");
		
		// 1. 난수 발생
		Random r = new Random();
		int num = r.nextInt(3);
		System.out.println("num: " + num);
		
		// 2. 10을 난수로 나누기
		System.out.println(10 / num);
		
		System.out.println("==========================================");
		System.out.println("main end...");

	}

}
