package kr.ac.kopo.day18;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoThreadServerMain {
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			System.out.println("EchoThread 서버를 시작...");
			
			
			/*
			소켓이 3개 필요하다면, accept도 3번 필요하다.
			연결이 올때마다 소켓을 만들어내려면 accept()가 while문 안에 있어야 한다. 
			 */
			
			while(true) {
				Socket client = server.accept();
				
				/*
				각 소켓마다 읽고 쓰기 작업을 수행해야 하니까, 
				읽고 쓰기 작업이 쓰레드로 존재해야 한다.
				쓰레드에 client 정보를 전달해야 한다. 
				 */
				EchoThread et = new EchoThread(client);
				et.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


class EchoThread extends Thread {

	private Socket socket;
	
	public EchoThread() {

	}

	public EchoThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			// 접속한 클라이언트 정보
			InetAddress client = socket.getInetAddress();
			System.out.println("client : " + client);
			
			// 클라이언트가 작성한 내용 읽어오는 객체
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			// 클라이언트가 작성한 내용 써줄 객체
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			// 클라이언트에게 읽고 쓰기
			while(true) {				
				
				// 읽기
				String msg = br.readLine();
				
				if(msg == null) {
					socket.close();
					System.out.println("["+ client.getHostAddress() +"]와의 접속을 종료합니다.");
					break;
				}
				System.out.println("["+ client.getHostAddress() +"]에서 전달된 메세지 : " + msg);
				
				// 쓰기
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