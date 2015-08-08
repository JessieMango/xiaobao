package com.hqgj.xb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.service.StaffService;
import com.hqgj.xb.service.impl.StaffServiceImpl;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:39:49
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	
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
	
	

}
