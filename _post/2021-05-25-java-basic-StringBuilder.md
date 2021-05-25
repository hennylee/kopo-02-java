
## StringBuilder가 필요한 이유

- String 클래스는 변하지 않는 특성이 있다. 

- 그래서 자주 변경되는 데이터를 담기에는 비효율적이다. 

- 자주 변경되는 String의 경우에는 StringBuilder, StringBuffer를 사용한다.

- 이 중 웹 상에서는 StringBuilder를 주로 사용한다.


## String 타입의 sql 문장을 StringBuilder로 바꿔보기

#### String 데이터 타입

```java
String sql = "update t_test "
						+ "set name = ? "
						+ "where id = ? ";
```

#### StringBuilder 데이터 타입

- StringBuilder클래스를 String 클래스로 형변환하기 위해서는? `toString()` 메소드를 활용한다.

```java
StringBuilder sql = new StringBuilder();
			
sql.append("update t_test ");
sql.append(" set name = ? ");
sql.append(" where id = ? ");

// StringBuilder을 String으로 형변환하기 위해서는? toString 메소드를 활용한다. 
pstmt = conn.prepareStatement(sql.toString());
```
