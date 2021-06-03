package kr.ac.kopo.ui.banking;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.BankingVO;

public class WithdrawUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		// 출금 정보 입력
		int amount = scanInt("출금할 금액을 입력하세요 (* 0원 미만 불가) : ", "^[0-9]*$"); 
		
		while(amount < 0){
			errorLine("0원 이상 입력하세요");
			amount = scanInt("출금할 금액을 입력하세요 (* 0원 미만 불가) : ", "^[0-9]*$"); 
		}
		
		BankingVO vo = new BankingVO();
		vo.setAmount(amount);
		vo.setOwnerAccount(myAcnt);
		vo.setOwnerBank(myBank);
		vo.setTargetAccount(myAcnt);
		vo.setTargetBank(myBank);
		
		String msg = bankingService.withdraw(vo);
		
		endLine(msg);
	}

}