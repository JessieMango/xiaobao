package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Dictionary;
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
	//获取员工的政治属性列表
	@RequestMapping(value = "/renshi/getpoliticalStatus", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getpoliticalStatus(String type) {
		return staffService.getpoliticalStatus(type);
	}
	//获取劳动关系字典表中的数据
	@RequestMapping(value = "/renshi/getlaborRelations", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getlaborRelations(String type) {
		return staffService.getlaborRelations(type);
	}
	//获得员工状态的字典表中的数据
	@RequestMapping(value = "/renshi/getpersonnelstatus", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getpersonnelstatus(String type){
		return staffService.getpersonnelstatus(type);
	}
	//获得员工的社保状态的字典表中的数据
	@RequestMapping(value = "/renshi/getsocialsecurityStatus", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getsocialsecurityStatus(String type) {
		return staffService.getsocialsecurityStatus(type);
	}
	//创建新员工
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
	//获得员工的标志
	@RequestMapping(value = "/renshi/getStaffTag", method = RequestMethod.POST)
	public @ResponseBody List<Staff> getStaffTag(String type) {
		return staffService.getStaffTag(type);
	}
	//获得面试期员工列表
	@RequestMapping(value = "/renshi/Getmianshiqi", method = RequestMethod.POST)
	public @ResponseBody Grid Getmianshiqi(Staff staff, Parameter parameter) {
		return staffService.Getmianshiqi(staff, parameter);
	}
	
	//删除面试期员工，根据员工的ＩＤ
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


	
	//编辑员工信息
	@RequestMapping(value = "/renshi/editStaff", method = RequestMethod.POST)
	public @ResponseBody Json editStaff(Staff staff) {	
		Json json = new Json();
		if (0 != staffService.editStaff(staff)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新失败");
		}
		return json;
	}
	
	//通过userId获得员工信息。
	@RequestMapping(value = "/renshi/getstaffByuserId", method = RequestMethod.POST)
	public @ResponseBody Staff getstaffByuserId(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		return staffService.getstaffByuserId(userId);
	}
	
	//获得所有处于培训期员工的信息
	@RequestMapping(value = "/renshi/Getpeixunshiyong", method = RequestMethod.POST)
	public @ResponseBody Grid Getpeixunshiyong(Staff staff, Parameter parameter) {
		return staffService.Getpeixunshiyong(staff, parameter);
	}
	
	//删除培训其员工的信息，根据的是员工的iD
	@RequestMapping(value = "/renshi/deletepeixunshiyong", method = RequestMethod.POST)
	public @ResponseBody Json deletepeixunshiyong(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		logger.info(userId);
		Json json = new Json();
		if (staffService.deletepeixunshiyong(userId) != 1) {
			json.setSuccess(false);
			json.setMsg("删除失败");
		} else {
			json.setSuccess(true);
		}
		return json;
	}

	
	//获取转正失败的员工的信息
	@RequestMapping(value = "/renshi/Getzhuanzhengshibai", method = RequestMethod.POST)
	public @ResponseBody Grid Getzhuanzhengshibai(Staff staff, Parameter parameter) {
		return staffService.Getzhuanzhengshibai(staff, parameter);
	}
	
	//删除转正失败的员工信息
	@RequestMapping(value = "/renshi/deletezhuanzhengshibai", method = RequestMethod.POST)
	public @ResponseBody Json deletezhuanzhengshibai(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		logger.info(userId);
		Json json = new Json();
		if (staffService.deletezhuanzhengshibai(userId) != 1) {
			json.setSuccess(false);
			json.setMsg("删除失败");
		} else {
			json.setSuccess(true);
		}
		return json;
	}
	//获取正式员工或者是停职员工的信息列表
	@RequestMapping(value = "/renshi/Getzhengshitingzhi", method = RequestMethod.POST)
	public @ResponseBody Grid Getzhengshitingzhi(Staff staff, Parameter parameter) {
		return staffService.Getzhengshitingzhi(staff, parameter);
	}
	
	//删除正式员工，或者停职员工的信息
	@RequestMapping(value = "/renshi/deletezhengshitingzhi", method = RequestMethod.POST)
	public @ResponseBody Json deletezhengshitingzhi(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		logger.info(userId);
		Json json = new Json();
		if (staffService.deletezhengshitingzhi(userId) != 1) {
			json.setSuccess(false);
			json.setMsg("删除失败");
		} else {
			json.setSuccess(true);
		}
		return json;
	}
	//获取已经离职或者解聘的员工的信息列表
	@RequestMapping(value = "/renshi/Getlizhijiepin", method = RequestMethod.POST)
	public @ResponseBody Grid Getlizhijiepin(Staff staff, Parameter parameter) {
		return staffService.Getlizhijiepin(staff, parameter);
	}
	
	//删除已经离职或者解聘的员工的信息
	@RequestMapping(value = "/renshi/deletelizhijiepin", method = RequestMethod.POST)
	public @ResponseBody Json deletelizhijiepin(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		logger.info(userId);
		Json json = new Json();
		if (staffService.deletelizhijiepin(userId) != 1) {
			json.setSuccess(false);
			json.setMsg("删除失败");
		} else {
			json.setSuccess(true);
		}
		return json;
	}
	//查询正式员工的生日信息
	@RequestMapping(value = "/renshi/Getyuangongshengri", method = RequestMethod.POST)
	public @ResponseBody Grid Getyuangongshengri(Staff staff, Parameter parameter) {
		return staffService.Getyuangongshengri(staff, parameter);
	}
	
}
