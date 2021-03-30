package kr.ac.kopo.day03.homework;
/*

4>
	*
	**
	***
	****
	*****
	****
	***
	**
	*
	
	for3 + if1
	for2 + if1
	
 */
public class HomeworkMain04 {

	public static void main(String[] args) {
		
		int star = 1;
		
		for(int i = 1; i <= 9; i++) {
			
			
			for(int j = 0; j < star; j++) {
				System.out.print('*');
			}
			System.out.println();
			if(i <5) {
				star++;
			}else {
				star--;
			}
			
		}

	}

}
