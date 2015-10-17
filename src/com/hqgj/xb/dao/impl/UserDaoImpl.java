package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.UserPermission;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.UserDao;
import com.hqgj.xb.util.MD5Util;

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
				+ "u.loginStartTime,u.`password`,u.photo,u.school,u.tel,u.updateTime,u.userId,u.username,r.nameM,ur.scope,ur.role_id  "
				+ "from User u LEFT OUTER JOIN User_Role ur on u.userId=ur.user_id  "
				+ "left OUTER JOIN Role r on ur.role_id=r.id  where u.username= :username ";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				user);
		final List<User> results = new ArrayList<User>();
		this.npJdbcTemplate.query(sql, namedParameters,
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						User user = new User();
						if (rs.getString("age") != null) {
							user.setAge(Integer.parseInt(rs.getString("age")));
						}
						user.setCarCode(rs.getString("carCode"));
						user.setCreateTime(rs.getString("createTime"));
						user.setGender(rs.getString("gender"));
						user.setIsEnabled(rs.getString("isEnabled"));
						user.setLoginDate(rs.getString("loginDate"));
						user.setLoginEndTime(rs.getString("loginEndTime"));
						user.setLoginStartTime(rs.getString("loginStartTime"));
						user.setPassword(rs.getString("password"));
						user.setPhoto(rs.getString("photo"));
						user.setSchool(rs.getString("school"));
						user.setTel(rs.getString("tel"));
						user.setUpdateTime(rs.getString("updateTime"));
						user.setUserId(rs.getString("userId"));
						user.setUsername(rs.getString("username"));
						user.setPower(rs.getString("nameM"));
						user.setScope(rs.getString("scope"));
						user.setRoleId(rs.getString("role_id"));
						results.add(user);
					}
				});
		return results;
	}

	@Override
	public Grid getAllUsers(Parameter parameter) {
		String sql = "SELECT u.gender,u.username,ur.scope,r.nameM,u.isEnabled,u.tel,u.loginDate,u.loginStartTime,	"
				+ "u.loginEndTime,u.carCode,u.permission,u.userId,ur.role_id	FROM `User` u LEFT OUTER JOIN User_Role ur on ur.user_id=u.userId	LEFT OUTER JOIN Role r on r.id=ur.role_id	 ";
		String sqlUserPermissions = "select up.user_id,p.name  from User_Permission up left outer join Permission p on p.id=up.permission_id order by up.user_id";

		logger.info("islogin:" + parameter.getIslogin());
		if (StringUtils.equals("1", parameter.getIslogin())) {
			sql += " where u.islogin=1 ";
		}
		final List<UserPermission> userPermissions = new ArrayList<UserPermission>();
		final List<UserPermission> userPermissionsAfters = new ArrayList<UserPermission>(); // 整理后的user_id->permission
		this.npJdbcTemplate.query(sqlUserPermissions, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				UserPermission userPermission = new UserPermission();
				userPermission.setPermission_id(rs.getString("name"));
				userPermission.setUserId(rs.getString("user_id"));
				userPermissions.add(userPermission);
			}
		});

		// 把每个人权限转换成[userId,[permission1,permission2...]]这种形式
		String first = "", last = "";
		UserPermission temp = new UserPermission();
		for (UserPermission userPermission : userPermissions) {
			first = userPermission.getUserId();
			if (StringUtils.equals(first, last)) {
				temp.setPermission_id(temp.getPermission_id() + ","
						+ userPermission.getPermission_id());
			} else {
				if (StringUtils.isNotBlank(last)) {
					userPermissionsAfters.add(temp);
				}
				temp = new UserPermission();
				temp.setUserId(userPermission.getUserId());
				temp.setPermission_id(userPermission.getPermission_id());
			}
			last = userPermission.getUserId();
		}
		userPermissionsAfters.add(temp);

		final List<User> results = new ArrayList<User>();
		this.npJdbcTemplate.query(sql, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				User user = new User();
				user.setCarCode(rs.getString("carCode"));
				user.setGender(rs.getString("gender"));
				user.setIsEnabled(rs.getString("isEnabled"));
				user.setLoginDate(rs.getString("loginDate"));
				user.setLoginEndTime(rs.getString("loginEndTime"));
				user.setLoginStartTime(rs.getString("loginStartTime"));
				user.setTel(rs.getString("tel"));
				user.setUsername(rs.getString("username"));
				user.setPower(rs.getString("nameM"));
				user.setScope(rs.getString("scope"));
				user.setPermission(rs.getString("permission"));
				user.setUserId(rs.getString("userId"));
				user.setRoleId(rs.getString("role_id"));
				results.add(user);
			}
		});
		for (User result : results) {
			for (UserPermission tt : userPermissionsAfters) {
				if (StringUtils.equals(result.getUserId(), tt.getUserId())) {
					result.setPermission(tt.getPermission_id());
				}
			}
		}

		logger.info("一共有" + results.size() + "条数据");
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
	public int resetPwd(String userId) {
		String sql = "UPDATE `User` SET `password`=:pwd WHERE userId=:userId";
		String pwd = MD5Util.md5("123");
		Map<String, String> map = new HashMap<String, String>();
		map.put("pwd", pwd);
		map.put("userId", userId);
		return this.npJdbcTemplate.update(sql, map);
	}

	@Override
	public int addUserByRole(User user) {
		String sqlUser = "insert into User (userId,password,age,username,tel,school,loginStartTime,loginEndTime,gender,carCode,isEnabled,loginDate,photo,createTime,updateTime,permission,islogin) "
				+ "values (:userId,:password,:age,:username,:tel,:school,:loginStartTime,:loginEndTime,:gender,:carCode,:isEnabled,:loginDate,:photo,:createTime,:updateTime,:permission,1)";
		String sqlUser_Role = "insert into User_Role (user_id,role_id,scope) values (:userId,:power,:scope)";
		String sqlBatch = "insert into User_Permission (user_id,permission_id) values (:userId,:permission_id)";
		SqlParameterSource userParameterSource = new BeanPropertySqlParameterSource(
				user);
		String[] permission_id = user.getPermission().split(",");
		List<UserPermission> list = new ArrayList<UserPermission>();
		for (int i = 0; i < permission_id.length; i++) {
			UserPermission userPermission = new UserPermission();
			userPermission.setUserId(user.getUserId());
			userPermission.setPermission_id(permission_id[i]);
			list.add(userPermission);
		}
		SqlParameterSource[] parameterSources = SqlParameterSourceUtils
				.createBatch(list.toArray());
		int n1 = this.npJdbcTemplate.update(sqlUser, userParameterSource);
		int n2 = this.npJdbcTemplate.update(sqlUser_Role, userParameterSource);
		int[] insertCounts = this.npJdbcTemplate.batchUpdate(sqlBatch,
				parameterSources);
		logger.info("insertCounts:" + insertCounts.length);
		if (n1 != n2) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int deleteUserByUserId(String userId) {
		String sqlDeteUser = "DELETE from `User` WHERE userId=:userId";
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		return this.npJdbcTemplate.update(sqlDeteUser, map);
	}

	@Override
	public User getUserByUserId(String userId) {
		String sql = "SELECT u.gender,u.username,ur.scope,r.nameM,u.isEnabled,u.tel,u.loginDate,u.loginStartTime,	"
				+ "u.loginEndTime,u.carCode,u.userId,u.permission	FROM `User` u LEFT OUTER JOIN User_Role ur on ur.user_id=u.userId	LEFT OUTER JOIN Role r on r.id=ur.role_id	where u.userId=:userId ";

		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		final User result = this.npJdbcTemplate.queryForObject(sql, map,
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int index)
							throws SQLException {
						User user = new User();
						user.setCarCode(rs.getString("carCode"));
						user.setGender(rs.getString("gender"));
						user.setIsEnabled(rs.getString("isEnabled"));
						user.setLoginDate(rs.getString("loginDate"));
						user.setLoginEndTime(rs.getString("loginEndTime"));
						user.setLoginStartTime(rs.getString("loginStartTime"));
						user.setTel(rs.getString("tel"));
						user.setUsername(rs.getString("username"));
						user.setPower(rs.getString("nameM"));
						user.setScope(rs.getString("scope"));
						user.setUserId(rs.getString("userId"));
						user.setPermission(rs.getString("permission"));
						return user;
					}
				});
		return result;
	}

	@Override
	public int updateUserByUserId(User user) {
		logger.info("userId:" + user.getUserId());
		String sqlUser = "update User set tel=:tel,loginStartTime=:loginStartTime,loginEndTime=:loginEndTime,gender=:gender,carCode=:carCode,isEnabled=:isEnabled,loginDate=:loginDate where userId=:userId";
		String sqlDeletePermissionByUserId = "delete from User_Permission where user_id=:userId";
		String sqlBatch = "insert into User_Permission (user_id,permission_id) values (:userId,:permission_id)";
		SqlParameterSource userParameterSource = new BeanPropertySqlParameterSource(
				user);
		int n1 = this.npJdbcTemplate.update(sqlUser, userParameterSource);
		int n2 = this.npJdbcTemplate.update(sqlDeletePermissionByUserId,
				userParameterSource);
		if (StringUtils.isNotBlank(user.getPermission())) {
			String[] permission_id = user.getPermission().split(",");
			List<UserPermission> list = new ArrayList<UserPermission>();
			for (int i = 0; i < permission_id.length; i++) {
				UserPermission userPermission = new UserPermission();
				userPermission.setUserId(user.getUserId());
				userPermission.setPermission_id(permission_id[i]);
				list.add(userPermission);
			}
			SqlParameterSource[] parameterSources = SqlParameterSourceUtils
					.createBatch(list.toArray());
			this.npJdbcTemplate.batchUpdate(sqlBatch, parameterSources);
		}
		return n1 + n2;
	}

	@Override
	public int alterPwd(User user) {
		String sql = "UPDATE `User` SET `password`=:password WHERE userId=:userId";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				user);
		return this.npJdbcTemplate.update(sql, namedParameters);
	}

	@Override
	public List<User> getUsersByRoleId(String roleId, boolean combo) {
		String sql = "select u.userId,u.username from User_Role ur left outer join User u on u.userId=ur.user_id where ur.role_id=:roleId ";
		Map<String, String> map = new HashMap<String, String>();
		map.put("roleId", roleId);
		final List<User> results = new ArrayList<User>();
		this.npJdbcTemplate.query(sql, map, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				User user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUsername(rs.getString("username"));
				results.add(user);
			}
		});

		if (combo) {
			User u = new User();
			u.setUserId("qb");
			if (StringUtils.equals(roleId, "4")) {
				u.setUsername("全部教师");
			} else if (StringUtils.equals(roleId, "11")) {
				u.setUsername("全部助教");
			}
			results.add(0, u);
		}
		return results;
	}
}
