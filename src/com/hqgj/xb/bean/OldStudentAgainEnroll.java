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
	private String consultId; // 咨询记录ID
	private String nameM; // 学员姓名
	private String gender; // 学员性别
	private String birthday; // 学员生日
	private String banlance; // 可用余额
	private String availabelPoints; // 可用积分
	private String councilSchoolCode; // 公立学校编码 用于Combobox
	private String liveArea; // 居住区域
	private String otherTel; // 电话
	/**
	 * 经办人DHandler
	 */
	private String handler;
	/**
	 * DCouncilSchool表
	 */
	private String councilSchool; // 公立学校
	/**
	 * School表
	 */
	private String handleSchool; // 经办学校
	/**
	 * 报名表
	 */
	private String id; // 报名表ID
	private String sellSourceCode; // 销售来源编码 用于Combobox
	private String sellerCode; // 销售员编码
	private String handleSchoolCode; // 经办学校 用于Combobox
	private String handlerCode;
	private String courseCode; // 课程编码
	private String classCode; // 对应班级编码
	private String discountType; // 收费类型 1原价;2优惠;3折扣;4插班
	private String preferentialPrice; // 优惠金额
	private String discount; // 打折时的折扣
	private String enrollDate; // 报名日期
	private String tuition; // 规定学费
	private String realTuition; // 实收学费
	private String reduceMoney; // 插班时减免的学费
	private String textBook; // 教材费
	private String fee;// 杂费
	private String lackMoney;// 欠费金额
	private String studentType; // 学生类型 1代表新生，2代表老生
	private String studentState; // 学生状态 1正常2转出3停课4退费
	/**
	 * 销售员
	 */
	private String seller; // 销售员
	/**
	 * DSellSource表
	 */
	private String sellSource; // 销售来源
	/**
	 * 课程表
	 */
	private String courseName; // 课程名称
	/**
	 * 班级表
	 */
	private String className; // 班级名称
	private String teacherCode; // 教师编码 关联User表
	/**
	 * User表
	 */
	private String teacherName; // 教师姓名

	/**
	 * 查询用于接收前台参数
	 */
	private String telTail; // 电话尾号
	private String order; // 排序字段 1日期排序 2状态排序 3来源排序 4姓名排序 5年龄排序 6课程排序 7经办排序
	private String courseTypeCode; // 课程大类编码
	private String startTime; // 报名开始时间
	private String endTime; // 报名结束时间

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月26日 下午4:40:19
	 */
	public OldStudentAgainEnroll() {

	}

	public String getTelTail() {
		return telTail;
	}

	public void setTelTail(String telTail) {
		this.telTail = telTail;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getCourseTypeCode() {
		return courseTypeCode;
	}

	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public String getStudentState() {
		return studentState;
	}

	public void setStudentState(String studentState) {
		this.studentState = studentState;
	}

	public String getOtherTel() {
		return otherTel;
	}

	public void setOtherTel(String otherTel) {
		this.otherTel = otherTel;
	}

	public String getTextBook() {
		return textBook;
	}

	public void setTextBook(String textBook) {
		this.textBook = textBook;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getLackMoney() {
		return lackMoney;
	}

	public void setLackMoney(String lackMoney) {
		this.lackMoney = lackMoney;
	}

	public String getCouncilSchoolCode() {
		return councilSchoolCode;
	}

	public void setCouncilSchoolCode(String councilSchoolCode) {
		this.councilSchoolCode = councilSchoolCode;
	}

	public String getCouncilSchool() {
		return councilSchool;
	}

	public void setCouncilSchool(String councilSchool) {
		this.councilSchool = councilSchool;
	}

	public String getLiveArea() {
		return liveArea;
	}

	public void setLiveArea(String liveArea) {
		this.liveArea = liveArea;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getConsultId() {
		return consultId;
	}

	public void setConsultId(String consultId) {
		this.consultId = consultId;
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
