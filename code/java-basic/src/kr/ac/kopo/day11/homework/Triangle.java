package kr.ac.kopo.day11.homework;
/**
 * 삼각형 클래스
 * @author iamsu
 *
 */
public class Triangle extends Shape{
	/* private */ int base;
	/* private */ int height;
	
	@Override
	public void getLength() {
		base = randomLine();
		height = randomLine();
	}

	@Override
	public void getArea() {
		dimensions = (base * height) / 2;
		
	}

	@Override
	public void info() {
		System.out.println("삼각형의 밑변의 길이는 " +base+"이고 높이는 "+ height +"이며, 넓이는 "+ dimensions +"이다.");
		//System.out.print("넓이는 "+ dimensions + "이다.");
	}

}
