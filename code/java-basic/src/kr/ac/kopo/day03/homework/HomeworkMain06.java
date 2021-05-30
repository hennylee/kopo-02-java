package kr.ac.kopo.day03.homework;
/*

	6>
		*********
		 *******
		  *****
		   ***
		    *

		0	9 	0
		1	7 	1
		2	5	2
		3	3	3
		4	1	4
 */
public class HomeworkMain06 {

	public static void main(String[] args) {
		
		/* 기존 풀이
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(' ');
			}
			for(int j = 0; j < 9 - (2*i); j++) {
				System.out.print('*');
			}
			for(int j = 0; j < i; j++) {
				System.out.print(' ');
			}
			
			System.out.println();
		}
		*/
		
		int front = 0;
		
		for(int i = 0; i < 5; i++) {
			
			for(int j = 0; j < 9; j++) {
				
				if(j < front) {
					System.out.print(' ');
				} else if(j < (9-front) ){
					System.out.print('*');
				}
				
			}
			System.out.println();
			
			front++;
			
		}
		
		
		
	}

}
