package com.hqgj.xb.bean;

/**
 * 咨询Bean
 * 
 * @author 崔兴伟
 * @datetime 2015年8月5日 下午3:47:38
 */
public class Consult {
	private String id; // 咨询记录ID
	private String nameM; // 学员姓名
	private String gender; // 学员性别
	private String consultDate; // 咨询日期
	private String birthday; // 学员生日
	private String motherTel;
	private String fatherTel;
	private String otherTel;
	private String councilSchoolCode; // 公立学校编码 用于Combobox
	private String councilSchool; // 公立学校
	private String class_grade; // 班级年级
	private String liveArea; // 居住区域
	private String others; // 其他信息
	private String consultWayCode; // 咨询方式编码 用于Combobox
	private String consultWay; // 咨询方式编码
	private String consultCourseCode; // 咨询课程编码
	private String consultCourse; // 咨询课程编码 用于Combobox
	private String consultContent; // 咨询内容
	private String willDegreeCode; // 意向度编码 用于Combobox
	private String willDegree; // 意向度
	private String sellSource; // 销售来源
	private String sellSourceCode; // 销售来源编码 用于Combobox
	private String seller; // 销售员
	private String sellerCode; // 销售员编码
	private String handleSchoolCode; // 经办学校 用于Combobox
	private String handleSchool; // 经办学校
	private String handler; // 经办人当前登录人员
	private String handlerCode; // 经办人当前登录人员 用于Combobox
	private String mark; // 标记
	private String markCode; // 标记 编码 用于Combobox
	private String state; // 0表示未报名,1表示已报名
	private String carCode; // 磁卡号
	private String banlance; // 可用余额
	private String availabelPoints; // 可用积分
	private String flag; // 表示是否有咨询记录 0表示有，1表示没有
	private String starttime;
	private String endtime;
	private String age; // 年龄

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
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

	/**
	 * 用于查询
	 */
	private String telTail; // 电话尾号
	private String startTime; // 查询开始日期
	private String endTime; // 查询截止日期
	private String order; // 排序字段 1按日期排序 2方式排序 3来源排序 4课程排序 5经办排序

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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

	public String getTelTail() {
		return telTail;
	}

	public void setTelTail(String telTail) {
		this.telTail = telTail;
	}

	public String getCouncilSchoolCode() {
		return councilSchoolCode;
	}

	public void setCouncilSchoolCode(String councilSchoolCode) {
		this.councilSchoolCode = councilSchoolCode;
	}

	public String getConsultWay() {
		return consultWay;
	}

	public void setConsultWay(String consultWay) {
		this.consultWay = consultWay;
	}

	public String getConsultCourse() {
		return consultCourse;
	}

	public void setConsultCourse(String consultCourse) {
		this.consultCourse = consultCourse;
	}

	public String getWillDegree() {
		return willDegree;
	}

	public void setWillDegree(String willDegree) {
		this.willDegree = willDegree;
	}

	public String getSellSourceCode() {
		return sellSourceCode;
	}

	public void setSellSourceCode(String sellSourceCode) {
		this.sellSourceCode = sellSourceCode;
	}

	public String getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public String getHandleSchool() {
		return handleSchool;
	}

	public void setHandleSchool(String handleSchool) {
		this.handleSchool = handleSchool;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getMarkCode() {
		return markCode;
	}

	public void setMarkCode(String markCode) {
		this.markCode = markCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(String consultDate) {
		this.consultDate = consultDate;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMotherTel() {
		return motherTel;
	}

	public void setMotherTel(String motherTel) {
		this.motherTel = motherTel;
	}

	public String getFatherTel() {
		return fatherTel;
	}

	public void setFatherTel(String fatherTel) {
		this.fatherTel = fatherTel;
	}

	public String getOtherTel() {
		return otherTel;
	}

	public void setOtherTel(String otherTel) {
		this.otherTel = otherTel;
	}

	public String getCouncilSchool() {
		return councilSchool;
	}

	public void setCouncilSchool(String councilSchool) {
		this.councilSchool = councilSchool;
	}

	public String getClass_grade() {
		return class_grade;
	}

	public void setClass_grade(String class_grade) {
		this.class_grade = class_grade;
	}

	public String getLiveArea() {
		return liveArea;
	}

	public void setLiveArea(String liveArea) {
		this.liveArea = liveArea;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getConsultWayCode() {
		return consultWayCode;
	}

	public void setConsultWayCode(String consultWayCode) {
		this.consultWayCode = consultWayCode;
	}

	public String getConsultCourseCode() {
		return consultCourseCode;
	}

	public void setConsultCourseCode(String consultCourseCode) {
		this.consultCourseCode = consultCourseCode;
	}

	public String getConsultContent() {
		return consultContent;
	}

	public void setConsultContent(String consultContent) {
		this.consultContent = consultContent;
	}

	public String getWillDegreeCode() {
		return willDegreeCode;
	}

	public void setWillDegreeCode(String willDegreeCode) {
		this.willDegreeCode = willDegreeCode;
	}

	public String getSellSource() {
		return sellSource;
	}

	public void setSellSource(String sellSource) {
		this.sellSource = sellSource;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getHandleSchoolCode() {
		return handleSchoolCode;
	}

	public void setHandleSchoolCode(String handleSchoolCode) {
		this.handleSchoolCode = handleSchoolCode;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
