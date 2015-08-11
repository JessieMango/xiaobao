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

import com.hqgj.xb.bean.Communication;
import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.CommunicationDAO;
import com.hqgj.xb.dao.ConsultDAO;
import com.hqgj.xb.util.StringUtil;

/**
 * @author 崔兴伟
 * @datetime 2015年8月10日 上午9:44:59
 */
@Repository
public class CommunicationDAOImpl implements CommunicationDAO {
	private Logger logger = Logger.getLogger(CommunicationDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	private ConsultDAO consultDAO;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Grid getCommunications(Communication communication,
			Parameter parameter) {
		String select = "select c.id,c.consultId,c.communicationType,c.communicationDate,c.communicationContent,c.communicationResult,"
				+ "c.returnVisitDate,c.isRemind,ct.nameM communicationTypeName,ct.type,co.nameM,co.gender,co.otherTel,c.handlerCode,dh.nameM handler,c.handleSchoolCode,s.schoolName handleSchool from Communication c "
				+ "left outer join CommunicationType ct on c.communicationType=ct.id left outer join Consult co on co.id=c.consultId "
				+ "left outer join School s on s.schoolCode=c.handleSchoolCode left outer join DHandler dh on dh.id=c.handlerCode ";

		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				communication);
		final List<Communication> results = new ArrayList<Communication>();
		this.nJdbcTemplate.query(select, namedParameters,
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Communication communication = new Communication();
						communication.setCommunicationContent(rs
								.getString("communicationContent"));
						communication.setCommunicationDate(rs
								.getString("communicationDate"));
						communication.setCommunicationResult(rs
								.getString("communicationResult"));
						communication.setCommunicationType(rs
								.getString("communicationType"));
						communication.setCommunicationTypeName(rs
								.getString("communicationTypeName"));
						communication.setConsultId(rs.getString("consultId"));
						communication.setId(rs.getString("id"));
						communication.setIsRemind(rs.getString("isRemind"));
						communication.setReturnVisitDate(rs
								.getString("returnVisitDate"));
						communication.setType(rs.getString("type"));
						communication.setOtherTel(rs.getString("otherTel"));
						communication.setGender(rs.getString("gender"));
						communication.setNameM(rs.getString("nameM"));
						communication.setHandler(rs.getString("handler"));
						communication.setHandlerCode(rs
								.getString("handlerCode"));
						communication.setHandleSchool(rs
								.getString("handleSchool"));
						communication.setHandleSchoolCode(rs
								.getString("handleSchoolCode"));
						results.add(communication);
					}
				});
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
	public Communication getCommunicationById(String id) {
		String sql = "select c.id,c.consultId,c.communicationType,c.communicationDate,c.communicationContent,c.communicationResult,"
				+ "c.returnVisitDate,c.isRemind,ct.nameM communicationTypeName,ct.type,c.handleSchoolCode from Communication c "
				+ "left outer join CommunicationType ct on c.communicationType=ct.id where c.id=:id";

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		final Communication result = this.nJdbcTemplate.queryForObject(sql,
				map, new RowMapper<Communication>() {
					@Override
					public Communication mapRow(ResultSet rs, int index)
							throws SQLException {
						Communication communication = new Communication();
						communication.setCommunicationContent(rs
								.getString("communicationContent"));
						communication.setCommunicationDate(rs
								.getString("communicationDate"));
						communication.setCommunicationResult(rs
								.getString("communicationResult"));
						communication.setCommunicationType(rs
								.getString("communicationType"));
						communication.setCommunicationTypeName(rs
								.getString("communicationTypeName"));
						communication.setConsultId(rs.getString("consultId"));
						communication.setId(rs.getString("id"));
						communication.setIsRemind(rs.getString("isRemind"));
						communication.setReturnVisitDate(rs
								.getString("returnVisitDate"));
						communication.setType(rs.getString("type"));
						communication.setHandleSchoolCode(rs
								.getString("handleSchoolCode"));
						return communication;
					}
				});
		return result;
	}

	@Override
	public List<Communication> getCommunicationByConsultId(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		String sql = "select c.id,c.consultId,c.communicationType,c.communicationDate,c.communicationContent,c.communicationResult,"
				+ "c.returnVisitDate,c.isRemind,ct.nameM communicationTypeName,ct.type,c.handlerCode,dh.nameM handler from Communication c "
				+ "left outer join CommunicationType ct on c.communicationType=ct.id left outer join DHandler dh on dh.id=c.handlerCode where c.consultId=:id ";
		List<Communication> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<Communication>() {
					@Override
					public Communication mapRow(ResultSet rs, int index)
							throws SQLException {
						Communication communication = new Communication();
						communication.setCommunicationContent(rs
								.getString("communicationContent"));
						communication.setCommunicationDate(rs
								.getString("communicationDate"));
						communication.setCommunicationResult(rs
								.getString("communicationResult"));
						communication.setCommunicationType(rs
								.getString("communicationType"));
						communication.setCommunicationTypeName(rs
								.getString("communicationTypeName"));
						communication.setId(rs.getString("id"));
						communication.setIsRemind(rs.getString("isRemind"));
						communication.setReturnVisitDate(rs
								.getString("returnVisitDate"));
						communication.setHandler(rs.getString("handler"));
						communication.setHandlerCode(rs
								.getString("handlerCode"));
						communication.setType(rs.getString("type"));
						return communication;
					}
				});
		return results;
	}

	@Override
	public int addCommunication(Communication communication) {
		if (StringUtils.isBlank(communication.getIsRemind())) {
			communication.setIsRemind("0");
		}
		communication.setId(UUID.randomUUID().toString());

		// 经办人处理
		boolean result = false;
		Consult consult = new Consult();
		List<Consult> consults = consultDAO.getHandler(null);
		if (StringUtils.isNotBlank(communication.getHandlerCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(communication.getHandlerCode(),
						cs.getHandlerCode())) {
					communication.setHandlerCode(cs.getHandlerCode());
					result = true;
				}
			}
			if (!result) {
				consult.setHandler(communication.getHandler());
				consult.setHandlerCode(communication.getHandlerCode());
				String sql = "insert into DHandler(id,nameM) values(:handlerCode,:handler)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		SqlParameterSource communicationParameterSource = new BeanPropertySqlParameterSource(
				communication);
		String sql = "insert into Communication(id,consultId,communicationType,communicationDate,communicationContent,communicationResult,"
				+ "returnVisitDate,isRemind,handleSchoolCode,handlerCode) values (:id,:consultId,:communicationType,:communicationDate,:communicationContent,:communicationResult,:returnVisitDate,:isRemind,:handleSchoolCode,:handlerCode)";
		return this.nJdbcTemplate.update(sql, communicationParameterSource);
	}

	@Override
	public int updateCommunication(Communication communication) {

		// 经办人处理
		boolean result = false;
		Consult consult = new Consult();
		List<Consult> consults = consultDAO.getHandler(null);
		if (StringUtils.isNotBlank(communication.getHandlerCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(communication.getHandlerCode(),
						cs.getHandlerCode())) {
					communication.setHandlerCode(cs.getHandlerCode());
					result = true;
				}
			}
			if (!result) {
				consult.setHandler(communication.getHandler());
				consult.setHandlerCode(communication.getHandlerCode());
				String sql = "insert into DHandler(id,nameM) values(:handlerCode,:handler)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		SqlParameterSource communicationParameterSource = new BeanPropertySqlParameterSource(
				communication);
		String sql = "update Communication set communicationType=:communicationType,communicationDate=:communicationDate,communicationContent=:communicationContent,"
				+ "communicationResult=:communicationResult,returnVisitDate=:returnVisitDate,handlerCode=:handlerCode,handleSchoolCode=:handleSchoolCode,isRemind=:isRemind where id=:id";
		return this.nJdbcTemplate.update(sql, communicationParameterSource);
	}

	@Override
	public int deleteCommunicationById(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		String sql = "delete from Communication where id=:id";
		return this.nJdbcTemplate.update(sql, map);
	}

	@Override
	public List<Communication> getCommunicationType(String type, String flag) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		String sql = "select * from CommunicationType where type=:type";
		final List<Communication> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<Communication>() {
					@Override
					public Communication mapRow(ResultSet rs, int index)
							throws SQLException {
						Communication communication = new Communication();
						communication.setCommunicationType(rs.getString("id"));
						communication.setCommunicationTypeName(rs
								.getString("nameM"));
						return communication;
					}
				});
		if (StringUtils.equals(flag, "select")) {
			Communication temp = new Communication();
			temp.setCommunicationType("qb");
			temp.setCommunicationTypeName("全部类型");
			results.add(0, temp);
		}
		return results;
	}

}
