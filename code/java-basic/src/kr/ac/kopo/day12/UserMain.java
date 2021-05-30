package kr.ac.kopo.day12;

public class UserMain {

	public static void main(String[] args) {
		
		SamsungTV sam = new SamsungTV();
		sam.channelDown();
		sam.channelUp();
		sam.volumDown();
		sam.volumUp();
		sam.powerOff();
		
		LGTV lg = new LGTV();
		
	}

}
