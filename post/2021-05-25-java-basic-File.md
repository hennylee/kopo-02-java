- day17

## 파일 객체



## 파일 관련 메소드


```java
package kr.ac.kopo.day17;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File 메소드 정리
 * @author HP
 *
 */
public class FileMain {
	
	public static void main(String[] args) {
		
		// iodata/a.txt의 정보 읽기
		File fileObj = new File("iodata/a.txt"); // 상대경로(절대경로가 들어가도 된다.)

		String name = fileObj.getName();	// 파일 이름
		System.out.println("파일명 : " + name);
		
		String parent = fileObj.getParent(); // 파일 부모 경로
		System.out.println("부모 : " + parent);
		
		String path = fileObj.getPath();	// 상대 경로
		System.out.println("경로 : " + path);

		String abPath = fileObj.getAbsolutePath(); // 절대경로
		System.out.println("절대경로 : " + abPath);
		
		boolean bool = fileObj.isFile(); // 파일인지 확인
		System.out.println(bool? "파일입니다" : "파일이 아닙니다.");
		
		bool = fileObj.isDirectory(); // 디렉토리인지 확인
		System.out.println(bool? "디렉토리입니다" : "디렉토리가 이닙니다.");
		
		bool = fileObj.exists(); // 파일이 존재하는지 확인
		System.out.println(bool? "존재합니다" : "존재하지 않습니다.");
		
		long size = fileObj.length(); // 파일의 크기 확인
		System.out.println("파일 크기 : " + size + "byte(s)");
		
		long time = fileObj.lastModified(); // 마지막으로 수정한 시간 확인(밀리세컨드)
		
		// 밀리세컨드를 날짜로 바꾸려면 1. Date => Calendar => getMonth...	 2. simpleDataFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println("마지막 수정 날짜 : " + sdf.format(new Date(time)));
		
		bool = fileObj.canWrite();
		System.out.println(bool? "쓰기 가능" : "쓰기 불가능");
		
		bool = fileObj.canRead();
		System.out.println(bool? "읽기 가능" : "읽기 불가능");
		
		bool = fileObj.canExecute();
		System.out.println(bool? "실행 가능" : "실행 불가능");
	}
}
```

## 디렉토리 관련 메소드


```java
package kr.ac.kopo.day17;

import java.io.File;

/**
 * File의 디렉토리 관련 메소드 정리
 * @author HP
 *
 */
public class DirectoryMain {
	
	public static void main(String[] args) {
		
		File dirObj = new File("iodata");
		
		// 디렉토리 유효성 검증
		System.out.println(dirObj.exists() ? "유효한 디렉토리입니다" : "유효하지 않는 디렉토리 입니다.");
		
		System.out.println(dirObj.isDirectory()? "디렉토리입니다" : "디렉토리가 아닙니다.");
		
		
		// iodata 디렉토리 밑에 있는 모든 리스트
		String[] list = dirObj.list(); 
		
		System.out.println("-----------------------------------------");
		System.out.println("\t " + dirObj.getName() + " 정보");
		System.out.println("-----------------------------------------");
		for(String name : list) {
			System.out.println(name);
		}
		System.out.println("-----------------------------------------");
		
		// 새 디렉토리 만들기 : 성공 ( * 한 개의 폴더를 만들때에는 mkdir() 를 사용한다. *)
		File newDirObj = new File("iodata/새폴더");
		if(!newDirObj.exists()) {
			boolean bool = newDirObj.mkdir();
			System.out.println(bool? "생성 성공" : "생성 실패");
		}
		
		// 새 디렉토리 만들기 : 실패 (* 상위 폴더인 새새폴더가 없는 폴더이기 때문이다 *)
		newDirObj = new File("iodata/새새폴더/오리");
		if(!newDirObj.exists()) {
			boolean bool = newDirObj.mkdir();
			System.out.println(bool? "생성 성공" : "생성 실패");
		}
		
		// 새 디렉토리 만들기 : 성공 ( * 여러개의 폴더를 만들때에는 mkdirs() 를 사용한다. *)
		newDirObj = new File("iodata/새새폴더/오리");
		if(!newDirObj.exists()) {
			boolean bool = newDirObj.mkdirs();
			System.out.println(bool? "생성 성공" : "생성 실패");
		}
		
		// 맨 마지막에 생성된 폴더 삭제하기
		boolean bool = newDirObj.delete();
		System.out.println(bool ? "삭제 성공 " : "삭제 실패");
		
	}
}
```
