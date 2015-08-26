package com.hqgj.xb.service;

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.StudentClass;

/**
 * @author 崔兴伟
 * @datetime 2015年8月24日 下午5:41:15
 */
public interface StudentClassService {
	/**
	 * 学生报名
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月24日 下午5:43:52
	 * @param studentClass
	 * @return
	 */
	public int addStudentClass(StudentClass studentClass);

	/**
	 * 无咨询记录学生报名
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月26日 下午2:11:15
	 * @param studentClass
	 * @param consult
	 * @return
	 */
	public int addStudentClassNo(StudentClass studentClass, Consult consult);

}
