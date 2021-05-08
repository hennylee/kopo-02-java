package inter;

import java.util.List;

import vo.BookVO;
import vo.ReservationVO;
import vo.UserVO;

public interface MemberBookManagement {
	/**
	 * 도서 대출
	 */
	public void ReserveBook(); 
	
	/**
	 * 개인 대출 도서 조회
	 * @return 
	 */
	public List<ReservationVO> MyReserveList();
	
	/**
	 * 도서 반납
	 */
	public void ReturnBook();
	
	
	
}
