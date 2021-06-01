package kr.ac.kopo.main;

import kr.ac.kopo.ui.HanaUserUI;

public class HanaUserMain {
	public static void main(String[] args) {
		HanaUserUI ui = new HanaUserUI();
		
		try {
			ui.execute();
		} catch (Exception e) {
			System.out.println("HanaUserUI 오류..."); 
			e.printStackTrace();
		}
	}
}
