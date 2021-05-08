package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import vo.BookVO;
import vo.PendingVO;
import vo.ReservationVO;
import vo.UserVO;

public class FileManager {
	public static final File bFile = new File("C:\\DBMS-Study\\LibraryProject\\src\\file\\bookList.txt");
	public static final File mFile = new File("C:\\DBMS-Study\\LibraryProject\\src\\file\\memberList.txt");
	public static final File aFile = new File("C:\\DBMS-Study\\LibraryProject\\src\\file\\adminList.txt");
	public static final File rFile = new File("C:\\DBMS-Study\\LibraryProject\\src\\file\\reserveList.txt");
	public static final File pFile = new File("C:\\DBMS-Study\\LibraryProject\\src\\file\\pendingList.txt");

	protected static List<PendingVO> pendingList;
	protected static List<BookVO> bookList;
	protected static List<BookVO> searchedBookList;
	protected static List<UserVO> memberList;
	protected static List<UserVO> adminList;
	protected static List<ReservationVO> reserveList;

	/**
	 * 로그인 중이면 true, 로그아웃 상태면 false
	 */
	public static boolean loginStatus = false; // 로그인 상태
	public static int logedUserCode = -1; // 로그인 되어 있는 회원 코드
	public static String logedMemberId = ""; // 로그인 되어 있는 회원 ID
	
