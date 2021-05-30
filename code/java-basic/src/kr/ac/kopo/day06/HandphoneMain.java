package kr.ac.kopo.day06;

public class HandphoneMain {

	public static void main(String[] args) {
		// "홍길동", "010-2222-2222", "삼성"을 가지는 Handphone 인스턴스 객체 만들기
		Handphone hp = new Handphone();
		
		hp.name = "홍길동";
		hp.phone = "010-2222-2222";
		hp.company = "삼성";
		
		// "윤길동", "010-1111-1111", "애플"을 가지는 객체 hp2 생성
		Handphone hp2 = new Handphone();
		
		hp2.name = "윤길동";
		hp2.phone = "010-1111-1111";
		hp2.company = "애플";

		// Handphone 데이터형인 배열을 만들어보기=================================================================================
		Handphone[] hpArr = {hp, hp2};
		
		// index를 활용한 방법
		for(int i = 0; i < hpArr.length; i++) {
			System.out.println("소유주명 : " + hpArr[i].name);
			System.out.println("핸드폰번호 : " + hpArr[i].phone);
			System.out.println("핸드폰제조사 : " + hpArr[i].company);
		}
		
		// 1.5버전 foreach문 활용한 방법
		for(Handphone h : hpArr) {
			System.out.println("소유주명 : " + h.name);
			System.out.println("핸드폰번호 : " + h.phone);
			System.out.println("핸드폰제조사 : " + h.company);
		}
		
		
	}

}
