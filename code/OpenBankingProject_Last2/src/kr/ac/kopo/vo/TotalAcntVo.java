package kr.ac.kopo.vo;

import java.util.Date;

public class TotalAcntVo {
	private int seq;
	private String residentNumber;
	private String accountNumber;
	private int bankCode;
	private String bankName;
	private Date openingDate;
	private String name;
	
	public TotalAcntVo() {
		// TODO Auto-generated constructor stub
	}
	


	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getResidentNumber() {
		return residentNumber;
	}
	public void setResidentNumber(String residentNumber) {
		this.residentNumber = residentNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBankCode() {
		return bankCode;
	}
	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "TotalAcntVo [seq=" + seq + ", residentNumber=" + residentNumber + ", accountNumber=" + accountNumber
				+ ", bankCode=" + bankCode + ", bankName=" + bankName + ", openingDate=" + openingDate + ", name="
				+ name + "]";
	}


	
	
}
