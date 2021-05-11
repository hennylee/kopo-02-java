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
	
	// ----------------------------------------------------------------------------
	// 대출
	@Override
	public void ReserveBook() {
		
		// 리스트 출력
		System.out.println("[ 전체 도서 목록 ]");
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
	// 도서검색
	public List<ReservationVO> SearchBook() {
		List<ReservationVO> list = new ArrayList<>();

		bm.searchBook();

		return list;

	}
	

	// ----------------------------------------------------------------------------
	// 도서 반납
	@Override
	public void MemberReturnBook() {
		List<BookVO> newBookList = new ArrayList<BookVO>(); // 도서 정보를 대출 가능으로 변경할 리스트
		
		bm.ReturnBook();

	}

}
