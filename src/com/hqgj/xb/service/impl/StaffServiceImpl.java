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
	
	@Override
	public  List<Staff> getStaffTag(String type)
	{
		return staffDAO.getStaffTag(type);
				
	}

	@Override
	public int deletemianshiqi(String userid) {
		return staffDAO.deletemianshiqi(userid);
	}

	@Override
	public Grid Getpeixunshiyong(Staff staff, Parameter parameter) {
		return staffDAO.Getpeixunshiyong(staff, parameter);
	}

	@Override
	public int deletepeixunshiyong(String userid) {
		return staffDAO.deletepeixunshiyong(userid);
	}

	@Override
	public Grid Getzhuanzhengshibai(Staff staff, Parameter parameter) {
		return staffDAO.Getzhuanzhengshibai(staff, parameter);
				
	}

	@Override
	public int deletezhuanzhengshibai(String userid) {
		return staffDAO.deletezhuanzhengshibai(userid);
	}

	@Override
	public Grid Getzhengshitingzhi(Staff staff, Parameter parameter) {
		return staffDAO.Getzhengshitingzhi(staff, parameter);
	}

	@Override
	public int deletezhengshitingzhi(String userid) {
		// TODO Auto-generated method stub
		return staffDAO.deletezhengshitingzhi(userid);
	}

	@Override
	public Grid Getlizhijiepin(Staff staff, Parameter parameter) {
		// TODO Auto-generated method stub
		return staffDAO.Getlizhijiepin(staff, parameter);
	}

	@Override
	public int deletelizhijiepin(String userid) {
		return staffDAO.deletelizhijiepin(userid);
	}

	@Override
	public Grid Getyuangongshengri(Staff staff, Parameter parameter) {
		return staffDAO.Getyuangongshengri(staff, parameter);
	}

	@Override
	public Staff getstaffByuserId(String userid) {
		return staffDAO.getstaffByuserId(userid);
	}

	@Override
	public int editStaff(Staff staff) {
		return staffDAO.editStaff(staff);
	}
	




}
