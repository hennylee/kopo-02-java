package kr.ac.kopo.ui.account;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ui.AtmUI;
import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.ui.ExitUI;
import kr.ac.kopo.ui.IBankUI;
import kr.ac.kopo.ui.onlineUI;
import kr.ac.kopo.vo.AccountVO;

public class SearchAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		List<AccountVO> list = new ArrayList<>();
		
		list = accountService.searchMyAll();
		
		for(AccountVO vo : list) {
			vo.toString();
		}
		
		
		
		
		
		
		
		while(true) {
			
			int type = menu();
			IBankUI ui = null;
			
			switch(type) {
			case 1:
				ui = new onlineUI();
				break;
			case 2:
				ui = new AtmUI();
				break;
			case 0:
				ui = new ExitUI();
			}
			
			ui.execute();
			
		}
		
		
	}
	private int menu() {
		System.out.println("-------------------------------");
		System.out.println("\t하나은행 내 계좌관리 시스템");
		System.out.println("-------------------------------");
		System.out.println("\t1. 계좌 조회");
		System.out.println("\t2. 계좌 해지");
		System.out.println("\t3. 계좌 수정");
		System.out.println("\t4. 계좌 개설");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");
		
		return type;
	}
	
}
