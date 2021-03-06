# [day08 ~ 09] java-basic : 문자열 API

## 문자열 정의
- 자바에서는 문자열을 무조건 객체로 취급한다. reference 참조형 데이터형이기 때문이다.

- java.lang 패키지에 포함되어 있기 때문에 import하지 않아도 사용할 수 있다.

- 문자열을 저장할 수 있는 클래스는 `java.lang.String`, `java.lang.StringBuffer`, `java.lang.StringBuilder` 클래스를 제공한다.

- 변화가 일어나는 경우 String클래스를 사용하지 않고, 한 번 생성된 다음 변하지 않는 문자열에 보통 String 클래스를 사용한다.

- String은 char의 배열로 이루어져 있기 때문에 공간이 한 번 만들어지면 크기를 절대 변경할 수 없기 때문이다. 

- 즉, Stringdms 두 문자열을 합친때 기존의 문자열 공간이 늘어나는 것이 아니라 새로운 공간이 생기고 합쳐진 문자열이 저장되는 것이기 때문에 변화가 잦은 경우에는 적합하지 않다.  

- 보통 변화하는 문자열의 경우에는 StringBuilder(비동기화, 1.5이후)와 StringBuffer(동기화)를 사용한다. 

- https://docs.oracle.com/javase/8/docs/api/index.html


## String 클래스
- 문자열의 길이를 알려주는 메소드 : `length()`

- 특정한 위치의 문자열 추출하는 메소드 : `charAt(int i)`

- 문자열을 배열로 변환하는 메소드 : `getChar()`

- 문자열의 내용를 비교하는 메소드 : `boolean equals(Object str)` / `boolean eqaulsIgnoreCase(String str)` / `startsWith()` / `endsWith()`

- 사전순으로, 앞쪽에 위치(-)하는지 뒷쪽(+)에 위치하는지 같은지(0) 확인하는 메소드 : `int compareTo(String str)`
  - 작동 원리 : `charAt(0)` ~ `charAt(str.length())`까지 도는데, 각 번지수의 유니코드 값을 뺀 차가 0이 아닐때까지만 돌면서 차가 음수인지 양수인지 0인지를 반환한다.

- 문자열이 포함되어 있는지 확인하기 : `boolean contains(String str)`

## String의 비교

- 주소 비교 : `==`

- 내용 비교 : `.equals()`

- 아래 경우에 내용 비교가 이루어진 것처럼 보이지만, 실제로는 "Hello"가 같은 주소값에 저장되어 공유하기 때문에 같다는 결과가 도출된 것이다.

```java
// 문자열 상수 주소비교 ==============================================
String str = "Hello";
String str2 = "Hello";

if(str == str2)
System.out.println("str == str2");
else
System.out.println("str != str2");
```

## String 탐색
- 0 번지부터 검색하며 위치 반환하기 : `int indexOf(String str)`

- 마지막 번지부터 검색하며 위치 반환하기 : `int lastindexOf(String str)`

## String 변환
- 사실상 변환은 아니고 변환된 String을 return하는 메소드들이다. 

- 부분 문자열 반환 : ``
- 결합된 문자열 반환 : ``
- 치환된 문자열 반환 : ``
- 시작과 끝부분의 공백 제거해서 반환 : ``
- 소문자로 반환 : ``
- 대문자로 반환 : ``
- regexp를 기준으로 문자열 나누기(하나의 문자열을 특정 구분자를 가지고 여러개의 문자열로 쪼개는 것) : `String[] `

## String 형변환

- `String.valueOf()` : 어떤 데이터형이 나오던 문자열로 바꾸는 메소드

```java
int sum = 0;

for(int i = 0; i < 100000; i++) {
  //str += i;
  sum += i;
}

long end = System.currentTimeMillis();
```
