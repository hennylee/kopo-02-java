package kr.ac.kopo.day17.homework;

import java.util.Random;

class DonationThread {
	
	static int aSum = 0;
	static int bSum = 0;
	static int cSum = 0;
	static int dSum = 0;
	
	public static int getRandomPrice() {
		
		// 랜덤하게 금액 고르기
		Random random = new Random();
		int price = (random.nextInt(10) + 1) * 1000;
		
		return price;
	}
	
	public void a() {
		for(int i = 0; i< 10; i++) {
			int price = getRandomPrice();
			aSum += price;
			System.out.println("1번 콜센터 : " + price + "원 받았습니다.");
		}
		System.out.println("[1번 콜센터 총 성금 금액] : " + aSum);
	}
	
	public void b() {
		for(int i = 0; i< 10; i++) {
			int price = getRandomPrice();
			bSum += price;
			System.out.println("2번 콜센터 : " + price + "원 받았습니다.");
		}
		System.out.println("[2번 콜센터 총 성금 금액] : " + bSum);
	}
	
	public void c() {
		for(int i = 0; i< 10; i++) {
			int price = getRandomPrice();
			cSum += price;
			System.out.println("3번 콜센터 : " + price + "원 받았습니다.");
		}
		System.out.println("[3번 콜센터 총 성금 금액] : " + cSum);
		
	}
	
	public void d() {
		for(int i = 0; i< 10; i++) {
			int price = getRandomPrice();
			dSum += price;
			System.out.println("4번 콜센터 : " + price + "원 받았습니다.");
		}
		System.out.println("[4번 콜센터 총 성금 금액] : " + dSum);
		
	}
	
}

public class DonationThreadMain extends Thread{
	
	private DonationThread thread;
	private int call;
	
	public DonationThreadMain() {
		// TODO Auto-generated constructor stub
	}
	
	public DonationThreadMain(DonationThread thread, int call) {
		this.thread = thread;
		this.call = call;
	}

	@Override
	public void run() {
		switch(call) {
		case 1:
			thread.a();
			break;
		case 2:
			thread.b();
			break;
		case 3:
			thread.c();
			break;
		case 4:
			thread.d();
			break;
			
		}
	}
	
	public static void main(String[] args) {
		DonationThread thread = new DonationThread();
		
		DonationThreadMain aThread = new DonationThreadMain(thread, 1);
		DonationThreadMain bThread = new DonationThreadMain(thread, 2);
		DonationThreadMain cThread = new DonationThreadMain(thread, 3);
		DonationThreadMain dThread = new DonationThreadMain(thread, 4);
		
		aThread.start();
		bThread.start();
		cThread.start();
		dThread.start();
		
		try {
			
			aThread.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		try {
			
			bThread.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		try {
			
			cThread.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		try {
			
			dThread.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		
		System.out.println("==================================================");
		
		int total = thread.aSum + thread.bSum + thread.cSum + thread.dSum;
		
		System.out.println("국민들이 보내주신 총 성금액 : " + total + "원");
	}
	

}
