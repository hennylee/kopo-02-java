package kr.ac.kopo.day09;

public class StringMain04 {

	public static void main(String[] args) {
		String[] names = {"홍길동", "홍길순", "", "홍명보", "홍길동", "김길동", "김홍순"};
		
		System.out.println("========================== 이름이 홍길동인 사람 찾기 ===================================");
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals("홍길동"))
				System.out.println(names[i]);
		}
		
		System.out.println("=========================== 홍씨 성을 가진 사람 찾기 ===================================");
		
		for(int i = 0; i < names.length; i++) {
			if(names[i].startsWith("홍"))
				System.out.println(names[i]);
		}

		System.out.println("=========================== 이름이 길동인 사람 찾기 ===================================");
		
		for(int i = 0; i < names.length; i++) {
			if(names[i].endsWith("길동"))
				System.out.println(names[i]);
		}
		
		System.out.println("=========================== 이름에 홍이 포함된 사람 찾기 ===================================");
		
		for(String name : names) {
			if(name.contains("홍"))
					System.out.println(name);
		}
		
		
		

	}

}
