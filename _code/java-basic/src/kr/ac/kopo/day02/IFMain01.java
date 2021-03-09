package kr.ac.kopo.day02;

public class IFMain01 {

	public static void main(String[] args) {

		int a = 5, b = 5;
		
		/*
		 * 1. 2가지 경우 표현하기
		 * 
		 * 	a가 크면 a를, 그렇지 않으면 b를 출력하라
		 */
		
		// 3항 연산자
		System.out.println("MAX : " + (a > b ? a : b));

		// if ~ else 문
		if (a > b) {
			System.out.println("MAX : " + a);
		} else {
			System.out.println("MAX : " + b);
		}
		
		/*
		 * 2. 3가지 경우 표현하기
		 * 
		 * 	a가 b보다 크면 a 출력
		 * 	a가 b보다 작으면 b 출력
		 * 	a와 b가 같다면 0 출력
		 */
		
		// 3항연산자
		System.out.println(a>b? a: a<b ? b : 0);
		
		// 중첩된 if~ else
		if(a>b) {
			System.out.println(a);
		} else { // a<=b
			if(a<b) {
				System.out.println(b);
			}
			else { // a == b
				System.out.println(0);
			}
		}

		// else if
		if(a>b) {
			System.out.println(a);
		} else if(a<b) {
			System.out.println(b);
		}
		else { // a == b
			System.out.println(0);
		}
		
	}

}
