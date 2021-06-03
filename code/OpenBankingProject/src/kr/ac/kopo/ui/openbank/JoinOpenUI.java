package kr.ac.kopo.ui.openbank;

import kr.ac.kopo.ui.BaseUI;

public class JoinOpenUI extends BaseUI{

	@Override
	public void execute() throws Exception {

		String choice = scanString("ㄱㅏㅇㅣㅂㅇㅡㄹ ㅈㅣㄴㅎㅐㅇ하시겠습니까? (Y / N)", "^[YN]*$");
		
		if(choice.equals("N") ) {
			endLine("계좌 수정 서비스를 취소합니다.");
			return;
		}
		
		startLine("통합계좌 시스템 가입을 시작합니다.");
		
		// 계좌 비밀번호 입력
		int pw = scanInt("통합계좌 시스템에 사용할 비밀번호를 입력하세요 (숫자 4자리) : ", "^[1-9]{1}[0-9]{3}$");
		
		openService.joinOpen(pw);
		
		endLine("통합계좌 시스템 가입이 완료되었습니다.");
		
	}

}
