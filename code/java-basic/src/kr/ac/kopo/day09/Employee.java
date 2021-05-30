package kr.ac.kopo.day09;

public class Employee {
	
	private String name; // 은닉화된 변수
	
	int salary;
	String grade;
	static int totalEmployee; // 총사원수
	
	Employee() {
		++Employee.totalEmployee;
	}
	
	Employee(String name, int salary, String grade){
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		
		++Employee.totalEmployee;
	}
	
	void info() {
		System.out.println("사원명 : " + this.name
						+ "연봉  : " + this.salary
						+ "직책 : " + this.salary);
		Employee.printTotalEmployee();
	}
	
	static void printTotalEmployee() {
		
		// static메소드에서는 this 혹은 nonStatic 변수를 사용할 수 없다~!
		System.out.println("총 사원수 : " + totalEmployee + "명");
	}
	
	// 은닉화된 변수 name에 접근하는 getter/setter 메소드
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
