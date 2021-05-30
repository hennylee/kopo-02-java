package kr.ac.kopo.day08;

public class CarMain {

	public static void main(String[] args) {
		Car c = new Car();
		Car c2 = new Car("소나타");
		Car c3 = new Car(1000, "모닝");
		
		c.Car(); // 생성자가 아닌 일반 메소드가 호출됨
		
	}

}
