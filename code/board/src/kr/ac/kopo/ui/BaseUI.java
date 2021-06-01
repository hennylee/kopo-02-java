package kr.ac.kopo.ui;
/**
 * 매번 Scanner 쓰는 것 귀찮으니까 만들어둔 클래스이다.
 * @author HP
 *
 */

import java.util.Scanner;

import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.service.BoardServiceFactory;
/*
	[abstract class]
	
	IBoardUI 인터페이스를 상속받으면 인터페이스 내의 메소드를 구현해야 하지만, 
	BaseUI 내에서는 해당 메소드를 구현할 필요가 없다. 
	그래서 추상클래스로 만들어줌으로써, 상속받은 인터페이스의 메소드를 구현하지 않아도 되게 만들어줘야 한다. 
 */


public abstract class BaseUI implements IBoardUI{
	
	private Scanner sc = new Scanner(System.in);
	protected BoardService service; // BaseUI를 상속받는 모든 UI클래스가 Service객체를 필요로 하게 때문에 멤버변수로 갖는다. 
	
	public BaseUI() {
		sc = new Scanner(System.in);
		
		/*
		 *  service가 계속 new키워드로 생성되면 list를 기억할 수 없기 때문에 한번만 생성해주는 메소드를 만들어서 실행한다. 
		 */
		service = BoardServiceFactory.getInstance(); 
	}
	
	
	protected String scanStr(String msg) { // 같은 패키지 아니어도 상속받은 클래스 내에서만 쓰고 싶다면? => protected
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected int scanInt(String msg) {
		int num = Integer.parseInt(scanStr(msg));// scanStr(String msg)으로 입력받은 것을 정수로 파싱
		return num;
	}
	
	
}
