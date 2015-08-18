package com.hqgj.xb.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.bean.ClassTimePlan;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.service.ClassSService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月13日 下午2:30:52
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class ClassSController {

	@Autowired
	private ClassSService classSService;

	@RequestMapping(value = "/jiaowu/addClass", method = RequestMethod.POST)
	public @ResponseBody Json addClass(ClassS cla, ClassTimePlan classTimePlan) {
		if (StringUtils.equals(cla.getTuitionType(), "2")
				|| StringUtils.equals(cla.getTuitionType(), "3")) {
			cla.setStartDate(cla.getStartDate2());
			cla.setEndDate(null);
		}
		if (StringUtils.equals(cla.getDateUndetermined(), "1")) {
			cla.setStartDate(null);
			cla.setEndDate(null);
		}
		Json json = new Json();
		if (0 != classSService.addClass(cla, classTimePlan)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加失败");
		}
		return json;
	}

	@RequestMapping(value = "/jiaowu/updateClass", method = RequestMethod.POST)
	public @ResponseBody Json updateClass(ClassS cla,
			ClassTimePlan classTimePlan) {
		if (StringUtils.equals(cla.getTuitionType(), "2")
				|| StringUtils.equals(cla.getTuitionType(), "3")) {
			cla.setStartDate(cla.getStartDate2());
			cla.setEndDate(null);
		}
		if (StringUtils.equals(cla.getDateUndetermined(), "1")) {
			cla.setStartDate(null);
			cla.setEndDate(null);
		}
		Json json = new Json();
		if (0 != classSService.updateClass(cla, classTimePlan)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}

	@RequestMapping(value = "/jiaowu/getClass", method = RequestMethod.POST)
	public @ResponseBody Grid getClass(ClassS cla, Parameter parameter) {
		return classSService.getClass(cla, parameter);
	}

	@RequestMapping(value = "/jiaowu/getClassSByClassCode", method = RequestMethod.POST)
	public @ResponseBody ClassS getClassSByClassCode(String classCode) {
		return classSService.getClassSByClassCode(classCode);
	}

	@RequestMapping(value = "/qiantai/getClassSByCourseCode", method = RequestMethod.POST)
	public @ResponseBody List<ClassS> getClassSByCourseCode(String courseCode) {
		return classSService.getClassSByCourseCode(courseCode);
	}

	@RequestMapping(value = "/jiaowu/deleteClass", method = RequestMethod.POST)
	public @ResponseBody Json deleteClass(String classCode) {
		Json json = new Json();
		if (0 != classSService.deleteClass(classCode)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}

}
