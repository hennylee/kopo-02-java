package kr.ac.kopo.ui.account;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.AccountVO;

public class SearchOneAcntUI extends BaseUI {

	@Override
	public void execute() throws Exception {
			
		
		String searchNum = scanString("검색할 계좌번호를 입력하세요 : ");
		AccountVO vo = new AccountVO();
		
		vo = accountService.searchByAcntNum(searchNum);
		startLine("계좌 검색을 시작합니다.");
		
		if(vo == null) {
			endLine("존재하는 계좌가 없습니다");
			return;
		}
		
		
		System.out.printf("%-20s %-8s %-10s %-15s %-23s", "계좌번호", "별칭", "잔액", "자주쓰는 계좌", "이체 한도");
		System.out.println();
		
		System.out.printf("%-20s %-8s %-20d %-15s %-20d", 
				vo.getAccountNumber() ,vo.getAlias() , vo.getBalance() , vo.getOftenUsed(), vo.getLimitAmount());
		System.out.println();
		
		endLine("검색이 완료되었습니다.");
	}
	
}
