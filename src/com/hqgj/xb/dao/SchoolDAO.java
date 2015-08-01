package com.hqgj.xb.dao;

import java.util.List;

import com.hqgj.xb.bean.School;

/**
 * @author 崔兴伟
 * @datetime 2015年8月1日 下午4:21:32
 */
public interface SchoolDAO {
	/**
	 * 获取所有学校信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月1日 下午4:23:19
	 * @return
	 */
	public List<School> getAllSchools();

	/**
	 * 获取指定学校信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月1日 下午5:36:34
	 * @param schoolCode
	 * @return
	 */
	public School getSchoolById(String schoolCode);

	/**
	 * 获取学校类型
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月1日 下午4:23:35
	 * @return
	 */
	public List<School> getSchoolType();

	/**
	 * 更新学校信息按学校ID
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月1日 下午4:23:46
	 * @param school
	 * @return
	 */
	public int updateSchoolBySchoolCode(School school);

	/**
	 * 删除学校
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月1日 下午4:24:04
	 * @param school
	 * @return
	 */
	public int deleteSchoolBySchoolCode(School school);
}
