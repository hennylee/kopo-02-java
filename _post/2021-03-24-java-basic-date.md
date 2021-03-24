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

  - 이와 마찬가지로 String클래스에서도 `toString()`을 override했기 때문에 문자열 값 자체를 출력할 수 있게 된 것이다.

## Calendar클래스
- Calendar클래스는 추상클래스이기 때문에 자체만으론 인스턴스 객체를 만들 수 없다.

- 하지만 Calendar클래스의 객체를 만들기 위해서 Calendar클래스를 상속받은 자식 클래스의 객체를 생성하지 않는다.

- 대신 Calendar에 static메소드인 `getInstance()`를 통해서 객체를 생성할 수 있다.

- `static Calendar getInstance()` : 객체 얻기

- `int get(int calendarField)` : 정보 추출

- calendarField는 final 상수 변수이다.

- `int getActualMaximum(int calendarFeild)` : 해당 월의 일수 반환

- Calendar클래스의 get메소드로 오늘 날짜 구하기는 아래와 같다. 

```java
// 캘린더 객체 생성
Calendar c = Calendar.getInstance();
System.out.println(c); 	// java.util.GregorianCalendar


// 년
int year = c.get(1);						        // 1이라고 쓰면 직관적이지 않음
year = c.get(Calendar.YEAR);				    // Calendar클래스에 정의된 YEAR 상수 변수를 활용하면 직관적임

// 월
int month = c.get(2);
month = c.get(Calendar.MONTH) + 1;			// MONTH : 0 ~ 11

// 일
int date = c.get(3);
date = c.get(Calendar.DATE);	
date = c.get(Calendar.DAY_OF_MONTH);		// 변수 DAY_OF_MONTH나 DATE모두 상수값 5로 저장되어 있음

// 요일
int day = c.get(Calendar.DAY_OF_WEEK);	// 1(일요일) ~ 7(토요일)
String[] dayArr = {"","일", "월", "화", "수", "목", "금", "토"};

System.out.println(year + "-" + month + "-" + date +" (" + dayArr[day] + ")");
```

- Calendar클래스의 get메소드와 set메소드를 활용하면 궁금한 날짜에 대한 정보를 알 수 있다. 

```java
// 2021년 5월 5일은 무슨 요일?
c.set(2021, 5-1, 5);					// MONTH : 0 ~ 11이므로 5월이 궁금하면 4를 매개변수로 넘겨줘야 한다.
day = c.get(Calendar.DAY_OF_WEEK);
System.out.println("2021-5-5은 " + dayArr[day] + "요일 입니다.");

// 5월의 마지막날이 몇일?
int lastday = c.getActualMaximum(Calendar.DATE);
System.out.println("5월은 " + lastday +"일이 마지막 날이다.");

// 2월의 마지막날이 몇일?
c.set(c.MONTH, 2-1);
lastday = c.getActualMaximum(Calendar.DAY_OF_MONTH);
System.out.println("2월은 " + lastday + "일로 구성되어 있습니다.");
```


## SimpleDateFormat클래스

- `SimpleDateFomat(String patter)`으로 객체를 생성한다. 

- `객체.format(Date 객체)`로 Date 형식을 패턴에 맞게 바꿀 수 있다. 

```java
// 오늘 날짜 구하기
String pattern = "yyyy년 MM월 dd일(E) HH:mm:ss / hh:mm:ss";
SimpleDateFormat sdf = new SimpleDateFormat(pattern);

String date = sdf.format(new Date());
System.out.println(date);
```

- format 메소드의 매개변수는 Date 밖에 안된다. 
- 그래서 캘린더 객체의 `getTime()`메소드를 통해 얻어낸 값을 Date 데이터형의 객체로 만든 뒤 사용해야 한다.

```java
// 캘린더 객체를 가지고 simpleDateFormat 사용하기
Calendar c = Calendar.getInstance();
Date d = c.getTime();

System.out.println(sdf.format(d));
```

