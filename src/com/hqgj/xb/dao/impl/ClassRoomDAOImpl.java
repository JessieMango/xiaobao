package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.dao.ClassRoomDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月14日 上午9:59:49
 */
@Repository
public class ClassRoomDAOImpl implements ClassRoomDAO {
	private Logger logger = Logger.getLogger(ClassRoomDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<ClassS> getClassRooms() {
		Map<String, String> map = new HashMap<String, String>();
		String sql = "select * from ClassRoom";
		List<ClassS> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<ClassS>() {
					@Override
					public ClassS mapRow(ResultSet rs, int index)
							throws SQLException {
						ClassS classS = new ClassS();
						classS.setClassRoomCode(rs.getString("classRoomCode"));
						classS.setClassRoomName(rs.getString("classRoomName"));
						return classS;
					}
				});
		return results;
	}

	@Override
	public int addClassRoom(ClassS classS) {
		String sql = "insert into ClassRoom(classRoomCode,classRoomName) values (:classRoomCode,:classRoomName)";
		SqlParameterSource nParameterSource = new BeanPropertySqlParameterSource(
				classS);
		return this.nJdbcTemplate.update(sql, nParameterSource);
	}

}
