package kr.ac.kopo.day04;

public class ArrayMain03 {

	public static void main(String[] args) {

		int[][] arr = new int[3][8];
		
		System.out.println( arr );
		
		// arr[]에는 일차원배열들의 주소값만 저장되어 있다. 
		System.out.println( arr[0] );
		System.out.println( arr[1] );
		System.out.println( arr[2] );
		
		// arr[][]에는 값이 저장되어 있다.
		System.out.println( arr[0][0] );		
		
		// 배열의 크기
		System.out.println( arr.length );
		System.out.println( arr[1].length );

	}

}
