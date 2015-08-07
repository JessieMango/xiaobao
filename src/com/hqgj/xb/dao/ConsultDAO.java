package com.hqgj.xb.dao;

import java.util.List;

import com.hqgj.xb.bean.Consult;

/**
 * @author 崔兴伟
 * @datetime 2015年8月6日 下午3:15:37
 */
public interface ConsultDAO {
	/**
	 * 查询所有公立学校
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:16:54
	 * @return
	 */
	public List<Consult> getCouncilSchools();

	/**
	 * 获取所有意向度
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:55:52
	 * @return
	 */
	public List<Consult> getWillDegree();

	/**
	 * 获取所有标记
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:57:26
	 * @return
	 */
	public List<Consult> getMark();

	/**
	 * 获取所有销售来源
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:58:06
	 * @return
	 */
	public List<Consult> getSellSource();

	/**
	 * 获取所有销售员信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:59:07
	 * @return
	 */
	public List<Consult> getSeller();

	/**
	 * 获取所有经办人
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:59:42
	 * @return
	 */
	public List<Consult> getHandler();

	/**
	 * 保存新咨询数据到数据库
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午6:01:57
	 * @return
	 */
	public int saveConsult(Consult consult);
}
