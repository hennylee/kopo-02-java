# [day15] java-basic : I/O API

- 공식문서 : https://docs.oracle.com/javase/tutorial/essential/io/file.html

## I/O란
- RAM에 들어있는 변수을 외부장치 입출력 장치에 보내거나 받는 것은 다 I/O와 관련이 있다. (I/O : Input/Output)

- 외부 장치와 데이터를 주고 받기 위해서는 스트림이란 연결 통로를 활용한다.

- Java는 기본적으로 입출력 단위가 유니코드 기반으로 움직인다. (char가 2byte) 

- C, C++은 입출력 단위가 아스키코드 기반으로 움직인다. (char는 1byte)

- 만약 클라이언트는 자바로, 서버는 C로 만든다면 문제가 발생한다.

- 그래서 원래는 다 아스키코드 기반으로 만들었었다.

- 90년대 이후부터는 유니코드 기반으로 만들어지기도 한다.

- 그래서 자바가 다른 프로그램과 소통, 연결하기 위해서 아스키코드와 유니코드 기반 모두를 지원한다.

## Stream이란

- 자바는 기본적으로 character stream을 사용한다.

- 다만 이기종과 접근하기 위해서 byte Stream도 제공하는 것이다.

- 컴퓨터에서 Stream이란? 실시간 스트리밍 방송에서 스트림이란 단어를 왜 쓸까?

- 실제로는 수십만개의 데이터가 넘어오지만 사용자가 느끼기에는 물흐르듯이 하나의 데이터를 받는 것처럼 느끼기 때문이다.

- 실제로 "사랑합니다"라는 글자를 전송하면 자바에서는 스트림으로 '다', '니', '합', '랑', '사'라는 5개의 유니코드 단어가 따로따로 전송되는 것이다.

- 이때 이 5개의 단어가 날라가는 통로가 바로 Stream이라고 하는 것이다.

- 인터넷 속도가 안좋으면 버퍼링에 걸린다.

## 특징

- FIFO방식이다.

- 단방향이다.

- 지연될 수 있다.

## IO 처리 단위

|   |byte|Char|
|---|-----|-----|
|입력|InputStream|Reader|
|출력|OutputStream|Writer|


## 바이트 스트림

