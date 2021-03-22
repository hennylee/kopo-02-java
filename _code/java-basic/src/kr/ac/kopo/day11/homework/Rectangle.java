package kr.ac.kopo.day11.homework;

// 직사각형
public class Rectangle extends Shape {
	int base;
	int height;

	@Override
	public void getLength() {
		base = randomLine();
		height = randomLine();
	}

	@Override
	public void getArea() {
		dimensions = (base * height);
	}

	@Override
	public void info() {
		System.out.println("밑변의 길이가 "+ base +", 높이가 "+ height+"인 직사각형의 넓이는 "+ dimensions+"이다.");
		
	}

}
