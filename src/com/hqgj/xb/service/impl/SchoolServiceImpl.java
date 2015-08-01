package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.School;
import com.hqgj.xb.dao.SchoolDAO;
import com.hqgj.xb.service.SchoolService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月1日 下午4:25:16
 */
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDAO schoolDAO;

	@Override
	public List<School> getAllSchools() {
		return schoolDAO.getAllSchools();
	}

	@Override
	public List<School> getSchoolType() {
		return schoolDAO.getSchoolType();
	}

	@Override
	public int updateSchoolBySchoolCode(School school) {
		return schoolDAO.updateSchoolBySchoolCode(school);
	}

	@Override
	public int deleteSchoolBySchoolCode(School school) {
		return schoolDAO.deleteSchoolBySchoolCode(school);
	}

	@Override
	public School getSchoolById(String schoolCode) {
		return schoolDAO.getSchoolById(schoolCode);
	}

}
