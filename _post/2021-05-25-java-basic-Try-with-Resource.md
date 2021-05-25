

## Try With Resource란?

- JDK1.7 버전부터 자동으로 자원을 해제해주는 try~catch 문이 생겼다. 

- try 뒤에 괄호를 붙여 해제하고자 하는 객체를 생성한다. 


```java
try (
    해제하고자 하는 객체 생성
) {

} catch (Exception e) {

}
```

- 이때, 자동 해제하고자 하는 클래스는 반드시 AutoCloseable을 상속받아야 한다. 

- 현재 자바에서 자원을 해제시키는 클래스들(I/O, Connection)은 대부분 AutoCloseable을 상속받고 있다.

- AutoCloseable을 상속받은 클래스가 try뒤에 선언되어 있으면, try ~ catch가 끝나자마자 자동으로 close() 메소드가 호출된다. 



## Try With Resource 형식


```java
package kr.ar.kopo.jdbc;

/**
 * 1.7버전의 try ~ catch ~ resource 문을 사용해보기
 * @author HP
 *
 */


class Test implements AutoCloseable {

	// AutoCloseable을 상속받으면 try ~ catch가 끝나면 자동으로 무조건 close() 메소드가 호출된다. 
	@Override
	public void close() throws Exception {
		System.out.println("close()...");
	}
	
}

public class TryWithResource {
	public static void main(String[] args) {
		
		try (
				Test t = new Test();
		) {
			
		} catch (Exception e) {
			
		}
		
	}
}
```


## Try With Resource로 JDBC 연결 해제하기


```java
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
```
