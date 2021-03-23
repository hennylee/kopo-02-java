package kr.ac.kopo.day12.homework;

import java.util.Scanner;

public class Dice extends GameMenu implements Game {
	

	int you;
	
	public Dice() {
		this.you = youSelect();
		startGame(this.you);
	}
	
	
	/**
	 * 사용자가 주사위 돌리는 메소드
	 * @return 주사위 돌려서 나온 숫자
	 */
	int youSelect() {
		System.out.println("주사위 맞추기 게임입니다.");
		
		System.out.println("주사위를 선택하세요. (1~6값 중 하나)");
		
		Scanner sc = new Scanner(System.in);
		
		you = sc.nextInt();
		sc.nextLine();
		
		if(you < 1 | you >6) {
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
		int me = (int) (Math.random() * 6 + 1);
		int result = -1;
		
		System.out.println("me : " + me +", you : "+ you);
		if(me == you) {
			System.out.println("You win");
			result = 1;
			winScore++;
		} else {
			System.out.println("You lose");
			result = 0;
			loseScore++;
		}
		
		return result;
	}

}
