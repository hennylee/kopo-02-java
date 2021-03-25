package kr.ac.kopo.day14.generic;

/**
 * 제너릭스를 사용하지 않고 Object 데이터형으로 모든 데이터형의 자료를 모아둘 때의 문제점
 */


import java.util.Random;


class A {
	private Object obj;
	
	public A(Object obj) {
		this.obj = obj;
	}
	
	public void setObject(Object obj) {
		this.obj = obj;
	}
	
	public Object getObj() {
		return this.obj;
	}
	
	public void info() {
		System.out.println("obj : " + obj);
	}
	
}

public class NonGenericMain {

	public static void main(String[] args) {
		A a01 = new A(new String("hello"));
		A a02 = new A(new Random());
		
		a01.info();
		a02.info();
		
//		System.out.println("길이 : " + a01.getObj().length());  				// a01의 데이터형이 Object이기 때문에 오류 발생
		System.out.println("길이 : " + ((String)a01.getObj()).length());		// String타입으로 형변환해야 length()사용가능
//		System.out.println("길이 : " + ((String)a02.getObj()).length());		// 실행시 에러 발생 (명시적 형변환)
		System.out.println("난수 : " + ((Random)a02.getObj()).nextInt());
		
	}

}
