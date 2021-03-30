package kr.ac.kopo.day03.homework;
/*
5>
	*****
	-****
	--***
	---**
	----*
	---**
	--***
	-****
	*****
	
	for5 + if1
	for3 + if2
	for3 + if1
	for2 + if2
	

 */
public class HomeworkMain05 {

	public static void main(String[] args) {
		
		int line = 1;
		
		
		for(int i = 1; i<= 9; i++) {
			
			for(int j = 1; j <=5; j++) {
				
				if(j < line) {
					System.out.print('-');
				} else {
					System.out.print('*');
				}
				
			}
			System.out.println();
			
			if(i < 5) {
				line++;
			} else {
				line--;
			}
			
		}
		

	}

}
