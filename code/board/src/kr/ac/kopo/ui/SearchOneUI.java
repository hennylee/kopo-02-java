package kr.ac.kopo.ui;

public class SearchOneUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		int no = scanInt("조회할 글번호를 입력하세요 : ");
		
		System.out.println("-----------------------------------------------------");
		System.out.println("\t 번      호 : ");
		System.out.println("\t 제      목 : ");
		System.out.println("\t 글  쓴  이 : ");
		System.out.println("\t 등  록  일 : ");
		System.out.println("-----------------------------------------------------");
	}

}
