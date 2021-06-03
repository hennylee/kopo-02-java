package kr.ac.kopo.service;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.dao.OpenDAO;
import kr.ac.kopo.vo.TotalAcntVo;

public class OpenService extends BaseService{
	OpenDAO dao = new OpenDAO();
	
	// 서비스 가입 내역 확인
	public int hasRegister() {
		String id = session.getId();
		return dao.hasRegister(id);
	}
	
	// 오픈뱅킹 가입
	public void joinOpen(int pw) {
		dao.joinOpen(session.getSession(), pw);
	}
	
	
	// OPEN_HISTORY에서 계좌 조회 getTotal
	public List<TotalAcntVo> getTotal() {
		List<TotalAcntVo> list = new ArrayList<TotalAcntVo>();
		list = dao.getTotal(session.getSession().getResidentNumber());
		return list;
	}
		
	// 오픈뱅킹 계좌 등록 registerAcnt()
	public String registerAcnt(String bankName, String acntNum) {
		
		String id = session.getSession().getId();
		String residentNum = session.getSession().getResidentNumber();
		
		// 이미 등록한 계좌인지 확인
		int cnt = dao.alreadyRegist(bankName, acntNum, id);
		
		if(cnt > 0) {
			// 이미 등록된 계좌
			return "fail";
		}
		else {
			// 계좌 등록(String bankName, String acntNum, String residentNum ,String id)
			dao.registerAcnt(bankName, acntNum, residentNum, id);
			return "sucess";
		}
		
	}
}
