package kr.ac.kopo.day11.homework;

import java.util.Scanner;


/*
 * 질문 !!! 
 * 
 * 도형을 선택하는 클래스는 객체라기보다는 메소드만 있는 것 같은데 클래스를 따로 만드는게 맞나요?
 */



/**
 * 도형을 선택하는 클래스
 * @author HP
 *
 */

public class ChoiceShape {

	public void ChoiceShape() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원) => ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
		case 1: 
			Shape rectangle = new Rectangle();
			break;
		case 2: 
			Shape square = new Square();
			break;
		case 3: 
			Shape triangle = new Triangle();
			break;
		case 4: 
			Shape circle = new Circle();
			break;
		}
		
	}
	
}
