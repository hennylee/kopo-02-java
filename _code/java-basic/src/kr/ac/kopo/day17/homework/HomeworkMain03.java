package kr.ac.kopo.day17.homework;

import java.util.Random;
import java.util.Scanner;


class Sync{
	int aTotal = 0;
	int bTotal = 0;
	int cTotal = 0;
	int dTotal = 0;
	
	
	public static int getDonation() {
		
		// 선택 가능한 금액
		int[] moneys = new int[10000/1000];
		int size = moneys.length;
		
		int money = 0;
		for(int i = 0; i < size; i++) {
			
			money += 1000;
			moneys[i] = money;
			
		}
		
		// 랜덤하게 금액 고르기
		Random random = new Random();
		int index = random.nextInt(size) + 1;
		
		return moneys[index];
		 
	}
	
	
	public  synchronized void aCall() {
		int donation = getDonation();
		
		for(int i = 0; i < 10; i++) {
			aTotal += donation;
		}
		
		
	}

	
}



public class HomeworkMain03 {
	
	
	
	
	public static void main(String[] args) {

		int aTotal = 0;
		int bTotal = 0;
		int cTotal = 0;
		int dTotal = 0;
		
		int aCnt = 0;
		int bCnt = 0;
		int cCnt = 0;
		int dCnt = 0;
		
		while(true) {
			if(aCnt == 10) {
				
			}
			
			
			
			if(aCnt + bCnt + cCnt + dCnt == 40) break;
		}
		
		Scanner sc = new Scanner(System.in);
		
		// 콜센터 4개 선택
		System.out.print("콜센터를 선택하세요 : ");
		int call = Integer.parseInt(sc.next());
		
		int donation = 0;
		
		switch(call) {
		case 1:
			aCnt++;
			aTotal += donation;
			break;
		case 2:
			bCnt++;
			bTotal += donation;
			break;
		case 3:
			cCnt++;
			cTotal += donation;
			break;
		case 4:
			dCnt++;
			dTotal += donation;
			break;
		}
		
		System.out.println(call + "번 콜센터 : " + donation);
		
		
		
		
		
	}
}
