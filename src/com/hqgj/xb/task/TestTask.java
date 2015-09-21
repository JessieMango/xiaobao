package com.hqgj.xb.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hqgj.xb.dao.ChangeClassStatusDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年9月18日 下午3:06:56
 */
@Component
public class TestTask {
	Logger logger = Logger.getLogger(TestTask.class);
	@Autowired
	private ChangeClassStatusDAO changeClassStatusDAO;

	@Scheduled(cron = "59 59 23 * * ?")
	// 每天晚上24点触发一次
	synchronized public void doSomething() {
		changeClassStatusDAO.changeClassStatus();
		logger.info("修改班级状态");
	}
}
