package com.hqgj.xb.service;

import com.hqgj.xb.bean.OldStudentAgainEnroll;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 崔兴伟
 * @datetime 2015年8月26日 下午5:15:10
 */
public interface OldStudentAgainEnrollService {
	/**
	 * 根据姓名和电话尾号查询已报名学生信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月26日 下午5:22:17
	 * @param nameM
	 * @param telTail
	 * @return
	 */
	public Grid getOldStudentAgainEnrolls(
			OldStudentAgainEnroll oldStudentAgainEnroll, Parameter parameter);
}
