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
