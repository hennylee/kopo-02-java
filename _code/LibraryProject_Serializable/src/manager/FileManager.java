package manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import util.FileClose;
import vo.BookVO;
import vo.PendingVO;
import vo.ReservationVO;
import vo.UserVO;

public class FileManager {
	public static final File bFile = new File("files/bookList.txt");
	public static final File mFile = new File("files/memberList.txt");
	public static final File aFile = new File("files/adminList.txt");
	public static final File rFile = new File("files/reserveList.txt");
	public static final File pFile = new File("files/pendingList.txt");

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
	
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	
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

			fis = new FileInputStream(bFile);
			ois = new ObjectInputStream(fis);
			
			bookList = (List<BookVO>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fis, ois);
		}
		return bookList;
	}

	// -----------------------------------------------------------------------------------
	/**
	 * list를 파일로
	 */
	public void BListToFile() {
		
		try {
			fos = new FileOutputStream(bFile);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(bookList);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
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

			fis = new FileInputStream(rFile);
			ois = new ObjectInputStream(fis);
			
			reserveList = (List<ReservationVO>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fis, ois);
		}
		return reserveList;
	}

	// -----------------------------------------------------------------------------------
	/**
	 * list를 파일로
	 */
	public void RListToFile() {
		try {
			fos = new FileOutputStream(rFile);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(reserveList);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
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

			fis = new FileInputStream(pFile);
			ois = new ObjectInputStream(fis);
			
			pendingList = (List<PendingVO>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fis, ois);
		}
		return pendingList;
	}

	// -----------------------------------------------------------------------------------
	/**
	 * list를 파일로
	 */
	public void PListToFile() {
		try {
			fos = new FileOutputStream(pFile);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(pendingList);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
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

			fis = new FileInputStream(mFile);
			ois = new ObjectInputStream(fis);
			
			memberList = (List<UserVO>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fis, ois);
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

			fis = new FileInputStream(aFile);
			ois = new ObjectInputStream(fis);
			
			adminList = (List<UserVO>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fis, ois);
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
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileClose.close(fos, oos);
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
