package kr.ac.kopo.vo;

import java.util.Date;

public class AccountVO {
	private String accountNumber;
	private String memberID;
	private int accountPW;
	private int balance;
	private String alias;
	private String oftenUsed;
	private int limitAmount;
	private Date openingDate;
	private int type;
	
	// 기본 생성자
	public AccountVO() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountVO(String accountNumber, int accountPW, int balance, String alias,
			String oftenUsed, int type) {
		super();
		this.accountNumber = accountNumber;
		this.accountPW = accountPW;
		this.balance = balance;
		this.alias = alias;
		this.oftenUsed = oftenUsed;
		this.type = type;
	}

	// getter/setter
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getMemberID() {
		return memberID;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getAccountPW() {
		return accountPW;
	}
	public void setAccountPW(int accountPW) {
		this.accountPW = accountPW;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getOftenUsed() {
		return oftenUsed;
	}
	public void setOftenUsed(String oftenUsed) {
		this.oftenUsed = oftenUsed;
	}
	public int getLimitAmount() {
		return limitAmount;
	}
	public void setLimitAmount(int limitAmount) {
		this.limitAmount = limitAmount;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	@Override
	public String toString() {
		return "AccountVO [accountNumber=" + accountNumber + ", memberID=" + memberID + ", accountPW=" + accountPW
				+ ", balance=" + balance + ", alias=" + alias + ", oftenUsed=" + oftenUsed + ", limitAmount="
				+ limitAmount + ", openingDate=" + openingDate + ", type=" + type + "]";
	}
	
	
	
	
	
}
