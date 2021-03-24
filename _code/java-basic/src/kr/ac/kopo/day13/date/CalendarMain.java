package kr.ac.kopo.day13.date;

import java.time.Year;
import java.util.Calendar;



public class CalendarMain {

	public static void main(String[] args) {

		
// 1. 오늘 [년-월-일-요일] 구하기 : get메소드 ====================================================================================
		
		// 캘린더 객체 생성
		Calendar c = Calendar.getInstance();
		System.out.println(c); 	// java.util.GregorianCalendar
		
		
		// 년
		int year = c.get(1);						// 1이라고 쓰면 직관적이지 않음
		year = c.get(Calendar.YEAR);				// Calendar클래스에 정의된 YEAR 상수 변수를 활용하면 직관적임
		
		// 월
		int month = c.get(2);
		month = c.get(Calendar.MONTH) + 1;			// MONTH : 0 ~ 11
		
		// 일
		int date = c.get(3);
		date = c.get(Calendar.DATE);	
		date = c.get(Calendar.DAY_OF_MONTH);		// 변수 DAY_OF_MONTH나 DATE모두 상수값 5로 저장되어 있음
		
		// 요일
		int day = c.get(Calendar.DAY_OF_WEEK);		// 1(일요일) ~ 7(토요일)
		String[] dayArr = {"","일", "월", "화", "수", "목", "금", "토"};

		System.out.println(year + "-" + month + "-" + date +" (" + dayArr[day] + ")");
		
		
// 2. 2021년 5월 5일은 무슨 요일? : set메소드 ================================================================================
		
		// 2021년 5월 5일은 무슨 요일?
		c.set(2021, 5-1, 5);					// MONTH : 0 ~ 11이므로 5월이 궁금하면 4를 매개변수로 넘겨줘야 한다.
		day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println("2021-5-5은 " + dayArr[day] + "요일 입니다.");
		
		// 5월의 마지막날이 몇일?
		int lastday = c.getActualMaximum(Calendar.DATE);
		System.out.println("5월은 " + lastday +"일이 마지막 날이다.");
		
		// 2월의 마지막날이 몇일?
		c.set(c.MONTH, 2-1);
		lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("2월은 " + lastday + "일로 구성되어 있습니다.");
		
	}

}
