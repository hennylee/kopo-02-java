package kr.ac.kopo.ui.account;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.util.SessionFactory;
import kr.ac.kopo.vo.AccountVO;

public class DeleteAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		// 나의 계좌 전체 리스트
		List<AccountVO> list = new ArrayList<>();
		
		startLine(new SessionFactory().getSession().getId() + "님의 전체 계좌 목록입니다.");
		list = accountService.searchByID();

		if(list.isEmpty()) {
			endLine("존재하는 계좌가 없습니다");
			return;
		}
		
		System.out.printf("%-20s %-8s %-10s %-15s %-23s", "계좌번호", "별칭", "잔액", "자주쓰는 계좌", "이체 한도");
		System.out.println();
		for(AccountVO vo : list) {
			System.out.printf("%-20s %-8s %-20d %-15s %-15d", 
					vo.getAccountNumber() ,vo.getAlias() , vo.getBalance() , vo.getOftenUsed(), vo.getLimitAmount());
			System.out.println();
		}
		
		endLine("");
		
		// 해지할 계좌 선택		
		String targetAcnt = scanString("해지할 계좌의 계좌번호를 입력하세요 : ");
		
		// 해지할 계좌 비밀번호 입력
		String targetPW = scanString("계좌의 비밀번호를 입력하세요 : ", "^[1-9]{1}[0-9]{3}$");
		
		String result = accountService.deleteAcnt(targetAcnt, targetPW);
		
		if(result.equals("fail")) {
			errorLine("잔액이 존재하여, 계좌 해지가 불가합니다.");
		}
		else {
			errorLine("계좌 해지가 완료되었습니다.");
		}
		
		endLine("계좌 해지 서비스를 종료합니다.");
		
	}
	
}
