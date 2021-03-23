package kr.ac.kopo.day12.homework;

import java.util.Scanner;

public class GameMenu {
	
	char choice;
	GameScore gs = new GameScore();
	int you;
	
	/**
	 * 게임 선택하는 메소드
	 */
	char choiceGame() {
		System.out.println("게임을 선택하세요");
		System.out.println(" A. 가위바위보");
		System.out.println(" B. 주사위 값 맞추기");
		System.out.println(" C. 종료");

		Scanner sc = new Scanner(System.in);
		choice = sc.next().charAt(0);
		sc.nextLine();
				
		if(choice == 'A' | choice == 'B' | choice == 'C' |choice == 'a' | choice == 'b' | choice == 'c') {
			playGame(choice);
		} 
		else {
			System.out.println("다시 입력하세요");
			choiceGame();
		}
		
		return choice;
	}
	
	
		
	/**
	 * 게임 실행하는 메소드이다.
	 */
	void playGame(char choice) {
		Game g = null;
		
		switch (choice) {
		case 'A' : 
			g = new ScissorsRockPaper();
			you = g.youSelect();		// 너가 고른 값
			g.startGame(you);			
			choiceGame();
			
			break;
		case 'B' : 
			g = new Dice();
			you = g.youSelect();		// 너가 고른 값
			g.startGame(you);			// 게임 실행

			choiceGame();				// 선택 재귀호출..?
			break;
		case 'C' : 
			System.out.println("게임을 종료합니다.");
			gs.printScore();				   // 게임 전적 출력하는 메소드 실행
			break;
		}	
			
	}
	

	
}
