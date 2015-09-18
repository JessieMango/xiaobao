package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.ExpenseAccount;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.service.FinancialStatisticsService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月20日 下午10:19:34
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class FinancialStatisticsController {
	@Autowired
	private FinancialStatisticsService financialStatisticsService;
	
	//支出帐的相关模块
	
	
	
	//添加支出帐目
	@RequestMapping(value = "/caiwu/addExpenseAccount", method = RequestMethod.POST)
	public @ResponseBody Json addExpenseAccount(ExpenseAccount expenseAccount,HttpServletRequest request) {
		Json json = new Json();
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute("sessionInfo");
		expenseAccount.setDhandlerId(sessionInfo.getUser().getUserId());
		if (0 != financialStatisticsService.addExpenseAccount(expenseAccount)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加失败");
		}
		return json;
	}
	//修改支出帐目
	@RequestMapping(value = "/caiwu/updateExpenseAccount", method = RequestMethod.POST)
	public @ResponseBody Json updateExpenseAccount(ExpenseAccount expenseAccount) {
		Json json = new Json();
		if (-1 != financialStatisticsService.updateExpenseAccount(expenseAccount)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("修改信息失败");
		}
		return json;
	}
	//通过支出帐目id，获得支出帐目的详细信息。
	@RequestMapping(value = "/caiwu/getExpenseAccountById", method = RequestMethod.POST)
	public @ResponseBody ExpenseAccount getExpenseAccountById(String id)
	{
		return financialStatisticsService.getExpenseAccountById(id);
	}
	//删除支出帐目
	@RequestMapping(value = "/caiwu/deleteExpenseAccount", method = RequestMethod.POST)
	public @ResponseBody Json deleteExpenseAccount(String id) {
		Json json = new Json();
		if (0 != financialStatisticsService.deleteExpenseAccount(id)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}
	
	@RequestMapping(value = "/caiwu/getExpenseAccount", method = RequestMethod.POST)
	public @ResponseBody Grid getExpenseAccount(ExpenseAccount expenseAccount, Parameter parameter ) {
		return financialStatisticsService.getExpenseAccount(expenseAccount, parameter);
	}
	//查询所有的支出帐目，根据前台界面条件
	@RequestMapping(value = "/caiwu/getAllExpenditure", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getAllExpenditure(String type) {
		return financialStatisticsService.getAllExpenditure(type);
	}
	//查询所有的支出项目名称
	@RequestMapping(value = "/caiwu/getAllExpenditureProject", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getAllExpenditureProject(String type)
	{
		return financialStatisticsService.getAllExpenditureProject(type);
	}
	//根据支出大类，查询出支出
	@RequestMapping(value = "/caiwu/getZhiChuAnDaLei", method = RequestMethod.POST)
	public @ResponseBody Grid getZhiChuAnDaLei(String starttime,String endtime,Parameter parameter)
	{
		return financialStatisticsService.getZhiChuAnDaLei(starttime,endtime,parameter);
	}
	//根据支出子项，查询出支出
	@RequestMapping(value = "/caiwu/getZhiChuAnZiXiang", method = RequestMethod.POST)
	public @ResponseBody Grid getZhiChuAnZiXiang(String starttime,String endtime,Parameter parameter)
	{
		return financialStatisticsService.getZhiChuAnZiXiang(starttime,endtime,parameter);
	}
	//根据支出校区，查询出支出
	@RequestMapping(value = "/caiwu/getZhiChuAnXiaoQu", method = RequestMethod.POST)
	public @ResponseBody Grid getZhiChuAnXiaoQu(String starttime,String endtime,Parameter parameter)
	{
		return financialStatisticsService.getZhiChuAnXiaoQu(starttime,endtime,parameter);
	}
	//查询每个月的支出对比
	@RequestMapping(value = "/caiwu/getZhiChuYueDuiBi", method = RequestMethod.POST)
	public @ResponseBody Grid getZhiChuYueDuiBi(String statisticalYear,Parameter parameter)
	{
		return financialStatisticsService.getZhiChuYueDuiBi(statisticalYear,parameter);
	}
	
	
	
	
	
	//业务流水账相关的模块

	//根据校区，查询出收入
	@RequestMapping(value = "/caiwu/getLiuShuiAnXiaoQu", method = RequestMethod.POST)
	public @ResponseBody Charts getLiuShuiAnXiaoQu(String starttime,String endtime) {
		return financialStatisticsService.getLiuShuiAnXiaoQu(starttime,endtime);
	}
	//根据人员，查询出收入
	@RequestMapping(value = "/caiwu/getLiuShuiAnRenYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getLiuShuiAnRenYuan(String starttime,String endtime) {
		return financialStatisticsService.getLiuShuiAnRenYuan(starttime,endtime);
	}
	//根据校区，查询退费情况
	@RequestMapping(value = "/caiwu/getTuiFeiAnXiaoQu", method = RequestMethod.POST)
	public @ResponseBody Charts getTuiFeiAnXiaoQu(String starttime,String endtime) {
		return financialStatisticsService.getTuiFeiAnXiaoQu(starttime,endtime);
	}
	//根据课程，查询出收入
	@RequestMapping(value = "/caiwu/getXueFeiAnKeCheng", method = RequestMethod.POST)
	public @ResponseBody Charts getXueFeiAnKeCheng(String starttime,String endtime) {
		return financialStatisticsService.getXueFeiAnKeCheng(starttime,endtime);
	}
	//根据课程，查询退费情况
	@RequestMapping(value = "/caiwu/getTuiFeiAnKeCheng", method = RequestMethod.POST)
	public @ResponseBody Charts getTuiFeiAnKeCheng(String starttime,String endtime) {
		return financialStatisticsService.getTuiFeiAnKeCheng(starttime,endtime);
	}
	
	//对比每个月的收入
	@RequestMapping(value = "/caiwu/getLiuShuiYueDuiBi", method = RequestMethod.POST)
	public @ResponseBody Charts getLiuShuiYueDuiBi(String statisticalYear) {
		return financialStatisticsService.getLiuShuiYueDuiBi(statisticalYear);
	}
}
