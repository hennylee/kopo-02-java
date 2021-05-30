package vo;

import java.io.Serializable;

import util.DateUtil;

public class PendingVO implements Serializable  {
	
	// 유저코드
	private int usercode;
	
	// 반납일
	private String returnDate;
	
	// 다음 대여 가능일 
	private String nextDate;

	public int getUsercode() {
		return usercode;
	}

	public String getNextDate() {
		return nextDate;
	}

	public void setNextDate(String nextDate) {
		this.nextDate = nextDate;
	}

	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
    public String toString() {
        return usercode + "\t" + returnDate + "\t" + nextDate + "\t";
    }
	
}
