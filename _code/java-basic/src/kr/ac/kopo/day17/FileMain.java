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
