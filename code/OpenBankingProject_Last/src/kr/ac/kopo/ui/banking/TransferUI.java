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
		
		String msg = bankingService.transfer(vo);
		
		endLine(msg);
		
	}

}