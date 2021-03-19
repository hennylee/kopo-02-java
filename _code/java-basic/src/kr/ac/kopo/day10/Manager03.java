package kr.ac.kopo.day10;

public class Manager03 extends Employee{
	
	// 기타 공통 요소는 상속받았기 때문에 작성하지 않아도 사용할 수 있음
	Employee[] empList; // 관리하고 있는 사원 목록 저장
	
	// 부모 클래스에서 매개변수 없는 기본 디폴트 생성자가 정의되어 있어야 한다. 
	
	Manager03(int no, String name, int salary, String grade, Employee[] empList) {
		
		/*
		this.no = no;
		this.name = name;
		this.salary = salary;
		this.grade = grade;
		*/
		super(no,name,salary,grade);	// 부모메소드에서 매개변수가 있는 생성자를 호출하는 것이다. 
		
		this.empList = empList;
	}
	
	@Override // 부모클래스를 재정의한 거라고 알려줌 + 에러체크도 해줌
	void info() {
		
		// Employee클래스의 info()메서도와 공통되는 부분은 super.메소드명 으로 호출 가능함
		super.info();
		
		System.out.println("===================================");
		System.out.println("\t관리사원 목록");
		System.out.println("===================================");
		
		for(Employee e: empList) {
			e.info();
		}
		
		System.out.println("===================================");
	}
}
