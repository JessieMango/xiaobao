package com.hqgj.xb.dao;

import java.util.List;

import com.hqgj.xb.bean.Communication;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 崔兴伟
 * @datetime 2015年8月10日 上午9:44:32
 */
public interface CommunicationDAO {
	/**
	 * 按条件查询沟通记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月10日 上午9:51:59
	 * @param communication
	 * @return
	 */
	public Grid getCommunications(Communication communication,
			Parameter parameter);

	/**
	 * 按头痛记录ID查询指定沟通记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月10日 上午9:52:14
	 * @param id
	 * @return
	 */
	public Communication getCommunicationById(String id);

	/**
	 * 获取沟通类型
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月11日 上午11:29:35
	 * @param type
	 *            type=1表示售前沟通类型,type=2表示获取售后沟通类型
	 * @param flag
	 *            flag=select 表示后台封装全部方式，用于查询条件
	 * @return
	 */
	public List<Communication> getCommunicationType(String type, String flag);

	/**
	 * 按咨询记录ID查询沟通记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月10日 上午9:52:36
	 * @param id
	 * @return
	 */
	public List<Communication> getCommunicationByConsultId(String id);

	/**
	 * 添加沟通记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月10日 上午9:52:57
	 * @param communication
	 * @return
	 */
	public int addCommunication(Communication communication);

	/**
	 * 更新沟通记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月10日 上午9:53:14
	 * @param communication
	 * @return
	 */
	public int updateCommunication(Communication communication);

	/**
	 * 删除沟通记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月10日 上午9:53:25
	 * @param id
	 * @return
	 */
	public int deleteCommunicationById(String id);
}
