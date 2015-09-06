package com.hqgj.xb.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.service.ConsultService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月6日 下午4:57:51
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class ConsultController {

	@Autowired
	private ConsultService consultService;

	@RequestMapping(value = { "/qiantai/getCouncilSchools",
			"/jiaowu/getCouncilSchools" }, method = RequestMethod.POST)
	public @ResponseBody List<Consult> getCouncilSchools(String type) {
		return consultService.getCouncilSchools(type);
	}

	@RequestMapping(value = "/qiantai/getWillDegree", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getWillDegree(String type) {
		return consultService.getWillDegree(type);
	}

	@RequestMapping(value = "/qiantai/getMark", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getMark(String type) {
		return consultService.getMark(type);
	}

	@RequestMapping(value = { "/qiantai/getSellSource", "/jiaowu/getSellSource" }, method = RequestMethod.POST)
	public @ResponseBody List<Consult> getSellSource(String type) {
		return consultService.getSellSource(type);
	}

	@RequestMapping(value = { "/qiantai/getSeller", "/jiaowu/getSeller" }, method = RequestMethod.POST)
	public @ResponseBody List<Consult> getSeller(String type) {
		return consultService.getSeller(type);
	}

	@RequestMapping(value = "/qiantai/getConsultWay", method = RequestMethod.POST)
	public @ResponseBody List<Consult> getConsultWay(String type) {
		return consultService.getConsultWay(type);
	}

	@RequestMapping(value = { "/qiantai/getHandler", "/jiaowu/getHandler",
			"/shichang/getHandler", "/caiwu/getHandler" }, method = RequestMethod.POST)
	public @ResponseBody List<Consult> getHandler(String type) {
		return consultService.getHandler(type);
	}

	@RequestMapping(value = "/qiantai/saveConsult", method = RequestMethod.POST)
	public @ResponseBody Json saveConsult(Consult consult,
			HttpServletRequest request) {
		// 经办人为当前登录人员
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		consult.setHandler(sessionInfo.getUser().getUsername());
		consult.setHandlerCode(sessionInfo.getUser().getUserId());
		consult.setId(UUID.randomUUID().toString()); // 设置咨询表ID
		consult.setState("0"); // 默认咨询时没有报名
		Json json = new Json();
		if (0 != consultService.saveConsult(consult)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加新咨询失败 ");
		}
		return json;
	}

	@RequestMapping(value = "/qiantai/getConsult", method = RequestMethod.POST)
	public @ResponseBody Grid getConsult(Consult consult, Parameter parameter) {
		return consultService.getConsult(consult, parameter);
	}
	@RequestMapping(value = "/qiantai/GetShengRiXueYuan", method = RequestMethod.POST)
	public @ResponseBody Grid GetShengRiXueYuan(String StudentMonth, Parameter parameter) {
		return consultService.GetShengRiXueYuan(StudentMonth, parameter);
	}
	@RequestMapping(value = "/qiantai/getConsultById", method = RequestMethod.POST)
	public @ResponseBody Consult getConsultById(String id) {
		return consultService.getConsultById(id);
	}

	@RequestMapping(value = "/qiantai/updateConsult", method = RequestMethod.POST)
	public @ResponseBody Json updateConsult(Consult consult,
			HttpServletRequest request) {
		// 经办人为当前登录人员
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		consult.setHandler(sessionInfo.getUser().getUsername());
		consult.setHandlerCode(sessionInfo.getUser().getUserId());
		Json json = new Json();
		if (0 != consultService.updateConsult(consult)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新失败");
		}
		return json;
	}

	@RequestMapping(value = "/qiantai/deleteConsult", method = RequestMethod.POST)
	public @ResponseBody Json deleteConsult(String id) {
		Json json = new Json();
		if (0 != consultService.deleteConsult(id)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}
}
