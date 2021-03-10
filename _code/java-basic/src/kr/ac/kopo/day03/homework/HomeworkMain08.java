package kr.ac.kopo.day03.homework;
/*
	8>
		*-------*
		**-----**
		***---***
		****-****
		*********
		****-****
		***---***
		**-----**
		*-------*


1		1	7	1		9 - 2 * i
2		2	5	2		
3		3	3	3		
4		4	1	4


5		5	0	5		

6		4	1	4		2 * (i - 5) - 1 = 2 * i - 11
7		3	3	3		
8		2	5	2		
9		1	7	1		
		
 */
public class HomeworkMain08 {
	public static void main(String[] args) {
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
		
	}

}
