package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.Resource;

/**
 * @author 崔兴伟
 * @datetime 2015年7月16日 下午6:22:51
 */
public interface ResourceService {
	/**
	 * 获取资源
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月16日 下午6:22:02
	 * @return
	 */
	public List<Resource> getResource();

	/**
	 * 获取对应父菜单的子菜单
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月22日 下午4:56:55
	 * @param pid
	 * @return
	 */
	public List<Resource> getSubResource(String pid);
}
