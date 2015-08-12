package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Course;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.service.CourseService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 上午10:50:32
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class CourseController {
	private Logger logger = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = { "/xitong/getAllCourses", "/jiaowu/getAllCourses" }, method = RequestMethod.POST)
	public @ResponseBody List<Course> getAllCourses(String courseTypeCode) {
		return courseService.getAllCourses(courseTypeCode);
	}

	@RequestMapping(value = { "/form/getCourseTypes",
			"/qiantai/getCourseTypes", "/jiaowu/getCourseTypes" }, method = RequestMethod.POST)
	public @ResponseBody List<Course> getCourseTypes(String type) {
		return courseService.getCourseTypes(type);
	}

	@RequestMapping(value = "/form/getCourseById", method = RequestMethod.POST)
	public @ResponseBody Course getCourseById(HttpServletRequest request) {
		String courseCode = request.getParameter("courseCode");
		return courseService.getCourseById(courseCode);
	}

	@RequestMapping(value = "/form/getCourseTypeById", method = RequestMethod.POST)
	public @ResponseBody Course getCourseTypeById(HttpServletRequest request) {
		String courseTypeCode = request.getParameter("courseTypeCode");
		return courseService.getCourseTypeById(courseTypeCode);
	}

	@RequestMapping(value = "/form/addCourseType", method = RequestMethod.POST)
	public @ResponseBody Json addCourseType(Course course) {
		Json json = new Json();
		if (0 != courseService.addCourseType(course)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加课程大类失败");
		}
		return json;
	}

	@RequestMapping(value = "/form/addCourse", method = RequestMethod.POST)
	public @ResponseBody Json addCourse(Course course) {
		Json json = new Json();
		if (0 != courseService.addCourse(course)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加课程失败");
		}
		return json;
	}

	@RequestMapping(value = "/form/updateCourseType", method = RequestMethod.POST)
	public @ResponseBody Json updateCourseType(Course course) {
		Json json = new Json();
		if (0 != courseService.updateCourseType(course)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新课程大类失败");
		}
		return json;
	}

	@RequestMapping(value = "/form/updateCourse", method = RequestMethod.POST)
	public @ResponseBody Json updateCourse(Course course) {
		Json json = new Json();
		if (0 != courseService.updateCourse(course)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新课程失败");
		}
		return json;
	}

	@RequestMapping(value = "/xitong/deleteCourseType", method = RequestMethod.POST)
	public @ResponseBody Json deleteCourseType(HttpServletRequest request) {
		String code = request.getParameter("code");
		Json json = new Json();
		if (0 != courseService.deleteCourseType(code)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除课程大类失败");
		}
		return json;
	}

	@RequestMapping(value = "/xitong/deleteCourse", method = RequestMethod.POST)
	public @ResponseBody Json deleteCourse(HttpServletRequest request) {
		String code = request.getParameter("code");
		Json json = new Json();
		if (0 != courseService.deleteCourse(code)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除课程失败");
		}
		return json;
	}
}
