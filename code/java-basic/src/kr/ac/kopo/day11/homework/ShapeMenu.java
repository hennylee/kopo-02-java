package kr.ac.kopo.day11.homework;

import java.util.Scanner;


/*
 * 질문 !!! 
 * 1. 도형을 선택하는 메소드를 생성자로 구현하는게 나은지 
 * 2. 메소드로 구현하는게 나은지 궁금합니다!
 * 
 */



/**
 * 도형을 선택하는 클래스
 * @author HP
 *
 */

public class ShapeMenu {

	public ShapeMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원) => ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		
		while(choice < 1 || choice > 4) {
			System.out.println("1~4 사이의 숫자를 입력하세요");
			break;
			// 이렇게 범위를 벗어날 경우 다시 처음부터 실행시키려면 어떻게 하나요?
		}
		
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
