package kr.ac.kopo.day11.homework;

import java.util.Random;

// 도형은 점, 선, 면을 가지고 있다.
public abstract class Shape{
	
	public Shape(){
		getLength();
		getArea();
		info();
	}
	
	double dimensions;
	
	public abstract void getLength();
	public abstract void getArea();
	public abstract void info();
	
	int randomLine() {
		Random r = new Random();
		
		//nextInt() 에 숫자를 넣어주면, 0~num-1 까지의 범위에서 랜덤값을 추출한다.
		int line = r.nextInt(9) + 2;
		
		return line;
	}

}

