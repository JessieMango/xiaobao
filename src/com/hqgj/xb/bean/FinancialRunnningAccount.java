package com.hqgj.xb.bean;

import org.apache.commons.lang3.StringUtils;

/**
 * 流水账
 * 
 * @author 崔兴伟
 * @datetime 2015年8月29日 下午4:52:40
 */
public class FinancialRunnningAccount {
	private String id; // 交易号 流水表ID
	private String operateDate; // 流水日期
	private String operateCode; // 操作编码
	private String operate;
	private String typeCode; // 类型编码
	private String type;
	private String payWayCode; // 支付方式编码
	private String payWay;
	private String handlerCode; // 经办人编码
	private String handleSchoolCode; // 经办学校编码
	private String handleSchool;
	private String feeState; // 学费状态 0未到账 1已到账
	private String remark; // 备注
	private String studentClass_id; // 报名表ID 关联报名表
	private String realMoney; // 实付金额
	private String balance; // 余额
	private String flag; // 0表示此交易已删除，1表示未删除

	private String handler; // 经办人
	private String courseCode; // 课程编码
	private String courseName; // 课程名称
	private String courseTypeCode; // 课程大类编码
	private String courseTypeName; // 课程大类名称
	private String consultId; // 咨询表ID
	private String className; // 班级名称
	private String studentName; // 学生姓名
	private String gender; // 性别

	/**
	 * 查询用于接收前台参数
	 */
	private String order; // 排序 1日期2经办
	private String startTime; // 查询开始日期
	private String endTime; // 查询截止日期
	private String schoolCode; // 1按收费校区 2按上课校区
	private String realShouldTuition; // 实际应付学费
	private String realTuition; // 实际已付学费
	private String num; // 教材杂费的数量
	private String typeTF; // 教材杂费类型1教材2杂费
	private String textBookFeeCode; // 教材杂费ID
	private String stopClassReason; // 停课原因
	private String returnTuitionReason; // 退费原因

	/**
	 * 转班页面
	 */
	private String banlanceOfZhuanban; // 转班时剩下的余额
	private String isBanlance; // 转班后是否有学费剩余;退费页面

	
	public String getReturnTuitionReason() {
		return returnTuitionReason;
	}

	public void setReturnTuitionReason(String returnTuitionReason) {
		this.returnTuitionReason = returnTuitionReason;
	}

	public String getIsBanlance() {
		return isBanlance;
	}

	public void setIsBanlance(String isBanlance) {
		this.isBanlance = isBanlance;
	}

	public String getBanlanceOfZhuanban() {
		return banlanceOfZhuanban;
	}

	public void setBanlanceOfZhuanban(String banlanceOfZhuanban) {
		this.banlanceOfZhuanban = banlanceOfZhuanban;
	}

	public String getStopClassReason() {
		return stopClassReason;
	}

	public void setStopClassReason(String stopClassReason) {
		this.stopClassReason = stopClassReason;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTypeTF() {
		return typeTF;
	}

	public void setTypeTF(String typeTF) {
		this.typeTF = typeTF;
	}

	public String getTextBookFeeCode() {
		return textBookFeeCode;
	}

	public void setTextBookFeeCode(String textBookFeeCode) {
		this.textBookFeeCode = textBookFeeCode;
	}

	public String getHandleSchool() {
		return handleSchool;
	}

	public void setHandleSchool(String handleSchool) {
		this.handleSchool = handleSchool;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getRealTuition() {
		return realTuition;
	}

	public void setRealTuition(String realTuition) {
		this.realTuition = realTuition;
	}

	public String getConsultId() {
		return consultId;
	}

	public void setConsultId(String consultId) {
		this.consultId = consultId;
	}

	public String getRealShouldTuition() {
		return realShouldTuition;
	}

	public void setRealShouldTuition(String realShouldTuition) {
		this.realShouldTuition = realShouldTuition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateCode() {
		return operateCode;
	}

	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}

	public String getTypeCode() { // 默认是学费/余额
		if (StringUtils.isNotBlank(this.typeCode)) {
			return this.typeCode;
		}
		return "1";
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getPayWayCode() {
		return payWayCode;
	}

	public void setPayWayCode(String payWayCode) {
		this.payWayCode = payWayCode;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getHandleSchoolCode() {
		return handleSchoolCode;
	}

	public void setHandleSchoolCode(String handleSchoolCode) {
		this.handleSchoolCode = handleSchoolCode;
	}

	public String getFeeState() { // 默认未到款
		if (StringUtils.isNotBlank(this.feeState)) {
			return this.feeState;
		} else {
			return "0";
		}
	}

	public void setFeeState(String feeState) {
		this.feeState = feeState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStudentClass_id() {
		return studentClass_id;
	}

	public void setStudentClass_id(String studentClass_id) {
		this.studentClass_id = studentClass_id;
	}

	public String getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(String realMoney) {
		this.realMoney = realMoney;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getFlag() {
		if (StringUtils.isNotBlank(this.flag)) { // 默认没有删除
			return flag;
		} else {
			return "1";
		}
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
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

	public String getCourseTypeCode() {
		return courseTypeCode;
	}

	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

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

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月29日 下午5:05:17
	 */
	public FinancialRunnningAccount() {
	}

}
