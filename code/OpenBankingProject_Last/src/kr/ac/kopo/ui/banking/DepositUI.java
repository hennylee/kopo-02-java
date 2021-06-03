package kr.ac.kopo.ui.banking;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.BankingVO;

public class DepositUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		// 입금 정보 입력
		int amount = scanInt("입금할 금액을 입력하세요 : "); 
		
		BankingVO vo = new BankingVO();
		vo.setAmount(amount);
		vo.setOwnerAccount(myAcnt);
		vo.setOwnerBank(myBank);
		vo.setTargetAccount(myAcnt);
		vo.setTargetBank(myBank);
		
		String msg = bankingService.deposit(vo);
		
		endLine(msg);
		
	}

}
