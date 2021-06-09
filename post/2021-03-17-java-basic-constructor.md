# [day08] java-basic : 생성자

## 생성자란?

```java
public class Dog {
  
  // 생성자 start ==========================================
  Dog() {
    
  }
  // 생성자 end ============================================
  
}
```

- 생성자는 인스턴스 객체를 만들때 사용된다. `Dog dog = new Dog();` 에서 `Dog()`이 바로 생성자이다.


## 생성자는 왜 쓰는가?
- 멤버변수값을 초기화하기 위한 목적으로 생성자를 사용한다. 
- 보통 멤버변수는 private 접근제어자로 은닉화되어 있기 때문에, 매번 초기화해주는 것은 번거롭기 때문에 생성자가 이 역할을 미리 해주는 것이다. 
- 생성자는 객체를 생성할 때 속성의 초기화를 담당하게 된다.
- `Dog d = new Dog();`코드에선 멤버변수가 자동 초기화 된다.
- `Dog d = new Dog("메리", 4);`코드에선 멤버변수가 메리와 4로 초기화 된다.

## 생성자의 특징
- 생성자는 반환형이 없다. (void X)
- 생성자는 클래스명과 이름이 동일하다. 
- 생성자도 오버로딩을 지원한다. 오버로딩은 같은 클래스 내에 메소드 명은 동일하지만 매개변수의 타입과 수가 다른 것이다.
- 생성자 내에서 `this`없이는 다른 생성자 호출이 불가능하다.
- 생성자의 작성 위치는 클래스 내 멤버변수와 메소드 사이에 들어간다. 

## 디폴트 생성자
- 인스턴스 객체를 만들때 생성자를 사용하지만 생성자는 직접 만든 적이 없을 것이다. 
- 왜일까? JVM이 하나의 클래스를 로딩하다가 개발자 정의 **생성자가 하나도 존재하지 않으면** 자동으로 만들어주기 때문이다.
- 이렇게 JVM이 자동으로 생성한 생성자를 `default 생성자` 라고 한다.
- 디폴트 생성자는 매개변수가 없는 형태이다.
- 사용자 정의 생성자가 하나라도 존재하면 JVM은 디폴드 생성자를 절대 만들지 않는다. 
- 그래서 내가 매개변수 있는 생성자를 만들고자 한다면, 디폴트 생성자를 먼저 생성한 뒤 프로그램을 짜는 습관을 들이는 것이 좋다. 

## this의 사용방법
1. 나와 똑같은 정의되어 있는 클래스의 메소드를 호출하는 경우 : `this.메소드명()`
2. 내 객체에 있는 멤버변수에 접근하는 경우 : `this.멤버변수`
3. new를 이용해서 이미 호출됐을때 생성자를 다시 호출하는 경우 : `this(인자값)`

- 생성자 안에 this 사용자는 생성자의 brace `{ }` 안에서 제일 첫 줄에 위치해야 한다.
- this 호출 시 생성자 내부에서만 호출이 가능하다.

```java
class Dog {

  // 멤버변수
  String name;
  
  // 생성자01
  Dog() {
    // 생성자 내부에서 멤버변수 호출
    this("쫑");
  } 
  
  // 생성자02
  Dog(String name) {
    // 생성자 내부에서 멤버변수 호출
    this.name = name;
  } 

}
```
