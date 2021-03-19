package kr.ac.kopo.day09.homework;

import java.util.Arrays;

public class StringUtilMain {

	public static void main(String[] args) {
		String oriStr = "abcdANDaJdil";
		char delChar = 'a';
		String change = "";
		
		for(int i = 0; i < oriStr.length(); i++) {
			if(oriStr.charAt(i) != delChar) {
				change += oriStr.charAt(i);
			}
			
		}
		
		
	}

}
