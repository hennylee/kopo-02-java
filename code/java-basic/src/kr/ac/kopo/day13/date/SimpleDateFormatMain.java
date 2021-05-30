package kr.ac.kopo.day13.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatMain {

	public static void main(String[] args) {
		
		// 오늘 날짜 구하기
		String pattern = "yyyy년 MM월 dd일(E) HH:mm:ss / hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		String date = sdf.format(new Date());
		System.out.println(date);
		
		
		// 캘린더 객체를 가지고 simpleDateFormat 사용하기
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		
		System.out.println(sdf.format(d));

	}

}
