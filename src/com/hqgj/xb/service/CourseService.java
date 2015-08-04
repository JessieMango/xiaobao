package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.Course;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 上午9:25:28
 */
public interface CourseService {
	/**
	 * 获取所有课程信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:21:40
	 * @return
	 */
	public List<Course> getAllCourses();

	/**
	 * 获取所有课程大类
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:24:57
	 * @return
	 */
	public List<Course> getCourseTypes();

	/**
	 * 获取指定课程信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:21:56
	 * @param id
	 * @return
	 */
	public Course getCourseById(String id);

	/**
	 * 获取课程大类信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:22:36
	 * @param id
	 * @return
	 */
	public Course getCourseTypeById(String id);

	/**
	 * 增加课程大类
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:23:09
	 * @param course
	 * @return
	 */
	public int addCourseType(Course course);

	/**
	 * 增加课程信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:23:20
	 * @param course
	 * @return
	 */
	public int addCourse(Course course);

	/**
	 * 修改课程大类信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:23:37
	 * @param course
	 * @return
	 */
	public int updateCourseType(Course course);

	/**
	 * 修改课程信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:24:01
	 * @param course
	 * @return
	 */
	public int updateCourse(Course course);

	/**
	 * 删除课程大类信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:23:37
	 * @param course
	 * @return
	 */
	public int deleteCourseType(String id);

	/**
	 * 删除课程信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:24:01
	 * @param course
	 * @return
	 */
	public int deleteCourse(String id);
}
