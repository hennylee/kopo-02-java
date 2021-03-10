package kr.ac.kopo.day03.homework;

/*
	7>
		*
	   ***
	  *****
	 *******
	*********
	 *******
	  *****
	   ***
	    *
*/


/*
1		4	1	4
2		3	3	3
3		2	5	2
4		1	7	1
5		0	9	0


6		1	7	1			12	8
7		2	5	2			14	6
8		3	3	3 			16	4
9		4	1	4			18	2

 */
public class HomeworkMain07 {

	public static void main(String[] args) {
		
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
		

	}

}
