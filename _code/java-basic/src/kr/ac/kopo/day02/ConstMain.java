package kr.ac.kopo.day02;

public class ConstMain {
	public static void main(String[] args) {
		char ch = 'A';
		
		ch = 65; 
		
		ch = '\u0041'; // 유니코드 65인 문자를 ch에 저장 (16진수 형태로 표현)
		
		System.out.println(ch);
	}
}