	public FileManager() {
		
		MFileToList();

		
		AFileToList();

		
		BFileToList();

		
		RFileToList();
		
		
		PFileToList();
		
	}
	// ======================================= 책 ===================================================
	// -----------------------------------------------------------------------------------
	/**
	 * 파일을 list로
	 * 
	 * @return
	 */
	public List<BookVO> BFileToList() {
		bookList = new ArrayList<BookVO>();
		try {
			if (!bFile.exists()) {
				bFile.createNewFile();
			}

			FileReader fr = new FileReader(bFile);
			BufferedReader bfr = new BufferedReader(fr);

			String line = "";

			while ((line = bfr.readLine()) != null) {
				BookVO book = new BookVO();

				String[] bookInfo = line.split("\t");
				book.setBookBarcode(Integer.parseInt(bookInfo[0]));
				book.setBookName(bookInfo[1]);
				book.setBookAuthor(bookInfo[2]);
				book.setBookPublisher(bookInfo[3]);
				book.setBookCategory(bookInfo[4]);
				book.setReserved(Boolean.parseBoolean(bookInfo[5]));

				bookList.add(book);
			}
			bfr.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	// -----------------------------------------------------------------------------------
	/**
	 * list를 파일로
	 */
	public void BListToFile() {
		try {
			FileWriter fw = new FileWriter(bFile);
			for (BookVO book : bookList) {
				fw.write(book.toString());
				fw.write("\r");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// =======================================예약리스트===================================================

	// -----------------------------------------------------------------------------------
	/**
	 * R파일을 list로 초기화
	 * 
	 * @return
	 */
	public List<ReservationVO> RFileToList() {
		reserveList = new ArrayList<ReservationVO>(); 

		try {
			if (!rFile.exists()) {
				rFile.createNewFile();
			}

			FileReader fr = new FileReader(rFile);
			BufferedReader bfr = new BufferedReader(fr);

			String line = "";

			while ((line = bfr.readLine()) != null) {
				ReservationVO reservation = new ReservationVO();

				String[] reservationInfo = line.split("\t");

				reservation.setMemberCode(Integer.parseInt(reservationInfo[0]));
				reservation.setReserveDate(reservationInfo[1]);
				reservation.setIsOverdue(Boolean.parseBoolean(reservationInfo[2]));
				reservation.setBookBarcode(Integer.parseInt(reservationInfo[3]));

				reserveList.add(reservation);
			}

			bfr.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reserveList;
	}

	// -----------------------------------------------------------------------------------
	/**
	 * list를 파일로
	 */
	public void RListToFile() {
		try {
			FileWriter fw = new FileWriter(rFile);
			for (ReservationVO reservation : reserveList) {
				fw.write(reservation.toString());
				fw.write("\r");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// =======================================반납 리스트===================================================

	// -----------------------------------------------------------------------------------
	/**
	 * R파일을 list로 초기화
	 * 
	 * @return
	 */
	public List<PendingVO> PFileToList() {
		pendingList = new ArrayList<PendingVO>();
		try {
			if (!pFile.exists()) {
				pFile.createNewFile();
			}

			FileReader fr = new FileReader(pFile);
			BufferedReader bfr = new BufferedReader(fr);

			String line = "";

			while ((line = bfr.readLine()) != null) {
				PendingVO pvo = new PendingVO();

				String[] pInfo = line.split("\t");

				pvo.setUsercode(Integer.parseInt(pInfo[0]));
				pvo.setReturnDate(pInfo[1]);
				pvo.setNextDate(pInfo[2]);

				pendingList.add(pvo);
			}

			bfr.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pendingList;
	}

	// -----------------------------------------------------------------------------------
	/**
	 * list를 파일로
	 */
	public void PListToFile() {
		try {
			FileWriter fw = new FileWriter(pFile);
			for (PendingVO pvo : pendingList) {
				fw.write(pvo.toString());
				fw.write("\r");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}	
	
	
	
	// ====================================일반 멤버===================================================

	// -----------------------------------------------------------------------------------
	// M파일을 list로 초기화
	public List<UserVO> MFileToList() {
		memberList = new ArrayList<UserVO>(); 
		try {
			if (!mFile.exists()) {
				mFile.createNewFile();
			}

			FileReader fr = new FileReader(mFile);
			BufferedReader bfr = new BufferedReader(fr);

			String line = "";

			while ((line = bfr.readLine()) != null) {
				UserVO member = new UserVO();

				String[] memberInfo = line.split("\t");

				member.setuserCode(Integer.parseInt(memberInfo[0]));
				member.setuserName(memberInfo[1]);
				member.setId(memberInfo[2]);
				member.setPw(memberInfo[3]);
				member.setuserRegisterDate(memberInfo[4]);

				memberList.add(member);
			}

			bfr.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	// -----------------------------------------------------------------------------------
	// list를 파일로
	public void MListToFile() {
		UListToFile(memberList, mFile);

	}

	// ====================================관리자===================================================
	// -----------------------------------------------------------------------------------
	// A파일을 list로 초기화
	public List<UserVO> AFileToList() {
		adminList = new ArrayList<UserVO>();
		try {
			if (!aFile.exists()) {
				aFile.createNewFile();
			}

			FileReader fr = new FileReader(aFile);
			BufferedReader bfr = new BufferedReader(fr);

			String line = "";

			while ((line = bfr.readLine()) != null) {
				UserVO admin = new UserVO();

				String[] adminInfo = line.split("\t");

				admin.setuserCode(Integer.parseInt(adminInfo[0]));
				admin.setuserName(adminInfo[1]);
				admin.setId(adminInfo[2]);
				admin.setPw(adminInfo[3]);
				admin.setuserRegisterDate(adminInfo[4]);

				adminList.add(admin);
			}

			bfr.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return adminList;
	}

	// -----------------------------------------------------------------------------------
	// list를 파일로
	public void AListToFile() {
		UListToFile(adminList, aFile);
	}

	// ====================================회원 공통========================================
	// -----------------------------------------------------------------------------------
	// 회원list를 파일로
	public void UListToFile(List<UserVO> list, File file) {
		try {
			FileWriter fw = new FileWriter(file);
			for (UserVO vo : list) {
				fw.write(vo.toString());
				fw.write("\r");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// -----------------------------------------------------------------------------------
	// 파일에 추가하기
	public void AddToFile(File file, String str) {

		// 파일에 입력하기
		try {
			FileWriter fw = new FileWriter(file, true);

			if (file.isFile() && file.canWrite()) {
				fw.write(str);
				fw.write("\r");
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
