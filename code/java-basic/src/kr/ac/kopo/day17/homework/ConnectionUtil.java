package kr.ac.kopo.day17.homework;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	Connection conn = null;
	
	public Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@192.168.217.57:1522:xe";
			String user = "hr";
			String pw = "hr";
			
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
