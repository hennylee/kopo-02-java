package kr.ac.kopo.day07;

// 멤버변수 없이 메소드만 가지고 있는 클래스 : 기능클래스
// 실행 클래스는 MainMethod04
public class Method {

	void call() {
		System.out.println("call() 메소드 호출...");
	}
	
	void call(int i) {
		System.out.println("call(int) 메소드 호출...");
	}
	void call(double i) {
		System.out.println("call(double) 메소드 호출...");
	}

	 void call(String s) {
		System.out.println("call(String) 메소드 호출...");
	}
	 /* 오버로딩 불가능!!!!!!!!!!!!!
	 int call(String s) {
		 System.out.println("call(String) 메소드 호출...");
	 }
	 */
	 void call(String s, boolean b) {
		 System.out.println("call(String) 메소드 호출...");
	 }
	 void call(boolean b, String s) {
		 System.out.println("call(String) 메소드 호출...");
	 }
	 
	 
}
