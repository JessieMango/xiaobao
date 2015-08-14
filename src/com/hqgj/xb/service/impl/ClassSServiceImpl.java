package com.hqgj.xb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.bean.ClassTimePlan;
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

}
