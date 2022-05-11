package vo;

public class Order {
	// 주문내역
	private int orderNo; // 주문번호
	private int consumerNo; // 소비자번호
	private int productNo; // 상품번호
	private String zipcode; 
	private String address; // 주소
	private String detailedAddress; // 상세주소
	private String payment; // 총 결제금액
	private String method; // 결제방법
	private int count; // 한 물픔을 구매한 개수
	private String consumerCouponListNo; // 쿠폰 리스트번호
	private String createDate;
	private String updateDate;
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
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
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getConsumerCouponListNo() {
		return consumerCouponListNo;
	}
	public void setConsumerCouponListNo(String consumerCouponListNo) {
		this.consumerCouponListNo = consumerCouponListNo;
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
		return "Order [orderNo=" + orderNo + ", consumerNo=" + consumerNo + ", productNo=" + productNo + ", zipcode="
				+ zipcode + ", address=" + address + ", detailedAddress=" + detailedAddress + ", payment=" + payment
				+ ", method=" + method + ", count=" + count + ", consumerCouponListNo=" + consumerCouponListNo
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
	