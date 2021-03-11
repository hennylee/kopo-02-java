package kr.ac.kopo.day04;

public class ArrayMain02 {

	public static void main(String[] args) {
		// 1, 2, 3, 4, 5를 가지는 배열 arr를 생성
		int[] arr = new int[5];
		System.out.println("arr의 주소 : " + arr);
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
			System.out.println("arr["+(i+1)+"] : "+arr[i]);
		}
		
		System.out.println("------------------------------------------");
		
		// 생성과 초기화 동시에 하기
		arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println("arr의 주소 : " + arr);

		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
			System.out.println("arr["+(i+1)+"] : "+arr[i]);
		}
		
		System.out.println("------------------------------------------");
		
		// foreach를 활용한 배열이 가진 모든 요소 출력하기 
		for(int num : arr) {
			System.out.println("arr["+(num)+"] : "+num);
		}
		
		System.out.println("------------------------------------------");
		
		// Arrays.toString() 메소드를 이용한 배열 요소 출력
		System.out.println(java.util.Arrays.toString(arr));
		
		
	}

}
