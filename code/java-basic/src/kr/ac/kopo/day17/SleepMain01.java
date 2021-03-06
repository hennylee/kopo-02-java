package kr.ac.kopo.day17;

public class SleepMain01 {
	public static void main(String[] args) {
		
		System.out.println("Thread가 2초동안 잠이 들겠습니다.");
		
		try {
			Thread.sleep(2000); // 단위는 밀리세컨드(1000밀리세컨드 = 1초)
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		// Thread.sleep은 checked exception 이다. => Thread에 정의된 sleep 메소드가 throws Exception을 던지고 있는 것이다. 
		// io, 쓰레드, 소켓, 네트워크 => checked exception 
		
		System.out.println("Thread가 깨어났습니다.");
	}
}
