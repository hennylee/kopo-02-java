package kr.ac.kopo.ui;
/**
 * 기능에 대한 집합인 기능클래스이다. 
 * 실행하기 위해 Execute 메소드가 필요하다.
 * @author HP
 *
 */
public class BoardUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		while(true) {
				try {
				
				/*
				모든 메뉴는 IBoardUI 인터페이스에 있는 execute() 메소드를 실행한다. 
				모든 메뉴는 IBoardUI인터페이스를 상속받고 있기 때문에 묵시적 형변환을 사용해서 execute()를 한번만 실행하도록 할 수 있다. 
				 */
				IBoardUI ui = null;
				
				int type = menu();
				
				switch (type) {
				case 1:
					ui = new SearchAllUI();
					break;
				case 2:
					ui = new SearchOneUI();
					break;
				case 3:
					ui = new AddUI();
					break;
				case 4:
					ui = new UpdateUI();
					break;
				case 5:
					ui = new DeleteUI();
					break;
				case 0:
					ui = new ExitUI();
					break;
				}
				if(ui != null) {
					/*
					ui는 묵시적 형변환으로 각 메뉴의 UI 클래스를 받는다. 
					 */
					ui.execute();
				}else {
					System.out.println("잘못 입력하였습니다.");
				}
			
			} catch (Exception e) {
				System.out.println("BoardUI Catch...");
				e.printStackTrace();
			}
		}
	}
	
	private int menu() {
		System.out.println("-------------------------------");
		System.out.println("\t게시판 관리 프로그램");
		System.out.println("-------------------------------");
		System.out.println("\t1. 전체 게시글 조회");
		System.out.println("\t2. 글번호 조회");
		System.out.println("\t3. 새글 등록");
		System.out.println("\t4. 게시글 수정");
		System.out.println("\t5. 게시글 삭제");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}

}
