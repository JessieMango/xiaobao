package com.hqgj.xb.bean;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月6日 下午9:09:13
 */
public class Staff {
	private String Id;
	private String userId;        //user 表中的id
	private String wage;          //
	private String position;       //职位
	private String personnelstatusCode;	
	private String personnelstatus;   //人事状态
	private String socialsecurityStatusCode;
	private String socialsecurityStatus;//社保状态
	private String laborRelationsCode;//
	private String laborRelations;//
	private String contractState;
	private String contractStartDate;//
	private String contractEndtDate;//
	private String confirmationDate;//
	private String cardCode;//
	private String englishName;//
	private String trainingExperience;//
	private String staffTag;	//
	private String wagecardName;//
	private String remark;
	private String wagecardID;
	
	
	//以下字段来自数据表DStaffEducation
	private String startDate;
	private String endDate;
	private String school;
	private String unified;
	private String major;
	private String education;

	
	public String getContractState() {
		return contractState;
	}

	public void setContractState(String contractState) {
		this.contractState = contractState;
	}
	public String getPersonnelstatusCode() {
		return personnelstatusCode;
	}

	public void setPersonnelstatusCode(String personnelstatusCode) {
		this.personnelstatusCode = personnelstatusCode;
	}

	public String getPersonnelstatus() {
		return personnelstatus;
	}

	public void setPersonnelstatus(String personnelstatus) {
		this.personnelstatus = personnelstatus;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getUnified() {
		return unified;
	}

	public void setUnified(String unified) {
		this.unified = unified;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getErsonnelstatusCode() {
		return personnelstatusCode;
	}

	public void setErsonnelstatusCode(String personnelstatusCode) {
		this.personnelstatusCode = personnelstatusCode;
	}

	public String getErsonnelstatus() {
		return personnelstatus;
	}

	public void setErsonnelstatus(String personnelstatus) {
		this.personnelstatus = personnelstatus;
	}


	public String getSocialsecurityStatusCode() {
		return socialsecurityStatusCode;
	}

	public void setSocialsecurityStatusCode(String socialsecurityStatusCode) {
		this.socialsecurityStatusCode = socialsecurityStatusCode;
	}

	public String getLaborRelationsCode() {
		return laborRelationsCode;
	}

	public void setLaborRelationsCode(String laborRelationsCode) {
		this.laborRelationsCode = laborRelationsCode;
	}

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
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
