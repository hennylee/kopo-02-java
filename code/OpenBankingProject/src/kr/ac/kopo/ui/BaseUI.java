package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.service.AccountService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.OpenService;

public abstract class BaseUI implements IBankUI {
	private Scanner sc = new Scanner(System.in);
	
	protected MemberService memberService;
	protected AccountService accountService;
	protected OpenService openService;
	
	public BaseUI() {
		memberService = new MemberService();
		accountService = new AccountService();
		openService = new OpenService();
	}
	
	protected String scanString(String msg) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected String scanString(String msg, String regex) {
		System.out.println(msg);
		String str = sc.nextLine();
		
		while (!str.matches(regex)) {
			errorLine("형식에 맞춰 다시 입력해주세요.");
			str = sc.nextLine();
		}
		
		return str;
	}
	
	protected int scanInt(String msg) {
		int num = Integer.parseInt(scanString(msg)) ;
		return num;
	}
	
	protected int scanInt(String msg, String regex) {
		int num = Integer.parseInt(scanString(msg, regex)) ;
		return num;
	}
	
	public void startLine(String msg) {
		System.out.println("====================================================");
		System.out.println("\t\t" + msg);
		System.out.println();
	}
	
	public void endLine(String msg) {
		System.out.println();
		System.out.println("\t\t" + msg);
		System.out.println("====================================================");
	}
	
	public static void errorLine(String msg) {
		System.out.println("----------------------------------------------------");
		System.out.println("\t *" + msg + "*");
		System.out.println("----------------------------------------------------");
	}
	
}
