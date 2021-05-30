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
	
	0	1	2	3	4	5	6	7	8
	---------------------------------
	
	12  20  24  10  6  	31  9  	67  9
	
	<--------------짝수 | 홀수--------->

*/
public class HomeworkMain02 {

	public static void main(String[] args) {
		
		// 갯수 입력 받기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("짝수 몇개 입력 : ");
		int evenNum = sc.nextInt();
		
		System.out.print("홀수 몇개 입력 : ");
		int oddNum = sc.nextInt();
		
		int[] arr = new int[evenNum + oddNum];
		
		
		int evenCnt = 0;
		int oddCnt = oddNum;
		
		for(int i = 0; i < arr.length; i++) {
			
			System.out.println("num"+(i+1)+" : ");
			int num = sc.nextInt();
			
			
			if(num % 2 == 0 && evenCnt < evenNum) {
				arr[evenCnt] = num;
				evenCnt++;
			}
			else if(num % 2 != 0 && 0 <= oddCnt) {
				arr[evenNum+ oddCnt-1] = num;
				oddCnt--;
			} else {
				i--;
			}
		}
		
		
		System.out.println(Arrays.toString(arr));
		
		

	}

}
