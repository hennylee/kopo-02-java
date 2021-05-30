package kr.ac.kopo.day06.homework;

import java.util.Scanner;

public class IcecreamMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이스크림 몇 개 구입할거야? : ");
		
		
		Icecream[] iceArr = new Icecream[sc.nextInt()];
		System.out.println();
		
		for(int i = 0; i < iceArr.length; i++) {
			System.out.println("***" + (i+1) + "번째 아이스크림 구매정보 입력 ***");
			
			iceArr[i] = new Icecream();
			System.out.print("아이스크림명 : ");
			iceArr[i].name = sc.next();
			System.out.print("아이스크림가격 : ");
			iceArr[i].price = sc.nextInt();
			
			System.out.println();
		}
		
		System.out.println("< 총 "+ iceArr.length +"개의 아이스크림 구매정보 출력 >");
		System.out.println("번호		아이스크림명		아이스크림가격");
		int sum = 0;
		for(int i = 0; i < iceArr.length; i++) {
			System.out.println((i+1) + " 		  " + iceArr[i].name + "			" + iceArr[i].price);
			sum += iceArr[i].price;
		}
		System.out.println();
		System.out.println("총계 : " + sum);

	}

}
