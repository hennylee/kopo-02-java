package kr.ac.kopo.day16;
// 목표  : iodata패키지의 FileIOMain04.java를 FileIOMain04.java.txt로 복사하기
// Buffer를 사용하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import kr.ac.kopo.util.FileClose;

public class FileIOMain09 {
	
	public static void main(String[] args) {
		
		FileReader fr = null;
		FileWriter fw = null;

		BufferedReader br = null;
		BufferedWriter bw = null;
 		
		try {
			fr = new FileReader("iodata/FileIOMain04.java");
			fw = new FileWriter("iodata/FileIOMain04_2.java.txt");
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			while(true) {
				
				String data = br.readLine();
				
				if(data == null) break;
				
				bw.write(data);
				/*
				 *  리눅스, 윈도우에 따라 엔터의 기호가 다르다. ('\r', '\r\n')
				 *  이를 대비한 메소드가 바로 newLine()이다.
				 */
				bw.newLine();
			}
			bw.flush();
			
			System.out.println("파일 복사를 완료하였습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 필터클래스를 먼저 닫아줘야 한다.
			FileClose.close(br, bw); // utill 패키지에 존재하는 메소드
			FileClose.close(fr, fw); // utill 패키지에 존재하는 메소드
		}
		
	}
}
