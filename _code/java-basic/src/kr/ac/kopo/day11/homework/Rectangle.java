package kr.ac.kopo.day11.homework;

// 직사각형
public class Rectangle extends Shape {
	/* private */ int base;
	/* private */ int height;

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

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
