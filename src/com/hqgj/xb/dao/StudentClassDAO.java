package com.hqgj.xb.dao;

import java.util.List;

import com.hqgj.xb.bean.StudentClass;
import com.hqgj.xb.bean.StudentClass_TextbookFee;

/**
 * @author 崔兴伟
 * @datetime 2015年8月24日 下午5:41:00
 */
public interface StudentClassDAO {
	/**
	 * 学生报名
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月24日 下午5:43:52
	 * @param studentClass
	 * @return
	 */
	public int addStudentClass(List<StudentClass> studentClasses,
			List<StudentClass_TextbookFee> studentClass_TextbookFees);

}