![image](https://user-images.githubusercontent.com/77392444/115521859-88f64f80-a2c6-11eb-9d98-6ae9a71b4607.png)


- 입력출력이 Ram기반이 아니라 장치 기반이다.

- 외부장치를 입력용으로 하면 InputStream, 외부장치를 출력용으로 하면 OutputStream이다. 

- FileInput/Output은 1byte단위이다.

- 만약 20byte단위를 외부로 옮기려면 1byte씩 움직여서 20번 움직여야 한다. 

- 하지만 이렇게 되면 속도가 느리니까 Buffer라는 장치를 추가시킨 것이다. 그게 Filter클래스의 Buffered I/OStream이다.

- byte하나가 뭘 의미하는지 헷갈릴 수 있다. 쪼갠 1byte가 무엇인지 애매할 때, 날라가는 정보는 정수야~ 실수하나 넘기는 거야~ 라고 알려주는 것처럼 보이는것이 Data I/OStream이다.

- 근데 레퍼런스 타입을 주고 받을 때 쓰는 것이 Object I/OSteam 이다.


## InputStream

![image](https://user-images.githubusercontent.com/77392444/115522065-be02a200-a2c6-11eb-971c-d3cc11aafd05.png)


- `int read()` : 입력스트림으로 1byte씩 읽어와서 int형 값을 반환한다. 읽은 바이트가 파일의 끝이면 -1을 반환한다.

- `int close()` : 연결된 것을 끊는 것이다.

## OutputStream

![image](https://user-images.githubusercontent.com/77392444/115522130-cf4bae80-a2c6-11eb-91fc-7d4d4240d682.png)

- `void write(int c)` : 스트림으로 출력




## File

![image](https://user-images.githubusercontent.com/77392444/115522392-0752f180-a2c7-11eb-8052-70e85c2fa1fa.png)


## FileInputSteam

![image](https://user-images.githubusercontent.com/77392444/115522199-dd99ca80-a2c6-11eb-9a8c-1203ebf6f423.png)


- `int read()` : 입력스트림으로 1byte씩 읽어와서 int형 값을 반환한다. 읽은 바이트가 파일의 끝이면 -1을 반환한다.

- 메소드는 그냥 InputStream 같지만 입출력 장치에 따라 construct만 다르기 때문에 이것만 잘 숙지하면 된다.

- 디렉토리나 파일에 대한 정보를 클래스로 가지고 있는 아이가 File클래스이다. 

## FileOutputStream


- File을 모니터 Console창처럼 쓰고싶은 것이다.

![image](https://user-images.githubusercontent.com/77392444/115522226-e2f71500-a2c6-11eb-9968-31b0104eca9a.png)

- `void write(int c)` : 스트림으로 출력메소드

- 메소드는 그냥 InputStream 같지만 입출력 장치에 따라 construct만 다르기 때문에 이것만 잘 숙지하면 된다.

- FileNotException

- 하드디스크에 파일이 있어도 지워서 무조건 0바이트로 만든다. 그래서 매개변수에 append를 true로 바꾸면 맨 마지막 내용에 이어 붙인다. 


## BufferdInputStream

![image](https://user-images.githubusercontent.com/77392444/115522504-1e91df00-a2c7-11eb-97c2-4353062f20a0.png)


## BufferdOutputStream

![image](https://user-images.githubusercontent.com/77392444/115522552-2baece00-a2c7-11eb-8644-ea2c78851121.png)


## Data
![image](https://user-images.githubusercontent.com/77392444/115522966-8ba57480-a2c7-11eb-927a-76cc1d08d4ca.png)

## DataInput, DataOutput 인터페이스

![image](https://user-images.githubusercontent.com/77392444/115522870-7597b400-a2c7-11eb-93c0-d7f6f9899cf0.png)

![image](https://user-images.githubusercontent.com/77392444/115522905-7c262b80-a2c7-11eb-8ff4-eef6f5290315.png)


## DataInputStream

![image](https://user-images.githubusercontent.com/77392444/115522597-379a9000-a2c7-11eb-8f2b-9fcfb1b12bf8.png)


- 저장되어 있는 순서를 모르면 메소드를 결정할 수 없다는 단점이 있다. 


## DataOutputStream

![image](https://user-images.githubusercontent.com/77392444/115522625-3d907100-a2c7-11eb-904d-afc9e844bcfe.png)


- 기본 데이터형으로 입출력하고 싶을 때, 1byte씩 입출력된 파일 내용을 기본 자료형에 맞게 변형해주는 필터기능을 가지고 있는 것이다.

- 화면에 보여줄 목적이 아니기 때문에 DataStream을 통해 입/출력된 내용은 저장에 의의가 있다. 

- 메모장 등으로 보면 기본 자료형에 맞게 데이터가 보이진 않지만, 기본 자료형 byte에 맞게 잘 저장이 되어 있는 것이다. 


## ObjectInput, ObjectOutput 인터페이스

- 객체의 입출력을 지원하고, 객체를 파일에 저장 또는 저장된 객체를 읽어올때 사용한다. 

- 직렬화(Serialization)을 통해 객체가 가진 데이터들을 순차적인 데이터로 변환시킨다. 

- 역직렬화(Deserialization)를 통해 직렬화된 데이터를 읽어서 자신의 상태를 복구한다. 

## ObjectInputStream

![image](https://user-images.githubusercontent.com/77392444/119295566-0b8d7880-bc92-11eb-9686-e386171173a5.png)

- `readObject()` : 객체 단위로 읽어오는 메소드

## ObjectOutputStream

![image](https://user-images.githubusercontent.com/77392444/119295581-17793a80-bc92-11eb-8748-69947f929861.png)

- `writeObject()` : 객체 단위로 입력하는 메소드

- 객체 직렬화(Serializable) : 따로따로 있는 객체를 Stream에 이어서 쭉 넣고 싶을 때 사용한다. 
- 객체 직렬화를 사용하려면 객체 클래스(VO, DTO)에 Serializable이라는 인터페이스를 상속받기만 하면 된다. (`implements Serializable`)


## 문자 스트림

![image](https://user-images.githubusercontent.com/77392444/115521896-901d5d80-a2c6-11eb-9bef-0f64cbe67a33.png)


- 텍스트 형태의 정보를 주고 받을 때 2byte단위로 입출력한다.

- InputStreamReader는 byte로 날라온 것을 2byte 형태로 바꾸는 Filter클래스들이다.



## InputStreamReader/Writer

- InputStream/OutputStream과 같지만 2byte단위로 읽어오기 때문에 char문자를 인식한다.



## Reader

![image](https://user-images.githubusercontent.com/77392444/115523148-be4f6d00-a2c7-11eb-9112-9ac5cdd47d4f.png)


## Writer

![image](https://user-images.githubusercontent.com/77392444/115523178-c60f1180-a2c7-11eb-825f-e4d5c923be64.png)

- `void flush()` : 출력 버퍼에 저장된 모든 데이터를 출력 장치로 전송한다.  
  - 과거에는 출력과 입력 버퍼는 하나를 공통으로 사용했기 때문에 출력이 끝나기 전까지 입력이 버퍼를 사용할 수 없었다. 이때 버퍼를 비워주기 위해 필요한 기능이었다. 
  - 지금은 많이 사용되지 않지만 `write()`가 끝나면 `flush()`를 통해 데이터를 전송해주는 것이 좋다.

## FileReader

![image](https://user-images.githubusercontent.com/77392444/115523253-d7f0b480-a2c7-11eb-921e-e3367a2fd8e8.png)



## FileWriter

![image](https://user-images.githubusercontent.com/77392444/115523264-dcb56880-a2c7-11eb-96b2-175d7d42b170.png)


## BufferedReader

![image](https://user-images.githubusercontent.com/77392444/115523715-4e8db200-a2c8-11eb-8e0a-507ed3e2d95e.png)

- `readLine()` : 라인 단위로 읽어온다.


## BufferedWriter

![image](https://user-images.githubusercontent.com/77392444/115523736-53526600-a2c8-11eb-85ce-2132026d38a9.png)

- `newLine()` : 새로운 줄에 출력한다.
