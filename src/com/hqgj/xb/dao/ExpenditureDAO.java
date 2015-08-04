package com.hqgj.xb.dao;

import java.util.List;

import com.hqgj.xb.bean.Expenditure;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 上午11:13:23
 */
public interface ExpenditureDAO {
	/**
	 * 获取所有子项目记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:23:45
	 * @return
	 */
	public List<Expenditure> getAllExpenditureProjects();

	/**
	 * 获取指定ID支出大类记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:24:01
	 * @param id
	 * @return
	 */
	public Expenditure getExpenditure(String id);

	/**
	 * 获取指定子项目记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:24:40
	 * @param id
	 * @return
	 */
	public Expenditure getExpenditureProject(String id);

	/**
	 * 获取所有支出大类记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:25:14
	 * @return
	 */
	public List<Expenditure> getAllExpenditures();

	/**
	 * 添加支出大类记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:25:38
	 * @param expenditure
	 * @return
	 */
	public int addExpenditure(Expenditure expenditure);

	/**
	 * 添加支出子项目记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:25:56
	 * @param expenditure
	 * @return
	 */
	public int addExpenditureProject(Expenditure expenditure);

	/**
	 * 更新支出大类记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:26:13
	 * @param expenditure
	 * @return
	 */
	public int updateExpenditure(Expenditure expenditure);

	/**
	 * 更新支出子项目记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:26:43
	 * @param expenditure
	 * @return
	 */
	public int updateExpenditureProject(Expenditure expenditure);

	/**
	 * 删除指定支出大类记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:26:57
	 * @param id
	 * @return
	 */
	public int deleteExpenditure(String id);

	/**
	 * 删除指定子项目信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:27:25
	 * @param id
	 * @return
	 */
	public int deleteExpenditureProject(String id);
}
