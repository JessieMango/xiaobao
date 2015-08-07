package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.Course;
import com.hqgj.xb.bean.School;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.service.ConsultService;
import com.hqgj.xb.service.CourseService;
import com.hqgj.xb.service.SchoolService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月6日 下午4:57:51
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class ConsultController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private ConsultService consultService;

	@Autowired
	private SchoolService schoolService;

	@RequestMapping(value = "/qiantai/getAllSchools", method = RequestMethod.POST)
	public @ResponseBody List<School> getAllSchools() {
		return schoolService.getAllSchools();
	}

	@RequestMapping(value = "/qiantai/getCourseTypes", method = RequestMethod.POST)
	public @ResponseBody List<Course> getCourseTypes() {
		return courseService.getCourseTypes();
	}

	@RequestMapping(value = "/qiantai/getCouncilSchools", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getCouncilSchools() {
		return consultService.getCouncilSchools();
	}

	@RequestMapping(value = "/qiantai/getWillDegree", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getWillDegree() {
		return consultService.getWillDegree();
	}

	@RequestMapping(value = "/qiantai/getMark", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getMark() {
		return consultService.getMark();
	}

	@RequestMapping(value = "/qiantai/getSellSource", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getSellSource() {
		return consultService.getSellSource();
	}

	@RequestMapping(value = "/qiantai/getSeller", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getSeller() {
		return consultService.getSeller();
	}

	@RequestMapping(value = "/qiantai/getHandler", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getHandler() {
		return consultService.getHandler();
	}

	@RequestMapping(value = "/qiantai/saveConsult", method = RequestMethod.POST)
	public @ResponseBody Json saveConsult(Consult consult,
			HttpServletRequest request) {
		// 经办人为当前登录人员
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		consult.setHandler(sessionInfo.getUser().getUsername());
		consult.setHandlerCode(sessionInfo.getUser().getUserId());

		Json json = new Json();
		if (0 != consultService.saveConsult(consult)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加新咨询失败 ");
		}
		return json;
	}
}
