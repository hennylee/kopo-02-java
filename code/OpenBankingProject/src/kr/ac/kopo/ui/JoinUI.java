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
			String idRegex = "^[a-zA-Z]{1}[a-zA-Z0-9]{4,11}$";
			id = scanString("id를 입력하세요 \n(영문, 숫자로만 이루어진 5 ~ 12자 이하) : ", idRegex);
			
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
		String rnRegex = "\\d{6}\\-[1-4]\\d{6}";
		String residentNumber = scanString("주민번호를 입력하세요('-' 입력 필수) : ", rnRegex);
		
		// 이름 입력
		String nameRegex = "^[ㄱ-ㅎ가-힣A-Za-z]*$";
		String name = scanString("이름을 입력하세요 : ", nameRegex);
		
		
		// 나이 입력
		String agetRegex = "^[0-9]*$";
		int age = scanInt("나이를 입력하세요 : ");
		
		// 성별 입력
		String sexRegex = "^[FM]*$";
		String sex = scanString("성별을 입력하세요( 여성 : F, 남성 : M) : ");
		
		
		MemberVO member = new MemberVO(id, pw, residentNumber, name, age, sex);
		
		memberService.join(member);
		
		endLine("회원 가입이 완료되었습니다.");
	}
}
