package kr.ac.kopo.day04.homework;

import java.util.Arrays;
import java.util.function.IntPredicate;

/*
 * 이 문제는 모르겠습니다....다시 한 번 생각해보고 올리겠숩니다!!
 */


/*

5. 2 ~ 100사이의 소수를 출력
	2  3  5  7  11 13  17 ... 97
	------------------------------
	 2  3  5  7  11
	13 17 ...
	
	
 */
public class HomeworkMain05 {
	
	public static void main(String[] args) {
		
		// 방법 1 : 소수의 갯수를 미리 추측해서 배열 방 만들어놓기
		
		prime01();
		
		
		
		
		// 방법 2 : 소수를 배열 방에 담아두고 소수가 아니면 0으로 바꾸기
		
		
		
		// 방법 3 : hashMap을 활용해서 소수인 것과 아닌 것 표기하기
		
		
	}
	
	
	// 방법 1 : 소수의 갯수를 미리 추측해서 배열 방 만들어놓기
	private static void prime01() {
		
		int[] primes = new int[30]; // 2 ~ 100까지니까 30개의 배열 방 만들어두기?
		int loc = 0;
		
		
		for(int i = 2; i <= 100; i++) {
			
			for(int j = 0; j < loc; j++) {
				if(i % primes[loc] != 0) {
					primes[loc++] = i;
				}
			}
		}
		System.out.println(Arrays.toString(primes));
		
	}
	

}
