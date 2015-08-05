package com.hqgj.xb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.SystemLog;
import com.hqgj.xb.dao.SystemLogDAO;
import com.hqgj.xb.service.SystemLogService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 下午3:20:57
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {
	@Autowired
	private SystemLogDAO systemLogDAO;

	@Override
	public int writeLog(SystemLog log) {
		return systemLogDAO.writeLog(log);
	}

}
