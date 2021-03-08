// 1. 선언부
// 1.1 패키지
package kr.ac.kopo.day01;

// 1.2 import문
import java.util.Random;

// 1.3 문서화 주석
/**
 * 로또와 관련된 기능을 제공하는 기능 클래스
 * @author 이해니
 *
 */

/* LottoUtil : 참조 클래스 */
public class LottoUtil {
	
// 2. 내용부
	
	// 2.1 변수
	private int lottoNum; 

	// 2.2 메소드 (문서화 주석으로 설명해줄 수 있음)
	/**
	 * 오늘의 로또 확률을 출력해주는 메소드
	 */
	void todayLottoNum() {
		
		Random r = new Random();
		// import가 없다면 => java.util.Random r = new java.util.Random();
		
		System.out.println("오늘의 로또 확률 : "+ r.nextInt(101) +"%입니다.");
	}
	
	/**
	 * 1 ~ 45 사이의 로또 번호를 알려주는 메소드
	 * @return 추출된 로또 번호
	 */
	public int getNum() {
		Random r = new Random();
		return r.nextInt(45) + 1 ;
	}

}

// 3. 선언부
