package kr.ac.kopo.day10;

public class EmployeeMain {

	public static void main(String[] args) {
		// 사원번호가 1, 연봉을 4000을 받는 홍길동 사원의 객체 생성
		Employee e = new Employee(1, "홍길동", 1_344_000, "사원");
		Employee e2 = new Employee(2, "박길동", 5_000_000, "사원");
		Employee e3 = new Employee(3, "강길동", 2_800, "사원");
		Employee e4 = new Employee(4, "한길동", 5_544_000, "사원");	
		
		e.info();
		
		Employee[] empList = {e, e2, e4};
//		Manager01 m = new Manager01(100, "나팀장", 5_555_555, "팀장", empList);
//		m.info();
		
//		Manager02 m2 = new Manager02(100, "나팀장", 5_555_555, "팀장", empList);
//		m2.info();
		
		Manager03 m3 = new Manager03(100, "나팀장", 5_555_555, "팀장", empList);
		m3.info();
	}

}
