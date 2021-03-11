package kr.ac.kopo.day04;

public class ArrayMain01 {

	public static void main(String[] args) {
		
		// 참조변수 설정 (stack)
		int[] arr;
		
		// 초기화 (heap)
		arr = new int[5];
		
		System.out.println("arr의 주소 : " + arr); // 배열의 주소값이 출력됨( arr 은 참조변수 )
		
		// 배열의 크기 (갯수) : length
		int length = arr.length;
		System.out.println("배열의 크기(갯수) : " + length);
		
		// 배열의 각 요소 출력하기
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i+1 +"번째 정수는 : " + arr[i]);
		}

	}

}
