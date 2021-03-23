package kr.ac.kopo.day12.homework;

import java.util.Random;
import java.util.Scanner;

public class ScissorsRockPaper extends GameMenu implements Game{
	final static int SISSOR = 1;
	final static int ROCK = 2;
	final static int PAPER = 3;
	int you;
	
	public ScissorsRockPaper() {
		this.you = youSelect();
		startGame(this.you);
	}
	
	
	/**
	 * 사용자가 가위바위보 선택하는 메소드
	 * @return 사용자가 선택한 것
	 */
	int youSelect() {
		System.out.println("가위바위보 게임입니다.");
		
		System.out.println("가위바위보 중 하나를 선택하세요.");
		
		System.out.println("1:가위, 2:바위, 3:보");
		
		Scanner sc = new Scanner(System.in);
		
		you = sc.nextInt();
		sc.nextLine();
		
		if(you < 1 | you >3) {
			System.out.println("다시 입력하세요.");
			youSelect();
		}
		
		return you;
				
	}
	
	/**
	 * 게임 실행하는 메소드
	 */
	@Override
	public int startGame(int you) {
		int result = -1;
		
		// 컴퓨터 가위바위보 선택
		int me = (int)(Math.random() * 3 + 1); 
		int temp = me - you;
		
		System.out.println("me : " + me +", you : "+ you);
		
		// win
		if(temp == -1 || temp == 2) {
			System.out.println("You win");
			result = 1;
			winScore++;
		} 
		// lose or draw
		else {
			if(temp == 1 || temp == -2) System.out.println("You lose");
			else {
				System.out.println("비겼습니다.");
				drawScore++;
			}
			result = 0;
			loseScore++;
		}
		
		return result;
	}

}
