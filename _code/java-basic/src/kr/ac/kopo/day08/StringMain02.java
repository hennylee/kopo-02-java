package kr.ac.kopo.day08;

import java.util.Scanner;

public class StringMain02 {

	public static void main(String[] args) {
		
		
		// 문자열은 char의 배열로 이루어져 있다. 
		char[] chars = {'H','e','l','l','o',' ','W','o','r','l','d'};
		String str = new String(chars);
		
		// getChar 메소드는 String을 배열로 만들어서 하나씩 출력하는 것이다.
		char[] chars2 = new char[str.length()];
		
		str.getChars(0, str.length(), chars, 0);
		
		for(int i = 0; i < str.length(); i++) {
			chars2[i] = str.charAt(i);
		}
		
		
		// 키보드로 char 한 글자 입력 받기 -----------------------------------------------------------------------------
		String str1 = "Hello World";
		
		// 방법 1 ==========================================
		System.out.println(str1.charAt(0));
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력");
		
		// 방법 2 ==========================================
		String input = sc.nextLine();
		char c = input.charAt(0);
		
		char d = sc.nextLine().charAt(0); // 위의 코드를 한줄로 줄이기
	}

}
