package inter;

import java.util.List;
import vo.BookVO;
import vo.ReservationVO;

public interface AdminBookManagement {
	/**
	 * 도서 등록
	 * @param book
	 * @return
	 */
	public BookVO registerBook();
	
	/**
	 * 도서 삭제
	 * @param book
	 * @return
	 */
	public void deleteBook();
	
	/**
	 * 연체 조회
	 * @return
	 */
	public List<ReservationVO> getOverdueList();
	
	/**
	 * 대출 조회
	 * @return
	 */
	public List<ReservationVO> getReserveList();
}
