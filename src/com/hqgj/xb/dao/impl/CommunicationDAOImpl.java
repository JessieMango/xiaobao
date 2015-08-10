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
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.CommunicationDAO;
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
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Grid getCommunications(Communication communication,
			Parameter parameter) {
		String select = "select c.id,c.consultId,c.communicationType,c.communicationDate,c.communicationContent,c.communicationResult,"
				+ "c.returnVisitDate,c.isRemind,ct.nameM communicationTypeName,ct.type from Communication c "
				+ "left outer join CommunicationType ct on c.consultId=ct.id ";

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
						communication.setConsultId(rs.getString(rs
								.getString("consultId")));
						communication.setId(rs.getString("id"));
						communication.setIsRemind(rs.getString("isRemind"));
						communication.setReturnVisitDate(rs
								.getString("returnVisitDate"));
						communication.setType(rs.getString("type"));
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
				+ "c.returnVisitDate,c.isRemind,ct.nameM communicationTypeName,ct.type from Communication c "
				+ "left outer join CommunicationType ct on c.consultId=ct.id where c.id=:id";

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
						communication.setConsultId(rs.getString(rs
								.getString("consultId")));
						communication.setId(rs.getString("id"));
						communication.setIsRemind(rs.getString("isRemind"));
						communication.setReturnVisitDate(rs
								.getString("returnVisitDate"));
						communication.setType(rs.getString("type"));
						return communication;
					}
				});
		return result;
	}

	@Override
	public List<Communication> getCommunicationByConsultId(String id) {
		String sql = "select c.id,c.consultId,c.communicationType,c.communicationDate,c.communicationContent,c.communicationResult,"
				+ "c.returnVisitDate,c.isRemind,ct.nameM communicationTypeName,ct.type from Communication c "
				+ "left outer join CommunicationType ct on c.consultId=ct.id where c.consultId=:id ";
		List<Communication> results = this.nJdbcTemplate.query(sql,
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
						communication.setConsultId(rs.getString(rs
								.getString("consultId")));
						communication.setId(rs.getString("id"));
						communication.setIsRemind(rs.getString("isRemind"));
						communication.setReturnVisitDate(rs
								.getString("returnVisitDate"));
						communication.setType(rs.getString("type"));
						return communication;
					}
				});
		return results;
	}

	@Override
	public int addCommunication(Communication communication) {
		if(StringUtils.isBlank(communication.getIsRemind())){
			communication.setIsRemind("0");
		}
		communication.setId(UUID.randomUUID().toString());
		SqlParameterSource communicationParameterSource = new BeanPropertySqlParameterSource(
				communication);
		String sql = "insert into Communication(id,consultId,communicationType,communicationDate,communicationContent,communicationResult,"
				+ "returnVisitDate,isRemind,handleSchoolCode) values (:id,:consultId,:communicationType,:communicationDate,:communicationContent,:communicationResult,:returnVisitDate,:isRemind,:handleSchoolCode)";
		return this.nJdbcTemplate.update(sql, communicationParameterSource);
	}

	@Override
	public int updateCommunication(Communication communication) {
		SqlParameterSource communicationParameterSource = new BeanPropertySqlParameterSource(
				communication);
		String sql = "update Communication set consultId=:consultId,set communicationType=:communicationType,set communicationDate=:communicationDate,set communicationContent=:communicationContent,"
				+ "set communicationResult=:communicationResult,set returnVisitDate=:returnVisitDate,set handleSchoolCode=:handleSchoolCode,set isRemind=:isRemind where id=:id";
		return this.nJdbcTemplate.update(sql, communicationParameterSource);
	}

	@Override
	public int deleteCommunicationById(String id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		String sql = "delete from Communication where id=:id";
		return this.nJdbcTemplate.update(sql, map);
	}

}
