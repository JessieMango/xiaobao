package com.hqgj.xb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.UserPermission;
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
	public int createStaff(Staff staff)
	{
		///注释
		String sqlUser = "insert into User (userId,password,age,username,tel,school,loginStartTime,loginEndTime,gender,carCode,isEnabled,loginDate,photo,createTime,updateTime,permission) "
				+ "values (:userId,:password,:age,:username,:tel,:school,:loginStartTime,:loginEndTime,:gender,:carCode,:isEnabled,:loginDate,:photo,:createTime,:updateTime,:permission)";
		
		String sqlUser_Role = "insert into User_Role (user_id,role_id,scope) values (:userId,:power,:scope)";
		String sqlBatch = "insert into User_Permission (user_id,permission_id) values (:userId,:permission_id)";
		SqlParameterSource userParameterSource = new BeanPropertySqlParameterSource(
				staff);
	String[] permission_id = staff.().split(",");
		List<UserPermission> list = new ArrayList<UserPermission>();
		for (int i = 0; i < permission_id.length; i++) {
			UserPermission userPermission = new UserPermission();
			userPermission.setUserId(staff.getUserId());
			userPermission.setPermission_id(permission_id[i]);
			list.add(userPermission);
		}
		SqlParameterSource[] parameterSources = SqlParameterSourceUtils
				.createBatch(list.toArray());
				
		int n1 = this.npJdbcTemplate.update(sqlUser, userParameterSource);
		int n2 = this.npJdbcTemplate.update(sqlUser_Role, userParameterSource);
		int[] insertCounts = this.npJdbcTemplate.batchUpdate(sqlBatch,
				parameterSources);
		logger.info("insertCounts:" + insertCounts.length);
		if (n1 != n2) {
			return 0;
		} else {
			return 1;
		}
	}

}
