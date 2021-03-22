package kr.ac.kopo.day11.abs02;

public class LGPrinter extends Printer {
	
	/*
	public void lgPrint() {
		System.out.println("LG프린터에서 출력 중...");
	}
	*/
	
	// 상속받은 추상 클래스의 추상 메소드를 오버라이딩
	@Override
	public void print() {
		System.out.println("LG프린터에서 출력 중...");
	}
	
}
