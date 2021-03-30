package kr.ac.kopo.day02;

public class OperationMain03 {

	public static void main(String[] args) {
		int a = 1, b = -1, c = 0;
		
		boolean bool = a++ > 0 || b++ >= 0 && c++ > 0;
					// 참			거짓			거짓
		
		/*
		 * a++ > 0 || b++ >= 0 && c++ > 0; 은
		 * 
		 * a++ > 0 || (b++ >= 0 && c++ > 0) 와 마찬가지이다.
		 * 
		 * 그래서 
		 * a++ > 0 || ( ); 이 면저 수행되어서
		 * 
		 * 앞이 참이니까 뒤의 것은 수행하지도 않고 결과 true를 도출하는 것이다.
		 * 
		 */
		
		System.out.println("bool : " + bool);
		
		System.out.println("a : " + a + ", b : " + b + ", c : " + c);

	}

}
