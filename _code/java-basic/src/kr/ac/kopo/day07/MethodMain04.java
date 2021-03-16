package kr.ac.kopo.day07;

public class MethodMain04 {

	public static void main(String[] args) {
		Method m = new Method();
		m.call();
		m.call(10);
		m.call(10.0);
		m.call("hi");
		m.call('h'); // 매개변수가 char인 메소드를 오버로딩하지 않아도 에러 발생 x , 컴퓨터가 char없으면 묵시적 형변환된다.
	}

}
