package kr.ac.kopo.ui.banking;

import java.util.List;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.LogVO;

public class LogUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		List<LogVO> list = bankingService.getLog(myAcnt, myBank);
		
		if(list.isEmpty()) {
			startLine("검색을 시작합니다.");
			endLine("존재하는 거래 내역이 없습니다");
			return;
		}
		
		// 나의 전체 계좌 리스트
		startLine(myAcnt + "의 거래 내역입니다.");
		
		for(LogVO vo : list) {
			System.out.println(vo.toString());
			System.out.println();
		}
		
		endLine("총 "+ list.size() + "건이 거래내역이 존재합니다.");
		
		
	}

}