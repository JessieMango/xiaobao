package com.hqgj.xb.service;

import com.hqgj.xb.bean.SystemLog;

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
}
