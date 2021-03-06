package kr.ac.kopo.day17;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
	public static void main(String[] args) {
		
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			
			System.out.println("내 컴퓨터의 네트워크 이름 : "+localhost.getHostName());
			System.out.println("내 컴퓨터의 IP 주소 : "+localhost.getHostAddress());
			
			System.out.println(localhost); 			  // 이것을 출력하면 호스트네임과 호스트주소가 둘 다 출력되는 이유는?
			System.out.println(localhost.toString()); // toString 메소드를 오버라이딩해서 둘 다 출력하도록 정의했기 때문이다.
			
			InetAddress addr = InetAddress.getByName("www.hanati.co.kr");
			System.out.println("하나금융티아이 IP : " + addr.getHostAddress());
			System.out.println("하나금융티아이 IP : " + addr.getHostName());
			
			InetAddress[] addrs = InetAddress.getAllByName("www.naver.com");
			System.out.println("------------------------------------------");
			System.out.println("\t\t네이버 ip 주소");
			System.out.println("------------------------------------------");
			for(InetAddress address : addrs) {
				System.out.println(address);
			}
			System.out.println("------------------------------------------");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}
}
