package kr.ac.kopo.day12;
/*
 * 인터페이스 사용하지 않은 버전
 */
public class SamsungTV {
	private boolean power;
	private int channelNo;
	private int volumeSize;
	
	/**
	 * 삼성 티비를 하나 구매하는 행위 = SamsungTV 객체 생성
	 */
	public SamsungTV() {
		power = false;
		channelNo = 3;
		volumeSize = 6;
		System.out.println("삼성tv를 구매하였습니다.");
	}
	
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	public void volumUp() {
		System.out.println("볼륨을 올립니다.");
	}
	
	public void volumDown() {
		System.out.println("볼륨을 내립니다.");
	}
	
	public void channelUp() {
		System.out.println("채널을 올립니다.");
	}
	
	public void channelDown() {
		System.out.println("채널을 내립니다.");
	}
}
