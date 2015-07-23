package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.User;
import com.hqgj.xb.dao.UserDao;

/**
 * @author 崔兴伟
 * @datetime 2015年7月7日 下午3:27:27
 */
@Repository
public class UserDaoImpl implements UserDao {
	private Logger logger = Logger.getLogger(UserDaoImpl.class);
	private NamedParameterJdbcTemplate npJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<User> login(User user) {
		String sql = "select u.age,u.carCode,u.createTime,u.gender,u.isEnabled,u.loginDate,u.loginEndTime,"
				+ "u.loginStartTime,u.`password`,u.photo,u.school,u.tel,u.updateTime,u.userId,u.username,r.nameM,ur.scope  "
				+ "from user u LEFT OUTER JOIN user_role ur on u.userId=ur.user_id  "
				+ "left OUTER JOIN role r on ur.role_id=r.id  where u.username= :username ";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				user);
		final List<User> results = new ArrayList<User>();
		this.npJdbcTemplate.query(sql, namedParameters,
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						User user = new User();
						user.setAge(Integer.parseInt(rs.getString("age")));
						user.setCarCode(rs.getString("carCode"));
						user.setCreatetime(rs.getString("createTime"));
						user.setGender(rs.getString("gender"));
						user.setIsEnabled(rs.getString("isEnabled"));
						user.setLoginDate(rs.getString("loginDate"));
						user.setLoginEndTime(rs.getString("loginEndTime"));
						user.setLoginStartTime(rs.getString("loginStartTime"));
						user.setPassword(rs.getString("password"));
						user.setPhoto(rs.getString("photo"));
						user.setSchool(rs.getString("school"));
						user.setTel(rs.getString("tel"));
						user.setUpdatetime(rs.getString("updateTime"));
						user.setUserId(rs.getString("userId"));
						user.setUsername(rs.getString("username"));
						user.setPower(rs.getString("nameM"));
						user.setScope(rs.getString("scope"));
						results.add(user);
					}
				});
		logger.info(results.size());
		return results;
	}

}
