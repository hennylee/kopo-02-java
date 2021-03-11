package kr.ac.kopo.day03;

public class ExamMain01 {

	public static void main(String[] args) {
		// 1
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <=5; j++) {
				System.out.print(i+j-1);
			}
			System.out.println();
		}
		
		System.out.println("------------------------------------------------");
		
		// 2
		for(int i = 5; i >= 1; i--) {
			for(int j = 1; j <= 5; j++) {
				System.out.print(i+j-1);
			}
			System.out.println();
		}

		System.out.println("------------------------------------------------");
		
		// 3
		for(int i = 5; i >= 1; i--) {
			for(int j = i; j >= 1; j-- ) {
				System.out.print('*');
			}
			System.out.println();
		}
		

		System.out.println("------------------------------------------------");
		
		// 4.1 for 3개 + if 1개
		for(int i = 1; i <= 9; i++) {
			
			if(i <= 5) {
				for(int j = 1; j <= i; j++) {
					System.out.print('*');
				}
			} else {
				for(int j = 1 ; j <= 10 - i  ; j++) {
					System.out.print('*');
				}
			}
			System.out.println();
			
		}
		
		
		// 4.2 for 2개 + if 1개
		
	
	
		/*
		
			1	9	1
			2	8	2
			3	7	3
			4	6	4
			
			5	5	5
				
			4	6	6
			3	7	7
			2	8	8
			1	9	9
		
		 */
		
		
		
		
		// 5.1 for5 + if1 
		System.out.println("------------------------------------------------");
		for(int i = 1; i <= 9; i++) {
			
			if(i <= 5) {
				for(int j = 0; j < i - 1; j++) {
					System.out.print(' ');
				}
				for(int j = 6 - i; j >= 1; j--) { // int j = 0 으로 시작하는 것이 가독성이 더 좋다. 
					System.out.print('*');
				}
			} else {
				for(int j = 0; j < 9 - i; j++) {
					System.out.print(' ');
				}
				for(int j = 10 - i ; j <= 5 ; j++) {	// int j = 0 으로 시작하는 것이 가독성이 더 좋다. 
					System.out.print('*');
				}
			}
			System.out.println();
		}	
			
			
			
		
		// 5.2 for3 + if2 
		
		
			
		
		// 5.3 for3 + if1
		
		
		
		
		// 5.4 for2 + if2


		
		
		// 6.
		
		/*
			9개 ~ 1개
			0	9 	0
			1	7 	1
			2	5	2
			3	3	3
			4	1	4
		 */
		
		System.out.println("------------------------------------------------");
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
		
		// 7. 다이아몬드 만들기
		
		
		// 8. 나비모양 출력하기


	
	}

}
