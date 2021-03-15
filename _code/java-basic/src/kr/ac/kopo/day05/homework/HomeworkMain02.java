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
		
		int[] nums = new int[evenCount + oddCount];	// 짝수 배열
		
		/* (교슈님 풀이) 두 개를 따로 받지 않고 같이 받을 수도 있다.
		 * 짝수는 0번지부터, 홀수는 마지막(length -1)번지부터 거꾸로 들어가기
		 */
		
		// 입력 받기
		System.out.println("정수를 입력하세요");
		
		int evenIndex = 0;
		int oddIndex = nums.length - 1;
		
		
		// while(oddIndex >= evenIndex) {
		for(int i = 0; i < nums.length; i++) {
			System.out.print("num " + (i+1) + ": ");
			int input = sc.nextInt();
			
			// 짝수일때
			
			if(input % 2 == 0 && evenIndex < evenCount) {
				nums[evenIndex++] = input;
				
			} else if(input % 2 == 1 && oddIndex >= evenCount) {
				nums[oddIndex--] = input;
			} else {
				i--;
			}
			
		}
		
		System.out.println("<총 정수>");
		for(int num : nums) {
			System.out.print(num + "  ");
		}
		
		
		
		
		/*
		 * 지금 evenCount를 evenIndex가 초과했을때 새로운 값을 받는 코드가 없음
		 * 
		 * 짝수의 index는 nums[0] ~ nums[evenNuym - 1]
		 * 홀수의 index는 nums[evenNum] ~ nums[nums.length - 1]
		 * 
		 * 
		 */
		

	}

}
