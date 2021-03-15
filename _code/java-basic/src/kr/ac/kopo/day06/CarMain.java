package kr.ac.kopo.day06;

// 실행 클래스
public class CarMain {
	public static void main(String[] args) {
		
		Car c = new Car();
		
		// c차의 이름 출력하기
		System.out.println(c.name);
		
		// c차의 특성 지정하기
		c.name = "소나타";
		c.price = 3200;
		c.company = "현대";
		
		// c2차의 인스턴스 객체 만들고 특성 지정하기
		Car c2 = new Car();
		c2.name = "K5";
		c2.price = 3000;
		c2.company = "기아";
		
		
		// shallow copy
		c = c2;
		
		// c, c2의 정보 출력하기
		System.out.println("모델명 : " + c.name 
						+ ", 가격 : " + c.price
						+ ", 제조사 : " + c.company);

		System.out.println("모델명 : " + c2.name 
				+ ", 가격 : " + c2.price
				+ ", 제조사 : " + c2.company);
	}
}
