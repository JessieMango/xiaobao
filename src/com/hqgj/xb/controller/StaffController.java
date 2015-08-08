package com.hqgj.xb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.service.StaffService;
import com.hqgj.xb.service.impl.StaffServiceImpl;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:39:49
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class StaffController {
	
	private StaffService staffService;
	
	@RequestMapping(value = "/renshi/createStaff", method = RequestMethod.POST)
	public @ResponseBody int createStaff(String username,String gender,String englishName ,String IDnumber,String  birthday,String tel
			,String email ,String birthPlace,String  nation,String  politicalstatecode,String  marriage
			,String school,String  major,String  education,String  trainingExperience,String  other ,String personnelstatus,String  staffTag ,String contractState 
			,String contractStartDate ,String contractEndtDate,String confirmationdate,String  laborRelationsCode ,String socialsecurityStatusCode,String  wagecardName 
			,String wagecardID ,String remarks) {

		User user=new User();
		user.setUsername(username);
		user.setGender(gender);
		user.setIDnumber(IDnumber);
		user.setBirthPlace(birthPlace);
		user.setBirthday(birthday);
		user.setTel(tel);
		user.setEmail(email);
		user.setNation(nation);
		user.setPoliticalStatus(politicalstatecode);
		user.setMarriage(marriage);
		user.setOther(other);
		
		
		
		Staff staff=new Staff();
		staff.setEnglishName(englishName);
		staff.setSchool(school);
		staff.setMajor(major);
		staff.setEducation(education);
		staff.setTrainingExperience(trainingExperience);
		staff.setPersonnelstatus(personnelstatus);
		staff.setStaffTag(staffTag);
		staff.setContractState(contractState);
		staff.setContractStartDate(contractStartDate);
		staff.setContractEndtDate(contractEndtDate);
		staff.setConfirmationDate(confirmationdate);
		staff.setLaborRelationsCode(laborRelationsCode);
		staff.setSocialsecurityStatusCode(socialsecurityStatusCode);
		staff.setWagecardName(wagecardName);
		staff.setWagecardID(wagecardID);
		staff.setRemark(remarks);
		
		
		
		
		staffService =new StaffServiceImpl();
		return staffService.createStaff(staff, user);
	}
	
	

}
