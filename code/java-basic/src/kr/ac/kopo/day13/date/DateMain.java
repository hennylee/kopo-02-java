package kr.ac.kopo.day13.date;

import java.util.Calendar;
import java.util.Date;



public class DateMain {

	public static void main(String[] args) {
		
		// 오늘은 ㅇㅇ년 ㅇㅇ월 ㅇㅇ일 입니다. 
		Date d = new Date();
		System.out.println("d : " + d.toString()); 	// 왜 d를 찍으면 주소값이 안찍힐까? Date클래스에서 toString메소드를 override했기 때문이다.
		
		// 연도 추출
		int year = d.getYear() + 1900;			// 1900년 1월 1일부터 몇년째인지 결과를 반환한다.

		// 월 추출
		int month = d.getMonth() + 1;			// 0(1월) ~ 11(12월)을 출력한다.
		
		// 일 추출
		int date = d.getDate();
		
		System.out.println("오늘은 "+ year + "년 " + month + "월 " + date + "일입니다.");
		
	}

}
