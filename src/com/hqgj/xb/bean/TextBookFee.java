package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 下午5:22:54
 */
public class TextBookFee {
	private String id;
	private String courseTypeCode;
	private String courseTypeName;
	private String seq;
	private String nameM; // 教材杂项名称
	private String price;
	private String points;
	private String type; // 类型编码
	private String dnameM; // 类型名称
	private String isEnableExchange;//是否允许用积分兑换。
	public String getIsEnableExchange() {
		return isEnableExchange;
	}

	public void setIsEnableExchange(String isEnableExchange) {
		this.isEnableExchange = isEnableExchange;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseTypeCode() {
		return courseTypeCode;
	}

	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getNameM() {
		return nameM;
	}

	public void setNameM(String nameM) {
		this.nameM = nameM;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDnameM() {
		return dnameM;
	}

	public void setDnameM(String dnameM) {
		this.dnameM = dnameM;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 下午5:28:50
	 */
	public TextBookFee() {
	}

}
