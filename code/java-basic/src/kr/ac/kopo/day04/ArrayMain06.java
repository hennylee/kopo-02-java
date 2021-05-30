package kr.ac.kopo.day04;

import java.util.Arrays;

public class ArrayMain06 {

	public static void main(String[] args) {
		int[] a = {10, 20, 30};
		int[] b = {5, 6, 7, 8, 9};
		
		int[] c = new int[a.length + b.length];
		
		int loc = 0;
		
		// a 배열 복사
		for(int i = 0; i < a.length; i++) {
			c[loc++] = a[i];
		}
		System.out.println(Arrays.toString(c));
		
		// b 배열 복사
		for(int i = 0; i < b.length; i++) {
			c[loc++] = b[i];
		}

		System.out.println(Arrays.toString(c));
		
		// arraycopy() 메소드 활용하기
		int[] d = new int[a.length + b.length];
		
		System.arraycopy(a, 0, d, 0, a.length);
		
		System.out.println(Arrays.toString(d));
		
		System.arraycopy(b, 0, d, a.length, b.length);
		System.out.println(Arrays.toString(d));
		
	}

}
