package kr.ac.kopo.day13.homework.solution;

import java.util.Scanner;

/**
 * 캘린더 관련 키보드 입력을 받는 클래스
 * @author HP
 *
 */
public class CalendarView {
	
	private Scanner sc;

	public CalendarView() {
		sc = new Scanner(System.in);
	}
	
	public int getInt(String msg) {
		System.out.println(msg);
		int no = sc.nextInt();
		sc.nextLine();
		
		return no;
	}
	
	public void process() {
		CalendarUtil util = new CalendarUtil();
		loop: while(true){
			int command = getInt("항목을 선택하세요(1. 특정 년도  2. 특정 월  3. 종료) : ");
			int year, month;
			
			
			switch(command) {
			case 1:
				year = getInt("년도를 입력하세요");
				util.showDayByYear(year);
				break;
			case 2:
				year = getInt("년도를 입력하세요 :");
				month = getInt("월을 입력하세요 : ");
				util.showDayByMonth(year, month);
				System.out.println("2번 선택");
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);		// 종료시키는 방법 1. System.exit(0)하기 
//				break loop;			// 종료시키는 방법 2. loop를 빠져나가기
			}
		}
		
	}
	
}
