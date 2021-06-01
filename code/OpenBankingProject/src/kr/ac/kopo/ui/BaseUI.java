package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.service.MemberService;

public abstract class BaseUI implements IBankUI {
	private Scanner sc = new Scanner(System.in);
	
	protected MemberService memberService;
	
	public BaseUI() {
		memberService = new MemberService();
	}
	
	protected String scanString(String msg) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected int scanInt(String msg) {
		int num = Integer.parseInt(scanString(msg)) ;
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
