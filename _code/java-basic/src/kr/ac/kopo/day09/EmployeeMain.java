package kr.ac.kopo.day09;

public class EmployeeMain {
	public static void main(String[] args) {
		
		// 총 몇 명의 사원이 입사했는지 알고 싶다 !
		Employee e = new Employee("홍길", 3200, "사원");
		e.info();
		
		Employee e2 = new Employee("길소원", 50000, "사장");
		e2.info();

		Employee e3 = new Employee("윤민정", 3800, "대리");
		e3.info();
		
		Employee.printTotalEmployee();
		System.out.println(Employee.totalEmployee);
	}
}
