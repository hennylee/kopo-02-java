package kr.ac.kopo.vo;

import java.util.Date;

public class AccountVO {
	private String accountNumber;
	private String memberID;
	private String name;
	private int accountPW;
	private int balance;
	private String alias;
	private String oftenUsed;
	private int limitAmount;
	private Date openingDate;
	private int type;
	private String typeName;
	private String bankName;
	private int bankCode;
	
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
	
	public AccountVO(String accountNumber, int accountPW, int balance, String alias,
			String oftenUsed, int type, String bankName) {
		super();
		this.accountNumber = accountNumber;
		this.accountPW = accountPW;
		this.balance = balance;
		this.alias = alias;
		this.oftenUsed = oftenUsed;
		this.type = type;
		this.bankName = bankName;
	}

	// getter/setter
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getBankCode() {
		return bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
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
		return "계좌번호 : " + accountNumber + "\t계좌주명 : " + name + "\n잔액 : " + balance + "\t별칭 : "
				+ alias + "\t은행명 : " + bankName;
	}

	
	
	
	
}
