package kr.ac.kopo.ui.account;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.util.SessionFactory;
import kr.ac.kopo.vo.AccountVO;

public class CreateAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		startLine("계좌 개설을 시작합니다.");
		
		AccountVO vo = new AccountVO();
		
		// 사용할 상품 선택
		int choice = scanInt("개설한 계좌 상품을 선택하세요 : 1. 자유입출금 / 2. 정기예금 / 3. 급여", "[1-3]");
		
		// 계좌 비밀번호 입력
		int accountPW = scanInt("계좌 비밀번호를 입력하세요 (숫자 4자리) : ", "^[1-9]{1}[0-9]{3}$");
		
		// * 잔액 1000원 이상 채우기
		System.out.println("[하나은행 : XXX-XXXXXX-XXXXX] 계좌로 1000원 이상 입금이 필요합니다.");
		scanString("입금 완료시 엔터 버튼을 누르시오.");
		
		// * 1000원 입금 처리 확인
		int input = 1000;//accountService.checkDeposit();
		
		if(input >= 1000) {
			System.out.println(input + "원이 입금되었습니다.");
		}
		else {
			System.out.println("입금이 완료되지 않았습니다.");
			return;
		}
		
		
		// 계좌 별칭 입력
		String alias = scanString("원하시는 계좌 별칭을 입력하세요 (한글 5글자) : ", "^[가-힇]{5}$");
		
		// 자주 쓰는 계좌 등록
		String oftenUsed = scanString("자주 쓰는 계좌로 등록하시겠습니까? (Y / N)", "^[YM]{1}");
		
		// 계좌번호 자동 생성
		String accountNumber = accountService.getNewAcntNum(choice);
		
		
		vo.setAccountNumber(accountNumber);
		vo.setMemberID(new SessionFactory().getSession().getId());
		vo.setAccountPW(accountPW);
		vo.setBalance(input);
		vo.setAlias(alias);
		vo.setOftenUsed(oftenUsed);
		
		accountService.createAccount(vo);
		
		endLine("계좌 개설이 완료되었습니다.");
		
	}
	
}
