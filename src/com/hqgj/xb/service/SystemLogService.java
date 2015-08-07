package com.hqgj.xb.service;

import java.util.Date;
import java.util.List;

import com.hqgj.xb.bean.SystemLog;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 下午3:13:46
 */
public interface SystemLogService {
	/**
	 * 写日志
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 下午3:15:51
	 * @param log
	 * @return
	 */
	public int writeLog(SystemLog log);
	
	
	/**
	 * 写日志
	 * 
	 * @author 鲁宗豪
	 * @datetime 2015年8月5日 下午4:15:51
	 * @param 
	 * @return
	 */
	public Grid readLog(SystemLog systemLog,Parameter parameter);
	

	/**
	 * 写日志
	 * 
	 * @author 鲁宗豪
	 * @datetime 2015年8月5日 下午6:26:51
	 * @param 
	 * @return
	 */
	public List<SystemLog> readOperateType();
}
