package kr.ac.kopo.ui.account;

import java.util.List;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.AccountVO;

public class RegisterUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		String msg = "";
		
		// 등록 가능한 통합계좌 목록
		List<AccountVO> list = accountService.notRegistered();
		new SearchRegisterUI().execute();
		
		if(list.isEmpty()) {
			return;
		}
		
		// 거래할 은행 입력하기
		String bankName = scanString("통합계좌로 등록할 은행명을 입력하세요 : ");
		String acntNum = scanString("통합계좌로 등록할 계좌번호를 입력하세요 : ");
		
		// 해당 계좌 잘 입력했는지 확인
		msg = accountService.register(bankName, acntNum);
		
		// 계좌를 잘못 입력한 경우
		if(!msg.isEmpty()) {
			endLine(msg);
			return;
		}
		
		endLine("통합계좌 등록이 완료되었습니다.");
	}
}
