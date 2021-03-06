package kr.ac.kopo.day17;

// Thread를 상속받으면 AAA, BBB가 Thread라고 인식된다. 
class AAA extends Thread {

	// run() => 쓰레드가 수행할 작업을 정의
	// alt + shift + s + v
	@Override
	public void run() {
		while(true) {
			System.out.println("go!!");
		}
	}
	
}
class BBB extends Thread {
	
	// run() => 쓰레드가 수행할 작업을 정의
	// alt + shift + s + v
	@Override
	public void run() {
		while(true) {
			System.out.println("\tstop!!");
		}
	}	
}

public class ThreadMain01 {
	
	public static void main(String[] args) {
		
		AAA ta = new AAA();
		BBB tb = new BBB();
		
		
		/*
		
		쓰레드가 실제로 작업할 것은 run()이기 때문에 원래는 ta.run(); 이라고 써야 한다.  
		
		ta.run();
		tb.run();
		
		하지만 이렇게 작성하면 쓰레드가 동시에 수행되지 않는다. 
		ta.run()이 수행되고, ta.run()이 완료되면 tb.run()이 수행된다. 
		
		실제로 쓰레드는 동시에 작업되는 것은 아니지만, 동시적으로 시행되는 것처럼 보이게 하려면 어떻게 해야 할까?
		
		JVM자체가 run() 메소드를 수행하게 해야 한다. 
		그래서 개발자는 run()이 아닌 start() 메소드를 실행하지만 하면 된다. 
		
		*/
		
		ta.start();
		tb.start();
	
	}
	
}
