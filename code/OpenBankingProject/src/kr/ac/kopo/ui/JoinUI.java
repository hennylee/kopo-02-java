package kr.ac.kopo.ui;

import kr.ac.kopo.vo.MemberVO;

public class JoinUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		startLine("회원가입을 시작합니다.");
		
		// id 입력
		String id = "";
		
		boolean bCheck = true;
		
		while(bCheck) {
			id = scanString("id를 입력하세요 : ");
			
			if(memberService.idExist(id) == 1) {
				errorLine("중복 id가 존재합니다. 다른 id를 입력하세요");
			}
			else {
				bCheck = false;
			}
		}
		
		// 기타 정보 입력
		String pw = scanString("pw를 입력하세요 : ");
		String residentNumber = scanString("주민번호를 입력하세요 : ");
		String name = scanString("이름을 입력하세요 : ");
		int age = scanInt("나이를 입력하세요 : ");
		String sex = scanString("성별을 입력하세요 : ");
		
		
		MemberVO member = new MemberVO(id, pw, residentNumber, name, age, sex);
		
		memberService.join(member);
		
		endLine("회원 가입이 완료되었습니다.");
	}
}
