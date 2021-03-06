package kr.ac.kopo.day18;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerMain {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			
			Socket client = server.accept();  // 클라이언트의 접속 기다리기
			System.out.println("접속한 클라이언트 IP : " + client.getInetAddress().getHostAddress());
			System.out.println("접속한 클라이언트 이름 : " + client.getInetAddress().getHostName());
			
			
			// 1. 클라이언트에서 전송한 데이터를 수신할 수 있는 객체 
			InputStream is = client.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr); // 속도를 빠르게 하는 필터
			
			
			// 2. 수신한 데이터를 클라이언트에 재전송할 객체
			OutputStream os = client.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);

			while(true) {				
				String msg = br.readLine();
				
				if(msg == null) {
					client.close();
					System.out.println("클라이언트와의 접속을 종료합니다.");
					break;
				}
				System.out.println("클라이언트에서 전달된 메세지 : " + msg);
				
				/*
				pw.write(msg);
				pw.write('\n');
				 */
				
				pw.println(msg);
				pw.flush();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
