package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Resource;
import com.hqgj.xb.service.ResourceService;

/**
 * @author 崔兴伟
 * @datetime 2015年7月20日 下午2:36:03
 */
@Controller
@RequestMapping(value = "/securityJsp")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "/getResource", method = RequestMethod.GET)
	public @ResponseBody List<Resource> getResources() {
		return resourceService.getResource();
	}
	@RequestMapping(value = "/getAllResource", method = RequestMethod.GET)
	public @ResponseBody List<Resource> getAllResource() {
		return resourceService.getAllResource();
	}

	@RequestMapping(value = "/getSubResource", method = RequestMethod.GET)
	public @ResponseBody List<Resource> getSubResource(
			HttpServletRequest request) {
		String pid = request.getParameter("pid");
		return resourceService.getSubResource(pid);
	}
}
