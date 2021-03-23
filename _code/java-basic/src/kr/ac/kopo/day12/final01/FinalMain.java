package kr.ac.kopo.day12.final01;

import java.util.Random;

final class Super {
	
	private final int MAX = 100;
	
	public final void info() {
		System.out.println("Super 클래스에서 정의된 메소드...");
		// MAX = 50; 					==> MAX는 final상수이기 때문에 오류발생
	}
	
}

/*
class Sub extends Super{ 				==> final클래스는 상속 금지
	
	/*
	@Override 							==> final 메소드는 오버라이드 금지
	public void info() {
		System.out.println("Sub 클래스에서 정의된 메소드...");
	}
	*/
/*
}
*/


// 기존의 Random클래스를 상속받아서 나만의 MyRandom클래스를 만들고 싶을 때!!!
class MyRandom extends Random {
	
	/**
	 * bound가 10일 때 1~ 10사이의 난수를 추출하는 메소드
	 * @param bound 정수인 난수 범위
	 * @return 1~bound 사이의 난수
	 */
	@Override
	public int nextInt(int bound) {
		return super.nextInt(bound) + 1;
	}
	
}


// String클래스는 final클래스이기 때문에 상속받을 수 없다. 
//class MyString extends String {	}


public class FinalMain {

	public static void main(String[] args) {

		/*
		 * 1~ 100 사이의 난수를 발생시켜 출력하는 코드를 작성
		 */
		Random r = new MyRandom();
		int random = r.nextInt(3);
		System.out.println("추출된 정수값은 : " + random);
	} 

}
