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

import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.StaffDAO;
import com.hqgj.xb.util.MD5Util;

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
	
	
	//编辑员工信息
	@Override
	public int editStaff(Staff staff) {
		
		String sql = "update User set username=:username,tel=:tel,gender=:gender,IDnumber=:IDnumber,nation=:nation,birthPlace=:birthPlace,birthday=:birthday"
				+ ",email=:email,politicalStatus=:politicalStatus,marriage=:marriage,other=:other "
				+ "where userId=:userId";
		SqlParameterSource StaffParameterSource = new BeanPropertySqlParameterSource(staff);
		int n1= this.npJdbcTemplate.update(sql, StaffParameterSource);
		
	
		sql = "update Staff set personnelstatus=:personnelstatus,socialsecurityStatus=:socialsecurityStatus,laborRelations=:laborRelations,contractStartDate=:contractStartDate,contractEndtDate=:contractEndtDate,"
				+ "confirmationdate=:confirmationdate,englishName=:englishName,trainingExperience=:trainingExperience,staffTag=:staffTag,wagecardName=:wagecardName,wagecardID=:wagecardID,"
				+ "remark=:remark,contractState=:contractState "
				+ "where userId=:userId";
		int n2= this.npJdbcTemplate.update(sql, StaffParameterSource);
		
		sql = "update DStaffEducation set school=:school,major=:major,education=:education "
				+ "where userId=:userId";
		int n3= this.npJdbcTemplate.update(sql, StaffParameterSource);
		
		//此处需要事务
		//
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return 1;
	}

	@Override
	public Staff getstaffByuserId(String userid) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userid", userid);
		String sql="select User.username username,User.userId userId,User.gender gender,User.tel tel,User.IDnumber IDnumber,User.nation nation,User.birthPlace birthPlace,User.birthday birthday,"
				+ "User.email email,User.politicalStatus politicalStatus,User.marriage marriage,User.other other,Staff.wage wage,Staff.personnelstatus personnelstatus"
				+ ",Staff.socialsecurityStatus socialsecurityStatus,Staff.laborRelations laborRelations,Staff.contractStartDate contractStartDate,Staff.contractEndtDate contractEndtDate,"
				+ "Staff.confirmationdate confirmationdate,Staff.englishName englishName,Staff.trainingExperience trainingExperience,Staff.staffTag staffTag,"
				+ "Staff.wagecardName wagecardName,Staff.wagecardID wagecardID,Staff.remark remark,Staff.contractState contractState,"
				+ "DStaffEducation.education education,DStaffEducation.school school,DStaffEducation.major major"
				+ "  from User left outer join Staff on Staff.userId=User.userId left outer join DStaffEducation on User.userId=DStaffEducation.userId where User.userId=:userid";

		final Staff result = this.npJdbcTemplate.queryForObject(sql, paramMap,
				new RowMapper<Staff>() {
					@Override
					public Staff mapRow(ResultSet rs, int index)
							throws SQLException {
						Staff staff = new Staff();
						staff.setUserId(rs.getString("userId"));
						staff.setUsername(rs.getString("username"));
						staff.setTel(rs.getString("tel"));
						staff.setGender(rs.getString("gender"));
						staff.setIDnumber(rs.getString("IDnumber"));
						staff.setNation(rs.getString("nation"));
						staff.setBirthPlace(rs.getString("birthPlace"));
						staff.setBirthday(rs.getString("birthday"));
						staff.setEmail(rs.getString("email"));
						staff.setPoliticalStatus(rs.getString("politicalStatus"));
						staff.setMarriage(rs.getString("marriage"));
						staff.setOther(rs.getString("other"));
						
						
						staff.setWage(rs.getString("wage"));
						staff.setPersonnelstatus(rs.getString("personnelstatus"));
						staff.setSocialsecurityStatus(rs.getString("socialsecurityStatus"));
						staff.setLaborRelations(rs.getString("laborRelations"));
						staff.setContractStartDate(rs.getString("contractStartDate"));
						staff.setContractEndtDate(rs.getString("contractEndtDate"));
						staff.setConfirmationdate(rs.getString("confirmationdate"));
						staff.setEnglishName(rs.getString("englishName"));
						staff.setTrainingExperience(rs.getString("trainingExperience"));
						staff.setStaffTag(rs.getString("staffTag"));
						staff.setWagecardName(rs.getString("wagecardName"));
						staff.setWagecardID(rs.getString("wagecardID"));
						staff.setRemark(rs.getString("remark"));
						staff.setContractState(rs.getString("contractState"));
						
						staff.setSchool(rs.getString("school"));
						staff.setMajor(rs.getString("major"));
						staff.setEducation(rs.getString("education"));
						return staff;
					}
				});
		return result;

	}
	//新增员工
	@Override
	public int createStaff(Staff staff,User user)
	{
		logger.info("user:"+user+";staff:"+staff);
		staff.setId(UUID.randomUUID().toString());
		user.setUserId(UUID.randomUUID().toString());
		staff.setUserId(user.getUserId());
		user.setPassword(MD5Util.md5("123456"));
		user.setIsEnabled("0");
	
		
		String sqlUser ="insert into User (userId,password,username,tel,gender,isEnabled,IDnumber,nation,birthPlace,birthday,email,politicalStatus,marriage,other) "
				+"values (:userId,:password,:username,:tel,:gender,:isEnabled,:IDnumber,:nation,:birthPlace,:birthday,:email,:politicalStatus,:marriage,:other)";
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
		"values (:id,:userId,:school,:major,:education)";
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

	//查询面试期员工
	@Override
	public  Grid Getmianshiqi(Staff staff, Parameter parameter)
	{
		String sql=" where (personnelstatus='0' or personnelstatus is null) ";;
				return queryStaffByStatus(staff, parameter, sql);
		
	}
	
	//获得员工标识
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
	
	

	//删除面试起员工
	@Override
	public int deletemianshiqi(String userid) {

	
		String sqlDeteStaff = "DELETE from `Staff` WHERE userId=:userId";
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userid);
		int n1=this.npJdbcTemplate.update(sqlDeteStaff, map);
		

	
		String sqlDeteUser = "DELETE from `User` WHERE userId=:userId";
		int n2=this.npJdbcTemplate.update(sqlDeteUser, map);

	
		String sqlDeteDStaffEducation = "DELETE from `DStaffEducation` WHERE userId=:userId";		
		int n3=this.npJdbcTemplate.update(sqlDeteDStaffEducation, map);
		
		
		//注意此处，可能出错。
		return 1;
	}

	//查询培训/试用期员工
	@Override
	public Grid Getpeixunshiyong(Staff staff, Parameter parameter) {
		String sql=" where (personnelstatus='1' or personnelstatus='2' or personnelstatus is null) ";;
				return queryStaffByStatus(staff, parameter, sql);
	}

	//删除培训/试用期员工
	@Override
	public int deletepeixunshiyong(String userid) {
		return this.deletemianshiqi(userid);	
	}

	//查询转正失败员工
	@Override
	public Grid Getzhuanzhengshibai(Staff staff, Parameter parameter) {
		String sql=" where (personnelstatus='4' or personnelstatus is null) ";;
				return queryStaffByStatus(staff, parameter, sql);
	}

	//删除转正失败员工
	@Override
	public int deletezhuanzhengshibai(String userid) {
		return this.deletemianshiqi(userid);	
	}
	
	



	@Override
	public Grid Getzhengshitingzhi(Staff staff, Parameter parameter) {
		String sql=" where (personnelstatus='3' or personnelstatus='5' or personnelstatus is null) ";;
				return queryStaffByStatus(staff, parameter, sql);
	}


	@Override
	public int deletezhengshitingzhi(String userid) {
		return this.deletemianshiqi(userid);
	}


	@Override
	public Grid Getlizhijiepin(Staff staff, Parameter parameter) {
		String sql=	" where (personnelstatus='6' or personnelstatus='7' or personnelstatus is null) ";;
				return queryStaffByStatus(staff, parameter, sql);
	}


	@Override
	public int deletelizhijiepin(String userid) {
		return this.deletemianshiqi(userid);
	}


	@Override
	public Grid Getyuangongshengri(Staff staff, Parameter parameter) {
		
		String sql=" where (personnelstatus!='6' and personnelstatus!='7' or personnelstatus is null) ";
		return queryStaffByStatus(staff, parameter, sql);
	}

	/**
	 * @author 鲁宗豪
	 * @datetime 2015年8月12日 下午2:27:08
	 * @param staff
	 * @param parameter
	 * @param sql
	 * @return
	 */
	private Grid queryStaffByStatus(Staff staff, Parameter parameter, String sql) {
		
		String mysql="select User.username username,User.userId userId,User.gender gender,User.tel tel,User.IDnumber IDnumber,User.nation nation,User.birthPlace birthPlace,User.birthday birthday,"
				+ "User.email email,User.politicalStatus politicalStatus,User.marriage marriage,User.other other,Staff.wage wage,Staff.personnelstatus personnelstatus,DPersonnelStatus.nameM DPersonnelStatusnameM"
				+ ",Staff.socialsecurityStatus socialsecurityStatus,Staff.laborRelations laborRelations,DLaborRelations.nameM DLaborRelationsnameM,Staff.contractStartDate contractStartDate,Staff.contractEndtDate contractEndtDate,"
				+ "Staff.confirmationdate confirmationdate,Staff.englishName englishName,Staff.trainingExperience trainingExperience,Staff.staffTag staffTag,"
				+ "Staff.wagecardName wagecardName,Staff.wagecardID wagecardID,Staff.remark remark,Staff.contractState contractState,"
				+ "DStaffEducation.education education,DStaffEducation.school school,DStaffEducation.major major"
				+ "  from User left outer join Staff on Staff.userId=User.userId left outer join DStaffEducation on User.userId=DStaffEducation.userId "
				+ " left join DPersonnelStatus on Staff.personnelstatus=DPersonnelStatus.id "
				+ "left join DLaborRelations on Staff.laborRelations=DLaborRelations.id";
		mysql+=sql;
		final List<Staff> results = new ArrayList<Staff>();
		
		if(StringUtils.isNotBlank(staff.getRemark()))
		{
		
		
		if(!StringUtils.equals("qb", staff.getContractState())||!StringUtils.equals("qb", staff.getSocialsecurityStatus())||!StringUtils.equals("qb", staff.getLaborRelations())||!StringUtils.equals("qb", staff.getStaffTag()))
		{
			if (!StringUtils.equals("qb", staff.getContractState()))
			{
				sql+=" and (contractState=:contractState or contractState is null)";			
			}
		
			
			if (!StringUtils.equals("qb", staff.getSocialsecurityStatus())) 
			{
					sql+=" and (socialsecurityStatus=:socialsecurityStatus or socialsecurityStatus is null) ";		
			}
			
			if (!StringUtils.equals("qb", staff.getLaborRelations()))
			{
					sql+=" and (laborRelations=:laborRelations  or laborRelations is null)";					
			}
		
			if (!StringUtils.equals("qb", staff.getStaffTag())) {
			
					sql+=" and (Staff.staffTag=:staffTag  or Staff.staffTag is null) ";
			}
		}
		
				switch (staff.getRemark().trim()) {
				case "1"://员工姓名排序
					sql+=" order by username";
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

	
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("socialsecurityStatus", staff.getSocialsecurityStatus());
		map.put("contractState", staff.getContractState());
		map.put("laborRelations", staff.getLaborRelations());
		map.put("staffTag", staff.getStaffTag());
		
	
		this.npJdbcTemplate.query(mysql,map, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Staff staff = new Staff();
				staff.setUserId(rs.getString("userId"));
				staff.setUsername(rs.getString("username"));
				staff.setTel(rs.getString("tel"));
				staff.setGender(rs.getString("gender"));
				staff.setIDnumber(rs.getString("IDnumber"));
				staff.setNation(rs.getString("nation"));
				staff.setBirthPlace(rs.getString("birthPlace"));
				staff.setBirthday(rs.getString("birthday"));
				staff.setEmail(rs.getString("email"));
				staff.setPoliticalStatus(rs.getString("politicalStatus"));
				staff.setMarriage(rs.getString("marriage"));
				staff.setOther(rs.getString("other"));
				staff.setWage(rs.getString("wage"));
				staff.setPersonnelstatus(rs.getString("personnelstatus"));
				staff.setDPersonnelStatusnameM(rs.getString("DPersonnelStatusnameM"));
				staff.setSocialsecurityStatus(rs.getString("socialsecurityStatus"));
				staff.setLaborRelations(rs.getString("laborRelations"));
				staff.setDLaborRelationsnameM(rs.getString("DLaborRelationsnameM"));
				staff.setContractStartDate(rs.getString("contractStartDate"));
				staff.setContractEndtDate(rs.getString("contractEndtDate"));
				staff.setConfirmationdate(rs.getString("confirmationdate"));
				staff.setEnglishName(rs.getString("englishName"));
				staff.setTrainingExperience(rs.getString("trainingExperience"));
				staff.setStaffTag(rs.getString("staffTag"));
				staff.setWagecardName(rs.getString("wagecardName"));
				staff.setWagecardID(rs.getString("wagecardID"));
				staff.setRemark(rs.getString("remark"));
				staff.setContractState(rs.getString("contractState"));
				staff.setSchool(rs.getString("school"));
				staff.setMajor(rs.getString("major"));
				staff.setEducation(rs.getString("education"));
				results.add(staff);
			}
		});
		}
		else {
			this.npJdbcTemplate.query(mysql, new RowCallbackHandler() {

				@Override
				public void processRow(ResultSet rs) throws SQLException {
					Staff staff = new Staff();
					staff.setUserId(rs.getString("userId"));
					staff.setUsername(rs.getString("username"));
					staff.setTel(rs.getString("tel"));
					staff.setGender(rs.getString("gender"));
					staff.setIDnumber(rs.getString("IDnumber"));
					staff.setNation(rs.getString("nation"));
					staff.setBirthPlace(rs.getString("birthPlace"));
					staff.setBirthday(rs.getString("birthday"));
					staff.setEmail(rs.getString("email"));
					staff.setPoliticalStatus(rs.getString("politicalStatus"));
					staff.setMarriage(rs.getString("marriage"));
					staff.setOther(rs.getString("other"));
					staff.setWage(rs.getString("wage"));
					staff.setPersonnelstatus(rs.getString("personnelstatus"));
					staff.setDPersonnelStatusnameM(rs.getString("DPersonnelStatusnameM"));
					staff.setSocialsecurityStatus(rs.getString("socialsecurityStatus"));
					staff.setLaborRelations(rs.getString("laborRelations"));
					staff.setDLaborRelationsnameM(rs.getString("DLaborRelationsnameM"));
					staff.setContractStartDate(rs.getString("contractStartDate"));
					staff.setContractEndtDate(rs.getString("contractEndtDate"));
					staff.setConfirmationdate(rs.getString("confirmationdate"));
					staff.setEnglishName(rs.getString("englishName"));
					staff.setTrainingExperience(rs.getString("trainingExperience"));
					staff.setStaffTag(rs.getString("staffTag"));
					staff.setWagecardName(rs.getString("wagecardName"));
					staff.setWagecardID(rs.getString("wagecardID"));
					staff.setRemark(rs.getString("remark"));
					staff.setContractState(rs.getString("contractState"));
					staff.setSchool(rs.getString("school"));
					staff.setMajor(rs.getString("major"));
					staff.setEducation(rs.getString("education"));
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
	public List<Dictionary> getpoliticalStatus(String type) {
		
		String sql = "select * from DPoliticalstate";
		List<Dictionary> results = this.npJdbcTemplate.query(sql,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("id"));
						dictionary.setNameM(rs.getString("nameM"));
						return dictionary;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Dictionary temp = new Dictionary();
			temp.setId("qb");
			temp.setNameM("全部政治状态");
			results.add(0, temp);
		}
		return results;		
	}


	@Override
	public List<Dictionary> getpersonnelstatus(String type){
		String sql = "select * from DPersonnelStatus";
		List<Dictionary> results = this.npJdbcTemplate.query(sql,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("id"));
						dictionary.setNameM(rs.getString("nameM"));
						return dictionary;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Dictionary temp = new Dictionary();
			temp.setId("qb");
			temp.setNameM("全部人事状态");
			results.add(0, temp);
		}
		return results;		
	}


	@Override
	public List<Dictionary> getlaborRelations(String type){
		String sql = "select * from DLaborRelations";
		List<Dictionary> results = this.npJdbcTemplate.query(sql,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("id"));
						dictionary.setNameM(rs.getString("nameM"));
						return dictionary;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Dictionary temp = new Dictionary();
			temp.setId("qb");
			temp.setNameM("全部劳动关系");
			results.add(0, temp);
		}
		return results;		
	}


	@Override
	public List<Dictionary> getsocialsecurityStatus(String type) {
		String sql = "select * from DSocialSecurityStatus";
		List<Dictionary> results = this.npJdbcTemplate.query(sql,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("id"));
						dictionary.setNameM(rs.getString("nameM"));
						return dictionary;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Dictionary temp = new Dictionary();
			temp.setId("qb");
			temp.setNameM("全部社保状态");
			results.add(0, temp);
		}
		return results;		
	}



	
}

