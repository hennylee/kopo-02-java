package kr.ac.kopo.day11.homework;
/**
 * 정사각형 클래스
 * @author iamsu
 *
 */
public class Square extends Rectangle{
	
	@Override
	public void getLength() {
		
		// 상속관계에서 private으로 은닉화된 변수를 어떻게 사용할지 모르겠음....
		base = randomLine();
		height = base;
	}
	
	@Override
	public void info() {
		System.out.println("정사각형의 변의 길이는 " + base +"이고, 넓이는 "+ dimensions+"이다.");
		//System.out.print("넓이는 "+ dimensions + "이다.");
	}
}
