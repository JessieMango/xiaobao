package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.bean.ClassTimePlan;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.ClassSDAO;
import com.hqgj.xb.service.ClassSService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月13日 下午2:52:25
 */
@Service
public class ClassSServiceImpl implements ClassSService {
	@Autowired
	private ClassSDAO classSDAO;

	@Override
	public int addClass(ClassS cla, ClassTimePlan classTimePlan) {
		return classSDAO.addClass(cla, classTimePlan);
	}

	@Override
	public Grid getClass(ClassS classS, Parameter parameter) {
		return classSDAO.getClass(classS, parameter);
	}

	@Override
	public int deleteClass(String classCode) {
		return classSDAO.deleteClass(classCode);
	}

	@Override
	public ClassS getClassSByClassCode(String classCode) {
		return classSDAO.getClassSByClassCode(classCode);
	}

	@Override
	public int updateClass(ClassS cla, ClassTimePlan classTimePlan) {
		return classSDAO.updateClass(cla, classTimePlan);
	}

	@Override
	public List<ClassS> getClassSByCourseCode(String courseCode) {
		return classSDAO.getClassSByCourseCode(courseCode);
	}

}
