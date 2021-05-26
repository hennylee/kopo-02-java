package kr.ac.kopo.service;

public class BoardServiceFactory {
	private static final BoardService service = new BoardService(); // 맨처음엔 null 값을 갖는다.
	
	public static BoardService getInstance() {
		/*
		if(service == null) {
			service = new BoardService();
		}
		*/
		return service;
	}
}
