package com.hqgj.xb.service;

import java.util.List;





import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Json;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:42:19
 */
public interface StaffService {
	
	public int createStaff(Staff staff,User user);
	
	public  List<Staff> getStaffTag(String type);
	
	//面试期员工
	public  Grid Getmianshiqi(Staff staff, Parameter parameter);
	public int deletemianshiqi(String userid);
	public int editmianshiqi(Staff staff,User user);
	
	//培训试用期员工
	public Grid Getpeixunshiyong(Staff staff, Parameter parameter);
	public int deletepeixunshiyong(String userid);
	
	
	//转正失败员工
	public Grid Getzhuanzhengshibai(Staff staff, Parameter parameter);
	public int deletezhuanzhengshibai(String userid);
	
	//正式停职员工
	public Grid Getzhengshitingzhi(Staff staff, Parameter parameter);
	public int deletezhengshitingzhi(String userid);
	
	//离职解聘员工
	public Grid Getlizhijiepin(Staff staff, Parameter parameter);
	public int deletelizhijiepin(String userid);
	
	public Grid Getyuangongshengri(Staff staff, Parameter parameter);
}
