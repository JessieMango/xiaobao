package com.hqgj.xb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.StudentClass;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.service.StudentClassService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月24日 下午5:42:12
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class StudentClassController {
	@Autowired
	private StudentClassService studentClassService;

	@RequestMapping(value = "/qiantai/addStudentClass", method = RequestMethod.POST)
	public @ResponseBody Json addStudentClass(StudentClass studentClass,
			HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		studentClass.setHandlerCode(sessionInfo.getUser().getUserId());
		Json json = new Json();
		if (0 != studentClassService.addStudentClass(studentClass)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("报名失败");
		}
		return json;
	}

	/**
	 * 无咨询记录报名
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月26日 下午1:52:06
	 * @param studentClass
	 * @return
	 */
	@RequestMapping(value = "/qiantai/addStudentClassNo", method = RequestMethod.POST)
	public @ResponseBody Json addStudentClassNo(StudentClass studentClass,
			Consult consult, HttpServletRequest request) {
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		studentClass.setHandlerCode(sessionInfo.getUser().getUserId());
		Json json = new Json();
		if (0 != studentClassService.addStudentClassNo(studentClass, consult)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("报名失败");
		}
		return json;
	}
}
