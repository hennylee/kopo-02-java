package vo;

import java.io.Serializable;

public class ReservationVO implements Serializable  {
	
	// 대출 멤버 
	private int memberCode;
	
	// 대출 일자
	private String reserveDate;
	
	// 연체 여부
	private Boolean isOverdue;
	
	// 대출 책
	private int bookBarcode;
	
	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	/**
	 * 연체중 아니면 false, 연체중이면 true
	 */
	public Boolean getIsOverdue() {
		return isOverdue;
	}
	
	/**
	 * 연체중 아니면 false, 연체중이면 true
	 * @param overdueStatus
	 */
	public void setIsOverdue(Boolean isOverdue) {
		this.isOverdue = isOverdue;
	}

	public int getBookBarcode() {
		return bookBarcode;
	}

	public void setBookBarcode(int bookBarcode) {
		this.bookBarcode = bookBarcode;
	}

	@Override
    public String toString() {
        return memberCode + "\t" + reserveDate + "\t" + isOverdue + "\t" + bookBarcode + "\t ";
    }


	
}
