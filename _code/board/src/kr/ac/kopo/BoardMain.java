package kr.ac.kopo;

import kr.ac.kopo.ui.BoardUI;

public class BoardMain {
	public static void main(String[] args) {
		
		BoardUI ui = new BoardUI();
		try {
			ui.execute();// public void execute() throws Exception 이기 때문에 예외처리가 필요함
		} catch (Exception e) {
			e.printStackTrace(); // 예외 처리되면 소프트웨어 종료되는 문제가 발생함
		}
		
	}
}
