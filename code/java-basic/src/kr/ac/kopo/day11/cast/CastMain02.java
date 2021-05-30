package kr.ac.kopo.day11.cast;

public class CastMain02 {
	
	public static void print(Parent p) {
		p.info();
	}	
	
	public static void main(String[] args) {
		
		
		// Child01 c = new Parent(); ==> 컴파일 에러
		
		// Child01 c = (Child01) new Parent(); ==> 실행 시 예외발생
		
		Parent p = new Child02();
		p.info();
		print(p);
		
		System.out.println("--------------------------------------------------------------");
		
		Child01 c01 = new Child01();
		print(c01);
		
		System.out.println("--------------------------------------------------------------");

		// 만약 Child02만 가지고 있는 메소드를 실행시키고 싶을 때, 명시적 형변환을 한다.
		Child02 c = (Child02) p;
		c.sing();
		c.play();
		print(c);
		
	}
}
