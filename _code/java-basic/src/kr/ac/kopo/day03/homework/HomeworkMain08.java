package kr.ac.kopo.day03.homework;
/*
	8>
		*-------*	9		1	7	1
		**-----**			2	5	2
		***---***			3	3	3
		****-****			4	1	4
		*********			
		****-****			4	1	4
		***---***			3	3	3
		**-----**			2	5	2
		*-------*			1	7	1


 */
public class HomeworkMain08 {
	public static void main(String[] args) {
		
		int star = 1;
		
		// 새로운 풀이
		for(int i = 1; i <= 9; i++) {
			
			for(int j = 1; j <= 9; j++) {
				
				if(j < star) {
					System.out.print('*');
				} else if(j > star && j <= 9 - star) {
					System.out.print('-');
				} else {
					System.out.print('*');
				}
				
			}
			System.out.println();
			
			if(i < 5) {
				star++;
			}else {
				star--;
			}
			
			
		}
		
		
		
		
		
		/* 기존 풀이
		for(int i = 1; i <= 9; i++) {
			if(i < 5) {
				for(int j=1; j <= i; j++) {
					System.out.print('*');
				}
				for(int j=1; j <= 9 - 2 * i; j++) {
					System.out.print('-');
				}
				for(int j=1; j <= i; j++) {
					System.out.print('*');
				}
			} else if(i == 5){
				for(int j = 1; j <= 9; j++) {
					System.out.print('*');
				}
			} else {
				for(int j = 1; j <= 10 - i; j++) {
					System.out.print('*');
				}
				for(int j = 1; j <= 2 * i - 11; j++) {
					System.out.print('-');
				}
				
				for(int j = 1; j <= 10 - i; j++) {
					System.out.print('*');
				}
			}
			System.out.println();
		}
		*/
		
	}

}
