package kr.ac.kopo.day15;

import java.io.InputStream;
import java.io.InputStreamReader;

public class FileIOMain01 {
	public static void main(String[] args) throws Exception {	// 외부장치에서는 예외가 발생할 수 있기 때문에 예외처리 해줘야 함
		
		System.out.println("종료 시 crtl+z를 누르면 종료합니다.");		// [ctrl+z] : 라인의 맨 첫 열에서 Interrupt하기
		
		
		
		InputStream is = System.in; // 표준 입력 장치
		
/* 1바이트 단위의 InputStream으로 읽어오기============================================================
		while(true) {
			int c = is.read();	// 바이트 단위로 읽어와서 한글같은 유니코드는 쓸 수 없다. 
			// 바이트 스트림을 문자스트림으로 변화가 필요하다!
			// 그게 바로 InputStreamReader
			if(c == -1) break;
			System.out.print((char)c);
		}
		
		
		/*
		 * 아스키코드나 유니코드는 모두 0보다 큰 값을 가진다
		 * 그래서 입력 값이 없으면 -1로 출력된다.
		 */
		
		
// 2바이트 단위의 InputStreamReader 읽어오기 ========================================================
		// 바이트로 들어오는 데이터를 문자로 읽어서 사용할거야~
		InputStreamReader isr = new InputStreamReader(is);
		
		while(true) {
			
			int c = isr.read();
			if(c == -1) break;
			System.out.println((char)c);
			
		}
	}
}
