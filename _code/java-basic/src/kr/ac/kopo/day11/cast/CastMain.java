package kr.ac.kopo.day11.cast;

public class CastMain {

	
	// 매개변수의 묵시적 형변환
	public static void print(Parent p) {
		p.info();
	}	
	
	
	public static void main(String[] args) {
		
		
		Child01 c01 = new Child01();
		c01.info();
		print(c01);	// 오버라이딩에 의한 묵시적 형변환
		
		Child02 c02 = new Child02();
		c02.info();
		print(c02);	// 오버라이딩에 의한 묵시적 형변환
		
		Parent p = new Parent();
		p.info();	
		print(p);	// 오버라이딩에 의한 묵시적 형변환
		
		
		
		/*
		
		// 묵시적 형변환
		Parent p = new Child01();
		System.out.println(p.name + ", " + p.age);	
		p.info();									// 묵시적 형변환 발생!!!!
		
		
		*/
		
		
		
		
		/*
		
		
		Child01 c01 = new Child01();
		System.out.println(c01.name + ", " + c01.age);
		c01.info();
		
		Parent p = new Parent();
		System.out.println(p.name + ", " + p.age);
		p.info();
		
		*
		*/
	}

}
