package kr.ac.kopo.day03;

public class LoopMain02 {

	public static void main(String[] args) {
		
		/*
		 * 별찍기
		 * 제약조건 : print함수는 하나의 문자만 출력할 수 있다. 
		 */
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
	}

}
