package kr.ac.kopo.day16;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.FileClose;

/**
 * FileOutputStream, ObjectOutputStream를 사용해서 Object 여러개를 ArrayList 단위로 입출력하기
 * @author HP
 *
 */
public class FileIOMain12 {
	
	
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
			fos = new FileOutputStream("iodata/userList.txt");
			oos = new ObjectOutputStream(fos);
			
			/*
			 * for(int i = 0; i < list.size(); i++) { oos.writeObject(list.get(i)); }
			 */
			
			for(UserVO vo: list) {
				oos.writeObject(vo);
			}
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
			fis = new FileInputStream("iodata/userList.txt");
			ois = new ObjectInputStream(fis);
			
			
			/*
			 * 
			  while(ois != null) {
				UserVO user = (UserVO)ois.readObject();
				System.out.println(user);
			  }
			  
			  java.io.EOFException ==> 파일의 끝이 애매하게 정의되어 있기 때문에 발생 => 예외 처리를 해줘야 함
			  
			*/
			
			while(true) {
				
				try {
					UserVO user = (UserVO)ois.readObject();
					list.add(user);
				} catch (EOFException e) {
					break;
				}
			}
			
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
