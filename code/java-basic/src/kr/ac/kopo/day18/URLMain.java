package kr.ac.kopo.day18;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLMain {
	public static void main(String[] args) {
		try {
			URL urlObj = new URL("https://comic.naver.com/webtoon/list.nhn?titleId=670143&weekday=wed");
			URL urlObj2 = new URL("http://www.naver.com:80");
			
			// 1. URL 정보를 알고 싶을 때 사용하는 메소드
			System.out.println("프로토콜 : " +  urlObj.getProtocol());
			System.out.println("호스트명 : " +  urlObj.getHost());
			System.out.println("포트 : " +  urlObj.getPort()); // 포트를 명시하지 않으면 -1로 인식
			System.out.println("경로 : " +  urlObj.getPath());
			System.out.println("쿼리 : " +  urlObj.getQuery());
			
			
			// 2. openStream 메소드 => 페이지 소스 보기 했을때의 내용이 불러와짐, input만 가능하다
			System.out.println("===================================================================");
			
			// input
			InputStream is = urlObj.openStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 한글이 깨지지 않도록 바이트스트림을 문자스트림으로 받는 필터
 			
			while(is.read() != -1) {
				int c = isr.read();
				System.out.print((char)c);
			}
			
			
			// 3. openConnection() => input, output 객체를 모두 사용 가능하다.
			System.out.println("===================================================================");

			// input
			URLConnection uc = urlObj.openConnection();
			InputStream is2 = uc.getInputStream();
			InputStreamReader isr2 = new InputStreamReader(is2, "utf-8"); // 한글이 깨지지 않도록 바이트스트림을 문자스트림으로 받는 필터
 			
			while(is2.read() != -1) {
				int c = isr2.read();
				System.out.print((char)c);
			}
			
			// output
			uc.getOutputStream();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
