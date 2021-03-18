package kr.ac.kopo.day09;

public class StringMain05 {

	public static void main(String[] args) {
		String str = "hello world";
		
		// 처음부터 찾기
		int searchIdx = str.indexOf("o");
		System.out.println("\"o\"의 indexOf위치 : " + searchIdx);
		
		// 5번지 부터 찾기
		searchIdx = str.indexOf("o", 5);
		System.out.println("\"o\"의 indexOf위치 : " + searchIdx);
		
		// 뒤에서부터 찾기
		searchIdx = str.lastIndexOf("o");
		System.out.println("\"o\"의 lastIndex위치 : " + searchIdx);
		
		
		// str에서 'l'의 위치 전부 반환하기 ===========================================================
		
		int idx = str.indexOf('l');
		
		// 방법 1 -----------------------------------
		while(idx > 0) {
			System.out.println(idx);
			idx = str.indexOf('l', idx + 1);
		}
		
		// 방법 2 ----------------------------------
		
		int idx2 = -1;
		
		while((idx2 = str.indexOf('l', idx2 + 1)) != -1) {
			System.out.println(idx2);
		}
		
		// concat ==============================================================================
		String a = "aaa";
		String b = "bbb";
		
		String ab = a.concat(b);
		System.out.println(ab);
		
		System.out.println(1 + a);
		
		
		

	}

}
