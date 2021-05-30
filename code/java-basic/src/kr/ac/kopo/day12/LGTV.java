package kr.ac.kopo.day12;
/*
 * 인터페이스 사용하지 않은 버전
 */
public class LGTV {
	private boolean power;
	private int channelNo;
	private int volumeSize;
	
	/**
	 * LG 티비를 하나 구매하는 행위 = LGTV 객체 생성
	 */
	public LGTV() {
		power = false;
		channelNo = 3;
		volumeSize = 6;
		System.out.println("LGtv를 구매하였습니다.");
	}
	
	public void turnOn() {
		System.out.println("전원 ON");
	}
	
	public void turnOff() {
		System.out.println("전원 OFF");
	}
	
	public void soundUp() {
		System.out.println("sound 올립니다.");
	}
	
	public void soundDown() {
		System.out.println("sound 내립니다.");
	}
	
	public void channelUp() {
		System.out.println("channel 올립니다.");
	}
	
	public void channelDown() {
		System.out.println("channel 내립니다.");
	}
}
