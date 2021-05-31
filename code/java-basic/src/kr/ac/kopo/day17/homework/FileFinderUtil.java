package kr.ac.kopo.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileFinderUtil {
	boolean bool;
	public void fileList(File dirObj) {
		File[] fileList = dirObj.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t" + dirObj.getName() + "폴더 정보");
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		System.out.printf("%-28s%-10s%-20s%-10s", "이름", "종류", "크기", "마지막 수정일자");
		System.out.println();
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		for (File fl : dirObj.listFiles()) {
			System.out.printf("%-28s%-10s%-20s%-10s", fl.getName(), fl.isFile() ? "파일" : "폴더", fl.length() + "byte(s)",
					sdf.format(new Date(fl.lastModified())));
			System.out.println();
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------");
	}
	
	public File dirFile(String dirName) {
		File dirObj = new File(dirName);
		return dirObj;
	}
	
	public String input(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		String input = sc.nextLine();
		return input;
	}

	public void view(String dirName) {
		File dirObj = dirFile(dirName);
		
		
		while(true) {
			fileList(dirObj);
			String input = input("[M]새폴더\t\t[R]이름변경\t[D]삭제\t[.]상위폴더이동\t[MOVE]하위폴더이동\t[E]종료");
			switch (input) {
			case "M":
			case "m":
				String newDirName = input("새폴더 명을 입력하세요 : ");
				bool = dirFile(dirObj.getPath()+"/"+newDirName).mkdirs();
				System.out.println(bool ? "생성 성공": "생성실패");;
				
				break;
			case "R":
			case "r":
				String nowDirName = input("기존 파일명을 입력하세요 ");
				String updateDirName = input("변경할 파일명을 입력하세요 ");
				
				bool = dirFile(dirObj.getPath()+"/"+nowDirName).renameTo(dirFile(dirName+"/"+updateDirName));
				System.out.println(bool ? "변겅성공" : "변경실패");
				break;
			case "D":
			case "d":
				String delDirName = input("삭제할 파일명을 입력하세요 ");
				bool = dirFile(dirObj.getPath()+"/"+delDirName).delete();
				System.out.println(bool ? "삭제성공" : "삭제실패");
				break;
			case ".":
				if(dirObj.getParent() != null) {
					view(dirObj.getParent());
				}else {
					System.out.println("==========================이동 실패===================================");
					System.out.println("최상위 폴더 입니다.");
				}
				
				break;
			case "MOVE":
			case "move":
				String MoveDirName = input("이동할 폴더명을 입력하세요 ");
				if(dirFile(dirObj.getPath()+"/"+MoveDirName).exists()) {					
					view(dirObj.getPath()+"/"+MoveDirName);
				}else {
					System.out.println("폴더명을 다시 입력하세요!!!!!!!!!!!!!!!!!");
				}
				break;
			case "e":
			case "E":
				System.out.println("종료합니다.");
				System.exit(0);
				break;
			default:
				break;
			}
		}
		

	}



}
