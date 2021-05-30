package kr.ac.kopo.day04.homework;

import java.util.Scanner;

/*

   
3. 달팽이가 100M깊이의 우물에 빠졌습니다
   달팽이는 5M/hour 우물을 기어오릅니다
   올라간 높이가 50M미만일 때는 -1M/hour 
              50M이상일 때는 -2M/hour
   달팽이는 몇시간만에 우물을 탈출할까요?
   
   [1시간후] 달팽이가 올라간 총 높이 : 4M
   [2시간후] 달팽이가 올라간 총 높이 : 8M
   ....
   [XX시간후] 달팽이가 올라간 총 높이 : 100M or 101M or 102M
   

 */
public class HomeworkMain03 {
	static final int DEPTH = 100;
	static int speed = 5;

	public static void main(String[] args) {
		
		int hour = 1;
		int height = 0;

		if(height < 50) {
			speed -= 1;
		} else if(height < 100) {
			speed -= 2;
		} 
		
		while(height < DEPTH) {

			height = speed * hour;			
			System.out.println("[" + hour + "시간후] 달팽이가 올라간 초 높이 : " + height + "M");
			hour++;
		}
		
	}

}
