package com.hqgj.xb.dao;

import java.util.Date;
import java.util.List;

import com.hqgj.xb.bean.SystemLog;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 下午3:20:14
 */
public interface SystemLogDAO {
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
	 * 读日志
	 * 
	 * @author 鲁宗豪
	 * @datetime 2015年8月5日 下午4：29:51
	 * @param parameter
	 * @return
	 */
	public Grid readLog(SystemLog systemLog,Parameter parameter);
	
	/**
	 * 读日志
	 * 
	 * @author 鲁宗豪
	 * @datetime 2015年8月5日 下午6：29:51
	 * @return
	 */
	public List<SystemLog> readOperateType();
	
}
