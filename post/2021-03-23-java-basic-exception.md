# [day12 ~ day13] java-basic : 예외처리

## 예외란?
- 예외란 프로그램을 실행하는 중간에 예기치 않은 문제에 의해서 발생하는 예기치 않은 에러

- 예외란 _1) 컴파일 시점_ 과 _2) 실행 시점_ 으로 나눌 수 있다. 

- 컴파일 에러 = Checked Exception

- Exception과 Error는 Throwable 클래스를 상속받는다.


## Checked Exception
- 컴파일 시점의 예외 처리가 필요하다. 

- 너무 뻔하게 에러가 예상되기 때문에 예외처리를 꼭 해줘야 한다.

- 이클립스에서 실행하기도 전에 에러 체크 되는 경우이다. 


## 예외처리 키워드
- 예외 직접 처리 키워드 : `try`, `catch`, `finally`

- 예외 간접 처리 키워드 : `throws`

- 사용자 정의 예외처리 키워드 : `throw`

- 사용자 정의 예외 처리란 자바 JVM에 정의된 에러가 아닌데, 사용자가 예외라고 처리하는 것이다.



## 예외 직접 처리

- 예외가 발생한 문장에 

- `try ~ catch ~ final` 대신 `if ~ else`로 처리할 수도 있지 않나요? 

- 뻔히 보이는 문제일때는 `if ~ else`를 사용하는 것이 맞다.

- 반면, 개발자가 예상하기 어려운 예외가 발생할 때에는 `try ~ catch`를 사용한다.

- `finally`에 있는 문장은 `catch`문에 `break`가 있더라도 반드시 실행된다.


## 예외 간접 처리
- 특정한 예외만 떠넘길 수도 있고, Exception를 작성하면 객체형변환으로 인해 다수의 예외를 떠넘기는 것이 가능하다.

```java
public void print() throws Exception{
    // 예외가 발생할 것 같은 코드 정의
}
```

- 예외가 발생한 문장이 아니라 나를 호출했던 **호출자 메소드에 예외를 떠넘기는 것**이다. 

- 호출할때마다 예외처리를 해주는 것이 번거롭기 때문에 한 곳에 모아서 예외를 처리해줄 수 있는 편리함을 지닌다. 

- 직접처리와의 차이점은? 예외처리 후 아래 문장을 실해하게 하려면 직접처리를, 아니라면 간접처리해야 한다. 
 
- 메소드 뒤에 `throws`키워드와 떠넘기고자 하는 예외를 작성해서 예외를 떠넘기고, 피호출자 메소드 앞뒤에서 try ~ catch 블록 예외를 받아 처리한다.  

- 언제 쓰나요? 인터페이스나 추상클래스에서 추상메소드를 정의할 때 많이 쓴다. 

## 사용자 정의 예외처리
- JVM이 예외를 발생시키는 것이 아니라 인위적으로 특정 시점에 예외를 발생시킬 때 사용하는 키워드이다.

- `throw` 키워드를 사용한다. 

```java
Scanner sc = new Scanner(System.in);
System.out.println("등록할 ID를 입력하세요 : ");
String id = sc.nextLine();


try {
  if(id.length() > 8) {
    throw new Exception("ID는 최대 8글자만 가능합니다.");
  }
  System.out.println("ID를 등록하였습니다. ");

} catch (Exception e) {
  e.printStackTrace();
}
```

```
[cosole창]
java.lang.Exception: ID는 최대 8글자만 가능합니다.
	at kr.ac.kopo.day13.exception.Exception06.main(Exception06.java:27)
```


- 나만의 룰을 만들어 사용자 정의 예외 클래스를 만들고 싶다면, Exception클래스를 상속받은 클래스를 만들어주기만 하면 된다. 

```java
// 사용자 정의 예외 클래스
public class CheckIDException extends Exception{

	public CheckIDException() {
		super();
	}

	public CheckIDException(String message) {
		super(message);
	}
	
}
```

```java
Scanner sc = new Scanner(System.in);
System.out.println("등록할 ID를 입력하세요 : ");
String id = sc.nextLine();


try {
  if(id.length() > 8) {

// 사용자 정의 예외처리 ==========================================================================================================

    throw new CheckIDException("ID는 최대 8글자만 가능합니다.");           // CheckIDException에 매개변수 있는 생성자 만들어줘야 함
    
//===============================================================================================================================
  }
  System.out.println("ID를 등록하였습니다. ");

} catch (Exception e) {
  e.printStackTrace();
}
```
