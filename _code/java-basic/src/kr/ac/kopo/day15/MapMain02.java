package kr.ac.kopo.day15;

import java.util.HashMap;
import java.util.Map;

/**
 * 자주 쓰는 경우 클래스로 만들어주는 것도 나쁘지 않다~!
 * @author HP
 *
 */
class MemberInfo {
	private Member member;
	private Car car;
	
	public MemberInfo(Member member, Car car) {
		this.member = member;
		this.car = car;
	}
	
}

/**
 * 다양한 참조형변수로 반환타입 설정하기
 * @author HP
 *
 */
class Test {
	
	// Object배열로 반환하기
	public Object[] retrunTest() {
		
		Member member = new Member();
		Car car = new Car();
		
		Object[] arr = new Object[2];
		arr[0] = member;
		arr[1] = car;
		
		return arr;
	}
	
	// Map으로 반환하기
	public Map<String, Object> retrunTest02() {
		
		Member member = new Member();
		Car car = new Car();
		
		Map<String, Object> map = new HashMap<>();
		map.put("member", member);
		map.put("car", car);
		
		return map;
	}
	
	// class로 반환하기
	public MemberInfo retrunTest03() {
		
		Member member = new Member();
		Car car = new Car();

		MemberInfo info = new MemberInfo(member, car);
		
		return info;
	}
}



class Member {
	private String name;
	private String phone;
	
	public Member() {
		super();
	}
	
	public Member(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	/**
	 * 이클립스에서 자동으로 생성해준 hashcode와 equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	
	/**
	 * equals 오버라이딩해서 내용 비교로 바꾼 메소드
	 */	/*
	@Override
	
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		Member member = (Member) obj;
		
		// 어떤 field가 같아야 하는지는 현실세계의 문제에 따라 달라진다.
		if(name.equals(member.name) && phone.equals(member.phone)) {
			result = true;
		};
		
		return result;
	}*/
}

class Car {
	private String name;
	private String id;
	
	public Car() {
		super();
	}
	
	public Car(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
}

public class MapMain02 {

	public static void main(String[] args) {
		
		Map<Member, Car> carList = new HashMap<>();
		
		carList.put(new Member("홍길동","010-2121-7777"), new Car("소나타","12가1231"));
		carList.put(new Member("오루동","010-1231-1243"), new Car("모닝","32가1231"));
		carList.put(new Member("홍상루","010-5738-1355"), new Car("그랜져","46가1231"));
		carList.put(new Member("이지동","010-5432-5777"), new Car("카니발","78가1231"));
		
		
		// 총 등록된 차량 대수
		System.out.println("등록 대수 : " + carList.size());
		
		// 사람 추가하기
		carList.put(new Member("홍길동","010-9334-3099"), new Car("SM3", "25다3434"));
		System.out.println("등록 대수 : " + carList.size());
		
		// 홍길동의 차 정보를 바꾸고 싶을 때 ==> 기존 정보를 덮어쓴다 (키가 같은 값이 들어오니까)
		carList.put(new Member("홍길동","010-2121-7777"), new Car("제네시스","82가1231")); // 근데 주소값이 다르니까~중복이라고 인식X
		System.out.println("등록 대수 : " + carList.size());
		
		
		
		/*
		 * Object클래스의 equals메소드는 주소값만 비교하는데,
		 * Map에는 주소값이 상관없에 내용이 같으면 같은 객체로 인식할 수 있는 방법이 있다.
		 * 그것이 바로 equals 메소드를 오버라이딩 해서 내용 비교를 하게 만들고 hash코드도 같게 만드는 방법이다.
		 * 
		 * 근데 해시코드까지 같게 만드는 것은 너무 귀찮다.
		 * 그래서 Source에서 hashcode와 equals를 클릭해 자동으로 만드는 방법이 사용하면 된다.
		 */
		
		Member m = new Member("홍길동","010-2121-7777");
		Member m2 = new Member("홍길동","010-2121-7777");
		
		System.out.println(m);
		System.out.println(m2);
		
		System.out.println(m.hashCode());
		System.out.println(m2.hashCode());
		
		System.out.println(m.equals(m2));
		
		
		
		
		
	}

}
