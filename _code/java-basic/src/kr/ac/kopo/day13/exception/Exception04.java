package kr.ac.kopo.day13.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exception04 {

	public static void main(String[] args) {
		// finally는 위에 break가 있더라도 수행된다
		
		
		// [checked Exception]
		// 중첩되게 try ~ catch가 들어가 룻 있다. 
		try {
			
			FileReader fr = new FileReader("a.txt");			// java.io 패키지 밑에 있는 `파일`을 읽어오는 클래스
			
		} catch (FileNotFoundException e) {
			
			try {
				
				FileWriter fw = new FileWriter("error.log");
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
			
			e.printStackTrace();
			
		}  
		
		
	}

}
