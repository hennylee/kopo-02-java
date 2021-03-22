package kr.ac.kopo.day11.homework;

import java.util.Random;
/**
 * 도형의 공통 요소를 모아둔 추상클래스
 * @author iamsu
 *
 */
public abstract class Shape{
	
	// 넓이는 모든 도형마다 하나씩 가지고 있어서 멤버변수로 잡음 => 변은 하나인것도 있고, 두개 인것도 있어서 멤버변수로 잡지 않음
	protected double dimensions;
	
	// Shape의 생성자 => 상속받은 모든 도형이 똑같이 실행됨
	public Shape(){
		getLength();
		getArea();
		info();
	}
	
	// 길이를 구하는 추상메소드 => 도형마다 필요한 변이 다르니까 추상메소드로 잡음..
	public abstract void getLength();
	
	// 넓이를 구하는 추상메소드 => 도형마다 넓이를 구하는 방식이 다르니까 추상메소드로 잡음..
	public abstract void getArea();
	
	// 도형 정보를 출력하는 메소드 => 도형마다 출력 메세지가 다르니까 추상메소드로 잡음
	public abstract void info();
	//System.out.print("넓이는 "+ dimensions + "이다."); 
	//이 부분은 모든 도형에서 공통적으로 사용되는데 abstract메소드에서 공통부분을 따로 구현할 수 없나요?
	
	public int randomLine() {
		Random r = new Random();
		
		//nextInt() 에 숫자를 넣어주면, 0~num-1 까지의 범위에서 랜덤값을 추출한다.
		int line = r.nextInt(9) + 2;
		
		return line;
	}
	

}

