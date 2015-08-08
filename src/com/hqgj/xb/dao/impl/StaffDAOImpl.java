package com.hqgj.xb.dao.impl;


import java.util.UUID;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.dao.StaffDAO;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:41:45
 */
public class StaffDAOImpl implements StaffDAO {
	private NamedParameterJdbcTemplate npJdbcTemplate;
	private Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	@Override
	public int createStaff(Staff staff,User user)
	{
		staff.setId(UUID.randomUUID().toString());
		user.setUserId(UUID.randomUUID().toString());
		staff.setUserId(user.getUserId());
		
		
		user.setIsEnabled("0");
		/*user.setLoginStartTime();
		user.setLoginEndTime();
		user.setAge();
		user.setPassword();*/
		
		String sqlUser ="insert into User (userId,username,tel,school,gender,isEnabled,IDnumber,nation,birthPlace,birthday,email,politicalStatus,marriage,other) "
				+"values (:userId,:username,:tel,:school,:gender,:isEnabled,:IDnumber,:nation,:birthPlace,:birthday,:email,:politicalStatus,:marriage,other)";
		SqlParameterSource userParameterSource = new BeanPropertySqlParameterSource(
				user);
		int n1 = this.npJdbcTemplate.update(sqlUser, userParameterSource);
		
		String sqlStaff ="insert into User (id,userId,wage,personnelstatus,socialsecurityStatus,laborRelations,contractStartDate,contractEndtDate,confirmationDate,englishName,trainingExperience,staffTag,wagecardName,wagecardID,remark,contractState) "
				+"values (:id,:userId,:wage,:personnelstatus,:socialsecurityStatusCode,:laborRelationsCode,:contractStartDate,:contractEndtDate,:confirmationdate,:englishName,:trainingExperience,:staffTag,:wagecardName,:wagecardID,:remark,:contractState)";
		userParameterSource = new BeanPropertySqlParameterSource(
				staff);
		int n2 = this.npJdbcTemplate.update(sqlStaff, userParameterSource);
		
		
		staff.setId(UUID.randomUUID().toString());
		String sqlDStaffEducation="insert into User (id,userId,school,major,education)"+
		"values (:id,:userId,:school,:major,:education)";
		userParameterSource = new BeanPropertySqlParameterSource(
				staff);
		int n3 = this.npJdbcTemplate.update(sqlDStaffEducation, userParameterSource);
		
				
		
		if(n1==n2&&n2==n3&&n3==1)
		{
			return 1;
		}
		else {
			
			return 0;
		}
		
	}

}
