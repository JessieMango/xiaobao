package com.hqgj.xb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.OldStudentAgainEnroll;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.service.OldStudentAgainEnrollService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月26日 下午5:14:15
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class OldStudentAgainEnrollController {
	@Autowired
	private OldStudentAgainEnrollService oldStudentAgainEnrollService;

	@RequestMapping(value = { "/qiantai/getOldStudentAgainEnrolls",
			"/jiaowu/getOldStudentAgainEnrolls",
			"/caiwu/getOldStudentAgainEnrolls" }, method = RequestMethod.POST)
	public @ResponseBody Grid getOldStudentAgainEnrolls(
			OldStudentAgainEnroll oldStudentAgainEnroll, Parameter parameter) {
		return oldStudentAgainEnrollService.getOldStudentAgainEnrolls(
				oldStudentAgainEnroll, parameter);
	}
}
