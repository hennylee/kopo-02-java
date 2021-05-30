package kr.ac.kopo.day02;

import java.util.Scanner;

/*
 * q. 좋아하는 계절을 입력하세요
 * a. 봄은 3~5월입니다.
 * 
 */



public class SwitchMain02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 계절을 입력하세요 : ");
		String season = sc.nextLine();
		System.out.println();
		
		switch(season) {
		case "spring" :
		case "SPRING" :
		case "봄" :
			System.out.println("봄은 3~5월까지 입니다.");
		
		case "summer" :
		case "SUMMER" :
		case "여름" :
		}
	}

}
