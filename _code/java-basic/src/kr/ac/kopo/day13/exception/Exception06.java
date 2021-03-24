package kr.ac.kopo.day13.exception;
/**
 * 사용자 정의 예외 처리
 */

import java.util.Scanner;

/*
 * 등록할 ID를 입력하세요 : hello1234
 * ID는 최대 8글자만 가능합니다.
 * 
 * 등록할 ID를 입력하세요 : hello1234
 * ID를 등록하였습니다. 
 * 
 */
public class Exception06 {

// 2. 호출자로 예외처리 날리기 =======================================================================================
	static void register() throws CheckIDException{
		Scanner sc = new Scanner(System.in);
		System.out.println("등록할 ID를 입력하세요 : ");
		String id = sc.nextLine();
		
		
		if(id.length() > 8) {
			// 기본 ===> throw new Exception("ID는 최대 8글자만 가능합니다.");
			throw new CheckIDException("ID는 최대 8글자만 가능합니다."); // CheckIDException에 매개변수 있는 생성자 만들어줘야 함
		}
		System.out.println("ID를 등록하였습니다. ");
			
	}
	
	public static void main(String[] args) {
		
		// 호출자가 던진 예외 받아서 처리하기-----------------
		try {
			register();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
// 1. 사용자 정의 예외 처리 =======================================================================================

		Scanner sc = new Scanner(System.in);
		System.out.println("등록할 ID를 입력하세요 : ");
		String id = sc.nextLine();
		
		
		try {
			if(id.length() > 8) {
				// 기본 ===> throw new Exception("ID는 최대 8글자만 가능합니다.");
				
				// 사용자 정의 예외 클래스 : {@link CheckIDException}
				throw new CheckIDException("ID는 최대 8글자만 가능합니다."); // CheckIDException에 매개변수 있는 생성자 만들어줘야 함
			}
			System.out.println("ID를 등록하였습니다. ");
			
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage()); ==> 메시지만 출력하고 싶을 때
		}
		
	}

}
