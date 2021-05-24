---
title:  "자바 직렬화(Serialize)"
excerpt: "ObjectInputStream/ObjectOutputStream와 자바 직렬화(Serialize)"
header:
  teaser: 

categories:
  - Java
tags:
  - I/O
  - Serialize
toc: true
toc_sticky: true
---



## 1. 자바 직렬화

- 자바 직렬화란?
  - 자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte) 형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)을 아울러서 이야기합니다.

  - 시스템적으로 이야기하자면 JVM(Java Virtual Machine 이하 JVM)의 메모리에 상주(힙 또는 스택)되어 있는 객체 데이터를 바이트 형태로 변환하는 기술과 직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태를 같이 이야기합니다.

- 자바 직렬화 조건
  - 자바 기본(primitive) 타입과 java.io.Serializable 인터페이스를 상속받은 객체는 직렬화 할 수 있는 기본 조건을 가집니다.

- 직렬화 방법
  - 자바 직렬화는 방법은 java.io.ObjectOutputStream 객체를 이용한다.

## 2. FileOutputStream, ObjectOutputStream를 사용해서 Object 하나를 입출력하기

### UserInfo.java


```java
package kr.ac.kopo.day16;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private String name;
	private transient int age;
	private String addr;
	// 기본 생성자 : alt + shift + s 누른 후 c 선택
	public UserInfo() {
		super();
	}
	
	// 매개변수 생성자 : alt + shift + s 누른 후 o 선택
	public UserInfo(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	// getter/setter : alt + shift + s 누른 후 r 선택
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	

	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	// toString() 메소드를 오버라이드 : alt + shift + s 누른 후 s 선택
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}
```


### FileIOMain11.java

```java
package kr.ac.kopo.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * FileOutputStream, ObjectOutputStream를 사용해서 Object 하나를 입출력하기
 * @author HP
 *
 */
public class FileIOMain11 {
	
	public static void write() throws Exception{
		UserInfo user = new UserInfo("홍길동", 25, "서울시 서초구");
		
		// 만약 3개의 정보(이름, 나이, 주소) 중 age만 빼고 일부만 저장하고 싶다면? =>UserInfo클래스의 age에 transient 키워드를 붙인다.
		user.setAge(0);
		
		
		
		FileOutputStream fos= new FileOutputStream("iodata/objectData.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(user);
		oos.flush();
		
		System.out.println("objectData.txt 저장완료");
		
	}
	
	public static void read() throws Exception {
		
		// 파일 내용 읽어오기
		FileInputStream fis = new FileInputStream("iodata/objectData.txt");
		
		// 객체 단위 필터로 파일 내용 읽어오기
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 객체 단위 데이터 읽기
		UserInfo user = (UserInfo)ois.readObject();
		
		System.out.println("파일 로드 완료...");
		System.out.println(user);
	}
	
	
	public static void main(String[] args) {
		
		try {
//			write();
			read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
```

## 3. FileOutputStream, ObjectOutputStream를 사용해서 Object 여러개를 ArrayList 단위로 입출력하기


### UserVO.java


```java
package kr.ac.kopo.day16;

import java.io.Serializable;

// VO : Value Object
// DTO : Data T Object
public class UserVO implements Serializable{
	private String name;
	private int age;
	private String phone;
	private String addr;
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String name, int age, String phone, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "UserVO [name=" + name + ", age=" + age + ", phone=" + phone + ", addr=" + addr + "]";
	}
}
```


### FileIOMain12.java

```java
package kr.ac.kopo.day16;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.FileClose;

/**
 * FileOutputStream, ObjectOutputStream를 사용해서 Object 여러개를 ArrayList 단위로 입출력하기
 * @author HP
 *
 */
public class FileIOMain12 {
	
	
	public static void write() {
		
		UserVO user = new UserVO("홍길동", 26, "010-1111-2222", "서울시 서초구");
		UserVO user2 = new UserVO("김길동", 30, "010-3333-4444", "경기도 광명시 철산동");
		UserVO user3 = new UserVO("구길동", 58, "010-5555-6666", "경기도 고양시 덕양구");
		
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(user);
		list.add(user2);
		list.add(user3);
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iodata/userList.txt");
			oos = new ObjectOutputStream(fos);
			
			/*
			 * for(int i = 0; i < list.size(); i++) { oos.writeObject(list.get(i)); }
			 */
			
			for(UserVO vo: list) {
				oos.writeObject(vo);
			}
			oos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(oos);
			FileClose.close(fos);
		}
		System.out.println("저장 완료");
		
	}
	
	
	public static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<UserVO> list = new ArrayList<UserVO>(); // ArrayList도 Serializable 인터페이스를 상속받기 때문에 직렬화시킬 수 있다. 
		
		try {
			fis = new FileInputStream("iodata/userList.txt");
			ois = new ObjectInputStream(fis);
			
			
			/*
			 * 
			  while(ois != null) {
				UserVO user = (UserVO)ois.readObject();
				System.out.println(user);
			  }
			  
			  java.io.EOFException ==> 파일의 끝이 애매하게 정의되어 있기 때문에 발생 => 예외 처리를 해줘야 함
			  
			*/
			
			while(true) {
				
				try {
					UserVO user = (UserVO)ois.readObject();
					list.add(user);
				} catch (EOFException e) {
					break;
				}
			}
			
			System.out.println("파일 로드 완료....");
			
			for(UserVO vo : list) {
				System.out.println(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(ois);
			FileClose.close(fis);
		}
		
	}
	
	
	public static void main(String[] args) {
//		write();
		read();
	}
}
```


## 이클립스 꿀팁 

- main메소드의 매개변수 args를 설정하는 방법

![image](https://user-images.githubusercontent.com/77392444/119283061-cf98ea00-bc76-11eb-8ece-948da3bb753f.png)

![image](https://user-images.githubusercontent.com/77392444/119283100-efc8a900-bc76-11eb-9137-0933ad720cd7.png)

- 객체 클래스 단축키
  - alt + shift + s 누른 후 c 선택 : 기본 생성자
  - alt + shift + s 누른 후 o 선택 : 매개변수를 가지는 생성자
  - alt + shift + s 누른 후 r 선택 : getter/ setter 생성
  - alt + shift + s 누른 후 v 선택 : override 메소드
  - alt + shift + s 누른 후 s 선택 : toString() 메소드를 오버라이드
