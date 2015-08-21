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
import com.hqgj.xb.bean.TextBookFee;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.service.TextBookFeeService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 下午6:13:49
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class TextBookFeeController {
	private Logger logger = Logger.getLogger(TextBookFeeController.class);
	@Autowired
	private TextBookFeeService textBookFeeService;

	@RequestMapping(value = {"/xitong/getAllTextBookFees","/caiwu/getAllTextBookFees"}, method = RequestMethod.POST)
	public @ResponseBody List<TextBookFee> getAllTextBookFees(String type) {
		return textBookFeeService.getAllTextBookFees(type);
	}

	@RequestMapping(value = "/form/getDTextBookFeesType", method = RequestMethod.POST)
	public @ResponseBody List<TextBookFee> getDTextBookFeesType() {
		return textBookFeeService.getDTextBookFeesType();
	}

	@RequestMapping(value = "/form/getTextBookFee", method = RequestMethod.POST)
	public @ResponseBody TextBookFee getTextBookFee(String id) {
		return textBookFeeService.getTextBookFee(id);
	}
	
	@RequestMapping(value = "/form/updateTextBookFee", method = RequestMethod.POST)
	public @ResponseBody Json updateTextBookFee(TextBookFee textBookFee) {
		Json json = new Json();
		if (0 != textBookFeeService.updateTextBookFee(textBookFee)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("更新失败");
		}
		return json;
	}
	
	@RequestMapping(value = {"/xitong/deleteTextBookFee","/caiwu/deleteTextBookFee"}, method = RequestMethod.POST)
	public @ResponseBody Json deleteTextBookFee(String id) {
		Json json = new Json();
		if (0 != textBookFeeService.deleteTextBookFee(id)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("删除失败");
		}
		return json;
	}
	
	@RequestMapping(value = "/form/addTextBookFee", method = RequestMethod.POST)
	public @ResponseBody Json addTextBookFee(TextBookFee textBookFee) {
		Json json = new Json();
		if (0 != textBookFeeService.addTextBookFee(textBookFee)) {
			json.setSuccess(true);
		} else {
			json.setSuccess(false);
			json.setMsg("添加失败");
		}
		return json;
	}
	
}
