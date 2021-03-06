package kr.ac.kopo.day16;

import java.awt.dnd.DropTarget;
import java.io.FileReader;
import java.io.FileWriter;

import kr.ac.kopo.util.FileClose;

/**
 * cmd 명령어 [FileIOMain08 원본파일명 복사파일명] 를 만드는 클래스
 * 
 * 테스트 하려면, Run Configuration arguments에서 
 * FileIOMain05 FileIOMain04.java FileIOMain04.java.txt 로 바꾸기
 * @author HP
 *
 */
public class FileIOMain08 {
	
	// String[] args = {원본파일명, 복사파일명}
	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("======================================================");
			System.out.println("\t사용법 : FileIOMain06 원본파일명 복사할파일명");		
			System.out.println("======================================================");
			System.exit(0);
		}
		
		FileReader fr = null;
		FileWriter fw = null;
 		
		try {
			fr = new FileReader("iodata/" + args[0]);
			fw = new FileWriter("iodata/" + args[1]);
			
			while(true) {
				int c = fr.read();
				
				if(c == -1) break;
				fw.write(c);
			}
			
			fw.flush();
			System.out.println("파일 복사를 완료하였습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fr, fw); // utill 패키지에 존재하는 메소드
		}
		
	}
}
