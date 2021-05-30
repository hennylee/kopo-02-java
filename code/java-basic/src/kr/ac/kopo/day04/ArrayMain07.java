package kr.ac.kopo.day04;

public class ArrayMain07 {

	public static void main(String[] args) {
		int[] a = {10, 20, 30, 40, 50};
		
		// a배열의 모든 요소에 100을 더하기
		
		for(int num : a) {
			num = num + 100;
			System.out.println(num);
		}
		
		System.out.println("--------------- 배열 요소 출력 ----------------");
		for(int num : a) {
			System.out.println(num);
		}
	}

}
