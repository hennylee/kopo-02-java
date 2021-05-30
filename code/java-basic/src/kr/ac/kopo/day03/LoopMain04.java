package kr.ac.kopo.day03;

public class LoopMain04 {
	public static void main(String[] args) {
		
		// 일반적인 break 사용법
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 5; j++) {
				
				if(j == 3) {
					break;
				}
				
				System.out.print("i="+i);
				System.out.println(", j="+j);
			}
		}
		
		System.out.println("-------------------------------");
		
		// 중첩된 loop문을 한번에 빠져나오는 break 사용법
		loop01 : for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 5; j++) {
				
				if(j == 3) {
					break loop01; // loop01이라는 반복문을 벗어난다.
				}
				
				System.out.print("i="+i);
				System.out.println(", j="+j);
			}
		}
	}
}
