package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 드라이버 로딩, db접속, 연결객체 반환한다.
 * url, user, pw 정보가 변경되었을때 수정이 용이하도록 구성한 것이다.
 * @author HP
 *
 */
public class ConnectionFactory {
	public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			// 1단계
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url,user,pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
					
		return conn;
	}
}
