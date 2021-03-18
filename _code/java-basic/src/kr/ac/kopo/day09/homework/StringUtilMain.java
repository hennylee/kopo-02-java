package kr.ac.kopo.day09.homework;

import java.util.Arrays;

public class StringUtilMain {

	public static void main(String[] args) {
		String str = "abCCCCdDe";
		
		char[] temp = new char[str.length()];		
		
		for(int i = 0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			
			if( c > 96 && c < 123) {
				c -= 32;
				temp[i] = c;
			} else {
				temp[i] = c;
			}
			
			System.out.print(temp[i]);
	
		}
		
	}

}
