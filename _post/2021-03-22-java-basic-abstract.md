# [day11] 추상

## 추상메소드
- '추상메소드'란 반드시 사용해야 하는 표준화 작업이 필요할 때 강제성을 부여하는 메소드이다.

- `ㅁㅁ라는 추상클래스를 상속받은 ㅎㅎ라는 클래스에는 ㅇㅇ라는 추상메소드가 반드시 필요하다` 라고 코드를 짜고싶을 때 사용한다.

- 그래서 추상 클래스를 상속받은 하위 클래스는 상위 추상클래스의 추상메소드를 반드시 오버라이딩해야 한다. 

- '추상메소드'는 내용부(`{ }`)를 가지고 있지 않은 메소드이다.

- 추상메소드를 포함하는 클래스는 반드시 추상클래스로 선언되어야 한다.


## 추상클래스
- '추상클래스'란 1개 이상의 '추상메소드'를 가진 클래스이다.

- 상속보다 더 변화에 둔감하게 만들기 위해 상속에 부가적으로 사용되는 기능이 바로 '추상클래스'이다.

- 추상클래스는 덜 만들어진 설계도이므로, 추상클래스를 상속받은 자식 클래스로만 인스턴스 객체를 만들 수 있다.

- 즉, 추상클래스만으로는 `new`키워드를 사용할 수 없다.

- 추상클래스는 일반 구현된 메소드와 추상메소드를 모두 가질 수 있지만, 인터페이스는 추상메소드들의 집합이다.

- 추상클래스의 객체변수는 하위클래스를 이용한다.

```java
abstract class Printer { }
class LGPrinter extends Printer { }
=====================================
class Main {
    public staitc void main(String[] args) {
        Printer p = new LGPrinter();
    }
}
```



- '추상클래스'와 '추상메소드' 앞에는 `abstract`라는 키워드를 붙인다.

```java
// 추상클래스
abstract class Aniamal{

  // 추상메소드
  abstract void print{};

}
```

## 실습해보기

