package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Role;
import com.hqgj.xb.dao.RoleDAO;
import com.hqgj.xb.service.RoleService;

/**
 * @author 崔兴伟
 * @datetime 2015年7月30日 上午10:22:33
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public List<Role> getPermissionByRoleId(String role_id) {
		return roleDAO.getPermissionByRoleId(role_id);
	}

}
