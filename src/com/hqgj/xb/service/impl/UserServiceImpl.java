package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
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
	public Grid getAllUsers(Parameter parameter) {
		return userDAO.getAllUsers(parameter);
	}

	@Override
	public int resetPwd(String userId) {
		return userDAO.resetPwd(userId);
	}

	@Override
	public int addUserByRole(User user) {
		return userDAO.addUserByRole(user);
	}

	@Override
	public int deleteUserByUserId(String userId) {
		return userDAO.deleteUserByUserId(userId);
	}

	@Override
	public User getUserByUserId(String userId) {
		return userDAO.getUserByUserId(userId);
	}

	@Override
	public int updateUserByUserId(User user) {
		return userDAO.updateUserByUserId(user);
	}

	@Override
	public int alterPwd(User user) {
		return userDAO.alterPwd(user);
	}

	@Override
	public List<User> getUsersByRoleId(String roleId) {
		return userDAO.getUsersByRoleId(roleId);
	}

}
