package kr.ac.kopo.day08;

public class StringMain01 {

	public static void main(String[] args) {
	
		// 아래 객체들은 메모리 구조가 들리다. 
		String str = new String();	// stack 메모리 공간에 저장
		String str1 = "";			// 상수 변수 메모리 공간에 저장
		String str2 = null;
		
		System.out.println("str : " + str);
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		
		System.out.println(System.identityHashCode(str));
		System.out.println(str.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(str1.hashCode());
		
		System.out.println(System.identityHashCode(str2));
		//System.out.println(str2.hashCode());
		
		// char[]로 만든 String객체
		char[] chars = {'A','B','C','D','E'};
		String str3 = new String(chars);
		System.out.println("str3 : "+str3);
		
		// byte[]로 만든 String객체
		byte[] bytes = {97, 98, 100, 99};
		String str4 = new String(bytes);
		System.out.println("str4 : "+str4);
		
		// heap 영역의 같은 "Hello" 객체를 가리킴 => 상수영역이기 때문에 사라지지 않는다.
		String s5 = "Hello";
		String s6 = "Hello";
		
		// heap영역의 다른 "Hello"객체를 가리킴
		String s7 = new String("Hello");
		String s8 = new String("Hello");
		
	}

}
