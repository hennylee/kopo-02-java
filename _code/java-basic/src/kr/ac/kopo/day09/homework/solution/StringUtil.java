package kr.ac.kopo.day09.homework.solution;

public class StringUtil {
	
	/**
	 * 문자열을 거꾸로 변경하는 메소드 (1)String 클래스 사용하기
	 * @param 	변경할 문자열
	 * @return 	변경된 문자열
	 */
	public String reverseString01(String str) {
		char[] chars = new char[str.length()];
		
		for(int i = str.length() -1, j = 0; i >= 0; i--) {
			chars[j++] = str.charAt(i);
		}
		
		return new String(chars); // String 생성자 이용해서 char배열을 String으로 변환함
	}
	

	/**
	 * 문자열을 거꾸로 변경하는 메소드 (2) String클래스에 변화가 자주 일어나면 속도가 느림
	 * @param 	변경할 문자열
	 * @return 	변경된 문자열
	 */
	public String reverseString02(String str) {

		String revStr = new String();
		for(int i = str.length() -1, j = 0; i >= 0; i--) {
			revStr = revStr + str.charAt(i);
		}
		
		return revStr;
	}
	
	/**
	 * 문자열을 거꾸로 변경하는 메소드 (3) StringBuffer를 활용해서 사용하기
	 * @param 	변경할 문자열
	 * @return 	변경된 문자열
	 */
	public String reverseString03(String str) {

		StringBuffer sb = new StringBuffer();
		for(int i = str.length() -1, j = 0; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		
		return sb.toString(); // StringBuffer를 String으로 변환
	}
	
	/**
	 * 문자열을 거꾸로 변경하는 메소드 (4) 배열을 활용해서 swap하기
	 * @param 	변경할 문자열
	 * @return 	변경된 문자열
	 */
	public String reverseString04(String str) {

		char[] chars = new char[str.length()];
		str.getChars(0, str.length(), chars, 0); // string 배열로 복사하기
		
		int length  = str.length(); // length()를 계속 호출하면 속도가 드려지니까 변수로 만들어주기
		
		for(int i = 0, j = length - 1; i < length/2; i++,j--) {
			char swap = chars[i];
			chars[i] = chars[j];
			chars[j] = swap;
			
		}
		
		return new String(chars);  // String 생성자 이용해서 char배열을 String으로 변환함
	}


}
