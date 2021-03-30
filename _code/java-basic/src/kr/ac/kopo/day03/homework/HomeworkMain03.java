package kr.ac.kopo.day03.homework;
/*

3>
	*****
	****
	***
	**
	*
 */
public class HomeworkMain03 {

	public static void main(String[] args) {
		
		int star = 5;
		
		for(int i = 5; i > 0; i--) {
			
			for(int j = star--; j > 0; j--) {
				System.out.print('*');
			}
			System.out.println();
		}

	}

}
