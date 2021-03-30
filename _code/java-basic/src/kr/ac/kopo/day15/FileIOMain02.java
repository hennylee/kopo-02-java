package kr.ac.kopo.day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.stream.Stream;

/**
 * 	[iodata]/[dog.jpg]를 ===> [iodata]/[dog2.jpg]로 복사한다
 * 
 * 	dog.jpg를 읽어야 하니까 입력장치이다.
 * 	dog2.jpg는 저장을 해야 하니까 출력 장치이다.
 * 
 * 
 * 	[순서]
 * 	1. stream open : 객체 만들기
 * 	2. read/write 
 * 	3. stream close	
 * 
 */
public class FileIOMain02 {
	public static void main(String[] args) { // 파일이 없을 때 예외 발생 처리
		
//		FileOutputStream fos = new FileOutputStream("aa.txt");	==> 기본으로 자바프로젝트 디렉토리에 aa.txt파일이 생긴다.
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			
			long start = System.currentTimeMillis();
			
// 1. stream open = 객체 생성 = 통로 연결
			
			fis = new FileInputStream("iodata/dog.jpg");
			fos = new FileOutputStream("iodata/dog2.jpg");
			
// 2. read/write
			
			while(true) {
				int c = fis.read();
				if(c == -1) break;
				fos.write(c);
			}
			
			System.out.println("복사 완료");
				
				
			long end = System.currentTimeMillis();
			System.out.println("소요시간 : " + (end - start) / 1000. + "초");
			/*
			 * 시간이 1초 이상 걸리는 이유는?
			 * 70kb인데 1byte씩 옮기고 있으니까 느린 것이다.
			 * 그래서 속도를 더 빠르게 하기 위해 한번에 담아놓고 옮기는 것이 버퍼이다.
			 */
				
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
// 3. stream close 

			try {
				fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			System.out.println("stream close");
			
		}
		
/*
 * read/write를 할때 Stream을 열면 파일 lock이 걸려서 Stream 객체만 사용가능하게 된다.
 * lock을 해제하면 내용을 볼 수 있게 되는 것이다.
 * lock은 메인 메소드가 끝나면 해제된다.
 * 근데 무한 루프가 돌면 main메소드 종료가 안되어서 lock해제가 안되는 것이다.
 */
		
		//	while(true);
 		
	}

}
