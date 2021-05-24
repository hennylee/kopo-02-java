package kr.ac.kopo.test01;

public class Exam19 {

	static String str = "ABC123";
	public static void Change(String str) {
		str = Exam19.str + "!!!";
	}
	
	/*
	public static String Change(String str) {
		str = Exam19.str + "!!!";
		return str;
	}
	*/
	
	public static void main(String[] args) {
		String str = "ABC123";
		
		Change(str);
		
		System.out.println(str);

		//str = Change(str);
		System.out.println(str);
	}

}
