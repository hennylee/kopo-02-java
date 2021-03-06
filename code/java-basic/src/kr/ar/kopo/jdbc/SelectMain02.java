package kr.ar.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

/**
 * 자원해제 부분을 util클래스로 만들어두고 재사용
 * @author HP
 *
 */
public class SelectMain02 {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1단계 + 2단계
			
			/*
			ConnectionFactory factory = new ConnectionFactory();
			conn = factory.getConnection();
			*/
			conn = new ConnectionFactory().getConnection();
			
			
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
			JDBCClose.close(conn, pstmt);
		}
		
	}
}
