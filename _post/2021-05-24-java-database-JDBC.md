## JDBC란?

- 로그파일 : 시스템에 대한 기록을 남기는 목적이기 때문에 뒤에 계속 데이터를 추가만 하기 때문에 '파일'에 저장한다. 중간에 수정이나 삭제가 이루어지지 않기 때문이다. 

- 데이터베이스 : 데이터에 대한 Access가 빈번하고 복잡할 때 사용하는 시스템 구조이다. 

- JDBC : 데이터 베이스를 자바 언어로 Access하기 위해서 내가 원하는 데이터를 조회, 입력, 수정, 삭제하는 목적으로 사용하기 위한 접속 방법론이다.

- JAVA에서 데이터 베이스 벤더사에게 요청해서 데이터베이스를 자바에 연결할 수 있는 표준화된 인터페이스 라이브러리를 구현해둔 것이다. 

- 그래서 JAVA에는 JDBC를 가지고 있지 않다. 필요 시, 내가 필요로 하는 데이터베이스 밴더회사에서 라이브러리(드라이버)를 다운로드 받아 사용해야 한다. 

- JAVA는 JDBC 드라이버 관리자를 가지고 있기 때문에, 묵시적 형변환으로 오라클 DBMS를 사용하던지, MySQL DBMS를 사용하던지 각 드라이버를 형변환해서 유연하게 사용할 수 있다.

- JDBC도 내부적으로는 I/O 방식으로 구현되어 있다. 

- JDBC 관련 클래스는 모두 java.sql 패키지 밑에 있다. (`import java.sql.*`)


