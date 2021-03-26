package kr.ac.kopo.day14.homework;

/**
 * Map Key에 1 ~ 45까지 담기
 * 	   Value 1로 채우기
 * 
 * set
 * 
 * while(count < 6){S
 * 
 * 	랜덤으로 뽑기
 * 	뽑힌 애 배열 값 0으로 바꾸기
 * 	이미 0이면, 다시 랜덤 뽑아야 함
 * 	count++
 * }
 * 
 * value가 0인 애들 key값 출력하기? containsValue
 * 
 */
import java.util.Random;

public class LottoArray {

	public static void main(String[] args) {

		int[] arr = new int[5];
		Random r = new Random();
		
		int num = r.nextInt(44) + 1;
		
		
	}
	
	
	
	

}
