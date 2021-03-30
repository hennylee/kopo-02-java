package kr.ac.kopo.day05;

import java.util.Arrays;

public class ArrayMain06 {
	public static void main(String[] args) {
		int[] a = {10, 20, 30};
		int[] b = {5, 7, 8, 9, 20, 23};
		
		int[] c = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		
		System.out.println(Arrays.toString(c));
		
		
		
	}
}
