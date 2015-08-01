package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.Role;
import com.hqgj.xb.dao.RoleDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年7月30日 上午10:22:05
 */
@Repository
public class RoleDAOImpl implements RoleDAO {

	private NamedParameterJdbcTemplate npJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Role> getPermissionByRoleId(String role_id) {
		String sql = "SELECT p.`name`,rp.isDefault,rp.description,p.id permission_id from Role_Permission rp LEFT OUTER JOIN Permission p on p.id=rp.permission_id	LEFT OUTER JOIN Role r on r.id=rp.role_id	"
				+ "WHERE r.flag=1 and p.flag=1 and r.id=:roleId";
		Map<String, String> map = new HashMap<String, String>();
		map.put("roleId", role_id);
		final List<Role> results = this.npJdbcTemplate.query(sql, map,
				new RowMapper<Role>() {
					@Override
					public Role mapRow(ResultSet rs, int index)
							throws SQLException {
						Role role = new Role();
						role.setPermission(rs.getString("name"));
						role.setIsDefault(rs.getString("isDefault"));
						role.setDescription(rs.getString("description"));
						role.setPermission_id(rs.getString("permission_id"));
						return role;
					}
				});
		return results;
	}

}
