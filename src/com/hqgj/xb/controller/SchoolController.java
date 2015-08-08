package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.School;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.service.SchoolService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月1日 下午4:48:34
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class SchoolController {

	private Logger logger = Logger.getLogger(SchoolController.class);

	@Autowired
	private SchoolService schoolService;

	@RequestMapping(value = "/xitong/getAllSchools", method = RequestMethod.POST)
	public @ResponseBody List<School> getAllSchools(String type) {
		return schoolService.getAllSchools(type);
	}

	@RequestMapping(value = "/form/getSchoolById", method = RequestMethod.POST)
	public @ResponseBody School getSchoolById(HttpServletRequest request) {
		String schoolCode = request.getParameter("schoolCode");
		return schoolService.getSchoolById(schoolCode);
	}

	@RequestMapping(value = "/form/getSchoolType", method = RequestMethod.POST)
	public @ResponseBody List<School> getSchoolType() {
		return schoolService.getSchoolType();
	}

	@RequestMapping(value = "/form/updateSchoolBySchoolCode", method = RequestMethod.POST)
	public @ResponseBody Json updateSchoolBySchoolCode(School school) {
		school.setSchoolType(school.getSchoolTypeCode());
		Json json = new Json();
		if (-1 != schoolService.updateSchoolBySchoolCode(school)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("修改学校信息失败");
		}
		return json;
	}

	@RequestMapping(value = "/xitong/deleteSchoolBySchoolCode", method = RequestMethod.POST)
	public @ResponseBody Json deleteSchoolBySchoolCode(HttpServletRequest request) {
		School school = new School();
		school.setSchoolCode(request.getParameter("schoolCode"));
		Json json = new Json();

		if (-1 != schoolService.deleteSchoolBySchoolCode(school)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除学校信息失败");
		}
		return json;
	}

}
