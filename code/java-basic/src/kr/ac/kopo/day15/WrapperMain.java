package kr.ac.kopo.day15;

public class WrapperMain {

	public static void main(String[] args) {
		String str = "102039";
		
		int num = Integer.parseInt(str);	// parseInt는 기본 자료형을 반환한다.
			num = Integer.valueOf(str);		// valueOf는 참조 자료형을 반환한다.
	}

}
