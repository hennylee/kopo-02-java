package kr.ac.kopo.day12.homework;

public class GameScore {
	
	public static int winScore = 0;
	public static int loseScore = 0;
	public static int drawScore = 0;

	/**
	 * 게임 전적 기록을 출력하는 메소드이다.
	 *
	 */
	void printScore() {
		
		System.out.println("당신의 게임 전적은 " + winScore + "승 " + loseScore + "패 " + drawScore +"무입니다.");
	}
	
	/**
	 * 게임 전적을 계산하는 메소드이다.
	 * @param result
	 */
	void countScore(int result) {

		if(result == 1) {
			winScore++;
		} else if(result == 0) {
			loseScore++;
		} else {
			drawScore++;
		}
	}
}
