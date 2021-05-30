package kr.ac.kopo.day17;

import java.util.Date;

// 1초에 한 번씩 시간을 출력하는 Thread
class TimeThread extends Thread {

	@Override
	public void run() {
		while(true) {
			
			// 1초동안 block
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			System.out.println("현재시간 : " + new Date().toLocaleString());
		}
	}
	
	
}

public class SleepMain02 {
	public static void main(String[] args) {
		
		// 1초마다 시간을 찍어주는 쓰레드 실행
		TimeThread tt = new TimeThread();
		tt.start();
		
		/*
		while(true) {
			System.out.println("go!!!!!!!");
		}
		
		위의 메소드를 실행하면 go 찍어내고 sleep에 빠진 다음 현재시간을 찍지 못하고 계속 sleep에 빠져 go만 출력하게 된다. 
		
		그래서 둘을 동시에 수행시키려면, go 출력 쓰레드에도 sleep을 적절히 걸어줘야 한다. 
		
		
		*/
		while(true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("go!!!!!!!");
		}
		
	}

}
