package kr.ac.kopo.ui.openbank;

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
		startLine(new SessionFactory().getSession().getId() + "님의 전체 ㅌㅗㅇㅎㅏㅂ계좌 목록입니다.");
		list = accountService.searchByID();
		
		if(list.isEmpty()) {
			endLine("존재하는 계좌가 없습니다");
			return;
		}
		
		System.out.printf("%-20s %-8s %-10s %-15s %-23s", "계좌번호", "별칭", "잔액", "자주쓰는 계좌", "이체 한도");
		System.out.println();
		for(AccountVO vo : list) {
			System.out.printf("%-20s %-8s %-20d %-15s %-20d", 
					vo.getAccountNumber() ,vo.getAlias() , vo.getBalance() , vo.getOftenUsed(), vo.getLimitAmount());
			System.out.println();
		}
		
		endLine("");
		
		
	}
	
}
