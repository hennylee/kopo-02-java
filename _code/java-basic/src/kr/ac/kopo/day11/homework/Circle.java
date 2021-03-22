package kr.ac.kopo.day11.homework;

public class Circle extends Shape{

	final static double PI = Math.round(Math.PI);
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
		System.out.println("반지름의 길이가 " + radius + "인 원의 넓이는 "+ dimensions);
	}

}
