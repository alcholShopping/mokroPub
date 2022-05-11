package vo;

public class Customer {
	private String consumerId;
	   private String password;
	   private String name;
	   private String phone; 
	   private String email; 
	   private String zipCode; 
	   private String address; 
	   private String detailedAddress; 
	   private String consumer; 
	   private String residentNumber; 
	   private String accountNumber;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
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
	@Override
	public String toString() {
		return "Customer [consumerId=" + consumerId + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", zipCode=" + zipCode + ", address=" + address + ", detailedAddress="
				+ detailedAddress + ", consumer=" + consumer + ", residentNumber=" + residentNumber + ", accountNumber="
				+ accountNumber + "]";
	}


}
