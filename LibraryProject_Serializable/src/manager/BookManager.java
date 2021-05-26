package manager;

import java.security.Identity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.DateUtil;
import util.InputUtil;
import vo.BookVO;
import vo.PendingVO;
import vo.ReservationVO;
import vo.UserVO;

public class BookManager extends FileManager {
	

	

	/**
	 * 개인이 대출 중인 도서 목록
	 * @param memberCode
	 * @return 개인이 대출 중인 도서 목록
	 */
	public List<ReservationVO> MemberRsvList(int memberCode) {
		List<ReservationVO> myReserveList = new ArrayList<>();

		// reserveList 업데이트 (연체 여부 확인 위해서)
		UpdateReserveList();

		// 회원 검색
		for (ReservationVO vo : reserveList) {
			if (vo.getMemberCode() == memberCode) {
				myReserveList.add(vo);
			}
		}

		return myReserveList;
	}


	public void printReserveList() {

		System.out.println("memberCode" + "\t" + "reserveDate" + "\t" + "overdueStatus" + "\t" + "bookBarcode" + "\t");
		for (ReservationVO vo : reserveList) {
			System.out.println(vo.toString());

		}
	}
	
	/**
	 * 검색한 책이 존재하는 지 확인하는 메소드
	 * @param Bookinfo
	 * @return
	 */
	public boolean CheckExistBook(String msg) {
		boolean bCheck = true;
		boolean existCheck=false;
		
		String input = InputUtil.StrNullCheckInput(msg);
		
		for (BookVO book : bookList) {
			
			// 책 이름 검색
			if ((book.getBookName().equals(input))) {
				searchedBookList.add(book);
				System.out.println(book.toString());
				bCheck = false;
				existCheck=true;
				break;
			}
			// 출판사 검색
			if ((book.getBookPublisher().equals(input))) {
				searchedBookList.add(book);
				System.out.println(book.toString());
				bCheck = false;
				existCheck=true;
				break;
			}
			// 저자 검색
			if ((book.getBookAuthor().equals(input))) {
				searchedBookList.add(book);
				System.out.println(book.toString());
				bCheck = false;
				existCheck=true;
				break;
			}
		}
		if(!existCheck) {
			System.out.println(input+"의 책이 존재하지 않습니다.");
		}
		
		return bCheck;
	}	
	
	
	
	
	
	
	
	/**
	 * 도서 검색
	 * @return
	 */
	public List<BookVO> searchBook() {
		searchedBookList = new ArrayList<>();
		boolean bCheck = true;
//		boolean existCheck=false;
		search: while (true) {
			int condition = InputUtil.InputInt("검색 조건을 선택하세요 " + "( 1. 책이름 / 2. 출판사 / 3. 저자  / 4. 취소) ");
			if (bookList.size() == 0) {
				System.out.println("존재하는 책이 없습니다.");
			} else {
				
				switch (condition) {
				case 1:
					
					while (bCheck) {
						
						bCheck = CheckExistBook("책이름을 입력하세요 : ");
						
					}

					break;
					
				case 2:
					while (bCheck) {
						bCheck = CheckExistBook("출판사를 입력하세요 : ");
					}

					break;
				case 3:
					while (bCheck) {
						bCheck = CheckExistBook("저자를 입력하세요 : ");
					}

					break;
				case 4:
					break search;
				default:
					continue;
				}
				break;
			}

		}

		return searchedBookList;
	}
	
	
	/**
	 * 책 전체 리스트를 출력
	 */
	public void printBookList() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("bookBarcode" + "\t" + "bookName" + "\t" + "bookAuthor" + "\t" + "bookPublisher" + "\t"
				+ "bookCategory" + "\t" + "reservationStatus" + "\t");

		for (BookVO vo : bookList) {
			System.out.println(vo.toString());
		}
		System.out.println("----------------------------------------------------------------");
		
