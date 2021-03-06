package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.FinancialRunnningAccount;
import com.hqgj.xb.bean.StudentClass;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.service.FinancialRunnningAccountService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月29日 下午4:53:02
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class FinancialRunnningAccountController {
	@Autowired
	private FinancialRunnningAccountService financialRunnningAccountService;

	@RequestMapping(value = "/qiantai/addFinancialRunnningAccount", method = RequestMethod.POST)
	public @ResponseBody Json addClass(
			FinancialRunnningAccount financialRunnningAccount,
			HttpServletRequest request) {
		/**
		 * 加入经办人
		 */
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		financialRunnningAccount.setHandlerCode(sessionInfo.getUser()
				.getUserId());
		Json json = new Json();
		if (0 != financialRunnningAccountService
				.addFinancialRunnningAccount(financialRunnningAccount)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("操作失败");
		}
		return json;
	}

	@RequestMapping(value = "/caiwu/getTypeCode", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getTypeCode(String type) {
		return financialRunnningAccountService.getTypeCode(type);
	}

	@RequestMapping(value = "/caiwu/getPayWayCode", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getPayWayCode(String type) {
		return financialRunnningAccountService.getPayWayCode(type);
	}

	@RequestMapping(value = "/caiwu/getOperateCode", method = RequestMethod.POST)
	public @ResponseBody List<Dictionary> getOperateCode(String type) {
		return financialRunnningAccountService.getOperateCode(type);
	}

	@RequestMapping(value = "/caiwu/getFinancialRunnningAccount", method = RequestMethod.POST)
	public @ResponseBody Grid getFinancialRunnningAccount(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter) {
		return financialRunnningAccountService.getFinancialRunnningAccount(
				financialRunnningAccount, parameter);
	}

	@RequestMapping(value = "/caiwu/getFinancialRunnningAccountOfTrash", method = RequestMethod.POST)
	public @ResponseBody Grid getFinancialRunnningAccountOfTrash(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter) {
		return financialRunnningAccountService
				.getFinancialRunnningAccountOfTrash(financialRunnningAccount,
						parameter);
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年9月16日 下午4:14:08
	 * @param startTime
	 * @param pageCode
	 *            me表示我的今日 school 表示校区总计
	 * @return
	 */
	@RequestMapping(value = { "/caiwu/getRunningwaterDaily",
			"/qiantai/getRunningwaterDaily" }, method = RequestMethod.POST)
	public @ResponseBody List<FinancialRunnningAccount> getRunningwaterDaily(
			String startTime, String pageCode,HttpServletRequest request) {
		/**
		 * 加入经办人
		 */
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		return financialRunnningAccountService.getRunningwaterDaily(startTime,
				pageCode,sessionInfo.getUser().getUserId());
	}

	@RequestMapping(value = "/caiwu/deleteFinancialRunnningAccount", method = RequestMethod.POST)
	public @ResponseBody Json deleteFinancialRunnningAccount(String id,
			String type) {

		Json json = new Json();
		if (0 != financialRunnningAccountService
				.deleteFinancialRunnningAccount(id, type)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}

	/**
	 * 转班 （包括转入和转出，流水账的记录）
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年9月15日 下午1:41:28
	 * @param studentClass
	 * @param financialRunnningAccount
	 * @return
	 */
	@RequestMapping(value = "/qiantai/zhuanBan", method = RequestMethod.POST)
	public @ResponseBody Json zhuanBan(StudentClass studentClass,
			FinancialRunnningAccount financialRunnningAccount,
			HttpServletRequest request) {
		/**
		 * 加入经办人
		 */
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		financialRunnningAccount.setHandlerCode(sessionInfo.getUser()
				.getUserId());
		studentClass.setHandlerCode(sessionInfo.getUser().getUserId());
		Json json = new Json();
		if (0 != financialRunnningAccountService.zhuanBan(studentClass,
				financialRunnningAccount)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}
}
