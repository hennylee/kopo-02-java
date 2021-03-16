package kr.ac.kopo.day05.homework;

import java.util.Scanner;

/*

   짝수 입력시 하나 작은 홀수로 구성
   20라인을 입력받으면 19줄의 모양으로 구성
   									lines = 9
   									
   								   공백  i   total=j	star
   *****              *********		0	0	9		9
   ****                *******		1	1	8		7
   ***                  *****		2	2	7		5
   **                    ***		3	3	6		3
   *                      *			4	4	5		1
   **                    ***		3	5	6		3
   ***                  ***** 		2	6	7		5
   ****                *******  	1	7	8		7
   *****	          *********		0	8	9		9
	

 */
public class HomeworkMain05_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 총 줄 수 입력받기
		System.out.println("라인수를 입력하세요");
		int lines = sc.nextInt();
		if(lines % 2 == 0) lines--;
		
		int total = lines;		// 총 라인수
		int center = lines/2;	// 중간 라인
		int blank = 0;			// 공백의 갯수
		

		// lines 수만큼 행을 출력한다
		for(int i = 0; i< lines; i++) {
			
			// 한줄씩 공백과 별을 출력한다.
			for(int j = 0; j < total; j++) {
				if(j < blank) {
					System.out.print(' ');
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
				
			// 기호의 총 갯수 조절하기
			if(i < center) {
				total--;
				blank++;
			}else {
				total++;
				blank--;
			}
		}
		
		
	}

}
