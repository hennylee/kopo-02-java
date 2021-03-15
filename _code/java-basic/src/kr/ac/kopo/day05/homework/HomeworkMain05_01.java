package kr.ac.kopo.day05.homework;

import java.util.Scanner;

/*
	
5. 별그리기 관련 문제를 라인수를 입력받아 출력하는 코드를 작성.
   3 - 20사이의 라인수를 입력받고, 
   
   ----*
   ---**
   --***
   -****
   *****
	
	

 */
public class HomeworkMain05_01 {

	public static void main(String[] args) {
		// 라인 수 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("라인수를 입력하세요");
		int lines = sc.nextInt();
		int star = lines;
		
		
		for(int i = 0; i < lines; i++) {
			for(int j = 0; j < star; j++) {
				if(j < (star - i - 1)) {
					System.out.print('-');
				}else {
					System.out.print('*');
				}
			}
			System.out.println();
		}
		
		
		
		
	}

}
