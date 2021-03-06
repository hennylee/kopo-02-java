package kr.ac.kopo.day18;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * AppClient의 통신을 받아 메세지를 전달한다.
 * @author HP
 *
 */
public class AppServerMain {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10000);// 네트워크는 예외처리 필요함
			System.out.println("어플리케이션 서버 실행...");
			
			
			/*
			서버는 terminate되지 않고 계속 실행중이어야 요청이 들어왔을때 바로바로 소켓을 만들어줄 수 있다. 
			이 역할은 accept() 메소드가 실행한다. 
			 */
			
			 Socket client = server.accept(); // accept()가 실행되면 계속 기다리고 있는 상태, 접속한 클라이언트 소켓을 반환한다.
			 
			 // 접속된 클라이언트 컴퓨터의 정보
			 System.out.println("연결된 클라이언트의 정보 : "+client);
			 System.out.println("연결된 클라이언트의 IP : "+client.getInetAddress());
			 System.out.println("연결된 클라이언트의 PORT : "+client.getPort());
			 
			 String msg = "접속을 환영합니다.";
			 OutputStream os = client.getOutputStream();
			 DataOutputStream dos = new DataOutputStream(os); // 필터 클래스
			 
			 dos.writeUTF(msg); // UTF-8 방식으로 메세지 전송
			 dos.flush();
			 
			 client.close();
			 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
