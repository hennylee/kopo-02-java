package kr.ac.kopo.day08;

import java.util.Arrays;
import java.util.Scanner;

public class StringMain02 {

	public static void main(String[] args) {
		
		
		// 문자열은 char의 배열로 이루어져 있다. 
		char[] chars = {'H','e','l','l','o',' ','W','o','r','l','d'};
		String str = new String(chars);
		
		
		// 문자열을 char배열로 바꾸기 ---------------------------------------------------------------------------------
		// getChar 메소드는 String을 배열로 만들어서 하나씩 출력하는 것이다. 
		char[] chars2 = new char[str.length()];
		
		str.getChars(0, str.length(), chars, 0);
		
		for(int i = 0; i < str.length(); i++) {
			chars2[i] = str.charAt(i);
		}
		
		
		
		// 키보드로 char 한 글자 입력 받기 -----------------------------------------------------------------------------
		
		// 방법 1 ==========================================
		String str1 = "Hello World";
		
		System.out.println(str1.charAt(0));
		
		// 방법 2 ==========================================
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력");
		
//		String input = sc.nextLine();
//		char c = input.charAt(0);
//		System.out.println("c=" + c);
		
		char d = sc.nextLine().charAt(0); // 위의 코드를 한줄로 줄이기
		System.out.println("d=" + d);
	}

}
