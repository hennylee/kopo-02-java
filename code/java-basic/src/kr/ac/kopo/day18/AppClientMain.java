package kr.ac.kopo.day18;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * AppServer에 접속해서 상호 통신하는 것이 목적이다. 
 * @author HP
 *
 */
public class AppClientMain {
	public static void main(String[] args) {
		
		
		try {
			Socket socket = new Socket("localhost", 10000); // ip와 port를 알아야 한다. 
			
			/*
			10000번 포트를 열어놔야 실행이 가능하다. 
			10000번 포트를 열기 위해서는 서버(AppServerMain.java)를 먼저 실행해야 한다.
			 */
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			String msg = dis.readUTF();
			System.out.println("서버에서 받은 메세지 : " + msg);
			
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}
