package inter;

public interface AdminUserManagement {
	
	/**
	 * 본인 회원 가입 
	 * @param str
	 */
	public void MyAdminJoin();  
	
	/**
	 *  본인 회원 탈퇴
	 * @return
	 */
	public boolean MyAdminOut();


	/**
	 * 본인 회원정보 수정
	 */
	public void MyAdminEdit();
		
	
	/**
	 * 회원 추가 
	 * @param str
	 */
	public void MemberJoin();  
	
	/**
	 *  회원 삭제
	 * @return
	 */
	public void MemberOut();


	/**
	 * 회원 수정
	 */
	public void MemberEdit();
			
	/**
	 * 관리자 추가 
	 * @param str
	 */
	public void AdminJoin();  
	
	/**
	 *  관리자 삭제
	 * @return
	 */
	public void AdminOut();


	/**
	 *  관리자 수정
	 */
	public void AdminEdit();	
	
	
	
}
