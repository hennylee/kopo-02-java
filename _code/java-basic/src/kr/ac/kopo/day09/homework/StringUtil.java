package kr.ac.kopo.day09.homework;

import java.util.Scanner;

public class StringUtil {

	
	/**
	 * 하나의 문자를 입력받아 해당 문자가 대문자이면 true를 반환하는 메소드
	 * @param c 
	 * @return
	 */
	boolean isUpperChar(char c) {
		boolean checkUpper;
		
		if(c > 97) {
			checkUpper = false;
		} else {
			checkUpper = true;
		}
		
		return checkUpper;
	}
	
	
	/**
	 * 하나의 문자를 입력받아 해당 문자가 소문자이면 true를 반환하는 메소드
	 * @param c
	 * @return
	 */
	boolean isLowerChar(char c) {
		boolean checkLower;
		
		if(c < 97) {
			checkLower = false;
		} else {
			checkLower = true;
		}
		
		return checkLower;
		
	}
	
	
	/**
	 * 두 개의 숫자를 입력받아 큰 수를 반환하는 메소드
	 * @param i
	 * @param j
	 * @return
	 */
	int max(int i, int j) {
		int max;
		
		if(i > j) max = i;
		else max = j;
		
		return max;
	} 
	
	/**
	 *  두 개의 숫자를 입력받아 작은 수를 반환하는 메소드
	 * @param i
	 * @param j
	 * @return
	 */
	int min(int i, int j) {
		int min;
		
		if(i > j) min = j;
		else min = i;
		
		return min;
	}
	
	
	/**
	 * 문자열을 입력받아 거꾸로 반환하는 메소드
	 * @param str
	 * @return
	 */
	String reverseString(String str) {
		String temp = str;
		String reverse = null;
		int strLength = str.length() - 1;
		
		for(int i = 0; i < strLength; i++) {
			reverse += str.charAt(strLength - i);
		}
		
		return reverse;
	}

	/**
	 * 문자열을 입력받아 대문자로 변경하는 메소드
	 * @param str
	 * @return
	 */
	String toUpperString(String str) {
		
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
		
		return temp.toString();
		
	}
	
	/**
	 * 문자열을 입력받아 소문자로 변경하는 메소드
	 * @param str
	 * @return
	 */
	String toLowerString(String str) {
		
	}

}
