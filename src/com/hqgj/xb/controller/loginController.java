package com.hqgj.xb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.SystemLog;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.service.SystemLogService;
import com.hqgj.xb.service.UserService;
import com.hqgj.xb.util.CommonUtil;
import com.hqgj.xb.util.IpUtil;
import com.hqgj.xb.util.MD5Util;

@Controller
@RequestMapping(value = "/securityJsp")
public class loginController {
	private static final Logger logger = Logger
			.getLogger(loginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private SystemLogService systemLogService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Json loginn(HttpServletRequest request) {
		Json json = new Json();
		SystemLog log = new SystemLog();
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		logger.info("用户名loginname:" + loginname + ";密码:" + password);
		if (StringUtils.equals("admin", loginname) // 用户测试
				&& StringUtils.equals("admin", password)) {
			json.setMsg("登录成功");
			json.setSuccess(true);
			log.setMessage("IP地址" + IpUtil.getIpAddr(request));
			log.setOperateType("1");
			HttpSession session = request.getSession();
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setUser(null);
			session.setAttribute("sessionInfo", sessionInfo);
		} else {
			User user = new User();
			user.setUsername(loginname);
			user.setPassword(MD5Util.md5(password));
			List<User> list = userService.login(user);
			if (list.size() > 0) {
				User usertemp = list.get(0);
				if (StringUtils.equals(usertemp.getPassword(),
						MD5Util.md5(password))) {
					json.setMsg("登录成功");
					json.setSuccess(true);
					log.setMessage("IP地址[" + IpUtil.getIpAddr(request) + "]");
					log.setOperateType("1");
					HttpSession session = request.getSession();
					SessionInfo sessionInfo = new SessionInfo();
					sessionInfo.setUser(usertemp);
					session.setAttribute("sessionInfo", sessionInfo);
					session.setAttribute("mainUrl", "securityJsp/main.jsp");
				} else {
					json.setMsg("密码错误");
					json.setSuccess(false);
					log.setOperateType("2");
					log.setMessage("密码错误[IP地址" + IpUtil.getIpAddr(request)
							+ "]");
				}
			} else {
				json.setMsg("用户名不存在");
				json.setSuccess(false);
				log.setOperateType("2");
				log.setMessage("用户名不存在[IP地址" + IpUtil.getIpAddr(request) + "]");
			}
		}

		log.setUsername(loginname);
		log.setOperateTime(CommonUtil.getSystemTime());

		systemLogService.writeLog(log);
		return json;
	}

	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public @ResponseBody Json loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		Json json = new Json();
		json.setSuccess(true);
		return json;
	}

}
