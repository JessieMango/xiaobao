package com.hqgj.xb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.SessionInfo;
import com.hqgj.xb.service.UserService;
import com.hqgj.xb.util.MD5Util;

@Controller
@RequestMapping(value = "/securityJsp")
public class loginController implements
		org.springframework.web.servlet.mvc.Controller {
	private static final Logger logger = Logger
			.getLogger(loginController.class);

	@Autowired
	private UserService userService;

	@Override
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String view = ""; // 根据验证，设置不同的返回结果
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		logger.info("用户名loginname:" + loginname + ":密码" + password);
		String message = "";
		Map<String, String> model = new HashMap<String, String>();
		User user = new User();
		user.setUsername(loginname);
		user.setPassword(MD5Util.md5(password));
		List<User> list = userService.login(user);
		if (list.size() > 0) {
			User usertemp = list.get(0);
			if (StringUtils.equals(usertemp.getPassword(),
					MD5Util.md5(password))) {
				message = "登录成功";
				HttpSession session = request.getSession();
				SessionInfo sessionInfo = new SessionInfo();
				sessionInfo.setUser(usertemp);
				session.setAttribute("sessionInfo", sessionInfo);
				session.setAttribute("mainUrl", "securityJsp/main.jsp");
				view = "main";
			} else {
				message = "密码错误";
				view = "login";
			}
		} else {
			message = "用户名不存在";
			view = "login";
		}
		model.put("msg", message);
		return new ModelAndView(view, model);
	}

}
