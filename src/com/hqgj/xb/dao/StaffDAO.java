package com.hqgj.xb.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:40:42
 */
public interface StaffDAO {

	public int createStaff(Staff staff,User user);
	public  Grid Getmianshiqi(Staff staff, Parameter parameter);
	public  List<Staff> getStaffTag(String type);
	public int deletemianshiqi(String userid);
	public int editmianshiqi(Staff staff,User user);
}
