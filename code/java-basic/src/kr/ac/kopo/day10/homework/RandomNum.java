package kr.ac.kopo.day10.homework;

import java.util.EnumSet;
import java.util.Random;
import java.util.Scanner;

public class RandomNum {
	
	Scanner sc = new Scanner(System.in);
	
	Random random = new Random();
	
	
	int num1;
	int num2;
	
	// 도형 선택
	int select() {
		System.out.println("도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원)");
		int selected = sc.nextInt();
		
		if(selected < 1 && selected > 4) {
			System.out.println("1~4 중에서 다시 선택하세요.");
			selected = sc.nextInt();
		}
		
		return selected;
	}
	
	// 숫자 1개 출력
	int getOne(){
		num1 = random.nextInt(9) + 2;
	
		return num1;
	}
	
	// 숫자 2개 출력
	int[] getTwo(){
		num1 = random.nextInt(9) + 2;
		num2 = random.nextInt(9) + 2;
		
		int[] nums = {num1, num2};
		return nums;
	}

	
	
} 
