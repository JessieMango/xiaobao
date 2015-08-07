package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.dao.ConsultDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月6日 下午4:09:07
 */
@Repository
public class ConsultDAOImpl implements ConsultDAO {
	private Logger logger = Logger.getLogger(ConsultDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Consult> getCouncilSchools() {
		String sql = "select * from DCouncilSchool order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setCouncilSchoolCode(rs.getString("id"));
						consult.setCouncilSchool(rs.getString("nameM"));
						return consult;
					}
				});
		return results;
	}

	@Override
	public List<Consult> getWillDegree() {
		String sql = "select * from DWillDegreeCode order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setWillDegreeCode(rs.getString("id"));
						consult.setWillDegree(rs.getString("nameM"));
						return consult;
					}
				});
		return results;
	}

	@Override
	public List<Consult> getMark() {
		String sql = "select * from DMark order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setMarkCode(rs.getString("id"));
						consult.setMark(rs.getString("nameM"));
						return consult;
					}
				});
		return results;
	}

	@Override
	public List<Consult> getSellSource() {
		String sql = "select * from DSellSource order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setSellSourceCode(rs.getString("id"));
						consult.setSellSource(rs.getString("nameM"));
						return consult;
					}
				});
		return results;
	}

	@Override
	public List<Consult> getSeller() {
		String sql = "select * from DSeller order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setSellerCode(rs.getString("id"));
						consult.setSeller(rs.getString("nameM"));
						return consult;
					}
				});
		return results;
	}

	@Override
	public List<Consult> getHandler() {
		String sql = "select * from DHandler order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setHandlerCode(rs.getString("id"));
						consult.setHandler(rs.getString("nameM"));
						return consult;
					}
				});
		return results;
	}

	@Override
	public int saveConsult(Consult consult) {
		boolean result = false;
		consult.setId(UUID.randomUUID().toString()); // 设置咨询表ID
		consult.setState("0"); // 默认咨询时没有报名
		// 公立学校处理
		List<Consult> consults = getCouncilSchools();
		if (StringUtils.isNotBlank(consult.getCouncilSchoolCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getCouncilSchoolCode(),
						cs.getCouncilSchoolCode())) {
					consult.setCouncilSchoolCode(cs.getCouncilSchoolCode()); // 如果字典表中有直接把该公立学校的编码存入咨询表
					result = true;
				}
			}
			if (!result) { // 如果字典表中没有直接把该公立学校，要把该公立学校插入公立学校字典表
				consult.setCouncilSchool(consult.getCouncilSchoolCode());
				consult.setCouncilSchoolCode(UUID.randomUUID().toString());
				// 插入公立学校字典表
				String sql = "insert into DCouncilSchool(id,nameM) values(:councilSchoolCode,:councilSchool)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 标记处理
		result = false;
		consults = getMark();
		if (StringUtils.isNotBlank(consult.getMarkCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getMarkCode(), cs.getMarkCode())) {
					consult.setMarkCode(cs.getMarkCode()); // 如果字典表中有直接把该标记的编码存入咨询表
					result = true;
				}
			}
			if (!result) { // 如果字典表中没有直接把该标记，要把该标记插入标记字典表
				consult.setMark(consult.getMarkCode());
				consult.setMarkCode(UUID.randomUUID().toString());
				String sql = "insert into DMark(id,nameM) values(:markCode,:mark)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 销售来源处理
		result = false;
		consults = getSellSource();
		if (StringUtils.isNotBlank(consult.getSellSourceCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getSellSourceCode(),
						cs.getSellSourceCode())) {
					consult.setSellSourceCode(cs.getSellSourceCode()); // 如果字典表中有直接把该销售来源的编码存入咨询表
					result = true;
				}
			}
			if (!result) { // 如果字典表中没有直接把该销售来源，要把该销售来源插入销售来源字典表
				consult.setSellSource(consult.getSellSourceCode());
				consult.setSellSourceCode(UUID.randomUUID().toString());
				String sql = "insert into DSellSource(id,nameM) values(:sellSourceCode,:sellSource)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 销售员处理
		result = false;
		consults = getSeller();
		if (StringUtils.isNotBlank(consult.getSellerCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getSellerCode(), cs.getSellerCode())) {
					consult.setSellerCode(cs.getSellerCode());
					result = true;
				}
			}
			if (!result) {
				consult.setSeller(consult.getSellerCode());
				consult.setSellerCode(UUID.randomUUID().toString());
				String sql = "insert into DSeller(id,nameM) values(:sellerCode,:seller)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 经办人处理
		result = false;
		consults = getHandler();
		if (StringUtils.isNotBlank(consult.getHandlerCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getHandlerCode(),
						cs.getHandlerCode())) {
					consult.setHandlerCode(cs.getHandlerCode());
					result = true;
				}
			}
			if (!result) {
				consult.setHandler(consult.getHandler());
				consult.setHandlerCode(consult.getHandlerCode());
				String sql = "insert into DHandler(id,nameM) values(:handlerCode,:handler)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 插入咨询表
		String sql = "insert into Consult(id,nameM,gender,consultDate,birthday,motherTel,fatherTel,otherTel,councilSchoolCode,"
				+ "class_grade,liveArea,others,consultWayCode,consultCourseCode,consultContent,willDegreeCode,sellSource,seller,"
				+ "handleSchoolCode,handler,mark,state) values(:id,:nameM,:gender,:consultDate,:birthday,:motherTel,:fatherTel,:otherTel,"
				+ ":councilSchoolCode,:class_grade,:liveArea,:others,:consultWayCode,:consultCourseCode,:consultContent,:willDegreeCode,"
				+ ":sellSourceCode,:sellerCode,:handleSchoolCode,:handlerCode,:markCode,:state)";
		SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
				consult);

		return this.nJdbcTemplate.update(sql, consultParameterSource);
	}

}
