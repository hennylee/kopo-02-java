package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import inter.MemberBookManagement;
import inter.MemberConnManagement;
import inter.MemberUserManagement;
import util.*;
import vo.BookVO;
import vo.PendingVO;
import vo.ReservationVO;
import vo.UserVO;

public class MemberManager extends UserManager
		implements MemberConnManagement, MemberUserManagement, MemberBookManagement {

	// ============================== 로그인 로그아웃==============================================================
	// -----------------------------------------------------------------------------------
	// 로그인
	@Override
	public boolean MemberLogIn() {
		LogIn(memberList);
		return loginStatus;
	}

	// -----------------------------------------------------------------------------------
	// 일반회원 로그아웃
	@Override
	public boolean MemberLogOut() {
		LogOut(memberList);
		return loginStatus;
	}

	// ============================== 회원 관리==============================================================
	// -----------------------------------------------------------------------------------
	// 회원가입
	@Override
	public void MemberJoin() {

		// 회원 정보 입력 받기
		UserVO member = Join(memberList, mFile, "[ 회원 가입을 진행합니다. ]");

	}

	// -----------------------------------------------------------------------------------
	// 회원 탈퇴
	@Override
	public boolean MemberOut() {

		// 현재 로그인 중인 회원 삭제
//		UserDel(logedUserCode);
		UserOut();
		return loginStatus;

	}

	// -----------------------------------------------------------------------------------
	// 회원정보 수정
	@Override
	public void MemberEdit() {

		UserEdit(logedUserCode, memberList, mFile);
	}

	// ======================================일반회원========================================

	
	public boolean CheckExistBook(String Bookinfo) {
		
		boolean bCheck=false;
		for (BookVO vo : bookList) {
			
			if (vo.getBookName().equals(Bookinfo)) {
				bCheck=true;
			}
		}
		return bCheck;
	}
	
	// ----------------------------------------------------------------------------
	// 대출
	@Override
	public void ReserveBook() {
		
		
		// 리스트 출력
		bm.printBookList();
		
		// 대여하기
		BookManager bm = new BookManager();
		bm.ReserveBook();
		
		
		
		
		
	}

	// ----------------------------------------------------------------------------
	// 개인 대출 도서 조회
	@Override
	public List<ReservationVO> MyReserveList() {
		List<ReservationVO> list = new ArrayList<>();

		// 대출 중인 도서 목록 출력
		list = bm.printMemberRsvList();

		return list;

	}

	// ----------------------------------------------------------------------------
	// 도서 반납
	@Override
	public void ReturnBook() {
		List<BookVO> newBookList = new ArrayList<BookVO>(); // 도서 정보를 대출 가능으로 변경할 리스트

		System.out.println("==============================================");

		System.out.println("[ 현재 대출 중인 도서 목록 입니다 ]");

		// 나의 대출 리스트 출력
		MyReserveList();

		// 반납할 책 입력받기
		int bookBarcode = InputUtil.InputInt("반납할 책의 바코드를 입력하세요 : ");

		// reserveList에서 삭제
		Iterator iter = reserveList.iterator();
		ReservationVO rvo = new ReservationVO();

		for (ReservationVO vo : reserveList) {
			if (vo.getBookBarcode() == bookBarcode) {
				reserveList.remove(vo);
				System.out.println("[ 반납되었습니다. ]");

				// 반납 연체 처리
				// 연체 여부 확인해서 => 연체하면 => 연체 리스트에 넣기
				String returnDate = DateUtil.getToday();

				PendingVO pvo = new PendingVO();

				if (DateUtil.diffDatesFromToday(vo.getReserveDate()) > 7) {

					pvo.setUsercode(logedUserCode);
					pvo.setReturnDate(DateUtil.getToday());
//					pvo.setNextDate(DateUtil.diffDatesFromToday(vo.getReserveDate()) - 7);

					pendingList.add(pvo);
				}

				PListToFile();

				break;
			}
		}

		// reserveList 업데이트 => 대출 목록에서 삭제
		RListToFile();

		// 반납한 책 bookList에서 찾기 => isReservationStatus 변경하기
		for (BookVO vo : bookList) {
			if (vo.getBookBarcode() == bookBarcode) {
				vo.setReserved(false);
			}
			newBookList.add(vo);
		}

		// newBookList 파일에 넣기
		bookList = newBookList;
		BListToFile();

	}

}
