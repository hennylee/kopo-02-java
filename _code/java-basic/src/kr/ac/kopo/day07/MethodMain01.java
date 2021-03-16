package kr.ac.kopo.day07;

/*
	*************
	hello
	*************
	hi
	*************
	good bye
	*************
 */

public class MethodMain01 {

	// printStar라는 문장의 집합 정의하기
	static void printStar(){
		System.out.println("*************");
	}
	
	public static void main(String[] args) {
		
		// printStar라는 문장 실행하기
		printStar();
		System.out.println("hello");
		printStar();
		System.out.println("hi");
		printStar();
		System.out.println("good bye");
		printStar();
	}

}
