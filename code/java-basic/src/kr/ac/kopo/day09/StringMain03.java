package kr.ac.kopo.day09;

public class StringMain03 {

	public static void main(String[] args) {
		
		System.out.println("===============================문자열 상수 비교==============================");
		String str = "Hello";
		String str2 = "Hello";
		
		// 문자열 상수 주소비교 ==============================================
		if(str == str2)
			System.out.println("str == str2");
		else
			System.out.println("str != str2");
		
		// 문자열 상수 내용비교 =============================================
		boolean bool = str.equals(str2);
		
		if(bool)
			System.out.println("str == str2");
		else
			System.out.println("str != str2");
		

		
		System.out.println("===============================문자열 객체 비교==============================");
		
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
		// 문자열 객체 주소비교 ==============================================
		if(str3 == str4)
			System.out.println("str3 == str4");
		else
			System.out.println("str3 != str4");
		
		// 문자열 객체 내용비교 =============================================
		boolean bool2 = str3.equals(str4);
		
		if(bool2)
			System.out.println("str3 == str4");
		else
			System.out.println("str3 != str4");
		
		
		System.out.println("============================문자열 대소문자 무시 비교==========================");
		
		String str5 = new String("hello");
		String str6 = new String("Hello");
		
		// 문자열 객체 주소비교 ==============================================
		if(str5 == str6)
			System.out.println("str5 == str6");
		else
			System.out.println("str5 != str6");
	

		// 문자열 객체 내용비교 =============================================
		boolean bool4 = str5.equals(str6);
		
		if(bool4)
			System.out.println("str5 == str6");
		else
			System.out.println("str5 != str6");
	
		
		// 문자열 객체 대소문자 무시하고 내용비교 =============================================
		boolean bool3 = str5.equalsIgnoreCase(str6);
		
		if(bool3)
			System.out.println("str5 == str6");
		else
			System.out.println("str5 != str6");
	
		System.out.println("============================같은 문자열로 시작하는지 비교==========================");
		String str7 = new String("hello!!!!!!");
		String str8 = new String("hello world");
		
		
		String sub = "hello";
		
		boolean bool5 = str7.startsWith(sub);
		boolean bool6 = str8.startsWith(sub);
	
		System.out.println(bool5);
		System.out.println(bool6);
		
		System.out.println("============================같은 문자열로 끝나는지 비교==========================");
		String str9 = new String("hello!!!!!!.txt");
		String str10 = new String("hello world.pdf");
		
		
		String sub2 = ".txt";
		
		boolean bool7 = str9.endsWith(sub2);
		boolean bool8 = str10.endsWith(sub2);
		
		System.out.println(bool7);
		System.out.println(bool8);
		
		System.out.println("============================compareTo==========================");
		String a = "aaa";
		String b = "bbbbbbbbb";
		
		int com = a.compareTo(b);
		
		if(com == 0) {
			System.out.println("같다");
		} else if(com > 0) {
			System.out.println("a가 b보다 더 뒷쪽에 있다.");
		} else {
			System.out.println("a가 b보다 더 앞쪽에 있다.");
		}
		
	}

}
