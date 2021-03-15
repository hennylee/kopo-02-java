package kr.ac.kopo.day05.homework;
/*

7. 사용자가 생각하는 숫자를 컴퓨터가 맞추는 프로그램을 작성하세요.

   사용자가 생각하는 숫자가 [88]입니까?(맞으면 0, 작은수면 1, 큰수면 2) ==> 1
   ... 	




	반씩 잘라서 물어보기??
	1/2로 가르는 방식이 처음에 가장 좋은 알고리즘임
	
	

 */
public class HomeworkMain07 {

	public static void main(String[] args) {
		int userNum = 65; // 사용자가 생각한 숫자
		
		int min = 1;
		int max= 100;
		
		
		while(true) {
			int comNum = (min + max) / 2;
			System.out.println("사용자가 생각하는 숫자가 [" + comNum +"] 입니까?");
			
			// 정답이면
			if(comNum == userNum) {
				System.out.println(0);
				break;
			}
			// 컴퓨터수가 더 크면
			else if(comNum > userNum) {
				max = comNum - 1;
				System.out.println(2);
			}
			// 컴퓨터 수가 더 작으면
			else {
				min = comNum + 1;
				System.out.println(1);
			}
		}
		
	}

}
