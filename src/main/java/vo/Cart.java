package vo;

public class Cart {
	private int cartNo;
	private int productNo; // 상품번호
	private int consumerNo; // 회원번호
	private int count; // 수량
	private String createDate;
	private String updateDate;
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
		return "Cart [cartNo=" + cartNo + ", productNo=" + productNo + ", consumerNo=" + consumerNo + ", count=" + count
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}	
}
