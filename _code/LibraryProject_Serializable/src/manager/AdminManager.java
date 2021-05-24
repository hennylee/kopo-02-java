package manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import inter.AdminBookManagement;
import inter.AdminConnManagement;
import inter.AdminUserManagement;
import util.DateUtil;
import util.InputUtil;
import util.JoinCheck;
import vo.BookVO;
import vo.ReservationVO;
import vo.UserVO;

public class AdminManager extends UserManager
		implements AdminConnManagement, AdminUserManagement, AdminBookManagement {

	// ==============================접속==============================================================
	// 로그인
	@Override
	public boolean AdminLogIn() {
		LogIn(adminList);
		return loginStatus;
	}

	// -----------------------------------------------------------------------------------------------------
	// 로그아웃
	@Override
	public boolean AdminLogOut() {
		LogOut(adminList);
		return loginStatus;
	}

	// ==============================관리자마이페이지==============================================================
	// 회원가입
	@Override
	public void MyAdminJoin() {
		// 회원 정보 입력 받기
		UserVO user = Join(adminList, aFile, "[ 관리자 가입을 진행합니다. ]");
	}

	// 회원탈퇴
	@Override
	public boolean MyAdminOut() {
		for (UserVO admin : adminList) {
			if (admin.getuserCode() == logedUserCode) {
				adminList.remove(admin);
				System.out.println("[ 회원탈퇴 되었습니다. ]");
				loginStatus = false;
				break;
			}
		}
		// 바뀐 정보를 파일에
		AListToFile();

		System.out.println("==============================================");

		return loginStatus;
	}

	// 회원수정
	@Override
	public void MyAdminEdit() {
		for (UserVO admin : adminList) {

			if (admin.getuserCode() == logedUserCode) {
				int condition = InputUtil.InputInt("[ 수정할 내역을 선택하세요 ( 1. id / 2. pw / 3. 이름 / 4.종료) ]");

				switch (condition) {
				case 1:
					String id = JoinCheck.IdCheck("수정할 id를 입력하세요 : ", adminList);
					admin.setId(id);
					break;
				case 2:
					String pw = JoinCheck.PWCheck("수정할 pw를 입력하세요 : ");
					admin.setPw(pw);
					break;
				case 3:
					String name = JoinCheck.NameCheck("수정할 이름을 입력하세요 : ");
					admin.setuserName(name);
					break;
				case 4:
					return;
				}

			}
		}
		// 바뀐 정보를 파일에 저장
		UListToFile(adminList, aFile);

		System.out.println("[ 회원 정보가 수정되었습니다. ]");

	}

	// ========================================도서=======================================
	// 도서등록
	@Override
	public BookVO registerBook() {
		
		BookVO book = new BookVO();
		System.out.println("==============================================");

		System.out.println("[ 새로운 도서 등록을 진행합니다. ]");

		// console로 입력받기
		int bookBarcode;
		String bookName;
		String bookAuthor;
		String bookPublisher;
		String bookCategory;
		boolean reservationStatus;

		while (true) {

			// 제약조건 맞춰서 입력 받기
			bookBarcode = getBookCode();
			bookName = InputUtil.StrNullCheckInput("책 제목을 입력하세요 : ");
			bookAuthor = InputUtil.StrNullCheckInput("책 저자를 입력하세요 : ");
			bookPublisher = InputUtil.StrNullCheckInput("책 출판사를 입력하세요 : ");
			bookCategory = InputUtil.StrNullCheckInput("책 카테고리를 입력하세요 : ");
			reservationStatus = false;

			break;
		}
		// book에 입력받은 데이터 넣기
		book.setBookBarcode(bookBarcode);
		book.setBookName(bookName);
		book.setBookAuthor(bookAuthor);
		book.setBookPublisher(bookPublisher);
		book.setBookCategory(bookCategory);
		book.setReserved(reservationStatus);

		// bookVO를 파일에 추가
		AddToFile(bFile, book.toString());
		
		// bookList 업데이트하기
		bookList = BFileToList();

		// 도서 등록 결과 출력하기
		System.out.println("[ 도서 등록이 완료되었습니다. ]");
		System.out.println("==============================================");

		return book;
	}

	// 마지막 회원번호 구하기
	/**
	 * 책의 마지막 회원번호 구하기
	 * @return (마지막 책번호 + 1)
	 */
	public int getBookCode() {
		int lastBookCode;

		if (bookList == null || bookList.size() == 0) {
			lastBookCode = 1;
		} else {
			lastBookCode = bookList.get(bookList.size() - 1).getBookBarcode() + 1;
		}

		return lastBookCode;

	}

	// -----------------------------------------------------------------------------------------------------
	// 도서 삭제
	@Override
	public void deleteBook() {
		boolean bCheck = true;
		int input = 0;
		
		// 책 목록 출력하기
		bm.printBookList();
		
		while(true) {
			
			// 삭제할 책의 바코드 입력
			input = InputUtil.InputInt("삭제할 책의 바코드를 입력하세요 : ");
		
			// 입력한 바코드가 존재하니? => YES!
			if(!bm.CheckExistBook(input)) {
				System.out.println("[ 해당 바코드가 존재하지 않습니다. ]");
			}
			else {
		
				// 그 책 대출 가능하니?
				if(bm.CheckRsvBook(input)) {
					System.out.println("[ 이미 대여 중인 책입니다. ]");
					bCheck = false;
				}
				
				if(bCheck) {
					// 삭제 실행
					for(BookVO bvo : bookList) {
						if(bvo.getBookBarcode() == input) {
							bookList.remove(bvo);
							BListToFile();
							System.out.println("[ 삭제가 완료되었습니다. ]");
							break;
						}
					}
					break;
					
				}
			}
		}
		
	}
		
		
		
		
		
		
		
//		while(bookList != null) {
//			
//			
//			// 바코드가 존재하면?
//			for (BookVO vo : bookList) {
//					
//				// 예약중이라면?
//				if (vo.getBookBarcode() == code && vo.isReserved()) {
//					System.out.println(vo.isReserved());
//					break;
//				}
//				else {
//					removedList.remove(vo.getBookBarcode());
//					bookList = removedList;
//					// 바뀐 정보를 파일에
//					BListToFile();
//					break top;
//				}
//			}
//				
//		}
		
		
	// 바코드가 삭제가능한지 검증
	/**
	 * 삭제 가능하면 true, 삭제 불가능하면 false
	 * 
	 * @param code
	 * @return
	 */
	public boolean rsvCheck(int code) {

		boolean bCheck = false;

		if (bookList != null) {
			for (BookVO vo : bookList) {
				// 중복되는 책이 있고, 현재 대출 가능하면 true
				if (vo.getBookBarcode() == code && !vo.isReserved()) {
					bCheck = true;
				}
			}
		}
		return bCheck;
	}

	// ----------------------------------------------------------------------------
	// 연체 조회
	@Override
	public List<ReservationVO> getOverdueList() {

		// 현재 날짜에 맞게 연체 상태 업데이트
		bm.UpdateReserveList();

		System.out.println("memberCode" + "\t" + "reserveDate" + "\t" + "overdueStatus" + "\t" + "bookBarcode" + "\t");

		for (ReservationVO vo : reserveList) {
			if (vo.getIsOverdue()) {
				System.out.println(vo.toString());
			}
		}
		return reserveList;
	}

	// ----------------------------------------------------------------------------
	// 대출 조회
	@Override
	public List<ReservationVO> getReserveList() {
		List<ReservationVO> reservedList = new ArrayList<>();

		// 전체 대출 목록 출력
		bm.printReserveList();

		return reservedList;
	}

	// ========================================회원관리=======================================

	@Override
	public void MemberJoin() {
		// 회원 정보 입력 받기
		UserVO member = Join(memberList, mFile, "[ 회원 추가를 진행합니다. ]");

	}

	@Override
	public void MemberOut() {

		// 회원 목록 출력
		printUserList(memberList);

		int input = 0;
		// 수정할 코드
		input = InputUtil.InputInt("삭제할 회원 코드를 입력하세요 : ");

		// 삭제 ( 대출 중인 도서 있는지, 존재하는 회원인지 검증해줌)
		MemberDel(input);

	}

	@Override
	public void MemberEdit() {

		// 회원 목록 출력
		printUserList(memberList);
		int input = 0;
		boolean bCheck = true;
		while (bCheck) {
			// 수정할 코드
			input = InputUtil.InputInt("수정할 회원 코드를 입력하세요 : ");

			// 코드가 회원에 있는지 검색
			for (UserVO vo : memberList) {
				if (vo.getuserCode() == input) {
					bCheck = false;
					break;
				}
			}
			if (bCheck) { // true인경우는 못찾은거
				System.out.println("[ 존재하지 않는 회원입니다. ]");
			}
		}

		// 수정
		UserEdit(input, memberList, mFile);
	}

	// ========================================관리자 관리 =======================================
	@Override
	public void AdminJoin() {
		Join(adminList, aFile, "[ 관리자 추가를 시작합니다. ]");

	}

	@Override
	public void AdminOut() {
		// 회원 목록 출력
		printUserList(adminList);
		int input = 0;

		// 수정할 코드
		input = InputUtil.InputInt("삭제할 관리자 코드를 입력하세요 : ");

		// 삭제
		for (UserVO admin : adminList) {
			if (admin.getuserCode() == input) {
				adminList.remove(admin);
				System.out.println("[ 삭제 되었습니다. ]");
				break;
			}
		}
		// 바뀐 정보를 파일에
		AListToFile();

		System.out.println("==============================================");

	}

	@Override
	public void AdminEdit() {

		// 회원 목록 출력
		printUserList(adminList);
		int input = 0;

			// 회원 목록 출력
			boolean bCheck = true;
			while (bCheck) {
				// 수정할 코드
				input = InputUtil.InputInt("수정할 회원 코드를 입력하세요 : ");

				// 코드가 회원에 있는지 검색
				for (UserVO vo : adminList) {
					if (vo.getuserCode() == input) {
						System.out.println("찾음");
						bCheck = false;
						break;
					}
				}
				if (bCheck) { // true인경우는 못찾은거
					System.out.println("[ 존재하지 않는 회원입니다. ]");
				}
			}
		
		// 수정
		UserEdit(input, adminList, aFile);
	}
}
