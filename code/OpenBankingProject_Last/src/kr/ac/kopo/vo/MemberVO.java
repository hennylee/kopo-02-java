package kr.ac.kopo.vo;

import java.io.Serializable;
import java.util.Date;

public class MemberVO  implements Serializable {
	private String id;
	private String pw;
	private String residentNumber;
	private String name;
	private int age;
	private String sex;
	private Date joinDate;
	
	// 기본 생성자
	public MemberVO() {
		super();
	}
	
	// 회원가입 생성자
	public MemberVO(String id, String pw, String residentNumber, String name, int age, String sex) {
		super();
		this.id = id;
		this.pw = pw;
		this.residentNumber = residentNumber;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	// 로그인 생성자
	public MemberVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public MemberVO(String id, String pw, String residentNumber, String name, int age, String sex, Date joinDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.residentNumber = residentNumber;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.joinDate = joinDate;
	}

	// getter/setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getResidentNumber() {
		return residentNumber;
	}
	public void setResidentNumber(String residentNumber) {
		this.residentNumber = residentNumber;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
	// toString
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", residentNumber=" + residentNumber + ", name=" + name + ", age="
				+ age + ", sex=" + sex + ", joinDate=" + joinDate + "]";
	}
	
	
	
}
