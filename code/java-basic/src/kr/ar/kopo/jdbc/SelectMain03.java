package kr.ar.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

/**
 * 1.7버전의 try ~ catch ~ resource 문을 사용해보기
 * @author HP
 *
 */


public class SelectMain03 {
	public static void main(String[] args) {
		
		String sql = "select * from t_test"; // autoclosable을 상속받지 않아서, try 뒤에 올 수 없음
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			
			// 만약 sql문장에 ?가 있다면, ? 정의는 여기서 한다.
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println(id +", " + name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
