package com.hqgj.xb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;




import com.hqgj.xb.bean.Staff;
import com.hqgj.xb.dao.StaffDAO;
import com.hqgj.xb.service.StaffService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月7日 上午9:44:51
 */
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDAO newStaffDAO;
	
	@Override
	public int createStaff(Staff staff){
		return newStaffDAO.createStaff(staff);
	}

}
