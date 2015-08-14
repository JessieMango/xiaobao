package com.hqgj.xb.service;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.bean.ClassTimePlan;

/**
 * @author 崔兴伟
 * @datetime 2015年8月13日 下午2:33:34
 */
public interface ClassSService {
	/**
	 * 添加班级
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月13日 下午2:39:41
	 * @return
	 */
	public int addClass(ClassS cla,ClassTimePlan classTimePlan);
}
