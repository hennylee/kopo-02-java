package kr.ar.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
 * 키보드로 입력받은 내용 oracle에 삽입하기
 * @author HP
 *
 */
public class InesertMain02 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
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
			stmt = conn.createStatement(); 							// createStatement() : statement라는 객체를 return한다.
			String sql = "INSERT INTO T_TEST(ID, NAME) "
					+ "VALUES(\'"+ id +"\', \'"+ name +"\')"; 		// 문자열은 작은 따옴표(\')로 묶어줘야 한다.
			
			// 4단계 : SQL문을 실행하고 결과 얻기
			int cnt = stmt.executeUpdate(sql); 						// executeUpdate()의 return값이 int인 이유는? update한 행의 갯수를 반환하기 때문이다.
			System.out.println("총 " + cnt + "개 행 삽입");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5단계 : preparedStatement, Connection순으로 접속 해지 (close)
			if(stmt != null) {
				try {
					stmt.close();
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
