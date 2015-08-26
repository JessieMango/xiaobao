package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.School;
import com.hqgj.xb.dao.SchoolDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月1日 下午4:26:47
 */
@Repository
public class SchoolDAOImpl implements SchoolDAO {
	private static final Logger logger = Logger.getLogger(SchoolDAOImpl.class);

	private NamedParameterJdbcTemplate npJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<School> getAllSchools(String type) {
		String sql = "select * from School s left outer join SchoolType st on st.code=s.schoolType where s.flag=1 ";
		if (StringUtils.isBlank(type)) {
			sql += " and s.schoolCode<>'qb' ";
		}
		sql += " order by s.seq";
		List<School> results = this.npJdbcTemplate.query(sql,
				new RowMapper<School>() {
					@Override
					public School mapRow(ResultSet rs, int index)
							throws SQLException {
						School school = new School();
						school.setAddress(rs.getString("address"));
						school.setFlag(rs.getString("flag"));
						school.setSchoolCode(rs.getString("schoolCode"));
						school.setSchoolName(rs.getString("schoolName"));
						school.setSchoolType(rs.getString("nameM"));
						school.setSchoolTypeCode(rs.getString("code"));
						school.setSeq(rs.getString("seq"));
						school.setTel1(rs.getString("tel1"));
						school.setTel2(rs.getString("tel2"));
						return school;
					}
				});
		return results;
	}

	@Override
	public List<School> getSchoolType() {
		String sql = "select * from SchoolType  ";
		List<School> results = this.npJdbcTemplate.query(sql,
				new RowMapper<School>() {
					@Override
					public School mapRow(ResultSet rs, int index)
							throws SQLException {
						School school = new School();
						school.setSchoolType(rs.getString("nameM"));
						school.setSchoolTypeCode(rs.getString("code"));
						return school;
					}
				});
		return results;
	}

	@Override
	public int updateSchoolBySchoolCode(School school) {
		String sql = "update School set schoolName=:schoolName,schoolType=:schoolType,tel1=:tel1,tel2=:tel2,address=:address,seq=:seq where schoolCode=:schoolCode";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(
				school);
		return this.npJdbcTemplate.update(sql, paramSource);
	}

	@Override
	public int deleteSchoolBySchoolCode(School school) {
		String sql = "update School set flag=0 where schoolCode=:schoolCode";
		Map<String, String> map = new HashMap<String, String>();
		map.put("schoolCode", school.getSchoolCode());
		return this.npJdbcTemplate.update(sql, map);
	}

	@Override
	public School getSchoolById(String schoolCode) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("schoolCode", schoolCode);
		String sql = "select * from School s left outer join SchoolType st on st.code=s.schoolType where s.flag=1 and schoolCode=:schoolCode";
		final School result = this.npJdbcTemplate.queryForObject(sql, paramMap,
				new RowMapper<School>() {
					@Override
					public School mapRow(ResultSet rs, int index)
							throws SQLException {
						School school = new School();
						school.setAddress(rs.getString("address"));
						school.setFlag(rs.getString("flag"));
						school.setSchoolCode(rs.getString("schoolCode"));
						school.setSchoolName(rs.getString("schoolName"));
						school.setSchoolType(rs.getString("nameM"));
						school.setSchoolTypeCode(rs.getString("code"));
						school.setSeq(rs.getString("seq"));
						school.setTel1(rs.getString("tel1"));
						school.setTel2(rs.getString("tel2"));
						return school;
					}
				});
		return result;
	}

}
