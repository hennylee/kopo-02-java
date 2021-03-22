package kr.ac.kopo.day11.cast;

public class CastMain03 {
	
	public static void print(Parent p) {
		p.info();
		
		System.out.println("[p instanceof Child01] : " + (p instanceof Child01));
		System.out.println("[p instanceof Child02] : " + (p instanceof Child02));
		System.out.println("[p instanceof Parent] : " + (p instanceof Parent));
		
		if(p instanceof Child01) {
			
			Child01 c = (Child01) p;
			c.sleep();
			c.study();
			
		}else if (p instanceof Child02) {
			
			Child02 c = (Child02) p;
			c.sing();
			c.play();
			
		}
	}	
	
	public static void main(String[] args) {
		
		
		Parent parent = new Parent();
		print(parent);
		System.out.println("--------------------------------------------------------------");
		
		Parent p = new Child02();
		print(p);
		
		System.out.println("--------------------------------------------------------------");
		
		Child01 c01 = new Child01();
		print(c01);
		
		System.out.println("--------------------------------------------------------------");

		// 만약 Child02만 가지고 있는 메소드를 실행시키고 싶을 때, 명시적 형변환을 한다.
		Child02 c = (Child02) p;
		print(c);
		
	}
}
