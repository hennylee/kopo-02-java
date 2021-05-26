package inter;

import java.util.List;

import vo.UserVO;

public interface MemberUserManagement {

	/**
	 *  회원가입
	 */
	public void MemberJoin(); 

	/**
	 *  회원탈퇴
	 * @return
	 */
	public boolean MemberOut();

	/**
	 * 회원정보 수정
	 */
	public void MemberEdit();
	
}
