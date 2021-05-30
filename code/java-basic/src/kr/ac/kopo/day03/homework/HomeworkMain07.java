package kr.ac.kopo.day03.homework;

/*
	7>
		*			4	1	5		1
	   ***			3	3	6		2
	  *****			2	5	7		3
	 *******		1	7	8		4
	*********		0	9	9		5
	 *******
	  *****
	   ***
	    *
*/


public class HomeworkMain07 {

	public static void main(String[] args) {
		
		
		// 새로운 풀이
		int star = 4;
		
		for(int i = 1; i <= 9; i++) {
			
			for(int j = 1; j <= 9; j++) {
				
				if(j <= star) {
					System.out.print(' ');
				}else if(j <= (9-star)){
					System.out.print('*');
				}
				
				
			}
			
			System.out.println();
			
			if(i < 5) {
				star--;
			} else {
				star++;
			}
			
		}
		
		
		
		/* 기존 풀이 
		for(int i = 1; i <= 9; i++) {
			if(i <= 5) {
				for(int j=0; j < 5 - i; j++) {
					System.out.print(' ');
				}
				for(int j=0; j < 2 * i - 1; j++) {
					System.out.print('*');
				}
				for(int j=0; j < 5 - i; j++) {
					System.out.print(' ');
				}
			} else {
				for(int j = 0; j < i - 5; j++) {
					System.out.print(' ');
				}
				for(int j = 0; j < 19 - 2 * i; j++) {
					System.out.print('*');
				}
				for(int j = 0; j < i - 5; j++) {
					System.out.print(' ');
				}
			}
			
			System.out.println();
		}
		*/
		

	}

}
