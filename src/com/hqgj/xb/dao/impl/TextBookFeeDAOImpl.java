package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.TextBookFee;
import com.hqgj.xb.dao.TextBookFeeDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 下午5:47:00
 */
@Repository
public class TextBookFeeDAOImpl implements TextBookFeeDAO {
	private Logger logger = Logger.getLogger(TextBookFeeDAOImpl.class);
	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<TextBookFee> getAllTextBookFees(String type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		String sql = "select t.id id,t.courseTypeCode courseTypeCode,t.seq,t.nameM,t.price,t.points,t.type,ct.nameM courseTypeName,t.isEnableExchange isEnableExchange from TextBookFee t "
				+ "left outer join CourseType ct on ct.courseTypeCode=t.courseTypeCode where t.type=:type";
		List<TextBookFee> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setCourseTypeCode(rs
								.getString("courseTypeCode"));
						textBookFee.setCourseTypeName(rs
								.getString("courseTypeName"));
						textBookFee.setId(rs.getString("id"));
						textBookFee.setNameM(rs.getString("nameM"));
						textBookFee.setPoints(rs.getString("points"));
						textBookFee.setPrice(rs.getString("price"));
						textBookFee.setSeq(rs.getString("seq"));
						textBookFee.setType(rs.getString("type"));
						textBookFee.setIsEnableExchange(rs
								.getString("isEnableExchange"));
						return textBookFee;
					}
				});
		return results;
	}

	@Override
	public List<TextBookFee> getDTextBookFeesType() {
		String sql = "select *  from DTextBookFee ";
		List<TextBookFee> results = this.nJdbcTemplate.query(sql,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setType(rs.getString("code"));
						textBookFee.setDnameM(rs.getString("nameM"));
						return textBookFee;
					}
				});
		return results;
	}

	@Override
	public TextBookFee getTextBookFee(String id) {
		String sql = "select t.courseTypeCode courseTypeCode,t.seq,t.nameM,t.price,t.points,t.type,ct.nameM courseTypeName,t.isEnableExchange isEnableExchange from TextBookFee t "
				+ "left outer join CourseType ct on ct.courseTypeCode=t.courseTypeCode where t.id=:id ";

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		final TextBookFee result = this.nJdbcTemplate.queryForObject(sql, map,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setCourseTypeCode(rs
								.getString("courseTypeCode"));
						textBookFee.setNameM(rs.getString("nameM"));
						textBookFee.setPoints(rs.getString("points"));
						textBookFee.setPrice(rs.getString("price"));
						textBookFee.setSeq(rs.getString("seq"));
						textBookFee.setType(rs.getString("type"));
						textBookFee.setIsEnableExchange(rs
								.getString("isEnableExchange"));
						return textBookFee;
					}
				});
		return result;
	}

	@Override
	public int updateTextBookFee(TextBookFee textBookFee) {
		if (!StringUtils.isNotEmpty(textBookFee.getIsEnableExchange())) {
			textBookFee.setIsEnableExchange("0");
		}
		String sql = "update TextBookFee set courseTypeCode=:courseTypeCode,seq=:seq,nameM=:nameM,price=:price,points=:points,type=:type,isEnableExchange=:isEnableExchange where id=:id";
		SqlParameterSource textBookFeeParameterSource = new BeanPropertySqlParameterSource(
				textBookFee);
		return this.nJdbcTemplate.update(sql, textBookFeeParameterSource);
	}

	@Override
	public int deleteTextBookFee(String id) {
		String sql = "delete from TextBookFee where id=:code";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("code", id);
		return this.nJdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int addTextBookFee(TextBookFee textBookFee) {
		textBookFee.setId(UUID.randomUUID().toString());
		if (!StringUtils.isNotEmpty(textBookFee.getIsEnableExchange())) {
			textBookFee.setIsEnableExchange("0");
		}
		String sql = "insert into TextBookFee(id,courseTypeCode,seq,nameM,price,points,type,isEnableExchange) values (:id,:courseTypeCode,:seq,:nameM,:price,:points,:type,:isEnableExchange)";

		SqlParameterSource textBookFeeParameterSource = new BeanPropertySqlParameterSource(
				textBookFee);
		return this.nJdbcTemplate.update(sql, textBookFeeParameterSource);
	}

	@Override
	public List<TextBookFee> getTextBookFeesByCourseType(String courseTypeCode,
			String type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("courseTypeCode", courseTypeCode);
		String sql = "select t.id id,t.courseTypeCode courseTypeCode,t.seq,t.nameM,t.price,t.points,t.type,ct.nameM courseTypeName,t.isEnableExchange isEnableExchange from TextBookFee t "
				+ "left outer join CourseType ct on ct.courseTypeCode=t.courseTypeCode where t.courseTypeCode=:courseTypeCode ";
		if (StringUtils.equals(type, "1")) {
			sql += " and t.type=1 ";
		}
		if (StringUtils.equals(type, "2")) {
			sql += " and t.type=2 ";
		}
		List<TextBookFee> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setCourseTypeCode(rs
								.getString("courseTypeCode"));
						textBookFee.setCourseTypeName(rs
								.getString("courseTypeName"));
						textBookFee.setId(rs.getString("id"));
						textBookFee.setNameM(rs.getString("nameM"));
						textBookFee.setPoints(rs.getString("points"));
						textBookFee.setPrice(rs.getString("price"));
						textBookFee.setSeq(rs.getString("seq"));
						textBookFee.setType(rs.getString("type"));
						textBookFee.setIsEnableExchange(rs
								.getString("isEnableExchange"));
						return textBookFee;
					}
				});
		return results;
	}

}
