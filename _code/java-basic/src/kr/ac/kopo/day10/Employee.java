package kr.ac.kopo.day10;

public class Employee {
	int no;
	String name;
	int salary;
	String grade;
	Employee() {
	}
	
	Employee(int no, String name, int salary, String grade) {
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
	}
	
	void info() {
		System.out.println("사원 번호 : " + no
						+ "\t사원 명 : " + name
						+ "\t연봉 금액 : " + salary
						+ "\t직급 명 : " + grade);
	}
}
