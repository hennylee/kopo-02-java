package kr.ac.kopo.day14.homework;

import java.util.Arrays;
import java.util.Random;

public class LottoDivide {
	public static void main(String[] args) {
		
		int[] lottoArr = new int[5];
		
		int front = 1;
		int end = 45;
		
		
		LottoDivide ld = new LottoDivide();
		
		
		int num = ld.lottoRandom(front, end);
		
		for(int i = 0; i < 3; i++) {
			front = ld.boundStart(num);
			lottoArr[i] = front;
		}
		for(int i = 0; i < 3; i++) {
			end = ld.boundEnd(num);
			lottoArr[2+i] = end;
			
		}
		
		
		System.out.println(Arrays.toString(lottoArr));
		
	}
	
	int lottoRandom(int front, int end) {
		// 1 ~45에서 하나 추출
		Random r = new Random();
		
		int num = r.nextInt(end) + front;
		return num;
	}
	
	int boundStart(int num) {

		int start01 = 1;
		int start02 = num - 1;
			
		int front = lottoRandom(start01, start02);
		
		return front;
	}
	
	int boundEnd(int num) {

		int end01 = num + 1;
		int end02 = 45;
		
		int back = lottoRandom(end01, end02);
		return back;
	}
	
	
}
