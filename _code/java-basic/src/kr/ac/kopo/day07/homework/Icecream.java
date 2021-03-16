package kr.ac.kopo.day07.homework;

import java.util.Scanner;

public class Icecream {
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * 아이스크림 정보 요소
	 * @author HP
	 *
	 */
	class IcecreamInfo{
		String name;
		int price;
	}
	
	/**
	 * 구매할 아이스크림 총 갯수 입력받기
	 * @return 아이스크림 총 갯수
	 */
	int getCount() {
		System.out.println("아이스크림 몇 개 구입할래?");
		int cnt = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		return cnt;
	}
	
	
	/**
	 * 구매한 아이스크림 정보 순서대로 출력
	 * @return 입력받은 아이스크림 정보
	 */
	IcecreamInfo[] getInfo(){
		// 총 아이스크림 구매 개수 입력 받기
		int cnt = getCount();
		
		IcecreamInfo[] ice = new IcecreamInfo[cnt];
		
		// 아이스크림 구매 정보 입력 받기
		for(int i = 0; i < cnt; i++) {
			System.out.println("*** " + (i+1) + "번째 아이스크림 구매정보 ***");
			ice[i] = new IcecreamInfo();
			
			System.out.print("아이스크림명 : ");
			ice[i].name = sc.nextLine();
			
			System.out.print("아이스크림가격 : ");
			ice[i].price = sc.nextInt();
			sc.nextLine();
			
			System.out.println();
		}
		
		// 총 구매 정보 출력하기
		printTotal(ice);
		
		return ice;
	}
	
	
	/**
	 * 입력받은 아이스크림 총 정보 출력
	 * @param ice 입력받은 아이스크림 정보들
	 */
	void printTotal(IcecreamInfo[] ice) {
		
		System.out.println("<총 " + ice.length + "개의 아이스크림 구매정보 출력>");
		
		System.out.println("번호\t아이스크림\t아이스크림가격");
		
		for(int i = 0; i < ice.length; i++) {
			System.out.println((i+1)+"\t"+ice[i].name+"\t"+ice[i].price);
		}
		
	}

}
