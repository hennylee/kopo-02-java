package kr.ac.kopo.day04.homework;

import java.security.interfaces.RSAKey;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*

2. 1~100 사이의 4개의 수를 랜덤으로 뽑아 가장 큰수를 출력
   12 6 2 54
   가장 큰수 : 54
   
 */
public class HomeworkMain02 {

	public static void main(String[] args) {
		Random r = new Random();
		
		
		int max = r.nextInt(100)+1;
		System.out.println("num1 : "+max);
		System.out.println("-------------------");
		for(int i = 0; i < 3; i++) {
			int num = r.nextInt(100)+1;
			
			System.out.println("num"+(i+2)+" : "+num);
			System.out.println("max: " + max);
			if(num > max) {
				max = num;
			}
			System.out.println("------------------");
			
		}
		

	}

}
