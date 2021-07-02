package kr.ac.kopo.vo;

import java.util.Date;

public class BankingVO {
	private int seq;
	private Date logDate;
	private int ownerCode;
	private String ownerBank;
	private String ownerAccount;
	private int targetCode;
	private String targetBank;
	private String targetAccount;
	private int amount;
	private int type;
	private String typeName;
	private int ownerBalance;
	private int targetBalance;
	
	
	public int getOwnerBalance() {
		return ownerBalance;
	}
	public void setOwnerBalance(int ownerBalance) {
		this.ownerBalance = ownerBalance;
	}
	public int getTargetBalance() {
		return targetBalance;
	}
	public void setTargetBalance(int targetBalance) {
		this.targetBalance = targetBalance;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public Date getLogDate() {
		return logDate;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public int getOwnerCode() {
		return ownerCode;
	}
	public String getOwnerBank() {
		return ownerBank;
	}
	public void setOwnerBank(String ownerBank) {
		this.ownerBank = ownerBank;
	}
	public String getTargetBank() {
		return targetBank;
	}
	public void setTargetBank(String targetBank) {
		this.targetBank = targetBank;
	}
	public void setOwnerCode(int ownerCode) {
		this.ownerCode = ownerCode;
	}
	public String getOwnerAccount() {
		return ownerAccount;
	}
	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount;
	}
	public int getTargetCode() {
		return targetCode;
	}
	public void setTargetCode(int targetCode) {
		this.targetCode = targetCode;
	}
	public String getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(String targetAccount) {
		this.targetAccount = targetAccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
