package kr.ar.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
목표
 	수정할 ID를 입력하세요 : HONG
 	수정할 이름을 입력하세요 : 홍길순
 */
public class UpdateMain01 {
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
			
			conn = DriverManager.getConnection(url, user, pw);
			
			// 3단계
			Scanner sc = new Scanner(System.in);
			System.out.println("아이디를 입력하세요 : ");
			String id = sc.nextLine();
			System.out.println("수정할 id를 입력하세요 : ");
			String name = sc.nextLine();
						
			/*
			String sql = "update t_test "
						+ "set name = ? "
						+ "where id = ? ";
			*/
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("update t_test ");
			sql.append(" set name = ? ");
			sql.append(" where id = ? ");
			
			// StringBuilder을 String으로 형변환하기 위해서는? toString 메소드를 활용한다. 
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			
			// 4단계
			int cnt = pstmt.executeUpdate();
			
			System.out.println("총 " + cnt + "개의 행을 수정");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 5단계
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}
}
