package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Role;
import com.hqgj.xb.service.RoleService;

/**
 * @author 崔兴伟
 * @datetime 2015年7月30日 上午10:45:35
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/form/getPermissionByRoleId", method = RequestMethod.POST)
	public @ResponseBody List<Role> getPermissionByRoleId(
			HttpServletRequest request) {
		String role_id = request.getParameter("roleId");
		return roleService.getPermissionByRoleId(role_id);
	}

}
