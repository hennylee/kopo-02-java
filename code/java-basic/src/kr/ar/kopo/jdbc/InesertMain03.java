package kr.ar.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*

jdbc 작업순서
   1. 드라이버 로딩
   2. db접속 후 연결객체 얻어오기
   3. SQL을 실행할 객체 얻기
   4. SQL문 실행 및 결과 얻기
   5. DB 접속 해제 

 */

/**
 * preparedStatement를 활용해서 키보드로 입력받은 내용 oracle에 삽입하기 (3, 4단계 변경)
 * @author HP
 *
 */
public class InesertMain03 {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			// 1단계 : JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공...");
			
			// 2단계 : DB 연결 후 Connection 객체 얻기
			String url 		= "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String user 	= "scott";
			String pw 		= "tiger";
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("conn : " + conn);
			
			System.out.println("아이디를 입력 : ");
			String id = sc.nextLine();
			
			System.out.println("이름를 입력 : ");
			String name = sc.nextLine();
			
			// 3단계 : SQL 실행 객체 얻기
			String sql  = "insert into t_test(id, name) ";
				   sql += " values(?,?) ";
				   
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, id);
			 pstmt.setString(2, name);
	
			// 4단계 : SQL문을 실행하고 결과 얻기
			int cnt = pstmt.executeUpdate(); // 매개변수 필요 없음 => pstmt에서 이미 
			
			System.out.println("총 " + cnt + "개 행 삽입" );
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5단계 : preparedStatement, Connection순으로 접속 해지 (close)
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
			sc.close();
		}
	}
}
