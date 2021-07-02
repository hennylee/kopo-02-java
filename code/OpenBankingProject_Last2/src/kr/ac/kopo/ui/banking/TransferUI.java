package kr.ac.kopo.ui.banking;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.BankingVO;

public class TransferUI extends BaseUI{	

	@Override
	public void execute() throws Exception {
		
		// 이체 정보 입력
		int amount = scanInt("이체할 금액을 입력하세요 : ");
		String bankName = scanString("이체할 대상 은행을 입력하세요 : "); 
		String account = scanString("이체할 계좌번호를 입력하세요 : "); 
		
		BankingVO vo = new BankingVO();
		vo.setAmount(amount);
		vo.setTargetBank(bankName);
		vo.setTargetAccount(account);
		vo.setOwnerAccount(myAcnt);
		vo.setOwnerBank(myBank);
		
		// 계좌 비밀번호 확인
		int pw = scanInt("계좌 비밀번호를 입력하세요 (* 숫자만 입력 가능)", "^[0-9]*$");
		
		if(bankingService.checkPw(myBank, myAcnt, pw) == 0) {
			errorLine("비밀번호가 일치하지 않습니다.");
			return;
		}
		
		String msg = bankingService.transfer(vo);
		
		endLine(msg);
		
	}

}