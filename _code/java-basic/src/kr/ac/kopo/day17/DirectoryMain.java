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
