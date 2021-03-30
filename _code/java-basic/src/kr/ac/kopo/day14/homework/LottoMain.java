package kr.ac.kopo.day14.homework;

import java.util.Scanner;


public class LottoMain {

	public static void main(String[] args) {
		
		LottoUtil util = new LottoUtil();
		
		System.out.print("게임 수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int gameTotal = sc.nextInt();
		sc.nextLine();
		
		System.out.println("1~4 중에서 선택하세요");
		int choice = sc.nextInt();
		
		
		int i = 1;
		
		while(i <= gameTotal) {
			System.out.print("게임 " + i++ + " : ");
			
			switch (choice) {
			case 1: 
				util.lottoSet();
				break;
			case 2:
				util.lottoArrayList();
				break;
			case 3:
				util.lottoMap();
				break;
			case 4:
				util.lottoArray();
				break;
			}
			
			
		}
		

	}

}
