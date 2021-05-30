package kr.ac.kopo.service;

public class BoardSequence {
	private static int no = 1;
	
	/*
	여러명이 동시에 글을 작성할 때, 번호 증가가 이루어지는 동안 다른 사람의 글번호가 증가하지 않도록 하기 위해 동기화 블록을 설정해준다.
	 */
	public static synchronized int getNo() {
		return BoardSequence.no++;
	}
}
