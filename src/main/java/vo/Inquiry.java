package vo;

public class Inquiry {
	private int inquiryNo;
	private int consumerNo;
	private String category;
	private String title;
	private String content;
	private String status;
	private String answer;
	private String photo;
	private String createDate;
	private String updateDate;
	
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public int getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
		return "InquiryDao [inquiryNo=" + inquiryNo + ", consumerNo=" + consumerNo + ", category=" + category
				+ ", title=" + title + ", content=" + content + ", status=" + status + ", answer=" + answer + ", photo="
				+ photo + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
}
