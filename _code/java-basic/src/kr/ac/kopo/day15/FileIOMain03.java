package kr.ac.kopo.day15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import kr.ac.kopo.util.FileClose;

/**
 * dog.jpg 파일을 dog3.jpg로 복사
 * @author HP
 *
 */
public class FileIOMain03 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			long start = System.currentTimeMillis();
			
			// 1. 스트림 열기
			fis = new FileInputStream("iodata/dog.jpg");
			fos = new FileOutputStream("iodata/dog3.jpg");
			
			// 2. 버퍼 객체 연결
			bis = new BufferedInputStream(fis);	// fis로 읽어온 데이터를 버퍼로 변환해서 받겠다!
			bos = new BufferedOutputStream(fos);
			
			// 3. 복사 수행
			while(true) {
				int c = bis.read();
				if(c == -1) break;
				bos.write(c);
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println("dog3.jpg에 복사 완료");
			System.out.println((end - start) / 1000. + "초");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 4. 스트림 닫기(연 순서 반대로 닫아야함) 
			// ====> close하는데 중복 코드가 너무많으니까 클래스로 뺴주겠음 :  kr.ac.kopo.utill.FileClose에 static으로...
			
			FileClose.close(bis, fis);
			FileClose.close(bos, fos);
			
			/*
			if(bis != null)	{
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(bos != null)	{
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(fis != null)	{
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(fos != null)	{
				try {
					bis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			*/
			
			

		}
			
		
	}
}
