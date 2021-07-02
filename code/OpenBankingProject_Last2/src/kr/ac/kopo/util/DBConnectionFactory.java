package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnectionFactory {
	Connection conn = null;
	
	public Connection getConnection() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1522:xe";
			String user = "system";
			String password = "happy";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			System.out.println("DBConnection 에러...");
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
