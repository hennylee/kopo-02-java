package kr.ac.kopo.day16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Writer;

public class FileIOMain10 {
	
	public static void write() throws Exception{
		
	}
	
	public static void read() throws Exception {
		
		FileReader fr = new FileReader("iodata/userInfo.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String name = br.readLine();
		int age = Integer.parseInt(br.readLine());
		String addr = br.readLine();
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		try {
			write();
			read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}