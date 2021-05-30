package kr.ac.kopo.day13.homework.solution;

import java.util.Calendar;
/**
 * 년도와 달을 알면 캘린더를 출력해주는 메소드
 * @author HP
 *
 */
public class CalendarUtil {
	
	// 캘린더 객체를 한번만 사용하기 위해서 멤버변수로 사용함
	private Calendar c;
	
	public CalendarUtil() {
		c = Calendar.getInstance();
	}
	
	
	public void showDayByYear(int year) {
		for(int month = 1; month <= 12; month++) {
			showDayByMonth(year, month);
		}
	}
	
	public void showDayByMonth(int year, int month) {
//		Calendar c = Calendar.getInstance();	==> showDayByMonth가 호출될때마다 객체 생성
		
		// 날짜정보 변경
		c.set(year, (month-1), 1 );
		
		// month월 1일의 요일 알아내기
		int week = c.get(Calendar.DAY_OF_WEEK);
		
		// month의 마지막 일
		int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.println("<< " + year + "년 " + month + "월 >>");
		showDay(week, lastDay);
	}
	
	private void showDay(int week, int lastDay) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("-----------------------------------------------------------");
		
		int cnt = 0;
		
		// 1일 앞 공백 출력하기
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
			cnt++;
		}
		
		// 1일부터 마지막날까지 출력하기
		for(int day = 1; day <= lastDay; day++) {
			System.out.print(day + "\t");
			
			// 토요일에 엔터찍기
			if(++cnt % 7 == 0) {
				System.out.println();
			}
		}
		
		// 마지막 날이 토요일일때는 엔터찍지 않기
		if(cnt % 7 != 0)
			System.out.println();
		
		System.out.println("---------------------------------------------------------");
	}
}
