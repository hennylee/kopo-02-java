package kr.ac.kopo.day12.inter01;

public class LGTV implements TV {
	private boolean power;
	private int channelNo;
	private int volumeSize;
	
	/**
	 * 생성자
	 */
	public LGTV() {
		System.out.println("LGTV를 구매하였습니다.");
	}

	@Override
	public void powerOn() {
		System.out.println("전원 ON");

	}

	@Override
	public void powerOff() {
		System.out.println("전원 OFF");

	}

	@Override
	public void channelUp() {
		System.out.println("channel 올립니다.");

	}

	@Override
	public void channelDown() {
		System.out.println("channel 내립니다.");

	}

	@Override
	public void soundUp() {
		System.out.println("sound 올립니다.");

	}

	@Override
	public void soundDown() {
		System.out.println("sound 내립니다.");

	}

	@Override
	public void mute() {
		System.out.println("음소거를 합니다.");

	}

}
