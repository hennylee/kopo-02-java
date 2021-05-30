package kr.ac.kopo.day10.homework;

public class getDimensions extends RandomNum {
	
	
	getDimensions(){
		int shape = select();
		
		switch (shape) {
			case 1: {
				rectangle();
				break;
			}
			case 2: {
				square();
				break;
			}
			case 3: {
				triangle();
				break;
			}
			case 4: {
				circle();
				break;
			}
		}
	}
	
	// rectangle
	void rectangle(){
		int[] nums = getTwo();
		System.out.println("가로"+ nums[0] + "세로"+ nums[1]+"인 직사각형의 넓이는 " + (nums[0] * nums[1]));
	}
	
	// circle
	void circle(){
		int num = getOne();
		double pi = 3.14;
		System.out.println("반지름 "+ num +"인 원의 면적은 "+ (Math.pow(num, 2)*pi));
	}
	
	// square
	void square(){
		int num = getOne();
		System.out.println("한 변이" +  num +"인 정사각형의 넓이는 " + (Math.pow(num, 2)));
	}
	
	// triangle
	void triangle(){
		int[] nums = getTwo();
		System.out.println("밑변"+ nums[0] + "높이"+ nums[1]+"인 삼각형의 넓이는 " + (nums[0] * nums[1] / 2));
	}
}
