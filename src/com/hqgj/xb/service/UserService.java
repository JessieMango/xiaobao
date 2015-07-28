package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.User;

public interface UserService {
	/**
	 * 登录验证
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月7日 下午3:25:51
	 * @param user
	 * @return
	 */
	public List<User> login(User user);

	/**
	 * 获取所有的用户信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月28日 上午9:19:13
	 * @return
	 */
	public List<User> getAllUsers();
}
