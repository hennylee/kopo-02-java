package kr.ac.kopo.day17;


/*
 * 쓰레드 구성 2가지 방식
 * 1. Thread 클래스를 상속 받아서 구현
 * 2. runnable 인터페이스를 상속 받아서 구현
 */


// 1-1. 인형 눈 붙이는 작업 => Thread 클래스를 상속 받아서 구현
class ExtendThread extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i+1 + "번째 인형 눈 붙이기...");
		}
	}
	
}

// 2-1. 인형코 붙이는 작업 => runnable 인터페이스를 상속 받아서 구현
class ImplementThread implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i+1+ "번째 인형코 만들기...");
		}
	}
	
}


public class ThreadMain02 {
	public static void main(String[] args) {
		
		// 1-2. Thread 클래스를 상속 받아서 구현한 쓰레드 실행
		ExtendThread et = new ExtendThread();
		et.start();
		
		// 2-2. runnable 인터페이스를 상속 받아서 구현한 쓰레드 실행
		ImplementThread it = new ImplementThread();
		Thread t = new Thread(it);
		t.start();
		
		// 3. 
		for(int i = 0; i< 100; i++) {
			System.out.println(i+1+"번째 감독중...");
		}
		
		/*
		
		<왜 위의 코드 "감독중"은 쓰레드가 모두 종료된 뒤 실행되지 않고, 쓰레드처럼 작동할까?>
		
		우리가 만드는 자바는 기본적으로 1 프로세스, 1 쓰레드이다. 
		
		그 1 쓰레드가 바로 우리가 실행하는 메인이다. 
		
		그래서 전체 코드를 수행하게 되면, 
			1. 메인 쓰레드 (감독중)
			2. ExtendThread (눈 작업)
			3. ImplementThread (코 작업)
		총 3개의 쓰레드가 실행되는 것이다. 
		 
		 */
		
		
		
	}
}
