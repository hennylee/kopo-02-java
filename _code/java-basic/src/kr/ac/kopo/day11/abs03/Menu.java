package kr.ac.kopo.day11.abs03;

import java.util.Scanner;

public class Menu {
	
	public int selectMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lv1. 프린터를 선택하세요(1.LG   2. 삼성) => ");
		int no = sc.nextInt();
		sc.nextLine();
		
		return no;
	}
	
	
	
	public void choice() {
		int type = selectMenu();
		print(type);
	}
	
	
	public void print(int no) {
		// 상속의 경우 상위클래스의 타입을 통해 하위 클래스의 인스턴스 객체를 생성할 수 있다. 
		Printer p = null;
		
		switch (no) {
		case 1: 
			p = new LGPrinter();
			break;
		case 2: 
			p = new SamsungPrinter();
			break;
		case 3: 
			p =  new HPInkjetPrinter();
			break;
		}

		// 세 가지 case 모두 같은 변수명과 메소드를 구현하기 때문에 한 번만 작성해줌으로써 코드를 줄일 수 있다.
		if(p != null)
			p.print();
		else {
			System.out.println("잘못 선택하셨습니다.");
		}
	}
}
