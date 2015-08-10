package com.hqgj.xb.dao.impl;


import java.util.UUID;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.dao.StaffDAO;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:41:45
 */
@Repository
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
		logger.info("user:"+user+";staff:"+staff);
		staff.setId(UUID.randomUUID().toString());
		user.setUserId(UUID.randomUUID().toString());
		staff.setUserId(user.getUserId());
		
		
		user.setIsEnabled("0");
		/*user.setLoginStartTime();
		user.setLoginEndTime();
		user.setAge();
		user.setPassword();*/
		
		String sqlUser ="insert into User (userId,username,tel,gender,isEnabled,IDnumber,nation,birthPlace,birthday,email,politicalStatus,marriage,other) "
				+"values (:userId,:username,:tel,:gender,:isEnabled,:IDnumber,:nation,:birthPlace,:birthday,:email,:politicalStatus,:marriage,:other)";
		SqlParameterSource userParameterSource = new BeanPropertySqlParameterSource(
				user);
		int n1 = this.npJdbcTemplate.update(sqlUser, userParameterSource);
		
		String sqlStaff ="insert into Staff (id,userId,wage,personnelstatus,socialsecurityStatus,laborRelations,contractStartDate,contractEndtDate,confirmationdate,englishName,trainingExperience,staffTag,wagecardName,wagecardID,remark,contractState) "
				+"values (:id,:userId,:wage,:personnelstatus,:socialsecurityStatusCode,:laborRelationsCode,:contractStartDate,:contractEndtDate,:confirmationdate,:englishName,:trainingExperience,:staffTag,:wagecardName,:wagecardID,:remark,:contractState)";
		userParameterSource = new BeanPropertySqlParameterSource(
				staff);
		int n2 = this.npJdbcTemplate.update(sqlStaff, userParameterSource);
		
		
		staff.setId(UUID.randomUUID().toString());
		String sqlDStaffEducation="insert into DStaffEducation (id,userId,school,major,education)"+
		"values (:id,:userId,:schooll,:major,:education)";
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
