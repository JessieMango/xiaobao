package com.hqgj.xb.dao;

import java.util.List;

import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.FinancialRunnningAccount;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 崔兴伟
 * @datetime 2015年8月29日 下午4:53:40
 */
public interface FinancialRunnningAccountDAO {
	/**
	 * 增加流水记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月29日 下午5:30:54
	 * @param financialRunnningAccount
	 * @param financialRunnningAccount
	 *            .operateCode 1表示增加积分 2按期缴费 3补费 4购买教材 5转班转入 6转班转出 7 转班退差额 8预存余额
	 * @return
	 */
	public int addFinancialRunnningAccount(
			FinancialRunnningAccount financialRunnningAccount);

	/**
	 * 获取流水账类型字典表
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月31日 上午10:57:43
	 * @param type
	 *            1表示查询需要
	 * @return
	 */
	public List<Dictionary> getTypeCode(String type);

	/**
	 * 获取流水账方式字典表
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月31日 上午10:58:51
	 * @param type
	 *            1表示查询需要
	 * @return
	 */
	public List<Dictionary> getPayWayCode(String type);

	/**
	 * 获取流水账操作字典表
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月31日 上午11:00:10
	 * @param type
	 *            1表示查询需要
	 * @return
	 */
	public List<Dictionary> getOperateCode(String type);

	/**
	 * 流水账查询
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月31日 上午11:27:40
	 * @param financialRunnningAccount
	 * @param parameter
	 * @return
	 */
	public Grid getFinancialRunnningAccount(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter);

	/**
	 * 交易回收站查询
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年9月6日 上午8:58:58
	 * @param financialRunnningAccount
	 * @param parameter
	 * @return
	 */
	public Grid getFinancialRunnningAccountOfTrash(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter);

	/**
	 * 删除交易记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年9月6日 上午8:35:46
	 * @param id
	 *            交易记录号
	 * @param type
	 *            1表示放入交易回收站 2表示彻底删除 3恢复交易记录
	 * @return
	 */
	public int deleteFinancialRunnningAccount(String id, String type);

	/**
	 * 查询流水日报
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年9月6日 上午9:28:46
	 * @param startTime
	 * @return
	 */
	public List<FinancialRunnningAccount> getRunningwaterDaily(String startTime);

}
