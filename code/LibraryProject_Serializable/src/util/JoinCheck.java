package util;

import java.util.List;

import manager.UserManager;
import vo.UserVO;

public class JoinCheck extends UserManager{
	// 이름 체크
	public static String NameCheck(String msg) {
		String name = "";
		do {
			name = InputUtil.InputString(msg);
			if(!SizeCompare(name)) {
				break;
			}
		}while(true);
		
		return name;
	}
	
	// id 입력 & 체크
	public static String IdCheck(String msg, List<UserVO> list) {
		String id="";
		do {
			id = InputUtil.InputString(msg);
			if(SizeCompare(id)) {
				System.out.println("공백없이 입력해주세요"); 
				continue;
			}
			else if(idDuplicateCheck(id, list)) {
				System.out.println("중복된 id가 있습니다."); 
				continue;
			}
			else {
				break;
			}
		}while(true); 

		return id;
	}

	// pw 입력 & 체크
	public static String PWCheck(String msg) {
		String pw="";
		do {
			pw = InputUtil.InputString(msg);
			if(!SizeCompare(pw)) {
				break;
			}
		}while(true);
		
		return pw;
	}
	
	// 공백 확인하기
	public static boolean SizeCompare(String str) {
		if(str.length()==0)  {
			// 입력을 안하면 true
			return true;
		}
		// 공백이 있으면 true, 없으면 false
		return str.length()>str.replaceAll(" ", "").length()?true:false;
	}
	
	// 아이디 중복조회하기
	/**
	 * 중복 id를 조회해서, 중복값이 있으면 true를 반환한다.
	 * @param id
	 * @return
	 */
	public static boolean idDuplicateCheck(String id, List<UserVO> list) {
		if (list != null) {
			for(UserVO vo : list) {
				if(vo.getId().equals(id)) {
					return true;
				}
			}
		}
		return false;
		
	}
	
}
