package kr.ac.kopo.day17.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DirectoryUI {
	

	public static void main(String[] args) {
		DirectoryDAO dao = new DirectoryDAO();
		
		// 폴더 출력하기
		dao.printDirList();
		
		while(true) {
			
			// 원하는 메뉴 입력받기
			String menu = dao.inputString("[M]새폴더  [R]이름변경  [D]삭제 [.]상위폴더이동 [move]하위폴더 이동 : "); 
			
			switch (menu) {
			// 새폴더
			case "M":
				dao.mkNewDir();
				break;
				
			// 이름 변경
			case "R":
				dao.rename();
				break;
			// 삭제
			case "D":
				dao.delDir();
				break;
			
			// 상위폴더로 이동
			case ".":
				dao.mvParentDir();
				break;
				
			// 하위폴더로 이동
			case "move":
				dao.mvSubDir();
				break;
			}
			
			
			
		}
		
	}

}