### 추상클래스 없는 방식 : package kr.ac.kopo.day11
- 클래스 만들때 상속받을 클래스 미리 설정해주기 : SuperClass 설정
![image](https://user-images.githubusercontent.com/77392444/111931613-e435f600-8afe-11eb-9711-1a2c18bbee1c.png)

- 삼성이나 엘지나 다 목적은 출력인데 출력 메소드를 다 다르게 가지고 있어서(`lgPrint()`, `samPrint()`) 프린트 회사를 바꾸면 메소드명을 다 바꿔줘야 해서 좋지 않다. 
![image](https://user-images.githubusercontent.com/77392444/111932444-c7022700-8b00-11eb-8f0e-a1216d80006f.png)

### 추상클래스 : package kr.ac.kopo.day11.abs02
- 추상클래스와 추상메소드를 만들어서 상속받아 사용하기 때문에 새로운 프린터 회사가 추가되어도 쉽게 구현할 수 있다. 
![image](https://user-images.githubusercontent.com/77392444/111933260-6aa00700-8b02-11eb-9940-433d7f9a1b8e.png)

- 상속의 경우 상위클래스의 타입을 통해 하위 클래스의 인스턴스 객체를 생성할 수 있다. 

```java
public void print(int no) {

  // 상속의 경우 상위클래스의 타입을 통해 하위 클래스의 인스턴스 객체를 생성할 수 있다. (객체형변환)
  Printer p = null;

  switch (no) {
  case 1: 
    p = new LGPrinter();
    break;
  case 2: 
    p = new SamsungPrinter();
    break;
  case 3: 
    p = new HPPrinter();
    break;
  }

  // 세 가지 case 모두 같은 변수명과 메소드를 구현하기 때문에 한 번만 작성해줌으로써 코드를 줄일 수 있다.
  if(p != null)
    p.print();
  else {
    System.out.println("잘못 선택하셨습니다.");
  }

}
```



### HP가 잉크젯과 레이저 사업부로 분사된 경우 : package kr.ac.kopo.day11.abs03

![image](https://user-images.githubusercontent.com/77392444/111951728-64705180-8b27-11eb-827d-acb26588488b.png)


## 객체형변환
- 다형성의 기본 원리가 바로 객체 형변환이다.

- 대입 연산자 `=` 를 기준으로 좌변과 우변 항의 형이 다른 경우 형변환이 일어난다

- 객체 형변환은 오직 대입 연산자에서만 일어난다.

- 객체 형변환이 발생하려면 좌변과 우변의 관계가 서로 상속관계를 가지고 있어야 한다.

```java
abstract class Printer { }
class LGPrinter extends Printer { }
=====================================
class Main {
    public staitc void main(String[] args) {
        Printer p = new LGPrinter();
    }
}
```

- 객체 형변환의 종류 : 1) 묵시적 형변환, 2) 명시적 형변환

### 묵시적 형변환
- `부모 클래스 타입 = 자식 클래스 타입`

- 자식클래스의 인스턴스 객체 주소를 부모클래스 타입의 참조변수가 가리키게 되는 것이다.

```java
abstract class Printer { }
class LGPrinter extends Printer { }
=====================================
class Main {
    public staitc void main(String[] args) {
        Printer p = new LGPrinter();
    }
}
```

- 만약 위의 예시에서 LGPrinter는 Printer객체와 LGPrinter 객체를 둘 다 가지고 있기 때문에, 
`Printer p = new LGPrinter()`에서 부모의 참조변수인 Printer p가 접근할 수 있는 범위는 Printer객체 뿐이다. 

- 단, 상위클래스의 메소드를 하위클래스에서 오버라이딩했을 경우 Printer p가 하위클래스에 오버라이딩된 메소드를 호출할 수 있다.

- `Printer p = (Printer) new LGPrinter()`로 작성해야 하지만, 묵시적 형변환에 의해 `(Printer)`를 생략할 수 있다.
![image](https://user-images.githubusercontent.com/77392444/111938059-7c86a780-8b0c-11eb-8b22-936df0b0b61c.png)

- `List list = new ArrayList();`도 묵시적 형변환이 자주 사용되는 예시이다. 만약 자료구조를 LinkedList로 바꾸고 싶다면, `List list = new LinkedList();`로만 바꿔주면 된다.


### 명시적 형변환

- `자식클래스 타입 = (자식 클래스 타입) 부모 클래스 타입`

```java
abstract class Printer { }
class LGPrinter extends Printer { }
===============================================
class Main {
    public staitc void main(String[] args) {
        Printer p = new LGPrinter();
    }
}
```

- 이때, `LGPrinter p = new Printer();`이나 `LGPrinter p = (LGPrinter) new Printer();` 은 모두 컴파일 에러이다. LGPrinter의 인스턴스 객체가 만들어지지 않은 상태이기 때문이다.

- `Printer p = new Printer();`이나 `LGPrinter lgtv = (LGPrinter) p;`는 컴파일 에러는 아니고 실행시 오류가 발생한다. 

- 객체를 생성하지도 않고 형변환을 시키려고 하면 에러가 발생할 수 밖에 없다. 그래서 무조건 형변환할 타입의 객체를 만들어줘야 한다.

- 명시적 형변환을 통해 묵시적 형변환에서 실행시킬 수 없는 자식클래스만의 메소드를 실행시킬 수 있다.

```java
// 묵시적 형변환
Parent p = new Child02();
p.info();

// 만약 Child02만 가지고 있는 메소드를 실행시키고 싶을 때, 명시적 형변환을 한다.
Child02 c = (Child02) p;
c.sing();
c.play();

```

- 대입연산자 오른쪽에 나와야 하는 상위 type의 변수는 이미 묵시적 형변환이 되어 있는 객체여야 한다.

```java
Printer p = new LGPrinter();  // 묵시적 형변환
LGPrinter lg = (LGPrinter) p; // 명시적 형변환
```

- `instanceof` 연산자

```java
public class CastMain03 {
	
	public static void print(Parent p) {
		p.info();
		
		System.out.println("[p instanceof Child01] : " + (p instanceof Child01));
		System.out.println("[p instanceof Child02] : " + (p instanceof Child02));
		System.out.println("[p instanceof Parent] : " + (p instanceof Parent));
		
		if(p instanceof Child01) {
			
			Child01 c = (Child01) p;
			c.sleep();
			c.study();
			
		}else if (p instanceof Child02) {
			
			Child02 c = (Child02) p;
			c.sing();
			c.play();
			
		}
	}	
	
	public static void main(String[] args) {
		
		Parent p = new Child02();
		print(p);
		
		System.out.println("--------------------------------------------------------------");
		
		Child01 c01 = new Child01();
		print(c01);
		
		System.out.println("--------------------------------------------------------------");

		// 만약 Child02만 가지고 있는 메소드를 실행시키고 싶을 때, 명시적 형변환을 한다.
		Child02 c = (Child02) p;
		print(c);
		
	}
}
```
