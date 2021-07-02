package kr.ac.kopo.ui.member;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.MemberVO;

public class JoinUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		startLine("회원가입을 시작합니다.");
		
		// id 입력
		String id = "";
		
		boolean bCheck = true;
		
		while(bCheck) {
			String idRegex = "^[a-z]{1}[a-z0-9]{4,11}$";
			id = scanString("id를 입력하세요 (* 영문소문자, 숫자만 가능 / 5 ~ 12자 이하) : ", idRegex);
			
			if(memberService.idExist(id) == 1) {
				errorLine("중복 id가 존재합니다. 다른 id를 입력하세요");
			}
			else {
				bCheck = false;
			}
		}
		
		// pw 입력
		String pwRegex = "^[A-Za-z[0-9]]{5,20}$";
		String pw = scanString("pw를 입력하세요 (영문(대소문자 구분), 숫자 조합, 5~20자리) : " , pwRegex );
		
		
		// 주민 번호 입력
		boolean rnCheck = true;
		String residentNumber = "";
		
		while(rnCheck) {
			String rnRegex = "\\d{6}\\-[1-4]\\d{6}";
			residentNumber = scanString("주민번호를 입력하세요('-' 입력 필수) : ", rnRegex);
			
			if(memberService.residentCheck(residentNumber) == 1) {
				errorLine("이미 가입된 주민번호입니다.");
			}
			else {
				rnCheck = false;
			}
		}
		
		String[] temp =  residentNumber.split("-");
		
		char[] front = temp[0].toCharArray();
		char[] back = temp[1].toCharArray();
		
		
		// 나이 계산
		int birthYear = -1;
		
		if(back[0] == '1' | back[0] == '2' ) {
			birthYear = 1900 + (front[0] - 48) * 10 + (front[1] - 48);
		}
		else {
			birthYear = 2000 + (front[0] - 48) * 10 + (front[1] - 48);
		}
		
		
		int age = 2021 - birthYear;
		
		
		// 성별 판정
		String sex = "";
		
		if(back[0] == '2' || back[0] == '4') {
			sex = "F";
		}
		else {
			sex = "M";
		}
		
		
		// 이름 입력
		String nameRegex = "^[ㄱ-ㅎ가-힣A-Za-z]*$";
		String name = scanString("이름을 입력하세요 : ", nameRegex);
		
		
		
		MemberVO member = new MemberVO(id, pw, residentNumber, name, age, sex);
		
		memberService.join(member);
		
		endLine("회원 가입이 완료되었습니다.");
	}
}
