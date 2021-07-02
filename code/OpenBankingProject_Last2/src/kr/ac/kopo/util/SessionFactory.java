package kr.ac.kopo.util;

import kr.ac.kopo.vo.MemberVO;

public class SessionFactory {
	static MemberVO session;
	
	public SessionFactory() {
		
	}
	
	public static MemberVO getSession() {
		return session;
	}
	public static void setSession(MemberVO member) {
		session = member;
	}
	
	public String getId() {
		return session.getId();
	}
	
}
