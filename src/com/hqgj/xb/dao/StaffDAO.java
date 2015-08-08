package com.hqgj.xb.dao;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:40:42
 */
public interface StaffDAO {

	public int createStaff(Staff staff,User user);

}
