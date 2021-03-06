package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BoardDAODB;
import kr.ac.kopo.vo.BoardVO;

public class BoardService {
	
	/*
	서비스는 dao들을 조합하여 실행하여야 하기 때문에, 멤버변수로 dao의 각 객체들을 가지게 만든 것이다.
	 */
	//private BoardDAO dao;
	private BoardDAODB dao;
	
	public BoardService() {
		//dao = new BoardDAO();
		dao = new BoardDAODB();
	}
	
	public void 새글등록서비스(BoardVO newbBoard) throws Exception{
		
		/*
		// 등록할 게시물 번호 추출
		newbBoard.setNo(BoardSequence.getNo());
		
		// 등록 날짜 추출 (현재시간)
		String pattern = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		newbBoard.setRegDate(sdf.format(new Date()));
		*/
		
		dao.새글등록(newbBoard);
	}
	
	public List<BoardVO> 전체게시글조회서비스() throws Exception{
		List<BoardVO> list = dao.전체게시글조회();
		return list;
	}
}
