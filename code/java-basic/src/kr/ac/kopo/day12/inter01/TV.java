package kr.ac.kopo.day12.inter01;

public interface TV {
	
	// 최대 음량
	public static final int MAX_VOLUME_SIZE = 50; // public static final은 생략 가능
	int MIN_VOLUME_SIZE = 0; 					  // public static final은 생략됨
	
	public abstract void powerOn();
	void powerOff();
	void channelUp();
	void channelDown();
	void soundUp();
	void soundDown();
	void mute();
	
}
