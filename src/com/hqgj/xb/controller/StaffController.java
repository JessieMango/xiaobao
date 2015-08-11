package com.hqgj.xb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.impl.UserDaoImpl;
import com.hqgj.xb.service.StaffService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:39:49
 */

@Controller
@RequestMapping(value = "/securityJsp/page")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	private Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@RequestMapping(value = "/renshi/createStaff", method = RequestMethod.POST)
	public @ResponseBody Json createStaff(User user,Staff staff) {
		Json json = new Json();
		
		if (0 != staffService.createStaff(staff, user)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加新咨询失败 ");
		}
		return json;
	}
	
	@RequestMapping(value = "/renshi/getStaffTag", method = RequestMethod.POST)
	public @ResponseBody List<Staff> getStaffTag(String type) {
		return staffService.getStaffTag(type);
	}
	
	@RequestMapping(value = "/renshi/Getmianshiqi", method = RequestMethod.POST)
	public @ResponseBody Grid Getmianshiqi(Staff staff, Parameter parameter) {
		return staffService.Getmianshiqi(staff, parameter);
	}
	
	
	@RequestMapping(value = "/renshi/deletemianshiqi", method = RequestMethod.POST)
	public @ResponseBody Json deletemianshiqi(HttpServletRequest request) {
		logger.info("132");
		String userId = request.getParameter("userId");
		logger.info(userId);
		Json json = new Json();
		if (staffService.deletemianshiqi(userId) != 1) {
			json.setSuccess(false);
			json.setMsg("删除失败");
		} else {
			json.setSuccess(true);
		}
		return json;
	}

	
	@RequestMapping(value = "/renshi/editmianshiqi", method = RequestMethod.POST)
	public @ResponseBody Json editmianshiqi(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		Staff staff=new Staff();
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
		if (staffService.editmianshiqi(staff, user) != 0) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新用户信息失败");
		}
		return json;
	}
}
