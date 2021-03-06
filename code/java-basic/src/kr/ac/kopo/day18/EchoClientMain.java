package kr.ac.kopo.day18;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientMain {
	public static void main(String[] args) {
		try {
//			Socket socket = new Socket("localhost", 10001);
			Socket socket = new Socket("192.168.217.57", 10001);
			
			// 1-1. 키보드로 입력받을 객체
			// Scanner는 1.5버전부터 나왔다. 
			BufferedReader keyboard 
					= new BufferedReader(new InputStreamReader(System.in));
			
			// 1-2. 클라이언트가 키보드로 입력받은 데이터를 서버에게 전달하기 위한 전달 객체
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw); // 속도를 빠르게 하는 버퍼의 기능을 print가 대체할 수 있다. 
			

			// 1-3. 서버에서 재전송한 데이터를 수신하기 위한 수신 객체
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				
				// 2-1. 키보드로 입력 받기
				System.out.print("메세지를 입력(quit 입력시 종료) : ");
				String msg = keyboard.readLine();
				
				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("서버 연결을 종료합니다.");
					socket.close();
					break;
				}
				
				// 2-2. 키보드로 입력받은 메세지 전달하기
				/*
				pw.write(msg);
				pw.write('\n');
				 */
				
				pw.println(msg);
				pw.flush();
				
				// 2-3. 서버에서 보낸 메세지 받기
				String echMsg = br.readLine();
				System.out.println("서버에서 전송한 메세지 : " + echMsg);
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
