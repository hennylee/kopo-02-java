package vo;

public class UserVO {
	private int usrCode;
	private String usrName;
	private String id;
	private String pw;
	private String usrRegisterDate;
	
	public int getuserCode() {
		return usrCode;
	}
	public void setuserCode(int userCode) {
		this.usrCode = userCode;
	}
	public String getuserName() {
		return usrName;
	}
	public void setuserName(String userName) {
		this.usrName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getuserRegisterDate() {
		return usrRegisterDate;
	}
	public void setuserRegisterDate(String userRegisterDate) {
		this.usrRegisterDate = userRegisterDate;
	}
	
	@Override
    public String toString() {
        return usrCode + "\t" + usrName + "\t" + id + "\t" + pw + "\t" + usrRegisterDate + "\t";
    }
}
