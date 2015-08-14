package com.hqgj.xb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.SystemLog;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.service.SystemLogService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月5日 下午4:08:45
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class SystemLogController {
	
	@Autowired
	private SystemLogService systemLogService;

	
	@RequestMapping(value = {"/xitong/readLog","/kaishi/readLog"}, method = RequestMethod.POST)
	public @ResponseBody Grid readLog(Parameter parameter,String cc,String cb) {
		SystemLog systemLog=new SystemLog();
		systemLog.setOperateTime(cc);
		systemLog.setOperateType(cb);		
		return systemLogService.readLog(systemLog,parameter);
	}
	
	@RequestMapping(value = {"/xitong/readOperateType","/kaishi/readOperateType"}, method = RequestMethod.POST)
	public @ResponseBody List<SystemLog> readOperateType() {
		return systemLogService.readOperateType();
		
	}
}
