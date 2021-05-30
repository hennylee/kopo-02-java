package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public static Calendar cal = Calendar.getInstance();

	public static String getToday() {
		return format.format(Calendar.getInstance().getTime());
	}

	public static int diffDatesFromToday(String strDate) {
		long calDateDays = 0;
		try {
			Date firstDate = format.parse(strDate);
			Date secondDate = format.parse(getToday());

			long calDate = Math.abs(firstDate.getTime() - secondDate.getTime());
			calDateDays = calDate / (24 * 60 * 60 * 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (int) calDateDays;
	}
	
	public static int diffDates(String strDate, String strDate2) {
		long calDateDays = 0;
		try {
			Date firstDate = format.parse(strDate);
			Date secondDate = format.parse(strDate2);

			long calDate = Math.abs(firstDate.getTime() - secondDate.getTime());
			calDateDays = calDate / (24 * 60 * 60 * 1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (int) calDateDays;
	}
	
	

	public static String plusWeek(String strDate) {

		try {
			Date date = format.parse(strDate);
			cal.setTime(date);

			cal.add(Calendar.DATE, 7);
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format.format(cal.getTime());
    }
	
	public static String plusDate(String strDate, int term) {

		try {
			Date date = format.parse(strDate);
			cal.setTime(date);

			cal.add(Calendar.DATE, term);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format.format(cal.getTime());
    }
	
	

}
