package kr.ac.kopo.ui;

import kr.ac.kopo.util.SessionFactory;
import kr.ac.kopo.vo.MemberVO;

public class LoginUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		startLine("로그인을 시작합니다.");
		
		String id = "";
		String pw = "";
		
		// id 입력
		id = scanString("id를 입력하세요 : ");

		// pw 입력
		pw = scanString("pw를 입력하세요 : ");
			
		// 로그인 실패
		if(memberService.idExist(id) == 0) {
			errorLine("id가 일치하지 않습니다.");
			return;
		}
		if(memberService.pwExist(id, pw) == 0) {
				errorLine("pw가 일치하지 않습니다.");
				return;
		}
		
		// 로그인 성공
		MemberVO memeber = memberService.login(id, pw);
		
		if(memeber != null) {
			SessionFactory.setSession(memeber);
			endLine("로그인에 성공하였습니다.");
			new HanaMemberUI().execute();
		}
			
		
		
	}
}
