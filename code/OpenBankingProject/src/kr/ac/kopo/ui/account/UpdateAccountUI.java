package kr.ac.kopo.ui.account;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.util.SessionFactory;
import kr.ac.kopo.vo.AccountVO;

public class UpdateAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<AccountVO> list = new ArrayList<>();
		
		// 나의 전체 계좌 리스트
		startLine(new SessionFactory().getSession().getId() + "님의 전체 계좌 목록입니다.");
		list = accountService.searchByID();
		
		System.out.printf("%-20s %-8s %-10s %-15s %-23s", "계좌번호", "별칭", "잔액", "자주쓰는 계좌", "이체 한도");
		System.out.println();
		for(AccountVO vo : list) {
			System.out.printf("%-20s %-8s %-20d %-15s %-15d", 
					vo.getAccountNumber() ,vo.getAlias() , vo.getBalance() , vo.getOftenUsed(), vo.getLimitAmount());
			System.out.println();
		}
		
		endLine("");
		
		// 계좌 별칭 서비스 실행 여부 확인
		String choice = scanString("계좌의 별칭을 수정하시겠습니까? (Y / N)", "^[YN]*$");
		
		if(choice.equals("N") ) {
			endLine("계좌 수정 서비스를 취소합니다.");
			return;
		}
		
		// 수정할 계좌 선택		
		String targetAcnt = scanString("수정할 계좌의 계좌번호를 입력하세요 : ");
		
		// 수정 이름 입력
		String newName = scanString("수정할 계좌 별칭을 입력하세요 (한글 5글자 미만) ", "^[가-힇]{1,5}$");
		
		accountService.updateAlias(targetAcnt, newName);
		
		endLine("계좌 별칭 수정이 완료되었습니다.");
		
	}
	
}
