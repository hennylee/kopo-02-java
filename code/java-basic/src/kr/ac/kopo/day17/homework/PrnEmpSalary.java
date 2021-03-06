package kr.ac.kopo.day17.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*

-- 테이블 확인
SELECT * FROM EMPLOYEES;
SELECT * FROM JOBS;

-- JOIN 전 쿼리
SELECT JOB_ID, SUM(SALARY)/COUNT(EMPLOYEE_ID) 
FROM EMPLOYEES 
WHERE SALARY >= 2000 
GROUP BY JOB_ID 
ORDER BY JOB_ID;

-- JOIN 후 쿼리
SELECT j.JOB_TITLE, SUM(e.SALARY)/COUNT(e.EMPLOYEE_ID)
FROM EMPLOYEES e, JOBS j
WHERE e.JOB_ID = j.JOB_ID AND e.SALARY >= 10000
GROUP BY j.JOB_TITLE;

 */


public class PrnEmpSalary {
	
	public void getAvg(int max) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT j.JOB_TITLE, SUM(e.SALARY)/COUNT(e.EMPLOYEE_ID) as AVG ");
		sb.append("FROM EMPLOYEES e, JOBS j ");
		sb.append("WHERE e.JOB_ID = j.JOB_ID AND e.SALARY >= ? ");
		sb.append("GROUP BY j.JOB_TITLE");
		
		try(
				Connection conn = new ConnectionUtil().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
				) {
			pstmt.setInt(1, max);
			ResultSet rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			
			while(rs.next()) {
				String job = rs.getString("JOB_TITLE");
				int avg = rs.getInt("AVG");
				cnt++;
				System.out.println("[" + job + "] " + avg);
			}
			System.out.println();
			System.out.println("\t총 [" + cnt + "]명이 검색되었습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT j.JOB_TITLE, SUM(e.SALARY)/COUNT(e.EMPLOYEE_ID) as AVG ");
		sb.append("FROM EMPLOYEES e, JOBS j ");
		sb.append("WHERE e.JOB_ID = j.JOB_ID AND e.SALARY >= ? ");
		sb.append("GROUP BY j.JOB_TITLE");
		
		System.out.print("급여를 입력하시오 : ");
		int max = sc.nextInt();
			
		try(
				Connection conn = new ConnectionUtil().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sb.toString());
				) {
			pstmt.setInt(1, max);
			ResultSet rs = pstmt.executeQuery();
			
			int cnt = 0;
			
			
			while(rs.next()) {
				String job = rs.getString("JOB_TITLE");
				int avg = rs.getInt("AVG");
				cnt++;
				System.out.println("[" + job + "] " + avg);
			}
			System.out.println();
			System.out.println("\t총 [" + cnt + "]명이 검색되었습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
			
		
		
		
	}
}
