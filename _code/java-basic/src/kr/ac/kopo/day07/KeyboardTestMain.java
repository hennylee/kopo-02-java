package kr.ac.kopo.day07;

import java.util.Scanner;

public class KeyboardTestMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("====================== 정수와 실수에서의 공백================");
		System.out.println("첫번째 정수 : ");
		int num = sc.nextInt();
		
		/*
		 * 이때, 엔터를 누르지 않고 띄어쓰기로 두 문자를 입력하면
		 * 컴퓨터는 자동으로 
		 * 첫번째 것을 num1, 두번째 것을 기억했다가 num2로 인식한다.
		 */
		
		System.out.println("두번째 정수 : ");
		int num2 = sc.nextInt();
		
		System.out.println("num : " + num + ", num2 : " + num2);
		
		
		System.out.println("====================== 문자와 문자열에서 공백================");
		
		System.out.println("정수를 입력하세요 : ");
		int num3 = sc.nextInt();
		sc.nextLine(); 
		// 정수나 실수 입력받는 키워드가 나오면 nextLine메소드를 쓴다 => 버퍼를 비워주는 역할을 한다.

		// next는 단어단위로 인식하는 것이다. '서울시 종로'를 입력하면 서울시로 끝나버린다. 
		// nextLine은 문장 단위로 입력 받을때 사용한다. 
		
		// "123" + 10 은 12310이다.
		// "123"을 123의 정수형으로 변환하기 위해서 Integer.parseInt("123");를 사용한다. 
		
		// int num3 = Integer.parseInt(sc.nextLine());으로 작성하면 입력받은 숫자의 문자를 정수형으로 변환한다. 
		// 위의 두 줄을 한줄로 작성하려면 위와 같이 작성하면 된다. 
		
		System.out.println("문자열을 입력 : ");
		String str = sc.nextLine();
		

		System.out.println("num3 : " + num3 + ", str : " + str);
	}

}
