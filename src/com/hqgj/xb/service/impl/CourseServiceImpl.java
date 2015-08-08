package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Course;
import com.hqgj.xb.dao.CourseDAO;
import com.hqgj.xb.service.CourseService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 上午9:26:30
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDAO courseDAO;
	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = courseDAO.getAllCourses();
		for(Course course : courses){
			course.setDelete(course.getCourseTypeName());
			course.setEdit(course.getCourseTypeName());
		}
		return courses;
	}

	@Override
	public List<Course> getCourseTypes(String type) {
		return courseDAO.getCourseTypes(type);
	}

	@Override
	public Course getCourseById(String id) {
		return courseDAO.getCourseById(id);
	}

	@Override
	public Course getCourseTypeById(String id) {
		return courseDAO.getCourseTypeById(id);
	}

	@Override
	public int addCourseType(Course course) {
		return courseDAO.addCourseType(course);
	}

	@Override
	public int addCourse(Course course) {
		return courseDAO.addCourse(course);
	}

	@Override
	public int updateCourseType(Course course) {
		return courseDAO.updateCourseType(course);
	}

	@Override
	public int updateCourse(Course course) {
		return courseDAO.updateCourse(course);
	}

	@Override
	public int deleteCourseType(String id) {
		return courseDAO.deleteCourseType(id);
	}

	@Override
	public int deleteCourse(String id) {
		return courseDAO.deleteCourse(id);
	}

}
