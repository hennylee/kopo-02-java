package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.DateUtil;
import util.InputUtil;
import util.JoinCheck;
import vo.BookVO;
import vo.ReservationVO;
import vo.UserVO;

public class UserManager extends FileManager {
	BookManager bm = new BookManager();

	// ====================================접속========================================
	// -----------------------------------------------------------------------------------
	// 로그인
	public boolean LogIn(List<UserVO> list) {
		System.out.println("[ 로그인을 진행합니다. ]");

		// console로 입력받기
		String id = InputUtil.InputString("id를 입력하세요 : ");
		String pw = InputUtil.InputString("pw를 입력하세요 : ");

		// 일치하는 회원 있는지 확인하기
		for (UserVO vo : list) {
			if (vo.getId().equals(id) && vo.getPw().equals(pw)) {
				loginStatus = true;
				logedUserCode = vo.getuserCode();
			}
		}

		// 로그인 결과 출력
		if (loginStatus == true) {
			System.out.println("[ " + getLogedUserName(list) + "님, 로그인 되었습니다. ]");

		} else {
			System.out.println("[ 로그인에 실패하였습니다. ]");
		}
		System.out.println("==============================================");

		return loginStatus;
	}

	// 로그아웃
	public boolean LogOut(List<UserVO> list) {
		loginStatus = false;
		logedUserCode = -1;

		System.out.println("[ " + getLogedUserName(list) + "님, 로그아웃 되었습니다. ]");
		System.out.println("==============================================");

		return loginStatus;
	}

	// 로그인 되어 있는 회원 이름 찾기
	public String getLogedUserName(List<UserVO> list) {
		while (logedUserCode != -1) {
			for (UserVO vo : list) {
				if (vo.getuserCode() == logedUserCode) {
					logedMemberId = vo.getId();
				}
			}
			break;
		}

		return logedMemberId;
	}

	// ====================================회원========================================
	// -----------------------------------------------------------------------------------
	// 회원 가입 및 등록
	public UserVO Join(List<UserVO> list, File file, String msg) {
		UserVO user = new UserVO();

		System.out.println(msg);

		// console로 입력받기
		int code = getMemberCode(list);
		String name = "";
		String id = "";
		String pw = "";

		while (true) {

			// 제약조건 맞춰서 입력 받기
			name = JoinCheck.NameCheck("이름을 입력하세요 : ");
			id = JoinCheck.IdCheck("id를 입력하세요 : ", list);
			pw = JoinCheck.PWCheck("pw를 입력하세요 : ");

			break;
		}

		// UserVO에 입력받은 데이터 넣기
		user.setuserCode(code);
		user.setuserName(name);
		user.setId(id);
		user.setPw(pw);
		user.setuserRegisterDate(DateUtil.getToday());

		// UserVO를 파일에 추가
		AddToFile(file, user.toString());

		// List 업데이트하기
		if (file.equals(mFile)) {
			MFileToList();
		} else if (file.equals(aFile)) {
			AFileToList();
		}

		// 회원가입 결과 출력하기
		System.out.println("[ 완료되었습니다. ]");

		return user;
	}

	// -----------------------------------------------------------------------------------
	// 마지막 회원번호 구하기
	public int getMemberCode(List<UserVO> list) {
		int lastMemberCode;

		if (list.isEmpty()) {
			lastMemberCode = 1;
		} else {
			lastMemberCode = list.get(list.size() - 1).getuserCode() + 1;
		}

		return lastMemberCode;

	}

	// 회원 탈퇴
	/**
	 * 접속한 회원이 탈퇴하는 메소드
	 * 
	 * @param memberCode
	 */
	public void UserOut() {
		if (bm.MemberRsvList(logedUserCode).size() > 0) {
			System.out.println("[ 대출 중인 도서가 있습니다. ]");
		} else {
			for (UserVO vo : memberList) {
				if (vo.getuserCode() == logedUserCode) {
					memberList.remove(vo);
					System.out.println("[ 탈퇴되었습니다. ]");
					loginStatus = false;
					break;
				}
			}

			MListToFile();

		}

	}

	// 관리자 삭제
	/**
	 * 관리자가 다른 관리자들을 삭제하는 메소드
	 * 
	 * @param memberCode
	 */
	public void AdminDel() {

		for (UserVO vo : memberList) {
			if (vo.getuserCode() == logedUserCode) {
				memberList.remove(vo);
				System.out.println("[ 탈퇴되었습니다. ]");
				loginStatus = false;
				break;
			}
		}

		MListToFile();

	}

	/**
	 * 회원을 삭제하는 메소드
	 * 
	 * @param memberCode
	 */
	public void MemberDel(int memberCode) {
		List<UserVO> newList = memberList;

		boolean bCheck = true;
		boolean doubleCheck = true;

		for (UserVO member : memberList) {

			// 예외처리
			if (member.getuserCode() == memberCode) {
				bCheck = false; // 해당 코드의 회원이 존재하면

				if (bm.MemberRsvList(memberCode).size() <= 0) {
					newList.remove(member);
					doubleCheck = false;
					break;
				}
			}
		}

		if (bCheck) {
			System.out.println("[ 존재하지 않는 회원입니다. ]");
			AdminManager am = new AdminManager();
			am.MemberOut();
		}

		if (doubleCheck) {
			System.out.println("[ 대출 중인 도서가 있습니다. ]");
			AdminManager am = new AdminManager();
			am.MemberOut();
		}

		memberList = newList;

		// 바뀐 정보를 파일에
		MListToFile();

		System.out.println("[ 회원 삭제 되었습니다. ]");

	}

	// 회원 리스트 출력
	public void printUserList(List<UserVO> list) {
		System.out.println("----------------------------------------------------------------");
		System.out.println("usrCode" + "\t" + "usrName" + "\t" + "id" + "\t" + "pw" + "\t" + "usrRegisterDate" + "\t");

		for (UserVO vo : list) {
			System.out.println(vo.toString());
		}
		System.out.println("----------------------------------------------------------------");
	}

	// 회원정보 수정
	public void UserEdit(int userCode, List<UserVO> list, File file) {

		for (UserVO vo : list) {

			if (vo.getuserCode() == userCode) {
				int condition = InputUtil.InputInt("[ 수정할 내역을 선택하세요 ( 1. id / 2. pw / 3. 이름 / 4.종료) ]");

				switch (condition) {
				case 1:
					String id = JoinCheck.IdCheck("수정할 id를 입력하세요 : ", list);
					vo.setId(id);
					break;
				case 2:
					String pw = JoinCheck.PWCheck("수정할 pw를 입력하세요 : ");
					vo.setPw(pw);
					break;
				case 3:
					String name = JoinCheck.NameCheck("수정할 이름을 입력하세요 : ");
					vo.setuserName(name);
					break;
				case 4:
					return;
				}

			}
		}

		// 바뀐 정보를 파일에 저장
		UListToFile(list, file);
		System.out.println("[ 수정이 완료되었습니다. ]");

	}

}
