package com.hqgj.xb.dao.impl;

import java.util.UUID;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.SystemLog;
import com.hqgj.xb.dao.SystemLogDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 下午4:12:50
 */
@Repository
public class SystemLogDAOImpl implements SystemLogDAO {
	private static final Logger logger = Logger
			.getLogger(SystemLogDAOImpl.class);

	private NamedParameterJdbcTemplate npJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int writeLog(SystemLog log) {
		log.setId(UUID.randomUUID().toString());
		String sql = "insert into SystemLog(id,operateTime,username,operateType,message) values (:id,:operateTime,:username,:operateType,:message)";
		SqlParameterSource logParameterSource = new BeanPropertySqlParameterSource(
				log);
		return this.npJdbcTemplate.update(sql, logParameterSource);
	}

}
