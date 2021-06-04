package kr.ac.kopo.main;

import kr.ac.kopo.ui.onlineUI;

public class HanaUserMain {
	public static void main(String[] args) {
		onlineUI ui = new onlineUI();
		
		try {
			ui.execute();
		} catch (Exception e) {
			System.out.println("HanaUserUI 오류..."); 
			e.printStackTrace();
		}
	}
}
