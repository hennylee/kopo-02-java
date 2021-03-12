package kr.ac.kopo.day04.homework;
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

	public static void main(String[] args) {
		int height = 0;
		int hour = 5;
		
		if( height < 50) {
			height += (hour * 4);
		} else {
			height += (hour * 3);
		}
		
		System.out.println(height);

	}

}
