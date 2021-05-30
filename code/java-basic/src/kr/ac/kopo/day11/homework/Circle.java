package kr.ac.kopo.day11.homework;
/**
 * 원 클래스
 * @author iamsu
 *
 */
public class Circle extends Shape{

	// 원주율을 불변값이기 때문에 final 상수로 설정함
	final static double PI = Math.round((Math.PI*10)/10);

	/* private */ int radius;
	
	@Override
	public void getLength() {
		radius = randomLine();
	}

	@Override
	public void getArea() {
		dimensions = Math.round(Math.pow(radius, 2) * PI);
	}

	@Override
	public void info() {
		System.out.print("원의 반지름 길이가 " + radius + "일때, 넓이는 "+ dimensions);
		//System.out.print("넓이는 "+ dimensions + "이다.");
	}

}
