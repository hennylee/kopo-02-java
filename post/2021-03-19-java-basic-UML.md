# UML

## 설치
- [Help - install new Software]
- `http://takezoe.github.io/amateras-update-site` - [엔터] - Modeler만 설치하기 - install Anyway

- installer로 이클립스를 설치한 경우 이 방법으로만 설치 가능하다.


## 클래스 다이어그램
- 클래스다이어그램 : 클래스와 클래스의 관계를 표현하는 것이다.
- 클래스와 클래스 간 관계를 설정해주는 것이 목적이다.
- 하나의 클래스의 정보도 표현하게 된다. 
- 클래스에 대한 구성도, 설계도를 클래스 다이어그램을 통해 만들 수 있다.

## Entity
- 클래스를 표현하려면 아래와 같이 구성되어 있다. 

|클래스명|
|--|
|멤버변수|
|메소드|

- 멤버변수와 메소드는 아래 형식을 맞춰서 작성해야 한다.

|클래스명|
|--|
|접근제한자 변수명 : 자료형|
|접근제한자 메소드명(매개변수명 : 자료형 ) : 반환타입|

- 접근제한자 기호
  - `+` : public
  - `#` : protected
  - `~` : default
  - `-` : private

## Relation

- 화살표가 가르키는곳이 상위 클래스이다.
- 화살표가 뻗어나가는 곳이 하위 클래스이다.


## 사용방법
- Class명에 package명까지 표기한다
- 마우스 우 클릭하면 `add Attribute`와 `add Operation`을 통해 멤버변수와 메소드를 만들 수 있다.
- 메소드는 기본이 public이다.
- 매개변수 있는 생성자를 만드려면, Open Propert View에서 Argument를 추가해야 한다. 
- 마우스 우클릭해서 [Java - export] 하면 자동으로 자바 클래스 파일이 만들어진다.
