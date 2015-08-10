package com.hqgj.xb.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
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
		
	
		
		String staffstagname=staff.getStaffTag().trim();
		String staffstagID=UUID.randomUUID().toString();
		staff.setStaffTag(staffstagID);
		
		
		
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
		
		
		
		staff.setId(staffstagID);
		staff.setStaffTag(staffstagname);
		String sqlDStaffStag="insert into DStaffTag (stafftag,nameM) values (:id,:staffTag)";
		userParameterSource = new BeanPropertySqlParameterSource(
				staff);
		int n4 = this.npJdbcTemplate.update(sqlDStaffStag, userParameterSource);
		
		if(n1==n2&&n2==n3&&n3==1&&n3==n4)
		{
			return 1;
		}
		else {
			
			return 0;
		}
		
	}

	@Override
	public  Grid Getmianshiqi(Staff staff, Parameter parameter)
	{
		String sql;
		final List<Staff> results = new ArrayList<Staff>();
		
		if(StringUtils.isNotBlank(staff.getRemark()))
		{
		logger.info("1");
		sql="select User.username userId,User.gender position,Staff.personnelstatus personnelstatus,DStaffEducation.education education,Staff.laborRelations laborRelations,Staff.contractState contractState,Staff.socialsecurityStatus socialsecurityStatus,Staff.confirmationdate confirmationdate,"
				+ "datediff(curdate(),Staff.contractStartDate) contractStartDate,datediff(Staff.contractEndtDate,curdate()) contractEndtDate"
				+ "  from User left outer join Staff on Staff.userId=User.userId left outer join DStaffEducation on User.userId=DStaffEducation.userId";
		
		if(!StringUtils.equals("qb", staff.getContractState())||!StringUtils.equals("qb", staff.getSocialsecurityStatus())||!StringUtils.equals("qb", staff.getLaborRelations())||!StringUtils.equals("qb", staff.getStaffTag()))
		{

			sql+=" where ";
			int countParameter=0;
			if (!StringUtils.equals("qb", staff.getContractState()))
			{
				sql+="(contractState=:contractState or contractState is null)";
				countParameter++;
			}
		
			
			if (!StringUtils.equals("qb", staff.getSocialsecurityStatus())) 
			{
				if(countParameter>0)
				{
					sql+="and (socialsecurityStatus=:socialsecurityStatus or socialsecurityStatus is null) ";		
				}
				else {
					sql+=" (socialsecurityStatus=:socialsecurityStatus or socialsecurityStatus is null) ";		
				}
				countParameter++;
			}
			
			if (!StringUtils.equals("qb", staff.getLaborRelations()))
			{
				if(countParameter>0)
				{
					sql+="and (laborRelations=:laborRelations  or laborRelations is null)";	
				}
				else {
					sql+=" (laborRelations=:laborRelations  or laborRelations is null) ";
				}
				countParameter++;
			}
		
			if (!StringUtils.equals("qb", staff.getStaffTag())) {
				if(countParameter>0)
				{
					sql+=" and (Staff.staffTag=:staffTag  or Staff.staffTag is null) ";
				}
				else {
					sql+=" (Staff.staffTag=:staffTag  or Staff.staffTag is null) ";
				}
				countParameter++;
			}
		}
		
			
				
				
				logger.info("2");
				
				
				switch (staff.getRemark().trim()) {
				case "1"://员工姓名排序
					sql+=" order by userId";
					break;
				case "2"://员工工龄排序
					sql+=" order by  contractStartDate";			
					break;
				case "3"://员工状态排序
					sql+=" order by  contractState";
					break;
				case "4"://合同起日排序
					sql+=" order by  contractStartDate";
					break;
				case "5"://合同止日排序
					sql+=" order by  contractEndtDate";
					break;
				case "6"://转正日期排序
					sql+=" order by  confirmationdate ";
					break;
				}
		logger.info("3");	
	
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("socialsecurityStatus", staff.getSocialsecurityStatus());
		map.put("contractState", staff.getContractState());
		map.put("laborRelations", staff.getLaborRelations());
		map.put("staffTag", staff.getStaffTag());
		
		logger.info(sql);	
		this.npJdbcTemplate.query(sql,map, new RowCallbackHandler() {

		
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Staff staff = new Staff();
				staff.setUserId(rs.getString("userId"));
				staff.setPosition(rs.getString("position"));
				staff.setPersonnelstatus(rs.getString("personnelstatus"));
				staff.setEducation(rs.getString("education"));
				staff.setLaborRelations(rs.getString("laborRelations"));
				staff.setContractState(rs.getString("contractState"));
				staff.setSocialsecurityStatus(rs.getString("socialsecurityStatus"));
				staff.setConfirmationdate(rs.getString("confirmationdate"));
				staff.setContractStartDate(rs.getString("contractStartDate"));
				staff.setContractEndtDate(rs.getString("contractEndtDate"));
				results.add(staff);
			}
		});

		
	
		}
		else {
			sql="select User.username userId,User.gender position,Staff.personnelstatus personnelstatus,DStaffEducation.education education,Staff.laborRelations laborRelations,Staff.contractState contractState,Staff.socialsecurityStatus socialsecurityStatus,Staff.confirmationdate confirmationdate,"
				+ "datediff(curdate(),Staff.contractStartDate) contractStartDate,datediff(Staff.contractEndtDate,curdate()) contractEndtDate"
				+ "  from User left outer join Staff on Staff.userId=User.userId left outer join DStaffEducation on User.userId=DStaffEducation.userId "
				+ " order by User.username";
			this.npJdbcTemplate.query(sql, new RowCallbackHandler() {

				@Override
				public void processRow(ResultSet rs) throws SQLException {
					Staff staff = new Staff();
					staff.setUserId(rs.getString("userId"));
					staff.setPosition(rs.getString("position"));
					staff.setPersonnelstatus(rs.getString("personnelstatus"));
					staff.setEducation(rs.getString("education"));
					staff.setLaborRelations(rs.getString("laborRelations"));
					staff.setContractState(rs.getString("contractState"));
					staff.setSocialsecurityStatus(rs.getString("socialsecurityStatus"));
					staff.setConfirmationdate(rs.getString("confirmationdate"));
					staff.setContractStartDate(rs.getString("contractStartDate"));
					staff.setContractEndtDate(rs.getString("contractEndtDate"));
					results.add(staff);
				}
			});
		}
		
		logger.info("一共有" + results.size() + "条数据");
		logger.info("page:"+parameter.getPage()+";rows:"+parameter.getRows());
		Grid grid = new Grid();
		if ((int) parameter.getPage() > 0) {
			int page = (int) parameter.getPage();
			int rows = (int) parameter.getRows();
			int fromIndex = (page - 1) * rows;
			int toIndex = (results.size() <= page * rows && results.size() >= (page - 1)
					* rows) ? results.size() : page * rows;
			grid.setRows(results.subList(fromIndex, toIndex));
			grid.setTotal(results.size());

		} else {
			grid.setRows(results);
		}
		
		return grid;
		
	}
	
	
	@Override
	public  List<Staff> getStaffTag(String type)
	{
		String sql = "select * from DStaffTag";
		List<Staff> results = this.npJdbcTemplate.query(sql,
				new RowMapper<Staff>() {
					@Override
					public Staff mapRow(ResultSet rs, int index)
							throws SQLException {
						Staff staff = new Staff();
						staff.setId(rs.getString("stafftag"));
						staff.setCardCode(rs.getString("nameM"));
						return staff;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Staff temp = new Staff();
			temp.setId("qb");
			temp.setCardCode("全部标记");
			results.add(0, temp);
		}
		return results;		
	}
	
}

