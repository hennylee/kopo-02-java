package kr.ac.kopo.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HomeworkMain02 {
	static String dirName = "iodata";
	
	public static void printDirList(String dirName) {
		File dirObj = new File(dirName);
		
		System.out.println("------------------------------------------");
		System.out.println("\t" +dirName+" 폴더 정보");
		System.out.println("------------------------------------------");
		System.out.printf("%-30s %-5s %-8s %-30s", "이름", "종류", "크기", "마지막수정날짜");
		System.out.println();
		System.out.println("------------------------------------------");
		
		if(dirObj.exists() && dirObj.isDirectory()) {
			// 디렉토리에 있는 파일 이름
			String[] list = dirObj.list();
			
			for(String name : list ) {
				
				File fileObj = new File(dirName +"/"+ name); 
				
				// 파일 이름
				String fileName = fileObj.getName();
				
				// 파일 종류
				String fileType = "";		
				
				if(fileObj.isDirectory()) {
					fileType = "디렉토리";
				} else if(fileObj.isFile()) {
					fileType = "파일";
				}
				
				// 파일 크기
				long fileSize = fileObj.length();
				
				// 파일 마지막 수정 날짜
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
				String fileDate = sdf.format(new Date(fileObj.lastModified()));
				
				
				System.out.printf("%-30s %-5s %-10d %-30s", fileName ,fileType ,fileSize , fileDate);
				System.out.println();
			}
			
		}
		
		
	}
	public static void mkDir(String dirName) {
		
	}
	

	public static void main(String[] args) {
		
		// 폴더 출력하기
		printDirList(dirName);
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("[M]새폴더  [R]이름변경  [D]삭제 [.]상위폴더이동 [move]하위폴더 이동 : ");
			
			String menu = sc.nextLine(); // 원하는 메뉴 입력받기
			
			switch (menu) {
				// 새폴더
			
				// 이름 변경
			
				// 삭제
			
				// 상위폴더로 이동
			
				// 하위폴더로 이동
			
				// move
			}
			
			
			String Name = sc.nextLine(); // 폴더명 입력받기
			
			
			// 폴더 출력하기
			printDirList(dirName);
			
		}
		
	}

}