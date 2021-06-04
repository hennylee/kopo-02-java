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
		
		// 해지할 계좌 선택		
		String targetAcnt = scanString("해지할 계좌의 계좌번호를 입력하세요 : ");

		// 해지할 은행 선택
		String bankName = scanString("해지할 계좌의 은행을 입력하세요 : "); 
		
		// 해지할 계좌 비밀번호 입력
		int pw = scanInt("계좌 비밀번호를 입력하세요 (* 숫자만 입력 가능)", "^[0-9]*$");
		
		if(bankingService.checkPw(bankName, targetAcnt, pw) == 0) {
			errorLine("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		String result = accountService.deleteAcnt(targetAcnt, bankName);
		
		if(result.equals("fail")) {
			errorLine("잔액이 존재하여, 계좌 해지가 불가합니다.");
		}
		else {
			errorLine("계좌 해지가 완료되었습니다.");
		}
		
		endLine("계좌 해지 서비스를 종료합니다.");
		
	}
	
}
