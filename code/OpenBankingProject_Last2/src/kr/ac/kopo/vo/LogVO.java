package kr.ac.kopo.vo;

import java.util.Date;

public class LogVO {
	private Date date;
	private int amount;
	private String bankName;
	private String logName;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	@Override
	public String toString() {
		return "로그 날짜 : " + date + "\t거래액 : " + amount + "\n은행명 : " + bankName + "\t거래유형 : " + logName;
	}
	
	
	
}
