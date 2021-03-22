package kr.ac.kopo.day11.homework;

public class Square extends Rectangle{
	/*
	 * Square(){ super(); }
	 */
	
	@Override
	public void getLength() {
		base = randomLine();
		height = base;
	}
	
	@Override
	public void info() {
		System.out.println("정사각형의 변의 길이는 " +base+"이고, 넓이는 "+dimensions+"이다.");
	}
}
