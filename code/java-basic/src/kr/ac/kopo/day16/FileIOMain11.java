package kr.ac.kopo.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * FileOutputStream, ObjectOutputStream를 사용해서 Object 하나를 입출력하기
 * @author HP
 *
 */
public class FileIOMain11 {
	
	public static void write() throws Exception{
		UserInfo user = new UserInfo("홍길동", 25, "서울시 서초구");
		
		// 만약 3개의 정보(이름, 나이, 주소) 중 age만 빼고 일부만 저장하고 싶다면? =>UserInfo클래스의 age에 transient 키워드를 붙인다.
		user.setAge(0);
		
		
		
		FileOutputStream fos= new FileOutputStream("iodata/objectData.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(user);
		oos.flush();
		
		System.out.println("objectData.txt 저장완료");
		
	}
	
	public static void read() throws Exception {
		
		// 파일 내용 읽어오기
		FileInputStream fis = new FileInputStream("iodata/objectData.txt");
		
		// 객체 단위 필터로 파일 내용 읽어오기
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 객체 단위 데이터 읽기
		UserInfo user = (UserInfo)ois.readObject();
		
		System.out.println("파일 로드 완료...");
		System.out.println(user);
	}
	
	
	public static void main(String[] args) {
		
		try {
//			write();
			read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
