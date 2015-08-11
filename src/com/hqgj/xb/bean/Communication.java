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
