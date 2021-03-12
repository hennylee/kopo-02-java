package kr.ac.kopo.day05.homework;

import java.util.Arrays;
import java.util.Scanner;

/*

설정한 갯수만큼 짝수/홀수 입력받기

출력 : 짝수 갯수만큼 쫘르르, 호룻 갯수 만큼 쫘르르~~



2. 다음과 같은 결과를 보이는 프로그램 작성
	짝수 몇개 입력 : 5
	홀수 몇개 입력 : 4
	
	num1 : 12
	num2 : 9
	num3 : 67
	num4 : 20
	num5 : 9
	num6 : 31
	num7 : 24
	
	num8 : 5
	num8 : 11
	num8 : 10
	
	num9 : 6
	
	< PRINT >
	12  20  24  10  6  31  9  67  9

*/
public class HomeworkMain02 {

	public static void main(String[] args) {
		int evenCount = 5; 	// 짝수의 갯수
		int oddCount = 4;	// 홀수의 갯수
		
		Scanner sc = new Scanner(System.in);
		
		int[] evenArr = new int[evenCount];	// 짝수 배열
		int[] oddArr = new int[oddCount]; 	// 홀수 배열
		
		// 입력 받기
		System.out.println("정수를 입력하세요");
		
		int evenIndex = 0;
		int oddIndex = 0;
		
		for(int i = 0; i < evenCount + oddCount; i++) {
			int input = sc.nextInt();
			
			// 짝수일때
			
			if(input % 2 == 0 && evenIndex < evenCount) {
				evenArr[evenIndex] = input;
				evenIndex++;
				
			}
			// 홀수일때
			
			if(input % 2 != 0 && oddIndex < oddCount) {
				oddArr[oddIndex] = input;
				oddIndex++;
			}
			
		}
		
		System.out.println(Arrays.toString(evenArr));
		System.out.println(Arrays.toString(oddArr));
		
		/*
		 * 지금 evenCount를 evenIndex가 초과했을때 새로운 값을 받는 코드가 없음
		 * 
		 * 
		 */
		

	}

}
