package util;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUtil {
	
	static Scanner sc = new Scanner(System.in);

	public static int InputInt() {
		int input = sc.nextInt();
		sc.nextLine();
		return input;
	}
		
	public static int InputInt(String msg) {
		System.out.println(msg);
		int input=0;
		
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println(msg+" * 숫자만을 입력해주세요. * ");
		}
		input = sc.nextInt();
		sc.nextLine();
		
		return input;
	}
	
	public static String InputString() {
		String input = sc.nextLine();
		return input;
	}
		
	public static String InputString(String msg) {
		System.out.println(msg);
		String input = sc.nextLine();
		return input;
	}
	
	
	
	// String 공백체크 & 입력
	public static String StrSizeCheckInput(String msg) {
		String str="";
		do {
			str = InputUtil.InputString(msg);
			if(!StrSizeCompare(str)) {
				break;
			}
		}while(true);
		
		return str;
	}
	

	// String 공백 확인하기
	public static boolean StrSizeCompare(String str) {
		if(str.length()==0)  {
			// 입력을 안하면 true
			return true;
		}
		// 공백이 있으면 true, 없으면 false
		return str.length()>str.replaceAll(" ", "").length()?true:false;
	}
		
	// 공백 없이 입력 받기
	public static String StrNullCheckInput(String msg) {
		String str = "";
		do {
			str = InputUtil.InputString(msg);
			if(StrNullCompare(str)) {
				break;
			}
			if(!StrNullCompare(str)) {
				System.out.println("공백입니다.");
			}
		}while(true);
		
		return str;
	}

	// 공백 확인하기
	/**
	 * 공백이면 false, 공백이 아니면 true
	 * @param str
	 * @return
	 */
	public static boolean StrNullCompare(String str) {
		if(str.length()==0)  {
			// 입력을 안하면 true
			return false;
		}
		return true;
	}	
	
	
	

}
