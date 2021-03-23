package kr.ac.kopo.day12.inter01;

import kr.ac.kopo.day02.IFMain01;

public class SamsungTV implements TV{
	
	private String modelName;
	private boolean power;
	private int channelNo;
	private int volumeSize;
	private boolean muteToggle; // 현재 음소거 상태인지 확인하는 멤버변수
	private int currentVolumeSize; // 현재 볼륨값
	
	/**
	 * 생성자
	 */
	public SamsungTV() {
		System.out.println("삼성티비 구매...");
		modelName = "n13rd223";
		power = false;
		channelNo = 3;
		volumeSize = 6;
		muteToggle = false;
	}
	
	
	/*
	 * 	추상메소드 오버라이딩
	 *  - 몇 개만 오버라이딩 하고 싶을 때 : Source - Implement
	 */
	@Override
	public void powerOn() {
		power = true;
		System.out.println("전원을 켭니다." + power);
		info();
	}

	@Override
	public void powerOff() {
		power = false;
		System.out.println("전원을 끕니다.");
		
	}

	@Override
	public void channelUp() {
		System.out.println("채널을 올립니다.");
		channelNo++;
		
		if(channelNo == 0) {
			channelNo--;
		}
		info();
	}

	@Override
	public void channelDown() {
		System.out.println("채널을 내립니다.");
		channelNo--;
		
		if(channelNo < 0) {
			channelNo++;
		}
		info();
		
	}

	@Override
	public void soundUp() {
		System.out.println("볼륨을 올립니다.");
		
		if(muteToggle) {
			volumeSize = currentVolumeSize;
			muteToggle = false;
		}
		
		if(volumeSize < MAX_VOLUME_SIZE) {
			volumeSize++;
		}
		info();
	}

	@Override
	public void soundDown() {
		System.out.println("볼륨을 내립니다.");
		if( volumeSize > MIN_VOLUME_SIZE) {
			volumeSize--;
		}
		info();
	}

	@Override
	public void mute() {
		System.out.println("음소거를 합니다.");
		
		if(muteToggle) {
			System.out.println("음소거 해제");
			volumeSize = currentVolumeSize;
			//muteToggle = false;
		} else {
			System.out.println("음소거");
			volumeSize = TV.MIN_VOLUME_SIZE;
			currentVolumeSize = volumeSize;
			//muteToggle = true;
		}
		muteToggle = !muteToggle;
		
	}
	
	// 외부에서는 저 메소드를 사용하지 않고, 내부에서만 사용하는 메소드일때는 private / private 메소드는 외부 DOC에 보여줄 필요 없다. 그래서 주로 핵심 기술을 private으로 쓴다. 
	private void info() {
		System.out.println("채널 : " + channelNo + ", 음량 : "  + volumeSize);
	}

}
