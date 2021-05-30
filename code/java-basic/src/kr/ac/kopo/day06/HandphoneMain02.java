package kr.ac.kopo.day06;

public class HandphoneMain02 {
	public static void main(String[] args) {
		
		Handphone[] hpArr =  new Handphone[3];
		
		/* 	메모리에 어떻게 그려질까??
		 	Handphone형의 참조변수만 만들 뿐, Handphone형의 인스턴스는 만들어지지 않는다!
		*/
		
		for(int i = 0; i < hpArr.length; i++) {
			System.out.println(hpArr[i]); // null값이 출력됨
			/* hpArr[i] 는 null이므로, hpArr[i].name은 nullPointerException이 발생한다. */
			
			// 핸드폰 인스턴스 객체 만들기
			hpArr[i] = new Handphone();
			System.out.println(hpArr[i]); //  객체를 생성했기 때문에 주소값이 출력됨
		}
		
		System.out.println("======================================================================");
		
		// 다른 방법
		Handphone[] hpArr2 = new Handphone[] {new Handphone(), new Handphone(), new Handphone()};
				
		hpArr2[0].name = "홍길동";
		hpArr2[0].phone = "010-1111-1111";
		hpArr2[0].company = "삼성";
		
		hpArr2[1].name = "윤길";
		hpArr2[1].phone = "010-2222-1111";
		hpArr2[1].company = "애플";
		
		hpArr2[2].name = "삼실";
		hpArr2[2].phone = "010-2222-1111";
		hpArr2[2].company = "화웨이";
		
		for(Handphone hp : hpArr2) {
			System.out.println(hp);
			System.out.println("소유주명 : " + hp.name);
			System.out.println("번호 : " + hp.phone);
			System.out.println("회사 : " + hp.company);
		}
		
	}

}
