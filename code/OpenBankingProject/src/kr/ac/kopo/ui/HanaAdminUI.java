package kr.ac.kopo.ui;

import kr.ac.kopo.util.SessionFactory;

public class HanaAdminUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		// 로그인 성공 시 메뉴
		while (true) {

			int type = menu();
			IBankUI ui = null;

			switch (type) {
			case 1:
				ui = new LoginUI();
				break;
			case 2:
				ui = new JoinUI();
				break;
			case 0:
				ui = new ExitUI();
				break;
			}

			ui.execute();

		}

	}

	private int menu() {
		System.out.println("-------------------------------");
		System.out.println("\t" + SessionFactory.getSession().getId() + " 님, 안녕하세요!");
		System.out.println("-------------------------------");
		System.out.println("\t1. 자주 쓰는 계좌");
		System.out.println("\t2. 회원가입");
		System.out.println("\t0. 종료");
		System.out.println("-------------------------------");
		int type = scanInt("메뉴 중 원하는 항목을 선택하세요 : ");

		return type;
	}

}
