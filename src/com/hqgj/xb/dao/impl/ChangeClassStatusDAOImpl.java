package com.hqgj.xb.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.dao.ChangeClassStatusDAO;
import com.hqgj.xb.util.CommonUtil;

/**
 * @author 崔兴伟
 * @datetime 2015年9月18日 上午9:26:05
 */
@Repository
public class ChangeClassStatusDAOImpl implements ChangeClassStatusDAO {

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void changeClassStatus() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("currentDate", CommonUtil.getSystemDate());
		this.nJdbcTemplate
				.update("update Class set classState=1 where :currentDate between startDate and endDate",
						map); // 改为状态上课中
		this.nJdbcTemplate.update(
				"update Class set classState=2 where :currentDate > endDate",
				map); // 改为状态已结课

	}

}
