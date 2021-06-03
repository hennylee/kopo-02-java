package kr.ac.kopo.ui.openbank;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.util.SessionFactory;
import kr.ac.kopo.vo.TotalAcntVo;

public class RegisterOpenUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		// OPEN_HISTORY에 등록된 계좌 목록 리스트 출력

		List<TotalAcntVo> list = new ArrayList<>();
		
		// 나의 전체 계좌 리스트
		startLine(new SessionFactory().getSession().getId() + "님의 전체 계좌 목록입니다.");
		list = openService.getTotal();
		
		if(list.isEmpty()) {
			endLine("등록 가능한 계좌가 없습니다");
			return;
		}
		
		// RESIDENT_NUMBER,ACCOUNT_NUMBER,BANK_CODE,NAME
		System.out.printf("%-20s %-8s %-10s", "계좌번호", "은행", "계좌주");
		System.out.println();
		
		for(TotalAcntVo vo : list) {
			System.out.printf("%-20s %-8s %-10s", 
					vo.getAccountNumber() ,vo.getBankName() , vo.getName());
			System.out.println();
		}
		
		endLine("");
		
		// 등록할 은행, 계좌 선택
		String bankName = scanString("등록할 은행ㅁㅕㅇㅇㅡㄹ 입력하세요 : ");		
		String acntNum = scanString("등록할 계좌ㅂㅓㄴㅎㅗ를 입력하세요 : ");		
		
		// 등록
		String result = openService.registerAcnt(bankName, acntNum);
		
		if(result.equals("fail")) {
			errorLine("ㅇㅣㅁㅣ ㄷㅡㅇㄹㅗㄱㄷㅗㅣㄴ ㄱㅖㅈㅗㅏㅇㅣㅂㄴㅣㄷㅏ.");
			return;
		}
		
		endLine("통합계좌 등록이 완료되었습니다.");
		
	}
	
}
