package kr.ac.kopo.ui.account;

import java.util.List;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.AccountVO;

public class SearchRegisterUI extends BaseUI{
	
	@Override
	public void execute() throws Exception {
		
		// 등록 가능한 통합계좌 목록
		List<AccountVO> list = accountService.notRegistered();
		
		if(list.isEmpty()) {
			startLine("검색을 시작합니다.");
			endLine("등록 가능한 계좌가 없습니다");
			return;
		}
		
		// 나의 전체 계좌 리스트
		startLine(session.getId()+"님의 등록 가능한 계좌 계좌 목록입니다.");
		
		for(AccountVO vo : list) {
			System.out.println(vo.toString());
			System.out.println();
		}
		
		endLine("총 "+ list.size() + "건 검색이 완료되었습니다.");
	}
}
