package kr.ac.kopo.day08;

public class MemberMain {

	public static void main(String[] args) {
		Member m = new Member();
		Member m2 = new Member("홍길동");
		Member m3 = new Member("김길동", 22);
		Member m4 = new Member("이길동", 32, "B");
		
		m.info(); // 생성자 : Member() {}
		m2.info(); // 생성자 : Member(String name) {}
		m3.info(); // 생성자 : Member(String name, int age) {}
		m4.info(); // 생성자 : Member(String name, int age, String bloodType) {}

	}

}
