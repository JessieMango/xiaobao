package com.hqgj.xb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.User;
import com.hqgj.xb.service.UserService;

@Controller
@RequestMapping(value = "/securityJsp/page/xitong")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.POST)
	public @ResponseBody List<User> getResources() {
		return userService.getAllUsers();
	}
}
