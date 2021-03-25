package kr.ac.kopo.day14.generic;

/**
 * 제너릭스를 사용했을 때의 편리한 점
 */


import java.util.Random;


class B<T> {
	private T obj;
	
	public B(T obj) {
		this.obj = obj;
	}
	
	public void setObject(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return this.obj;
	}
	
	public void info() {
		System.out.println("obj : " + obj);
	}
	
}

public class GenericMain {

	public static void main(String[] args) {
		B<String> b01 = new B(new String("hello")); 	// B의 T값들이 다 String으로 변한다.
		B<Random> b02 = new B(new Random());			// B의 T값들이 다 Random으로 변한다.
		
		b01.info();
		b02.info();
		
		System.out.println("길이 : " + b01.getObj().length());  				// a01의 데이터형이 Object이기 때문에 오류 발생
//		System.out.println("길이 : " + ((String)b01.getObj()).length());		// 형변환 불필요
		
		System.out.println("난수 : " + b02.getObj().nextInt());
//		System.out.println("길이 : " + ((Random)b02.getObj()).nextInt());		// 형변환 불필요
		
	}

}
