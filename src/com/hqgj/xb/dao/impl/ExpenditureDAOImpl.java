package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.Expenditure;
import com.hqgj.xb.dao.ExpenditureDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 上午11:14:11
 */
@Repository
public class ExpenditureDAOImpl implements ExpenditureDAO {
	private Logger logger = Logger.getLogger(ExpenditureDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Expenditure> getAllExpenditureProjects() {
		String sql = "select ep.id,ep.epCode expenditureCode,ep.seq expenditureProjectSeq,ep.nameM expenditureProjectName,e.nameM expenditureName,e.seq expenditureSeq "
				+ "from ExpenditureProject ep left outer join Expenditure e on e.code=ep.epCode order by ep.epCode,ep.id";
		List<Expenditure> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Expenditure>() {
					@Override
					public Expenditure mapRow(ResultSet rs, int index)
							throws SQLException {
						Expenditure expenditure = new Expenditure();
						expenditure.setId(rs.getString("id"));
						expenditure.setExpenditureCode(rs
								.getString("expenditureCode"));
						expenditure.setExpenditureProjectSeq(rs
								.getString("expenditureProjectSeq"));
						expenditure.setExpenditureProjectName(rs
								.getString("expenditureProjectName"));
						expenditure.setExpenditureName(rs
								.getString("expenditureName"));
						expenditure.setExpenditureSeq(rs
								.getString("expenditureSeq"));
						return expenditure;
					}
				});
		return results;
	}

	@Override
	public Expenditure getExpenditure(String code) {
		String sql = "select * from Expenditure where code=:code ";

		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		final Expenditure result = this.nJdbcTemplate.queryForObject(sql, map,
				new RowMapper<Expenditure>() {
					@Override
					public Expenditure mapRow(ResultSet rs, int index)
							throws SQLException {
						Expenditure expenditure = new Expenditure();
						expenditure.setExpenditureName(rs.getString("nameM"));
						expenditure.setExpenditureSeq(rs.getString("seq"));
						return expenditure;
					}
				});
		return result;
	}

	@Override
	public Expenditure getExpenditureProject(String id) {
		String sql = "select ep.epCode expenditureCode,ep.seq expenditureProjectSeq,ep.nameM expenditureProjectName from ExpenditureProject ep where ep.id=:id ";

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		final Expenditure result = this.nJdbcTemplate.queryForObject(sql, map,
				new RowMapper<Expenditure>() {
					@Override
					public Expenditure mapRow(ResultSet rs, int index)
							throws SQLException {
						Expenditure expenditure = new Expenditure();
						expenditure.setExpenditureCode(rs
								.getString("expenditureCode"));
						expenditure.setExpenditureProjectSeq(rs
								.getString("expenditureProjectSeq"));
						expenditure.setExpenditureProjectName(rs
								.getString("expenditureProjectName"));
						return expenditure;
					}
				});
		return result;
		
	}

	@Override
	public List<Expenditure> getAllExpenditures() {
		
		String sql = "select * from Expenditure";
		List<Expenditure> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Expenditure>() {
					@Override
					public Expenditure mapRow(ResultSet rs, int index)
							throws SQLException {
						Expenditure expenditure = new Expenditure();
						expenditure.setExpenditureCode(rs.getString("code"));
						expenditure.setExpenditureName(rs.getString("nameM"));
						expenditure.setExpenditureSeq(rs.getString("seq"));
						return expenditure;
					}
				});
		return results;
	}

	@Override
	public int addExpenditure(Expenditure expenditure) {
		expenditure.setExpenditureCode(UUID.randomUUID().toString());
		String sql = "insert into Expenditure(code,nameM,seq) values(:expenditureCode,:expenditureName,:expenditureSeq)";
		SqlParameterSource expenditureParameterSource = new BeanPropertySqlParameterSource(
				expenditure);
		return this.nJdbcTemplate.update(sql, expenditureParameterSource);
	}

	@Override
	public int addExpenditureProject(Expenditure expenditure) {
		expenditure.setId(UUID.randomUUID().toString());
		String sql = "insert into ExpenditureProject(id,epCode,nameM,seq) values(:id,:expenditureCode,:expenditureProjectName,:expenditureProjectSeq)";
		SqlParameterSource expenditureParameterSource = new BeanPropertySqlParameterSource(
				expenditure);
		return this.nJdbcTemplate.update(sql, expenditureParameterSource);
	}

	@Override
	public int updateExpenditure(Expenditure expenditure) {
		String sql = "update Expenditure set nameM=:expenditureName,seq=:expenditureSeq where code=:expenditureCode";
		SqlParameterSource expenditureParameterSource = new BeanPropertySqlParameterSource(
				expenditure);
		return this.nJdbcTemplate.update(sql, expenditureParameterSource);
	}

	@Override
	public int updateExpenditureProject(Expenditure expenditure) {
		String sql = "update ExpenditureProject set nameM=:expenditureProjectName,seq=:expenditureProjectSeq,epCode=:expenditureCode where id=:id";
		SqlParameterSource expenditureParameterSource = new BeanPropertySqlParameterSource(
				expenditure);
		return this.nJdbcTemplate.update(sql, expenditureParameterSource);
	}

	@Override
	public int deleteExpenditure(String code) {
		String sql = "delete from Expenditure where code=:code";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("code", code);
		return this.nJdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int deleteExpenditureProject(String id) {
		String sql = "delete from ExpenditureProject where id=:id";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		return this.nJdbcTemplate.update(sql, paramMap);
	}

}
