package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
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

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<ClassS> getClassRooms(String type) {
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
		if (StringUtils.equals(type, "1")) {
			ClassS cc = new ClassS();
			cc.setClassRoomCode("qb");
			cc.setClassRoomName("全部教室");
			results.add(0, cc);
		}
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
