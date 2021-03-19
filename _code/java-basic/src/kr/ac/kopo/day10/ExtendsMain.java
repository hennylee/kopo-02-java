package kr.ac.kopo.day10;


class One {
	One() {
		System.out.println("One 생성자 호출...");
	}
}

class Two extends One{
	Two() {
		//super() 라는 생성자가 숨어 있다.
		System.out.println("Two 생성자 호출...");
	}
}

class Three extends Two {
	Three() {
		System.out.println("three 생성자 호출...");
	}
}

public class ExtendsMain {

	public static void main(String[] args) {
		new Three();
	}

}
