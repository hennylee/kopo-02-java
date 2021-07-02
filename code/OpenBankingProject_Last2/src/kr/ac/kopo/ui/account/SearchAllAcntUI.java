package kr.ac.kopo.ui.account;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.util.SessionFactory;
import kr.ac.kopo.vo.AccountVO;

public class SearchAllAcntUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<AccountVO> list = new ArrayList<>();
		
		// 나의 전체 계좌 리스트
		startLine(new SessionFactory().getSession().getId() + "님의 전체 계좌 목록입니다.");
		list = accountService.searchByID();
		
		if(list.isEmpty()) {
			endLine("존재하는 계좌가 없습니다");
			return;
		}
		
		for(AccountVO vo : list) {
			System.out.println(vo.toString());
			System.out.println();
		}
		
		endLine("총 "+ list.size() + "건 검색이 완료되었습니다.");
		
		
	}
	
}
