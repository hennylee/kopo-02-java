package kr.ac.kopo.ui.banking;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.ui.ExitUI;
import kr.ac.kopo.ui.IBankUI;
import kr.ac.kopo.ui.account.SearchAllAcntUI;

public class BankingUI extends BaseUI {
	

	@Override
	public void execute() throws Exception {
		
		new SearchAllAcntUI().execute();
		
		String msg = "";
		
		// 거래할 은행 입력하기
		myBank = scanString("뱅킹 시스템을 이용할 은행을 입력하세요 : ");
		
		// 거래할 계좌 입력하기
		myAcnt = scanString("뱅킹 시스템을 이용할 계좌를 입력하세요 : ");
		
		// 해당 계좌 잘 입력했는지 확인
		int cnt = bankingService.searchOwner(myAcnt, myBank);
		
		// 계좌를 잘못 입력한 경우
		if(cnt == 0) {
			endLine("계좌를 잘못 입력하였습니다.");
		}
		else {
			while(true) {
				
				int type = menu();
				IBankUI ui = null;
				
				switch(type) {
				case 1:
					ui = new DepositUI();
					break;
				case 2:
					ui = new WithdrawUI();
					break;
				case 3:
					ui = new TransferUI();
					break;
				case 4:
					ui = new LogUI();
					break;
				case 0:
					ui = new ExitUI();
					break;
				}
				ui.execute();
			}
		}
		
		
		
		
		
	}
	private int menu() {
		System.out.println("-------------------------------");
		System.out.println("통합계좌 관리시스템(뱅킹 서비스)");
		System.out.println("-------------------------------");
		System.out.println("\t1. 입금");
		System.out.println("\t2. 출금");
		System.out.println("\t3. 계좌 이체");
		System.out.println("\t4. 거래 내역");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("ㅁ 메뉴 중 원하는 항목을 선택하세요 : ", "^[0-4]{1}$");
		
		return type;
	}
}