## java.sql 패키지
![image](https://user-images.githubusercontent.com/77392444/119306107-a5f6b780-bca4-11eb-83c5-77a635e1313f.png)


- DriverManager : JDBC 드라이버를 선택하고 연결객체를 얻어오는 역할을 한다. 

- Connection : 스트림 객체가 연결되어 있는 것이다. 

- Statement : 쿼리를 가지고 있는 객체이다. SQL문을 실행시키는 역할을 한다. 

- ResultSet(SELECT) : SQL문(SELECT와만 관련)의 실행결과인 레코드셋을 담는 클래스이다. 이차원 배열의 형태를 가지고 있다. 


## JDBC 프로그램 실행 순서

![image](https://user-images.githubusercontent.com/77392444/119306075-97a89b80-bca4-11eb-801f-7bff964591ec.png)


- 데이터베이스 드라이버 로드 : `Class.forName("oracle.jdbc.driver.OracleDriver");`

- 데이터베이스 연결 : Connection conn = DriverManager.getConnection(JDBC_url, "id", "password");
	- JDBC_url 구성 : jdbc:oracle:thin:@IP주소:포트:SID
	- IP주소 : 오라클이설치된컴퓨터의IP 주소혹은도메인이름
	- 포트 : 리스너의사용포트기본값은1521
	- SID, 서비스이름 : 오라클인스턴스이름으로MySQL에서는DB 이름으로도불림

- SQL 실행 객체 얻기 및 실행
	- Statement > PreparedStatement > CallableStatement
	- PreparedStatement : 객체생성시 `?`를 사용해서 SQL 문장을 미리 생성하고 변수부는 별도의 메서드로 대입하는 방식으로 성능과 관리면에서 모두 권장되는 방식이다.

- 결과 받기
	- SELECT 문의 결과를 받아올 때, `executeQuery( )`를 사용한다.
	- `ResultSet rs = pstmt.executeQuery( );` 
	- ResultSet은 커서 개념의 연결포인터이다. (Collection에서의 Iterator와 유사하다고 이해하면 된다.)
	- ResultSet은 각각의 record에 접근하는 것이 목적이다. 
	- 기본적으로 `next( )` 메서드를 통해 Raw를 이동한다.

- 연결 해제
	- `conn.close();`	 
	- Connection 을 close()해주지 않으면 사용하지 않는 연결이 유지되어 DB 자원을 낭비하게 되기 때문에 꼭 연결을 해제해 주어야 한다.

## oracle 18c Express 설치 

![image](https://user-images.githubusercontent.com/77392444/119309038-b6a92c80-bca8-11eb-9ad8-911a7035006c.png)


## hr계정 열기

#### 1. SQLPLUS 열기

#### 2. SQLPlus에서 HR 스키마 설치하기

```
SQL*Plus: Release 18.0.0.0.0 - Production on 수 5월 26 14:33:43 2021
Version 18.4.0.0.0

Copyright (c) 1982, 2018, Oracle.  All rights reserved.

사용자명 입력: sqlplus / as sysdba
비밀번호 입력:

다음에 접속됨:
Oracle Database 18c Express Edition Release 18.0.0.0.0 - Production
Version 18.4.0.0.0

SQL> alter user hr account unlock;
alter user hr account unlock
           *
1행에 오류:
ORA-01918: 사용자 'HR'(이)가 존재하지 않습니다


SQL> ALTER SESSION SET "_ORACLE_SCRIPT" = true;

세션이 변경되었습니다.

SQL> @?/demo/schema/human_resources/hr_main.sql

specify password for HR as parameter 1:
1의 값을 입력하십시오: hr

specify default tablespeace for HR as parameter 2:
2의 값을 입력하십시오: user

specify temporary tablespace for HR as parameter 3:
3의 값을 입력하십시오: temp

specify log path as parameter 4:
4의 값을 입력하십시오: $ORACLE_HOME/demo/schema/log/
```

#### 3. SQLPlus에서 HR 계정 설정 변경하기

```
SQL> ALTER USER hr ACCOUNT unlock;

User altered.

SQL> ALTER USER hr IDENTIFIED BY hr;

User altered.
```


## jdbc 다운로드

- ojdbc8 위치 : C:\app\HP\product\18.0.0\dbhomeXE\jdbc\lib

- ojdbc8.jar 파일을 프로젝트 내에 붙여넣기

![image](https://user-images.githubusercontent.com/77392444/119309806-c6754080-bca9-11eb-9844-3c1ab14259dc.png)


- 프로젝트 마우스 우클릭 - Java Build Path 에서 Libraries - Moduldpath에 복사해둔 ojdbc8.jar add하기

- java project facets는 Java 1.8로 변경하기

- 완료되면 Referenced Libraries에서 확인 가능하다

![image](https://user-images.githubusercontent.com/77392444/119310148-50bda480-bcaa-11eb-9102-1f940ef370d9.png)


## JDBC 연결하기

```java
package kr.ar.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTestMain {

	public static void main(String[] args) {
		try {
			// 1단계 : JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공...");
			
			// 2단계 : DB 접속 및 연결객체 얻기
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.119.119:1521:dink",
							"scott",
							"tiger");
			System.out.println("DB접속 성공 : " + conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```


## INSERT 하기

```java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*

jdbc 작업순서
   1. 드라이버 로딩
   2. db접속 후 연결객체 얻어오기
   3. SQL을 실행할 객체 얻기
   4. SQL문 실행 및 결과 얻기
   5. DB 접속 해제 

 */
public class InesertMain01 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
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
			
			// 3단계 : SQL 실행 객체 얻기
			stmt = conn.createStatement(); 	// createStatement() : statement라는 객체를 return한다.
			String sql = "INSERT INTO T_TEST(ID, NAME) "
					+ "VALUES('hong', '홍길동')";  // 끝에 세미콜론(;) 붙이지 않는다.
			
			// 4단계 : SQL문을 실행하고 결과 얻기
			int cnt = stmt.executeUpdate(sql);  // executeUpdate()의 return값이 int인 이유는? update한 행의 갯수를 반환하기 때문이다.
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
		}
	}
}
```

- 콘솔 결과

![image](https://user-images.githubusercontent.com/77392444/119314066-3d610800-bcaf-11eb-82b1-90e320adf141.png)

- SQLDeveloper

![image](https://user-images.githubusercontent.com/77392444/119314124-5073d800-bcaf-11eb-9cb4-f0c1c265ad1e.png)

## 키보드로 입력받은 내용 INSERT하기

- createStatement를 사용한다면, 문자열을 사용할 때 작은 따옴표(')로 꼭 묶어줘야 한다. 


```java
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
			stmt = conn.createStatement(); 	 // createStatement() : statement라는 객체를 return한다.
			String sql = "INSERT INTO T_TEST(ID, NAME) "
					+ "VALUES(\'"+ id +"\', \'"+ name +"\')";  // 문자열은 작은 따옴표(\')로 묶어줘야 한다.
			
			// 4단계 : SQL문을 실행하고 결과 얻기
			int cnt = stmt.executeUpdate(sql);   // executeUpdate()의 return값이 int인 이유는? update한 행의 갯수를 반환하기 때문이다.
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

```

- 콘솔 결과

![image](https://user-images.githubusercontent.com/77392444/119315184-8b2a4000-bcb0-11eb-99ce-713674cb9508.png)


- SQLDeveloper

![image](https://user-images.githubusercontent.com/77392444/119315137-7ea5e780-bcb0-11eb-9ac3-d1ba16f5ecf7.png)



## preparedStatement로 INSERT하기

- preparedStatement는 createStatement를 상속받아서 문자열을 따옴표 없이 사용할 수 있게 execute하기 전에 데이터 타입에 맞게 처리해준다.

- preparedStatement를 사용한다면 `insert into test(name, title) values(?, ?)` 처럼 채워넣을 데이터 변수 자리를 먼저  `?`로 채워 넣는다.

- 그리고 나서 데이터 타입에 맞게 처리해주기 위해서 setInt(), setString(), setDate() 등의 메소드를 활용한다.



```java
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
```


- 콘솔 결과

![image](https://user-images.githubusercontent.com/77392444/119317116-b6ae2a00-bcb2-11eb-9674-a5cdc936835f.png)

- SQLDeveloper

![image](https://user-images.githubusercontent.com/77392444/119317089-af871c00-bcb2-11eb-8611-c2fc26a70654.png)


## UPDATE하기

```java
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
						
			String sql = "update t_test "
						+ "set name = ? "
						+ "where id = ? ";
			
			pstmt = conn.prepareStatement(sql);
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
```

- 콘솔 결과

![image](https://user-images.githubusercontent.com/77392444/119318684-91bab680-bcb4-11eb-9779-b943dc585786.png)


- SQLDeveloper

![image](https://user-images.githubusercontent.com/77392444/119318669-8cf60280-bcb4-11eb-8ee8-d4ab717c4eef.png)


## SELECT문과 ResultSet로 결과 조회하기

```java
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
```

- 콘솔 결과

![image](https://user-images.githubusercontent.com/77392444/119422669-890dc300-bd3c-11eb-9f7c-b6e7f7d9d18d.png)

- SQLDeveloper

![image](https://user-images.githubusercontent.com/77392444/119422707-975bdf00-bd3c-11eb-9bee-ad35e0c2d503.png)


## util 클래스로 중복 코드 재사용하기

- 반복되는 내용을 util 클래스로 만들어 두고 재사용하고, 유연한 수정에 용이하게 만들기 위함이다.

- util클래스는 JAR 파일로 배포할 수 있다. 하지만, 배포된 JAR파일은 수정이 불가능하기 때문에 수정할 필요가 없는 내용만 배포하는 것이 좋다.

#### close util 클래스

```java
package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCClose {
	public static void close(Connection conn, Statement pstmt) { // PreparedStatement는 Statement를 상속받기 때문에 묵시적 형변환 가능

		// 5단계 : 자원해제
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
```

#### ConnectionFactory util 클래스

```java
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
```

#### SELECT를 util 클래스를 활용해서 단축시키기

```java
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
```



## 이클립스 꿀팁 : save 시에 import하기

![image](https://user-images.githubusercontent.com/77392444/119312258-1a355900-bcad-11eb-9813-3d6995a758a4.png)
