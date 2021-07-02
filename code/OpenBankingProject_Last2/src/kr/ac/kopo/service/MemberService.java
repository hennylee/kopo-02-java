package kr.ac.kopo.service;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class MemberService extends BaseService{
	
	MemberDAO dao = new MemberDAO();
	
	// id 체크
	public int idExist(String id) {
		return dao.idExist(id);
	}
	// pw 체크
	public int pwExist(String id, String pw) {
		return dao.pwExist(id, pw);
	}	
	
	// 주민번호 체크 residentCheck
	public int residentCheck(String residentNumber) {
		return dao.residentCheck(residentNumber);
	}
	
	// 회원가입
	public void join(MemberVO member) {
		dao.join(member);
	}
	
	// 로그인
	public MemberVO login(String id, String pw) {
		
		return dao.login(id, pw);
	}
	
}
