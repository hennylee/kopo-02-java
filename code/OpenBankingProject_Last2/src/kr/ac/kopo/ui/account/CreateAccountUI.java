package kr.ac.kopo.ui.account;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.AccountVO;

public class CreateAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		// 한달 내에 계좌 생성한 적 있는지 확인
		if(accountService.getHistory() != 0) {
			errorLine("한달 내 이미 개설한 계좌가 있어 계좌 개설이 불가합니다.");
			return;
		}
		
		startLine("계좌 개설을 시작합니다.");
		
		// 개설할 은행 선택
		String bankName = scanString("개설할 은행을 입력하세요 (하나 / 국민 / 신한 / 우리 / 기업) : ");	
		
		// 사용할 상품 선택
		int type = scanInt("개설한 계좌 상품을 선택하세요 : 1. 자유입출금 / 2. 정기예금 / 3. 급여", "[1-3]");
		
		// 계좌 비밀번호 입력
		int accountPW = scanInt("계좌 비밀번호를 입력하세요 (숫자 4자리) : ", "^[1-9]{1}[0-9]{3}$");
		
		// * 잔액 1000원 이상 채우기
		errorLine("계좌 개설을 위해 1000원 이상의 잔액이 필요합니다.");
		
		// * 1000원 입금 처리 확인
		int balance = scanInt("통장 최초 잔액 금액을 입력하세요 : ");//accountService.checkDeposit();
		
		if(balance >= 1000) {
			errorLine(balance + "원이 입금되었습니다.");
		}
		else {
			errorLine("잔액이 부족하여 계좌 개설이 취소됩니다.");
			return;
		}
		
		// 계좌 별칭 입력
		String alias = scanString("원하시는 계좌 별칭을 입력하세요 (한글 5글자 미만) : ", "^[가-힇]{1,5}$");
		
		// 통합 계좌 등록
		String oftenUsed = scanString("통합 계좌로 등록하시겠습니까? (Y / N)", "^[YN]{1}");
		
		// 계좌번호 자동 생성
		String accountNumber = accountService.getNewAcntNum(bankName, type);
		
		AccountVO vo = new AccountVO(accountNumber, accountPW, balance, alias, oftenUsed, type, bankName);
		
		accountService.createAccount(vo);
		
		endLine("계좌 개설이 완료되었습니다.");
		
	}
	
}
