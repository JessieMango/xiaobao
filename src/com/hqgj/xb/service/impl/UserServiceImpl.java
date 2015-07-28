package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.User;
import com.hqgj.xb.dao.UserDao;
import com.hqgj.xb.service.UserService;

/**
 * @author 崔兴伟
 * @datetime 2015年7月7日 下午3:28:41
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDAO;

	@Override
	public List<User> login(User user) {
		return userDAO.login(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

}
