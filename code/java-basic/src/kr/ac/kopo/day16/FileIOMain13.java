package kr.ac.kopo.day16;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.FileClose;

/**
 * ArrayList를 직렬화 시킨 코드
 * @author HP
 *
 */
public class FileIOMain13 {
	
	
	public static void write() {
		
		UserVO user = new UserVO("홍길동", 26, "010-1111-2222", "서울시 서초구");
		UserVO user2 = new UserVO("김길동", 30, "010-3333-4444", "경기도 광명시 철산동");
		UserVO user3 = new UserVO("구길동", 58, "010-5555-6666", "경기도 고양시 덕양구");
		
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(user);
		list.add(user2);
		list.add(user3);
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iodata/userList2.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			oos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(oos);
			FileClose.close(fos);
		}
		System.out.println("저장 완료");
		
	}
	
	
	public static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<UserVO> list = new ArrayList<UserVO>(); // ArrayList도 Serializable 인터페이스를 상속받기 때문에 직렬화시킬 수 있다. 
		
		try {
			fis = new FileInputStream("iodata/userList2.txt");
			ois = new ObjectInputStream(fis);
			
			list = (List<UserVO>)ois.readObject();
			
			System.out.println("파일 로드 완료....");
			
			for(UserVO vo : list) {
				System.out.println(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(ois);
			FileClose.close(fis);
		}
		
	}
	
	
	public static void main(String[] args) {
//		write();
		read();
	}

}