		BFileToList();
	}
	
	/**
	 * 바코드로 책 존재하는 확인하는 메소드
	 * 
	 * @param Bookinfo
	 * @return 존재하면 true를 반환한다.
	 */
	public boolean CheckExistBook(int bookCode) {

		boolean bCheck = false;

		for (BookVO vo : bookList) {
			if (vo.getBookBarcode() == bookCode) {
				bCheck = true;
			}
		}
		return bCheck;
	}

	/**
	 * 현재 유저가 연체 중인지 확인하는 메소드
	 * 
	 * @param usrCode
	 * @return 연체 중이면 true를 반환한다.
	 */
	public boolean CheckOverDue(int usrCode) {

		boolean bCheck = false;

		for (ReservationVO vo : reserveList) {
			// 연체 중이면
			if (vo.getMemberCode() == logedUserCode && vo.getIsOverdue()) {
				bCheck = true;
			}
		}
		return bCheck;
	}

	/**
	 * 3권 이상 대여하고 있는지 확인하기 위해 대출하고 있는 책 권수 확인
	 * 
	 * @param usrCode
	 * @return 대출하고 있는 책 권수
	 */
	public int RsvCntBook(int usrCode) {

		int cnt = 0;

		for (ReservationVO vo : reserveList) {
			// 연체 중이면
			if (vo.getMemberCode() == logedUserCode) {
				++cnt;
			}
		}
		return cnt;
	}

	/**
	 * 현재 해당 책이 대출되고 있는지 확인
	 * 
	 * @param bookCode
	 * @return
	 */
	public boolean CheckRsvBook(int bookCode) {

		boolean bCheck = false;
		
		for (BookVO vo : bookList) {
			// 대출 중이면
			if (vo.getBookBarcode()==bookCode  && vo.isReserved()) {
				bCheck = true;
			}
		}
		return bCheck;
	}

	/**
	 * 
	 * 대여 못하는 기간 (다음 대출 가능일 - 오늘날짜 )
	 * @param usrCode
	 * @param bookCode
	 * @param returnDate
	 * @return
	 */
	public int PendingTermCnt(int usrCode, int bookCode) {

		String nxtDate = "";
		int term = 0;
		
		if(!pendingList.isEmpty()) {
			for (PendingVO vo : pendingList) {
				if (usrCode == vo.getUsercode()) {
					nxtDate = vo.getNextDate();
				}
			}
			term = DateUtil.diffDatesFromToday(nxtDate);
		}

		return term;
	}

	/**
	 * [반납할때] 연체로 인한 대출금지 기간이 끝난 후, 대출이 가능한 날짜를 구한다. ( 반납일 - 원래 반납일 ) + 반납일
	 * 
	 * @param returnDate
	 * @return
	 */
	public String nextRsvDate(int usrCode, int bookCode, String returnDate) {

		int term = 0;
		
		
		RFileToList();

		for (ReservationVO vo : reserveList) {
			if (vo.getBookBarcode() == bookCode && vo.getMemberCode() == usrCode) {
				term = DateUtil.diffDates(returnDate, vo.getReserveDate());
			}
		}
		
		return DateUtil.plusDate(returnDate, term);

	}

	/**
	 * 도서 대출 및 검증
	 */
	public void ReserveBook() {
		boolean bCheck = true;
		int input = 0;
		
		while(bCheck) {
			
			// 대출할 책의 바코드 입력
			input = InputUtil.InputInt("대출할 책의 바코드를 입력하세요 : ");
		
			// 입력한 바코드가 존재하니? => YES!
			if(!CheckExistBook(input)) {
				System.out.println("[ 해당 바코드가 존재하지 않습니다. ]");
				bCheck = false;
			}
			else {
		
				// 그 책 대출 가능하니?
				if(CheckRsvBook(input)) {
					System.out.println("[ 이미 대여 중인 책입니다. ]");
					bCheck = false;
				}
				
				// 대여한 책이 3권 이하니?
				if(RsvCntBook(logedUserCode) >= 3) {
					System.out.println("[ 3권 이상 대출이 불가합니다. ]");
					bCheck = false;
				}
				
				
				// 연체중이니?
				if(CheckOverDue(logedUserCode)) {
					System.out.println("[ 연체 중인 책을 먼저 반납해주세요. ]");
					bCheck = false;
				}
				
				
				// pending기간이 남았니?
				if (PendingTermCnt(logedUserCode, input) > 0) {
					System.out.println("[ 연체 가능일까지 " + PendingTermCnt(logedUserCode, input) + "일 남았습니다. ]");
					bCheck = false;
				}
				
				if(bCheck) {
					// 대출 실행
					ReservationVO rvo = new ReservationVO();
					
					rvo.setMemberCode(logedUserCode);
					rvo.setReserveDate(DateUtil.getToday());
					rvo.setIsOverdue(false);
					rvo.setBookBarcode(input);
					
					// 대출리스트 파일에 등록
					AddToFile(rFile, rvo.toString());
					RFileToList();
					
					// 대출 이후 책 대출 상태 업데이트
					List<BookVO> lastBookList = bookList;
					
					for(BookVO bvo: bookList) {
						if(bvo.getBookBarcode() == input) {
							bvo.setReserved(true);
						}
					}
					
					bookList = lastBookList;
					BListToFile();
					
					System.out
					.println("[ 대출이 완료되었습니다. 반납일은 " + DateUtil.plusWeek(rvo.getReserveDate()) + " 입니다. ]");
					return;
				}
			}
			
		}
	}
	
	
	
	/**
	 * 개인 도서 대출 목록
	 * @return
	 */
	public List<ReservationVO> printMemberRsvList() {
		List<ReservationVO> myReserveList = new ArrayList<>();

		// reserveList 업데이트 (연체 여부 확인 위해서)
		UpdateReserveList();
		
		BFileToList();
		
		// 대여 하자마자 목록 조회할 때, 대여 내역을 불러오기 위해서 파일 내역을 리스트로 불러온다. 
		//RFileToList();
		
		System.out.println("[ 현재 "+ logedMemberId +"님이 대출 중인 도서 목록 입니다 ]");

		System.out.println("memberCode" + "\t" + "reserveDate" + "\t" + "overdueStatus" + "\t" + "bookBarcode" + "\t");
		System.out.println("------------------------------------------------------------------------------------------");
		for (ReservationVO vo : reserveList) {
			if (vo.getMemberCode() == logedUserCode) {
				myReserveList.add(vo);
				System.out.println(vo.toString());
			}
		}
		
		if(myReserveList.size() == 0) {
			System.out.println("대여 중인 책이 없습니다.");
		}
		
		
		return myReserveList;
	}

	/**
	 * 불러온 대출 목록 리스트에서 (오늘날짜 - 빌린날짜) = 7일 이면 연체로 판단한다.
	 */
	public List<ReservationVO> UpdateReserveList() {
		List<ReservationVO> overdueList = new ArrayList<ReservationVO>();

		RFileToList();
		for (ReservationVO vo : reserveList) {
			if (DateUtil.diffDatesFromToday(vo.getReserveDate()) >= 7) {
				vo.setIsOverdue(true);
			}
			overdueList.add(vo);
		}
		reserveList = overdueList;
		RListToFile();
		return overdueList;
	}
	
	/**
	 * 반납
	 */
	public void ReturnBook() {
		List<BookVO> newBookList = new ArrayList<BookVO>(); // 도서 정보를 대출 가능으로 변경할 리스트
		List<ReservationVO> resevedList = new ArrayList<ReservationVO>();
		// 나의 대출 리스트 출력
		resevedList = printMemberRsvList();

		top:
		while(resevedList.size() != 0) {
			
			// 반납할 책 입력받기
			int bookBarcode = InputUtil.InputInt("반납할 책의 바코드를 입력하세요 : ");
			
			// reserveList에서 삭제
			for (ReservationVO vo : reserveList) {
				if (vo.getBookBarcode() == bookBarcode) {
					reserveList.remove(vo);
					
					// 반납 연체 처리
					// 연체 여부 확인해서 => 연체하면 => 연체 리스트에 넣기
					String returnDate = DateUtil.getToday();
					
					PendingVO pvo = new PendingVO();
					
					if (DateUtil.diffDatesFromToday(vo.getReserveDate()) > 7) {
						
						pvo.setUsercode(logedUserCode);
						pvo.setReturnDate(DateUtil.getToday());
						pvo.setNextDate(nextRsvDate(logedUserCode, bookBarcode, pvo.getReturnDate()));
						//(int usrCode, int bookCode, String returnDate)
						
						pendingList.add(pvo);
						PListToFile();
					}
					
					// 반납한 책 bookList에서 찾기 => isReservationStatus 변경하기
					for (BookVO vo2 : bookList) {
						if (vo2.getBookBarcode() == bookBarcode) {
							vo2.setReserved(false);
						}
						newBookList.add(vo2);
					}
					
					// book 파일 업데이트
					bookList = newBookList;
					BListToFile();
					
					// reserve 파일 업데이트 => 대출 목록에서 삭제
					RListToFile();
					System.out.println("[ 반납되었습니다. ]");
					
					break top;
				}
			}
			
			System.out.println("해당 도서코드가 없습니다.");
			
		}

	}
	
	/**
	 * 개인 도서 대출 목록
	 * @return
	 */
	public List<ReservationVO> MyReserveList() {
		List<ReservationVO> list = new ArrayList<>();

		// 대출 중인 도서 목록 출력
		list = printMemberRsvList();

		return list;

	}

}
