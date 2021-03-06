package kr.ar.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectMain01 {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1단계
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2단계
			String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url,user,pw);
			
			// 3단계
			String sql = "select * from t_test";
			pstmt = conn.prepareStatement(sql);
			
			// 4단계
			ResultSet rs = pstmt.executeQuery();
			
			
			/*
			 * rs.next 메소드에 return 타입이 Boolean 형으로 나온다. 
			 * 그 다음 레코드가 있으면 true, 없으면 false값을 return한다.
			 */
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println(id + "," + name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 5단계 
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
