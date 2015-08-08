package com.hqgj.xb.bean;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.hqgj.xb.util.DateUtil;

public class User {
	private String userId;
	private String password;
	private Integer age;
	private String username;
	private String tel;
	private String school;
	private String loginStartTime;
	private String loginEndTime;
	private String gender;
	private String carCode;
	private String isEnabled;
	private String loginDate;
	private String photo;
	private String createTime;
	private String updateTime;
	private String power;
	private String scope;
	private String permission;
	private String roleId;
	private String flag;
	
	private String IDnumber;
	private String  birthday;
	private String email;
	private String birthPlace;
	private String  nation;
	private String  politicalStatus;
	private String  marriage;
	private String other;
	
	public String getIDnumber() {
		return IDnumber;
	}

	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getLoginStartTime() {
		return loginStartTime;
	}

	public void setLoginStartTime(String loginStartTime) {
		this.loginStartTime = loginStartTime;
	}

	public String getLoginEndTime() {
		return loginEndTime;
	}

	public void setLoginEndTime(String loginEndTime) {
		this.loginEndTime = loginEndTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCarCode() {
		return carCode;
	}

	public void setCarCode(String carCode) {
		this.carCode = carCode;
	}

	public String getIsEnabled() {
		if (!StringUtils.isBlank(this.isEnabled)) {
			return this.isEnabled;
		}
		return "1";
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCreateTime() {
		if (this.createTime != null)
			return this.createTime;
		return DateUtil.dateToString(new Date());
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}


	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月16日 下午4:37:32
	 */
	public User() {
	}

}
