package kr.ac.kopo.dao;
import java.util.ArrayList;
import java.util.List;

/**
 * 게시판들을 관리하는 것이 목적이다.
 * @author HP
 *
 */
import kr.ac.kopo.vo.BoardVO;

/**
 * 램에서 게시물 관리하는 DAO
 * @author HP
 *
 */
public class BoardDAO {
	private List<BoardVO> list;
	
	public BoardDAO() {
		list = new ArrayList<>();
	}
	
	/**
	 * 전체 게시글 조회
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> 전체게시글조회() throws Exception {
		System.out.println();
		return list;
	}
	
	/**
	 * 글번호로 게시글 조회
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public BoardVO 글번호조회(int no) throws Exception {
		for(BoardVO board : list) {
			if(board.getNo() == no) {
				return board;
			}
		}
		// 게시물이 없는 경우 처리
		return null;
	}
	
	/**
	 * 새글 등록
	 * @param newBoard
	 */
	public void 새글등록(BoardVO newBoard) {
		list.add(newBoard);
		System.out.println("dao : " + newBoard);
	}
	
	/**
	 * 게시글 수정
	 * @param board : 제목과 글번호만 수정하면 되지만, 
	 * 만약 수정할 항목이 늘어날 경우에 대비해서 유연하게 코드를 짜기 위해 매개변수를 BoardVO로 잡은 것이다.
	 */
	public void 게시글수정(BoardVO board) { 
		for(BoardVO vo : list) {
			if(vo.getNo() == board.getNo()) {
				vo.setTitle(board.getTitle());
				return;
			}
		}
	}
	
	/**
	 * 게시물 삭제
	 * @param no
	 */
	public void 게시글삭제(int no) {
		for(BoardVO vo : list) {
			if(vo.getNo() == no) {
				list.remove(vo);
				return;
			}
		}
	}
}
