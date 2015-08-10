package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:42:19
 */
public interface StaffService {
	
	public int createStaff(Staff staff,User user);
	public  Grid Getmianshiqi(Staff staff, Parameter parameter);
	public  List<Staff> getStaffTag(String type);
}
