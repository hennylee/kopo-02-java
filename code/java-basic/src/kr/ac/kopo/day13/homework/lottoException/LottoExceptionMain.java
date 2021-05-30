package kr.ac.kopo.day13.homework.lottoException;

import java.util.Scanner;

public class LottoExceptionMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 로또 번호를 입력하세요");
		int num = sc.nextInt();
		
		try {
			if(num < 1 | num > 45) {
				throw new LottoNumberException("1 - 45 사이만 가능합니다." + num + "은 올바르지 않습니다.");
			} else {
				System.out.println(num + "을 포함해서 로또번호들을 추출하겠습니다");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
