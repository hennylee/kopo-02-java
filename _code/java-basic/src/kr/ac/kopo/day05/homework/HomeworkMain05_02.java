package kr.ac.kopo.day05.homework;

import java.util.Scanner;

/*

   짝수 입력시 하나 작은 홀수로 구성
   20라인을 입력받으면 19줄의 모양으로 구성
   *****              *********
   ****                *******
   ***                  *****
   **                    ***
   *                      *
   **                    ***
   ***                  ***** 
   ****                *******  
   *****	          *********


 */
public class HomeworkMain05_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 총 줄 수 입력받기
		System.out.println("라인수를 입력하세요");
		int lines = sc.nextInt();
		if(lines % 2 == 0) lines--;
		
		// 별의 갯수
		int star = (lines/2) + 1;
		
		// 별 출력하기
		for(int i = 0; i < lines; i++) {
			
			for(int j = 0; j < star; j++) {
				System.out.print('*');
			}
			System.out.println();
			
			// 총 별의 갯수 조절하기
			if(i < (lines/2)) {
				star--;
			} else {
				star++;
			}
			
		}
		
	}

}
