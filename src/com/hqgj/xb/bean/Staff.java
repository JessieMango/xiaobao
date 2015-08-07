package com.hqgj.xb.bean;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月6日 下午9:09:13
 */
public class Staff {
	private String Id;
	private String userId;
	private String wage;
	private String state;
	private String position;
	private String contractStatus;
	private String socialsecurityStatus;
	private String laborRelations;
	private String contractStartDate;
	private String contractEndtDate;
	private String confirmationDate;
	private String cardCode;
	private String englishName;
	private String trainingExperience;
	private String staffTag;
	
	private String wagecardName;
	public String getWagecardName() {
		return wagecardName;
	}

	public void setWagecardName(String wagecardName) {
		this.wagecardName = wagecardName;
	}

	public String getWagecardID() {
		return wagecardID;
	}

	public void setWagecardID(String wagecardID) {
		this.wagecardID = wagecardID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private String wagecardID;
	private String remarks;
	
	
	public String getStaffTag() {
		return staffTag;
	}

	public void setStaffTag(String staffTag) {
		this.staffTag = staffTag;
	}
	public String getContractStartDate() {
		return contractStartDate;
	}


	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public String getContractEndtDate() {
		return contractEndtDate;
	}


	public void setContractEndtDate(String contractEndtDate) {
		this.contractEndtDate = contractEndtDate;
	}
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getTrainingExperience() {
		return trainingExperience;
	}

	public void setTrainingExperience(String trainingExperience) {
		this.trainingExperience = trainingExperience;
	}

	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getSocialsecurityStatus() {
		return socialsecurityStatus;
	}
	public void setSocialsecurityStatus(String socialsecurityStatus) {
		this.socialsecurityStatus = socialsecurityStatus;
	}
	public String getLaborRelations() {
		return laborRelations;
	}
	public void setLaborRelations(String laborRelations) {
		this.laborRelations = laborRelations;
	}

	public String getConfirmationDate() {
		return confirmationDate;
	}
	public void setConfirmationDate(String confirmationDate) {
		this.confirmationDate = confirmationDate;
	}
	public String getCardCode() {
		return cardCode;
	}
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	
	
	
	public Staff () {
		
	}
}
