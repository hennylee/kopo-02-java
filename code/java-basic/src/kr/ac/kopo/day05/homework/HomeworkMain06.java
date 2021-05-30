package kr.ac.kopo.day05.homework;

import java.util.Scanner;

/*
	
숫자 맞추기 게임 구성하기

객체지향처럼 짜지 않기?!

컴퓨터가 1~100 사이의 임의의 수를 알고 있다고 가정하기

기회는 5번입니다. 



 */
public class HomeworkMain06 {

	public static void main(String[] args) {
		int chance = 5;	  // 기회
		int correct = 45; // 정답
		
		Scanner sc = new Scanner(System.in);
		
		int min = 1, max = 100; // 범위
		
		for(int i = 0; i < chance; i++) {
			System.out.print(min + "-" + max + " : ");
			int num = sc.nextInt();
			
			// 정답일 경우
			if(num == correct) {
				System.out.println("축하합니다. 정답입니다.");
				break;
			}
			else if (i == (chance - 1)) {
				System.out.println("아쉽습니다.. 기회를 다 소진하셨습니다.");
			}
			// 정답보다 클 경우
			else if(num > correct && num <= max && num >= min) {
				max = num - 1;
				System.out.println(num +"보다 작은 수 입니다.");
				System.out.println("기회는 " +(chance - i - 1)+"번 남았습니다.");
			}
			// 정답보다 작을 경우
			else if(num < correct && num <= max && num >= min) {
				min = num + 1;
				System.out.println(num +"보다 큰 수 입니다.");
				System.out.println("기회는 " +(chance - i - 1)+"번 남았습니다.");
			} 
			
			// 범위를 벗어난 수를 입력했을 경우
			else {
				i--;
			}
			
			System.out.println();
		}
		
		
		
	}

}
