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
	 * 문자열을 입력받아 대문자로 변경하는 메소드 (교수님 수정본)
	 * @param str
	 * @return
	 */
	String toUpperString(String str) {
		
		char[] temp = new char[str.length()];		
		
		for(int i = 0; i < str.length(); i++) {
			
			temp[i] = str.charAt(i);
			
			if( temp[i] >= 'a' && temp[i] <= 'z') {
				temp[i] -= ('a' - 'A');
			} 
	
		}
		
		return new String(temp);
		
	}
	
	/**
	 * 문자열을 입력받아 소문자로 변경하는 메소드
	 * @param str
	 * @return
	 */
	String toLowerString(String str) {
		char[] temp = new char[str.length()];		
		
		for(int i = 0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			
			if( c > 'A' && c < 'Z') {
				c += 32;
				temp[i] = c;
			} else {
				temp[i] = c;
			}
	
		}
		
		return temp.toString();
	}
	
	
	/**
	 * 특정 문자의 갯수 찾는 메소드
	 * @param strData
	 * @param ch
	 * @return
	 */
	public static int checkChar(String strData, char ch) {

		int count = 0;
		for(int i = 0; i < strData.length();i++) {
			char c = strData.charAt(i);			
			
			if(c == ch) {
				count++;
			}
			
		}
		return count;
		
	}
	
	/**
	 * 특정 문자를 제거하기
	 * @param oriStr
	 * @param delChar
	 * @return
	 */
	public static String removeChar(String oriStr, char delChar) {
		
		String change = "";
		
		for(int i = 0; i < oriStr.length(); i++) {
			if(oriStr.charAt(i) != delChar) {
				change += oriStr.charAt(i);
			}
			
		}
		return change;
		
	}

}
