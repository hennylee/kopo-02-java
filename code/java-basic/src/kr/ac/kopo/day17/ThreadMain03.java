package kr.ac.kopo.day17;


/*
 * 쓰레드 구성 2가지 방식
 * 1. Thread 클래스를 상속 받아서 구현
 * 2. runnable 인터페이스를 상속 받아서 구현
 */


// 1-1. 인형 눈 붙이는 작업 => Thread 클래스를 상속 받아서 구현
class ExtendThread2 extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i+1 + "번째 인형 눈 붙이기...");
		}
	}
	
}

// 2-1. 인형코 붙이는 작업 => runnable 인터페이스를 상속 받아서 구현
class ImplementThread2 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i+1+ "번째 인형코 만들기...");
		}
	}
	
}


public class ThreadMain03 {
	public static void main(String[] args) {
		
		// 1-2. Thread 클래스를 상속 받아서 구현한 쓰레드 실행
		ExtendThread2 et = new ExtendThread2();
		
		// 2-2. runnable 인터페이스를 상속 받아서 구현한 쓰레드 실행
		ImplementThread2 it = new ImplementThread2();
		Thread t = new Thread(it);

		System.out.println("감독을 시작합니다.");
		
		et.start();
		t.start();
		
		
		// join
		/* 
			et나 t 쓰레드가 아니라 메인 쓰레드가 block 상태에 빠지게 된다. 
		 	대신, et와 t쓰레드가 끝날때까지만 block 상태에 빠진다. 
		 	매개변수가 있게 되면 해당 시간이 지난 뒤, block 상태를 빠져나오게 된다.
		*/
		
		try {
			et.join(); // 매개변수에 1을 쓰면 0.001초를 기다린 후, block상태에서 빠져나온다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		try {
			t.join(); // 매개변수에 1을 쓰면 0.001초를 기다린 후, block상태에서 빠져나온다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		System.out.println("감독을 종료합니다.");
		
	}
}
