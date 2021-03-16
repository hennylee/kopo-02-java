package kr.ac.kopo.day07;

public class MethodMain03 {
	
	/**
	 * 임의의 문자를 반복하여 출력하는 기능
	 * @param cnt 출력횟수
	 * @param c
	 * @return 
	 */
	
	// 호출자 메소드와 대화하는 피호출자 메소드 정의하기
	static String printStar(char c, int cnt){
		for(int i = 0; i < cnt; i++) {
			System.out.print(c);
		}
		System.out.println();
		
		return "everybody";
	}
	
	public static void main(String[] args) {
		
		// printStar라는 문장 실행하기
		String data = printStar('*',10);
		System.out.println("hello");
		printStar('{',10);
		System.out.println("hi");
		printStar('!',10);
		System.out.println("good bye");
		printStar('+',10);
	}

}
