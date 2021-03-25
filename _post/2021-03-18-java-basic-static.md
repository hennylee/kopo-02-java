# [day09] java-basic : Static

## static이란
- static은 활용제한자이다.

## static의 특징
- static이라는 키워드는 변수 or 메소드에만 쓸 수 있다. 클래스에는 쓸 수 없다.
- static이 변수에 붙으면 공유 값이다. 여러개가 만들어지지 않고 하나의 값만 만들어져서 이를 여러 개가 공유하게 되는 것이다.

- 메모리 특징 : static이 붙으면 클래스당 하나의 메모리 공간만 할당된다. nonStatic은 인스턴스 당 메모리가 별도로 할당된다. 
- static 변수는 클래스 당 하나씩밖에 안만들어지기 때문에 클래스변수라고도 한다.

- 로딩 시점 : static은 클래스 로딩 시, nonStatic은 객체 생성 시 로딩된다. 
- JVM이 클래스를 읽을 때 즉 프로그램에 실행되자마자, static의 공간이 만들어지는 것이다. 그래서 생성시점이 static이 nonStatic보다 훨씬 빠르다.
- 즉, 인스턴스 객체가 생성되지 않고 `Employee e;`라는 코드가 작성되기만 해도 static 변수가 생성된다.
- 이렇게 인스턴스 객체 없이 생성된 static 변수에 접근하려면 `클래스명.static변수명`으로 작성하면 된다.
- 근데 변수명으로 직접 접근하는 것보다는 getter/setter메소드를 이용해서 접근하는 방식이 일반적이므로 static변수의 getter/setter메소드도 static메소드여야 호출할 수 있다.

- 주의해야 할 점은 static메소드이다. 
- static메소드가 생성되었다고 해도 nonStatic 변수가 안만들어져 있을 수도 있기 때문에 static메소드에서는 static 영역만 사용 가능하다.
- 그래서 static 메소드 내에서는 this를 사용할 수 없게 된다.

## static의 사용 목적
- 같은 클래스의 변수값이 하나의 변수를 공유하고 싶을 때 변수에 static을 붙여서 사용한다.

## static의 메모리 영역
- 공유하는 상수값(Constant Pool)들은 Heap 영역이 아니라 Method Area에 저장되게 된다.
![image](https://user-images.githubusercontent.com/77392444/111570208-a035af00-87e7-11eb-8655-e1db1f765528.png)

- 만약 `String s = "hello";`라면 "hello"값은 상수값이므로 `Method Area` 메모리 영역에 저장되게 된다. 
- 반면 `String s = new String("hello");`라면 "hello"값은 `heap` 메모리 영역에 저장된다.

- 이처럼 static변수도 상수변수와 같이 한번 생성되면 여러개가 공유하게 되므로, Method Area에 저장되는 것이다.

