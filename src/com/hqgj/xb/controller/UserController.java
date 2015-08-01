package com.hqgj.xb.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.service.UserService;
import com.hqgj.xb.util.MD5Util;

@Controller
@RequestMapping(value = "/securityJsp/page")
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/xitong/getAllUsers", method = RequestMethod.POST)
	public @ResponseBody Grid getAllUsers(Parameter parameter) {
		return userService.getAllUsers(parameter);
	}

	@RequestMapping(value = "/xitong/resetPwd", method = RequestMethod.POST)
	public @ResponseBody Json resetPwd(HttpServletRequest request) {
		String userId = request.getParameter("id");
		Json json = new Json();
		if (userService.resetPwd(userId) != 0) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
		}
		return json;
	}

	@RequestMapping(value = "/xitong/deleteUser", method = RequestMethod.POST)
	public @ResponseBody Json deleteUser(HttpServletRequest request) {
		String userId = request.getParameter("id");
		Json json = new Json();
		if (userService.deleteUserByUserId(userId) != 1) {
			json.setSuccess(false);
			json.setMsg("删除失败");
		} else {
			json.setSuccess(true);
		}
		return json;
	}

	@RequestMapping(value = "/form/addUserByRole", method = RequestMethod.POST)
	public @ResponseBody Json addUserByRole(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		for (String key : map.keySet()) {
			if (StringUtils.equals("level", key)) {
				user.setPower(request.getParameter(key));
			} else if (StringUtils.equals("permission", key)) {
				user.setPermission(request.getParameter(key));
			} else if (StringUtils.equals("school", key)) {
				user.setSchool(request.getParameter(key));
				user.setScope(request.getParameter(key));
			} else if (StringUtils.equals("username", key)) {
				user.setUsername(request.getParameter(key));
			} else if (StringUtils.equals("pwd", key)) {
				user.setPassword(MD5Util.md5(request.getParameter(key)));
			} else if (StringUtils.equals("week", key)) {
				user.setLoginDate(request.getParameter(key));
			} else if (StringUtils.equals("startTime", key)) {
				user.setLoginStartTime(request.getParameter(key));
			} else if (StringUtils.equals("endTime", key)) {
				user.setLoginEndTime(request.getParameter(key));
			} else if (StringUtils.equals("tel", key)) {
				user.setTel(request.getParameter(key));
			} else if (StringUtils.equals("sex", key)) {
				if (StringUtils.equals(request.getParameter(key), "male")) {
					user.setGender("0");
				} else {
					user.setGender("1");
				}
			}
		}
		user.setUserId(UUID.randomUUID().toString());
		Json json = new Json();
		if (userService.addUserByRole(user) != 1) {
			json.setSuccess(false);
			json.setMsg("添加用户失败");
		} else {
			json.setSuccess(true);
		}
		return json;
	}

	@RequestMapping(value = "/form/getUserByUserId", method = RequestMethod.POST)
	public @ResponseBody User getUserByUserId(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		return userService.getUserByUserId(userId);
	}

	@RequestMapping(value = "/form/editUserByUserId", method = RequestMethod.POST)
	public @ResponseBody Json editUserByUserId(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		for (String key : map.keySet()) {
			if (StringUtils.equals("permission", key)) {
				user.setPermission(request.getParameter(key));
			} else if (StringUtils.equals("scope", key)) {
				user.setSchool(request.getParameter(key));
				user.setScope(request.getParameter(key));
			} else if (StringUtils.equals("week", key)) {
				user.setLoginDate(request.getParameter(key));
			} else if (StringUtils.equals("loginStartTime", key)) {
				user.setLoginStartTime(request.getParameter(key));
			} else if (StringUtils.equals("loginEndTime", key)) {
				user.setLoginEndTime(request.getParameter(key));
			} else if (StringUtils.equals("gender", key)) {
				user.setGender(request.getParameter("gender"));
			} else if (StringUtils.equals("userId", key)) {
				user.setUserId(request.getParameter("userId"));
			}
		}
		Json json = new Json();
		if (userService.updateUserByUserId(user) != 0) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新用户信息失败");
		}
		return json;
	}

}
