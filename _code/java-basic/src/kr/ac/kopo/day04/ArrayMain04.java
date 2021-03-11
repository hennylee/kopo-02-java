package kr.ac.kopo.day04;

import java.util.Arrays;

public class ArrayMain04 {

	public static void main(String[] args) {
		String[] strArr = {"vh","epd","dd"};
		// String[] strArr = {new String("vh"),new String("epd"),new String("dd")};
		
		// index이용한 출력
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		// foreach
		int i = 1;
		
		for(String s : strArr) {
			System.out.println(s);
			System.out.println(i++);
		}
		
		// Arrays.toString(strArr)
		System.out.println(Arrays.toString(strArr));
	}

}
