package kr.ac.kopo.ui.account;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.util.SessionFactory;
import kr.ac.kopo.vo.AccountVO;

public class UpdateAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		// 나의 전체 계좌 리스트
		List<AccountVO> list = new ArrayList<>();
		
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
		
		
		// 계좌 별칭 서비스 실행 여부 확인
		String choice = scanString("계좌의 별칭을 수정하시겠습니까? (Y / N)", "^[YN]*$");
		
		if(choice.equals("N") ) {
			endLine("계좌 수정 서비스를 취소합니다.");
			return;
		}
		
		// 수정할 계좌 선택		
		String targetAcnt = scanString("수정할 계좌의 계좌번호를 입력하세요 : ");
		
		// 수정할 은행 선택
		String bankName = scanString("수정할 계좌의 은행을 입력하세요 : "); 
		
		
		// 수정 이름 입력
		String newName = scanString("수정할 계좌 별칭을 입력하세요 (한글 5글자 미만) ", "^[가-힇]{1,5}$");
		
		// 계좌 비밀번호 확인
		int pw = scanInt("계좌 비밀번호를 입력하세요 (* 숫자만 입력 가능)", "^[0-9]*$");
		
		if(bankingService.checkPw(bankName, targetAcnt, pw) == 0) {
			errorLine("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		accountService.updateAlias(targetAcnt, newName, bankName);
		
		endLine("계좌 별칭 수정이 완료되었습니다.");
		
	}
	
}
