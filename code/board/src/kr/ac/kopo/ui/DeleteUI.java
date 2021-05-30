package kr.ac.kopo.ui;

public class DeleteUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		int no = scanInt("삭제할 게시물 번호를 입력하세요 :" );
		
		System.out.println("[" + no + "] 번 게시물이 삭제되었습니다.");
	}
	
}
