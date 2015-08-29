package com.hqgj.xb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.OldStudentAgainEnroll;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.OldStudentAgainEnrollDAO;
import com.hqgj.xb.service.OldStudentAgainEnrollService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月26日 下午5:15:27
 */
@Service
public class OldStudentAgainEnrollServiceImpl implements
		OldStudentAgainEnrollService {

	@Autowired
	private OldStudentAgainEnrollDAO oldStudentAgainEnrollDAO;

	@Override
	public Grid getOldStudentAgainEnrolls(OldStudentAgainEnroll oldStudentAgainEnroll,
			Parameter parameter) {
		return oldStudentAgainEnrollDAO.getOldStudentAgainEnrolls(oldStudentAgainEnroll, parameter);
	}

}
