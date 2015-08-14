package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;

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
	 * 获取对应角色的用户
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月14日 上午10:34:03
	 * @param roleId
	 * @return
	 */
	public List<User> getUsersByRoleId(String roleId);

	/**
	 * 获取所有的用户信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月28日 上午9:19:13
	 * @return
	 */
	public Grid getAllUsers(Parameter parameter);

	/**
	 * 根据用户ID获取指定用户信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月31日 下午2:37:04
	 * @param uesrId
	 * @return
	 */
	public User getUserByUserId(String userId);

	/**
	 * 重置用户密码为123456
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月29日 下午3:34:30
	 * @param userId
	 * @return 1代表重置成功 0 代表重置失败
	 */
	public int resetPwd(String userId);

	/**
	 * 账号设置中新增指定权限用户
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月30日 下午3:27:47
	 * @return
	 */
	public int addUserByRole(User user);

	/**
	 * 修改用户信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月1日 上午11:41:38
	 * @param user
	 * @return
	 */
	public int updateUserByUserId(User user);

	/**
	 * 根据用户ID删除用户信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月30日 下午5:50:43
	 * @param userId
	 * @return
	 */
	public int deleteUserByUserId(String userId);

	/**
	 * 修改密码
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月12日 上午9:02:03
	 * @param user
	 * @return
	 */
	public int alterPwd(User user);
}
