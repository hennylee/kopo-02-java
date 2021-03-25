package kr.ac.kopo.day13.homework.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMain {
	
	int year;
	int month;
	
	
	public CalendarMain() {
		select();
	}
	
	void select() {
		Scanner sc = new Scanner(System.in);
		System.out.println("선택하세요(1. 특정년도   2. 특정월   3. 종료) =>");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: 
			System.out.println("년도를 입력하세요 :");
			year = sc.nextInt();
			month = 1;
			while (month < 12) {
				printCalendar();
				month++;
			}
			
			printCalendar();
			select();
			break;
		case 2:
			System.out.println("년도를 입력하세요 :");
			year = sc.nextInt();
			System.out.println("월을 입력하세요 :");
			month = sc.nextInt();
			printCalendar();
			select();
			break;
		case 3:
			break;
		}
	}
	
	
	
	void printCalendar() {
		Calendar c = Calendar.getInstance();
		
		c.set(year, month - 1, 1);
				
		int firstDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int lastDay = c.getActualMaximum(Calendar.DATE);
		
		System.out.println("<< " + year + "년 " + month + "월 >>");
		System.out.print("일\t월\t화\t수\t목\t금\t토");
		System.out.println();
		
		// (2 - 첫번째 날짜)부터 1 ~ 마지막 날까지 출력
		for(int i = (2 - firstDayOfWeek); i <= lastDay; i++) {
			
			// 첫번째 날짜의 요일 전까지 공백 출력
			if(i < 1) {
				System.out.print(" \t");
			} else {
				c.set(year, month - 1, i );
				int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
				
				// 근데 만약 토요일을 넘어가면 한줄 엔터
				if(dayOfWeek == 7 ) {
					System.out.print(i+"\t");
					System.out.println();
				}else {
					System.out.print(i+"\t");
				}
				
			}
		}
		
		System.out.println();
		System.out.println("-----------------------------------------------------");
	}
	
	
	public static void main(String[] args) {
		CalendarMain main = new CalendarMain();
	}

}
