package kr.ac.kopo.day04.homework;

import java.util.Random;

/*

2. 4개의 정수를 랜덤으로 뽑아 가장 큰수를 출력
   12 6 2 54
   가장 큰수 : 54
   


 */
public class HomeworkSolution02 {

	public static void main(String[] args) {
		// 4개의 정수 랜덤으로 추출
		Random r = new Random();
		
		// 1~ 100 사이 숫자
		
		/*
		 * nextInt는 양/음의 정수가 모두 나옴
		 * r.nextInt(100)을 하면 0 ~ 99 사이 숫자가나옴
		 * r.nextInt() % 100 을 하면 -99 ~ 99까지의 숫자가 나옴
		 */
		int num = r.nextInt(100) + 1;
		int num2 = r.nextInt(100) + 1;
		int num3 = r.nextInt(100) + 1;
		int num4 = r.nextInt(100) + 1;
		
		
		

	}

}
