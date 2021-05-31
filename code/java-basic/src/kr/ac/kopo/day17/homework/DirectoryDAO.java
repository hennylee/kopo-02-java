package kr.ac.kopo.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DirectoryDAO {
	static File dirObj = new File("iodata/");
	static Scanner sc = new Scanner(System.in);
	
	public static void printDirList() {
		
		String dirName = dirObj.getName();
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("\t" +dirName+" 폴더 정보");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%-35s %-8s %-8s %-30s", "이름", "종류", "크기", "마지막수정날짜");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------");
		
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
				
				
				System.out.printf("%-35s %-8s %-10d %-30s", fileName ,fileType ,fileSize , fileDate);
				System.out.println();
			}
			
		}
	}
	
	public static String inputString(String msg) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	
	public static String getDirName(String input) {
		String dirName = dirObj.getName();
		
		dirName += "/";
		
		dirName += input;
		
		return dirName;
	}
	
	public static void mkNewDir() {
		
		String newName = inputString("새로 만들 폴더명 입력 : ");
		
		dirObj = new File(getDirName(newName));
		
		boolean bool = dirObj.mkdirs();
		
		printDirList();
		
	}
	public static void rename() {
		
		String dirName = inputString("변경할 이름 입력 : ");
		
		dirObj = new File(getDirName(dirName));
		
		boolean bool = dirObj.renameTo(dirObj);
		
		printDirList();
		
	}
	
	public static void delDir() {
		
		String dirName = inputString("삭제할 파일/폴더 입력 : ");
		
		dirObj = new File(getDirName(dirName));
		
		boolean bool = dirObj.delete();
		
		printDirList();
		
	}
	
	public static void mvParentDir() {
		
		dirObj = new File(dirObj.getParent());
		printDirList();
		
	}
	
	public static void mvSubDir() {
		
		String dirName = inputString("이동할 폴더를 입력하세요 : ");
		
		dirObj = new File(getDirName(dirObj.getPath() +"/" +dirName));
		
		printDirList();
	}

}
