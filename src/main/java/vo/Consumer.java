package vo;

public class Consumer {
	private int consumerNo;
	private String consumerId;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String zipcode;
	private String address;
	private String detailedAddr;
	private int consumerLevel;
	private String adultCertification;
	private String residentNumber;
	private String account;
	private String createDate;
	private String updateDate;
	public int getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailedAddr() {
		return detailedAddr;
	}
	public void setDetailedAddr(String detailedAddr) {
		this.detailedAddr = detailedAddr;
	}
	public int getConsumerLevel() {
		return consumerLevel;
	}
	public void setConsumerLevel(int consumerLevel) {
		this.consumerLevel = consumerLevel;
	}
	public String getAdultCertification() {
		return adultCertification;
	}
	public void setAdultCertification(String adultCertification) {
		this.adultCertification = adultCertification;
	}
	public String getResidentNumber() {
		return residentNumber;
	}
	public void setResidentNumber(String residentNumber) {
		this.residentNumber = residentNumber;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "Consumer [consumerNo=" + consumerNo + ", consumerId=" + consumerId + ", password=" + password
				+ ", name=" + name + ", phone=" + phone + ", email=" + email + ", zipcode=" + zipcode + ", address="
				+ address + ", detailedAddr=" + detailedAddr + ", consumerLevel=" + consumerLevel
				+ ", adultCertification=" + adultCertification + ", residentNumber=" + residentNumber + ", account="
				+ account + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
