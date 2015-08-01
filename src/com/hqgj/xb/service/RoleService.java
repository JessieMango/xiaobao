package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.Role;

/**
 * @author 崔兴伟
 * @datetime 2015年7月30日 上午10:13:46
 */
public interface RoleService {
	/**
	 * 根据角色ID获取对应角色的权限
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月30日 上午10:20:42
	 * @param role_id
	 * @return
	 */
	public List<Role> getPermissionByRoleId(String role_id);
}
