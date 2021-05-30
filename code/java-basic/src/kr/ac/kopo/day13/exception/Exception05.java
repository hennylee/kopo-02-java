package kr.ac.kopo.day13.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * 예외 간접 처리
 */


// 1. 추상클래스 예외 간접 처리 ==========================================================================================
abstract class Parent {
	abstract void print();
	abstract void scan() throws Exception; // 오류 간접 처리
}

class Child extends Parent{

	@Override
	void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void scan() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

public class Exception05 {

	public static void main(String[] args) { // b() 메소드의 예외 간접 처리를 main메소드에 하게 되면 JVM에서 받아서 처리한다. 
		
		// 1. 추상클래스 예외 간접 처리 --------------------------
		Child child = new Child();
		
		try {
			child.scan();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		// 2-1. 일반클래스 예외 간접 처리 --------------------------
		try {
//		b();
		} catch (Exception e) {
			System.out.println("main() 예외처리...");
			e.printStackTrace();
		}
		
		// 2-2. 일반클래스 예외 직접 처리 --------------------------
//		a();
	}
	
// 2-1. 일반 메소드 예외 직접 처리 ==========================================================================================
	public static void a() {
		System.out.println("a() 메소드 호출...");
		
		// Checked Exception => try ~ catch
		try {
			FileReader fr = new FileReader("a.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(10 / 0);
		
		System.out.println("a()메소드 종료..");
	}
	
// 2-2. 일반 메소드 예외 간접 처리 ==========================================================================================
	public static void b() throws Exception{
		System.out.println("b() 메소드 호출...");
		String s = null;
		System.out.println(s.charAt(0));
		System.out.println( 1 / 0 ); // unchecked exception
	}

}
