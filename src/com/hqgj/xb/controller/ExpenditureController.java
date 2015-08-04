package com.hqgj.xb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Expenditure;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.service.ExpenditureService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 下午1:00:31
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class ExpenditureController {
	
	@Autowired
	private ExpenditureService expenditureService;
	
	@RequestMapping(value = "/xitong/getAllExpenditureProjects", method = RequestMethod.POST)
	public @ResponseBody List<Expenditure> getAllExpenditureProjects() {
		return expenditureService.getAllExpenditureProjects();
	}
	
	@RequestMapping(value = "/form/getExpenditure", method = RequestMethod.POST)
	public @ResponseBody Expenditure getExpenditure(String id) {
		return expenditureService.getExpenditure(id);
	}
	
	@RequestMapping(value = "/form/getExpenditureProject", method = RequestMethod.POST)
	public @ResponseBody Expenditure getExpenditureProject(String id) {
		return expenditureService.getExpenditureProject(id);
	}
	
	@RequestMapping(value = "/form/getAllExpenditures", method = RequestMethod.POST)
	public @ResponseBody List<Expenditure>  getAllExpenditures() {
		return expenditureService.getAllExpenditures();
	}
	
	@RequestMapping(value = "/form/addExpenditure", method = RequestMethod.POST)
	public @ResponseBody Json addExpenditure(Expenditure expenditure) {
		Json json = new Json();
		if (0 != expenditureService.addExpenditure(expenditure)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加失败");
		}
		return json;
	}
	
	@RequestMapping(value = "/form/addExpenditureProject", method = RequestMethod.POST)
	public @ResponseBody Json addExpenditureProject(Expenditure expenditure) {
		Json json = new Json();
		if (0 != expenditureService.addExpenditureProject(expenditure)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加失败");
		}
		return json;
	}
	
	@RequestMapping(value = "/form/updateExpenditure", method = RequestMethod.POST)
	public @ResponseBody Json updateExpenditure(Expenditure expenditure) {
		Json json = new Json();
		if (0 != expenditureService.updateExpenditure(expenditure)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新失败");
		}
		return json;
	}
	
	@RequestMapping(value = "/form/updateExpenditureProject", method = RequestMethod.POST)
	public @ResponseBody Json updateExpenditureProject(Expenditure expenditure) {
		Json json = new Json();
		if (0 != expenditureService.updateExpenditureProject(expenditure)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新失败");
		}
		return json;
	}
	
	@RequestMapping(value = "/xitong/deleteExpenditure", method = RequestMethod.POST)
	public @ResponseBody Json deleteExpenditure(String code) {
		Json json = new Json();
		if (0 != expenditureService.deleteExpenditure(code)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}
	
	@RequestMapping(value = "/xitong/deleteExpenditureProject", method = RequestMethod.POST)
	public @ResponseBody Json deleteExpenditureProject(String code) {
		Json json = new Json();
		if (0 != expenditureService.deleteExpenditureProject(code)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}

}
