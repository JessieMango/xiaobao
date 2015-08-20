package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Communication;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.service.CommunicationService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月10日 上午10:08:53
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class CommunicationController {
	@Autowired
	private CommunicationService communicationService;

	@RequestMapping(value = "/jiaowu/getSellOutCommunications", method = RequestMethod.POST)
	public @ResponseBody Grid getSellOutCommunications(Communication communication,
			Parameter parameter) {
		return communicationService.getSellOutCommunications(communication, parameter);
	}
	
	
	@RequestMapping(value = {"/qiantai/getCommunications","shichang/getCommunications"}, method = RequestMethod.POST)
	public @ResponseBody Grid getCommunications(Communication communication,
			Parameter parameter) {
		return communicationService.getCommunications(communication, parameter);
	}
	

	@RequestMapping(value = "/qiantai/getCommunicationById", method = RequestMethod.POST)
	public @ResponseBody Communication getCommunicationById(String id) {
		return communicationService.getCommunicationById(id);
	}
	
	@RequestMapping(value = {"/qiantai/getCommunicationType","/jiaowu/getCommunicationType","shichang/getCommunicationType"}, method = RequestMethod.POST)
	public @ResponseBody List<Communication> getCommunicationType(String type, String flag) {
		return communicationService.getCommunicationType(type,flag);
	}

	@RequestMapping(value = "/qiantai/getCommunicationByConsultId", method = RequestMethod.POST)
	public @ResponseBody List<Communication> getCommunicationByConsultId(
			String id) {
		return communicationService.getCommunicationByConsultId(id);
	}

	@RequestMapping(value = {"/qiantai/addCommunication","shichang/addCommunication"}, method = RequestMethod.POST)
	public @ResponseBody Json addCommunication(Communication communication,
			HttpServletRequest request) {
		// 经办人为当前登录人员
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		communication.setHandler(sessionInfo.getUser().getUsername());
		communication.setHandlerCode(sessionInfo.getUser().getUserId());
		Json json = new Json();
		if (0 != communicationService.addCommunication(communication)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加失败");
		}
		return json;
	}

	@RequestMapping(value = "/qiantai/updateCommunication", method = RequestMethod.POST)
	public @ResponseBody Json updateCommunication(Communication communication,HttpServletRequest request) {
		// 经办人为当前登录人员
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute("sessionInfo");
		communication.setHandler(sessionInfo.getUser().getUsername());
		communication.setHandlerCode(sessionInfo.getUser().getUserId());
		Json json = new Json();
		if (0 != communicationService.updateCommunication(communication)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新失败");
		}
		return json;
	}

	@RequestMapping(value ={ "/qiantai/deleteCommunicationById","shichang/deleteCommunicationById"}, method = RequestMethod.POST)
	public @ResponseBody Json deleteCommunicationById(String id) {
		Json json = new Json();
		if (0 != communicationService.deleteCommunicationById(id)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}
}
