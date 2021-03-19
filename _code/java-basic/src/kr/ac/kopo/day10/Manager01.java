package kr.ac.kopo.day10;

public class Manager01 {
	int no;
	String name;
	int salary;
	String grade;
	Employee[] empList; // 관리하고 있는 사원 목록 저장
	
	Manager01(int no, String name, int salary, String grade, Employee[] empList) {
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		this.empList = empList;
	}
	
	void info() {
		System.out.println("사원 번호 : " + no
						+ "\t사원 명 : " + name
						+ "\t연봉 금액 : " + salary
						+ "\t직급 명 : " + grade);
		
		System.out.println("===================================");
		System.out.println("\t관리사원 목록");
		System.out.println("===================================");
		
		for(Employee e: empList) {
			e.info();
		}
		
		System.out.println("===================================");
	}
}
