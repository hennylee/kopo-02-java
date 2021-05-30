package kr.ac.kopo.day04;

import java.util.Arrays;

public class ArrayMain05 {

	public static void main(String[] args) {
		
		// 얕은 복사
		int[] a = {10, 20, 30};
		int[] b = a;
		
		System.out.println("------------------------- 주소값 비교 ---------------------------");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		System.out.println("-------------------------- 배열 요소 비교---------------------------");
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));
		
		b[1]++;
		System.out.println("------------------------- b[1]++ 수행 후 -----------------------");
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));
		
		
		// 깊은 복사
		b = new int[a.length];
		System.out.println(b);
		
		System.out.println("------------------------- 주소값 비교 ---------------------------");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		System.out.println("------------------------- 공간 크기만 복사--------------------------");
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));
		
		
		System.out.println("------------------------- 값까지 복사 --------------------------");
		
		for(int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}
		
		System.out.println("a : " + Arrays.toString(a));
		System.out.println("b : " + Arrays.toString(b));
		
	}

}
