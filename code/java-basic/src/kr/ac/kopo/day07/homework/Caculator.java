package kr.ac.kopo.day07.homework;

import java.util.Scanner;

public class Caculator {
	
	// 계산기 실행하기
	void caculate() {
		
		// 정수 입력받기
		int[] nums = getNum();
		
		System.out.println();
		
		// 사칙연산하기
		plus(nums);
		minus(nums);
		multiple(nums);
		divide(nums);
		
		System.out.println();
		
		// 정수 입력 받기
		primeCheck(nums);
	}
	
	// 정수 입력 받는 메소드
	int[] getNum() {
		int[] nums = new int[2];
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		nums[0] = sc.nextInt();
		System.out.print("정수 : ");
		nums[1] = sc.nextInt();
		
		return nums;
	}
	
	// 더하기
	void plus(int[] nums) {
		System.out.println(nums[0] + "+" + nums[1] + "=" + (nums[0]+nums[1]));
		
	}
	
	// 빼기
	void minus(int[] nums) {
		System.out.println(nums[0] + "-" + nums[1] + "=" + (nums[0]-nums[1]));
		
	}
	
	// 곱하기
	void multiple(int[] nums) {
		System.out.println(nums[0] + "*" + nums[1] + "=" + (nums[0]*nums[1]));
		
	}
	
	// 나누기
	void divide(int[] nums) {
		System.out.println(nums[0] + "/" + nums[1] + "=" + (nums[0]/(double)nums[1]));
		
	}
	
	
	// 소수체크하기
	void primeCheck(int[] nums) {
		
		for(int i = 0; i < nums.length; i++) {
			boolean check = true;
			
			for(int j = 2; j < nums[i]; j++) {
				if(nums[i] % j == 0) check = false;
			}
			
			System.out.println(nums[i] + " 소수체크 : " + check);			
		}
		
		
	}
}
