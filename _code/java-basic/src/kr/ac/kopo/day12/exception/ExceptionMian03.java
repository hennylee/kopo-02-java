package kr.ac.kopo.day12.exception;

import java.util.Random;

public class ExceptionMian03 {

	public static void main(String[] args) {
		
		/**
		 * 여러개의 예외 처리하는 방법
		 */
		
		String s = null;
		
		Random r = new Random();
		
		int i = r.nextInt(3);
		
		// [묵시적 형변환으로 Exception 으로 모든 예외처리 하기] ==========================================
		try {
			
			System.out.println(10 / i);
			System.out.println(s.charAt(0));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		// [ or 연산자로 여러 개의 에러 제어하기] =======================================================
		try {
			
			System.out.println(10 / i);
			System.out.println(s.charAt(0));
			
			
		} catch (ArithmeticException | NullPointerException n) {
			n.printStackTrace();
		} 
		
		
		// [Multi - Catch]========================================================================
		 
		try {
			
			System.out.println(10 / i);
			System.out.println(s.charAt(0));
			
			
		} catch (ArithmeticException e) {
			
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println("s.charAt(0)는 수행하지 않음");
			
		} catch (NullPointerException e) {
			
			System.out.println("빈 문자열 입니다.");
			
		}
		
	}

}
