package com.hqgj.xb.bean;

/**
 * 老生续报显示的信息
 * 
 * @author 崔兴伟
 * @datetime 2015年8月26日 下午4:01:39
 */
public class OldStudentAgainEnroll {
	/**
	 * 咨询表
	 */
	private String id; // 咨询记录ID
	private String nameM; // 学员姓名
	private String gender; // 学员性别
	private String birthday; // 学员生日
	private String banlance; // 可用余额
	private String availabelPoints; // 可用积分
	private String handler; // 经办人当前登录人员
	private String handlerCode; // 经办人当前登录人员 用于Combobox
	/**
	 * 报名表
	 */
	private String sellSource; // 销售来源
	private String sellSourceCode; // 销售来源编码 用于Combobox
	private String seller; // 销售员
	private String sellerCode; // 销售员编码
	private String handleSchoolCode; // 经办学校 用于Combobox
	private String handleSchool; // 经办学校
	private String courseCode; // 课程编码
	private String courseName; // 课程名称
	private String classCode; // 对应班级编码
	private String className; // 班级名称
	private String discountType; // 收费类型 1原价;2优惠;3折扣;4插班
	private String preferentialPrice; // 优惠金额
	private String discount; // 打折时的折扣
	private String enrollDate; // 报名日期
	private String realTuition; // 实收学费
	private String reduceMoney; // 插班时减免的学费

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月26日 下午4:40:19
	 */
	public OldStudentAgainEnroll() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameM() {
		return nameM;
	}

	public void setNameM(String nameM) {
		this.nameM = nameM;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBanlance() {
		return banlance;
	}

	public void setBanlance(String banlance) {
		this.banlance = banlance;
	}

	public String getAvailabelPoints() {
		return availabelPoints;
	}

	public void setAvailabelPoints(String availabelPoints) {
		this.availabelPoints = availabelPoints;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getSellSource() {
		return sellSource;
	}

	public void setSellSource(String sellSource) {
		this.sellSource = sellSource;
	}

	public String getSellSourceCode() {
		return sellSourceCode;
	}

	public void setSellSourceCode(String sellSourceCode) {
		this.sellSourceCode = sellSourceCode;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public String getHandleSchoolCode() {
		return handleSchoolCode;
	}

	public void setHandleSchoolCode(String handleSchoolCode) {
		this.handleSchoolCode = handleSchoolCode;
	}

	public String getHandleSchool() {
		return handleSchool;
	}

	public void setHandleSchool(String handleSchool) {
		this.handleSchool = handleSchool;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getPreferentialPrice() {
		return preferentialPrice;
	}

	public void setPreferentialPrice(String preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getRealTuition() {
		return realTuition;
	}

	public void setRealTuition(String realTuition) {
		this.realTuition = realTuition;
	}

	public String getReduceMoney() {
		return reduceMoney;
	}

	public void setReduceMoney(String reduceMoney) {
		this.reduceMoney = reduceMoney;
	}

}
