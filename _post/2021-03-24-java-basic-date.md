# 날짜 관련 API

## 날짜 관련 API 클래스
- java.util.`Date`
- java.util.`Calendar`
- java.text.`SimpleDateFormat`

## Date클래스
- JDK 1.1 버전부터 Calendar클래스가 생겨나서 Deprecated됨

```java
// 오늘 년,월,일 구하기
Date d = new Date();
System.out.println("d : " + d.toString()); 	// 왜 d를 찍으면 주소값이 안찍힐까? 
                                            // Date클래스에서 toString메소드를 override했기 때문이다.

// 연도 추출
int year = d.getYear() + 1900;			// 1900년 1월 1일부터 몇년째인지 결과를 반환한다.

// 월 추출
int month = d.getMonth() + 1;			// 0(1월) ~ 11(12월)을 출력한다.

// 일 추출
int date = d.getDate();

System.out.println("오늘은 "+ year + "년 " + month + "월 " + date + "일입니다.");
```

- 왜 Date의 객체를 출력하면 주소값이 아니라 날짜정보가 출력될까?

  - 원래 print, println 메소드에서는 객체 값을 찍으라고하면 내부적으로 Object클래스의 toString()메소드를 호출한다. (`객체.toString()`)

  - 이때 Object 클래스의 `toString()`메소드는 원래 클래스정보와 hashcode값을 반환한다.

  - 하지만 Date클래스에서는 `toString()`을 override해서 날짜 정보를 반환하라고 설정했기 때문에 날짜 정보가 출력되는 것이다. 

  - 이와 마찬가지고 String클래스에서도 `toString()`을 override했기 때문에 문자열 값 자체를 출력할 수 있게 된 것이다.

## Calendar클래스
- Calendar클래스는 추상클래스이기 때문에 자체만으론 인스턴스 객체를 만들 수 없다.

- 하지만 Calendar클래스의 객체를 만들기 위해서 Calendar클래스를 상속받은 자식 클래스의 객체를 생성하지 않는다.

- 대신 Calendar에 static메소드인 `getInstance()`를 통해서 객체를 생성할 수 있다.

- `static Calendar getInstance()` : 객체 얻기

- `int get(int calendarField)` : 정보 추출

- calendarField는 final 상수 변수이다.????
