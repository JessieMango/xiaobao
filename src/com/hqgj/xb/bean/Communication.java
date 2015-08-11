package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年8月10日 上午9:40:06
 */
public class Communication {
	private String id;
	private String consultId;
	private String communicationType; // 沟通类型(包括售前，售后的所有类型)
	private String communicationTypeName;
	private String type; // 1代表售前沟通，2代表售后沟通
	private String communicationDate;
	private String communicationContent;
	private String communicationResult;
	private String returnVisitDate;
	private String isRemind; // 1表示提醒 0表示不提醒
	private String handleSchoolCode;
	private String handleSchool;
	private String handler; // 沟通人
	private String handlerCode; // 沟通人编码
	/**
	 * 要关联咨询表
	 */
	private String nameM; // 学员姓名
	private String gender; // 学员性别
	private String otherTel; // 一般指学员自己电话
	/**
	 * 查询条件
	 */
	private String startTime; // 沟通开始日期
	private String endTime; // 沟通截止日期
	private String order; // 排序字段 1 日期排序 2方式排序 3经办排序

	public String getHandleSchool() {
		return handleSchool;
	}

	public void setHandleSchool(String handleSchool) {
		this.handleSchool = handleSchool;
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

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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

	public String getOtherTel() {
		return otherTel;
	}

	public void setOtherTel(String otherTel) {
		this.otherTel = otherTel;
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

	public String getHandleSchoolCode() {
		return handleSchoolCode;
	}

	public void setHandleSchoolCode(String handleSchoolCode) {
		this.handleSchoolCode = handleSchoolCode;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月10日 上午9:43:53
	 */
	public Communication() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConsultId() {
		return consultId;
	}

	public void setConsultId(String consultId) {
		this.consultId = consultId;
	}

	public String getCommunicationType() {
		return communicationType;
	}

	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}

	public String getCommunicationTypeName() {
		return communicationTypeName;
	}

	public void setCommunicationTypeName(String communicationTypeName) {
		this.communicationTypeName = communicationTypeName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCommunicationDate() {
		return communicationDate;
	}

	public void setCommunicationDate(String communicationDate) {
		this.communicationDate = communicationDate;
	}

	public String getCommunicationContent() {
		return communicationContent;
	}

	public void setCommunicationContent(String communicationContent) {
		this.communicationContent = communicationContent;
	}

	public String getCommunicationResult() {
		return communicationResult;
	}

	public void setCommunicationResult(String communicationResult) {
		this.communicationResult = communicationResult;
	}

	public String getReturnVisitDate() {
		return returnVisitDate;
	}

	public void setReturnVisitDate(String returnVisitDate) {
		this.returnVisitDate = returnVisitDate;
	}

	public String getIsRemind() {
		return isRemind;
	}

	public void setIsRemind(String isRemind) {
		this.isRemind = isRemind;
	}

}
