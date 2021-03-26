package kr.ac.kopo.day14.homework;

import java.util.Scanner;


public class LottoMain {

	public static void main(String[] args) {
		
		LottoUtil util = new LottoUtil();
		
		System.out.print("게임 수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int gameTotal = sc.nextInt();
		sc.nextLine();
		
		int i = 1;
		
		while(i <= gameTotal) {
			System.out.println("게임 " + i++ + " : ");
			util.lottoSet();
			//util.lottoArrayList();
		}
		

	}

}
