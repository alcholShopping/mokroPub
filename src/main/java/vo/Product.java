package vo;

public class Product {
	private int productNo; // 상품번호
	private String name; // 상품 이름
	private int price; // 가격
	private int volume; // 용량
	private int materialOriginNo; // 원료원산지 번호
	private String manufactureDate; // 제조일자
	private String expirationDate; // 유통기한
	private int alcoholLevel; // 도수 alcohol_level
	private String factory; // 공장
	private String color; // 색
	private String bottle; // 병 재질
	private String region; // 지역
	private int sellerNo; // 판매자번호
	private String smell; // 향
	private int sweet; // 당도
	private int maturity; // 숙성도
	private int categoryNo; // 주종
	private String picture; // 사진
	private int acidity; // 산미
	private int thin; // 바디감 질감
	private int refreshment; // 청량감
	private String reportNumber; // 품목보고번호
	private int companyNo; // 회사번호
	private String memo; // 설명
	private String createDate; 
	private String updateDate;
	
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getMaterialOriginNo() {
		return materialOriginNo;
	}
	public void setMaterialOriginNo(int materialOriginNo) {
		this.materialOriginNo = materialOriginNo;
	}
	public String getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public int getAlcoholLevel() {
		return alcoholLevel;
	}
	public void setAlcoholLevel(int alcholLevel) {
		this.alcoholLevel = alcholLevel;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBottle() {
		return bottle;
	}
	public void setBottle(String bottle) {
		this.bottle = bottle;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSmell() {
		return smell;
	}
	public void setSmell(String smell) {
		this.smell = smell;
	}
	public int getSweet() {
		return sweet;
	}
	public void setSweet(int sweet) {
		this.sweet = sweet;
	}
	public int getMaturity() {
		return maturity;
	}
	public void setMaturity(int maturity) {
		this.maturity = maturity;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getAcidity() {
		return acidity;
	}
	public void setAcidity(int acidity) {
		this.acidity = acidity;
	}
	public int getThin() {
		return thin;
	}
	public void setThin(int thin) {
		this.thin = thin;
	}
	public int getRefreshment() {
		return refreshment;
	}
	public void setRefreshment(int refreshment) {
		this.refreshment = refreshment;
	}
	public String getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
	public int getSellerNo() {
		return sellerNo;
	}
	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}
	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", name=" + name + ", price=" + price + ", volume=" + volume
				+ ", materialOriginNo=" + materialOriginNo + ", manufactureDate=" + manufactureDate
				+ ", expirationDate=" + expirationDate + ", alcholLevel=" + alcoholLevel + ", factory=" + factory
				+ ", color=" + color + ", bottle=" + bottle + ", region=" + region + ", sellerNo=" + sellerNo
				+ ", smell=" + smell + ", sweet=" + sweet + ", maturity=" + maturity + ", categoryNo=" + categoryNo
				+ ", picture=" + picture + ", acidity=" + acidity + ", thin=" + thin + ", refreshment=" + refreshment
				+ ", reportNumber=" + reportNumber + ", companyNo=" + companyNo + ", memo=" + memo + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
	
}
