package vo;

public class Password {
	private int consumerNo;
	private String password;
	private String updateDate;
	
	public int getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Password [consumerNo=" + consumerNo + ", password=" + password + ", updateDate=" + updateDate + "]";
	}
	
}
