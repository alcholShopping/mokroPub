package vo;

public class Category {
	private int categoryNo; // 주종 번호
	private String type; // 주종
	private String createDate;
	private String updateDate;
	
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		return "Category [categoryNo=" + categoryNo + ", type=" + type + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
}
