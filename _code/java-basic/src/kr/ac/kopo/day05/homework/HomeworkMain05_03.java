package kr.ac.kopo.day05.homework;

import java.util.Scanner;

/*

   짝수 입력시 하나 작은 홀수로 구성
   20라인을 입력받으면 19줄의 모양으로 구성
   *****              *********		0	0	9
   ****                *******		1	1	8
   ***                  *****		2	2	7
   **                    ***		3	3	6
   *                      *			4	4	5	
   **                    ***		3	5	6
   ***                  ***** 		2	6	7
   ****                *******  	1	7
   *****	          *********		0	8
	

 */
public class HomeworkMain05_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 총 줄 수 입력받기
		System.out.println("라인수를 입력하세요");
		int lines = sc.nextInt();
		if(lines % 2 == 0) lines--;
		
		int star = lines;
		
		for(int i = 0; i < lines; i++) {
			if(i <= (lines/2)) {
				for(int j = 0; j < star; j++) {
					if(j < i) {
						System.out.print(' ');
					}else {
						System.out.print('*');
					}
				}
				star--;
			} else {
				for(int j = 0; j < star; j++) {
					if(j < 9 - i) {
						System.out.print(' ');
					}else {
						System.out.print('*');
					}
				}
				star++;
			}
			
			System.out.println();
		}
		
	}

}
