package kr.ac.kopo.day07;

import java.util.Scanner;

public class GugudanMain {

	public static void main(String[] args) {

		Gugudan gu = new Gugudan();
		
		// 단을 입력받는 메소드 
		int dan = gu.getDan("2 - 9 사이의 단 입력 : ");
		
		gu.print(dan);
		
		gu.print();
		

		int startDan = gu.getDan("시작단을 입력 : ");
		int endDan = gu.getDan("종료단을 입력 : ");
		
		
		gu.print(startDan, endDan);
		
		

	}

}
