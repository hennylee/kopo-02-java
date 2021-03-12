package kr.ac.kopo.day05.homework;

import java.util.Scanner;

/*
	
별그리기 관련 문제를 라인수를 입력받아 출력하는 코드를 작성할 것이다. 

3~20 사이의 라인수를 입력받고, 짝수 입력시 하나 작은 홀수로 인식한다. 

	
	
	***** (5)
	****  (4)
	***
	**
	*
	**
	***
	****
	*****

	
	
	lines       first line's start		center
	===========================================
	1	  		1개						1
	3			2개						2
	5			3개						3
	7			4개						4
	
	
	(9)
	(7)
	(5)
	
	
	

 */
public class HomeworkMain05 {

	public static void main(String[] args) {
		// 라인 수 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("라인수를 입력하세요");
		int lines = sc.nextInt();
		
		if(lines % 2 == 0)	lines--;
		
		
		// 1. 반모래시계 문제
		int star = (lines + 1) / 2; 	// 별의 갯수
		int center = (lines + 1) / 2; 	// 중간 순서
		
		
		for(int i = 0; i< lines; i++) {
			
			for(int j = 0; j < star; j++) {
				System.out.print('*');
			}
			
			if(i <= center) star--;
			System.out.println();
		}
		
		
		
		
		
		
		
	}

}
