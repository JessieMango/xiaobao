package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.StaffDAO;
import com.hqgj.xb.service.StaffService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:44:51
 */
@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDAO staffDAO;
	
	@Override
	public int createStaff(Staff staff,User user){
		return staffDAO.createStaff(staff,user);
	}
	
	@Override
	public  Grid Getmianshiqi(Staff staff, Parameter parameter)
	{
		return staffDAO.Getmianshiqi(staff,parameter);
		
	}
	
	public  List<Staff> getStaffTag(String type)
	{
		return staffDAO.getStaffTag(type);
				
	}

}
