package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年8月25日 下午3:16:52
 */
public class StudentClass_TextbookFee {
	private String id;
	private String studentClassCode;
	private String textbookFeeCode;
	private String numbers;
	private String type; // 1教材2杂费
	private String price; // 单价

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentClassCode() {
		return studentClassCode;
	}

	public void setStudentClassCode(String studentClassCode) {
		this.studentClassCode = studentClassCode;
	}

	public String getTextbookFeeCode() {
		return textbookFeeCode;
	}

	public void setTextbookFeeCode(String textbookFeeCode) {
		this.textbookFeeCode = textbookFeeCode;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月25日 下午3:18:29
	 */
	public StudentClass_TextbookFee() {

	}

}
