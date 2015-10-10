package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;

/**
 * @author 崔兴伟
 * @datetime 2015年8月6日 下午4:00:32
 */
public interface ConsultService {
	/**
	 * 查询所有公立学校
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:16:54
	 * @return
	 */
	public List<Consult> getCouncilSchools(String type);

	/**
	 * 获取所有咨询方式
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月7日 下午2:44:36
	 * @return
	 */
	public List<Consult> getConsultWay(String type);

	/**
	 * 获取所有意向度
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:55:52
	 * @return
	 */
	public List<Consult> getWillDegree(String type);

	/**
	 * 获取所有标记
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:57:26
	 * @return
	 */
	public List<Consult> getMark(String type);

	/**
	 * 获取所有销售来源
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:58:06
	 * @return
	 */
	public List<Consult> getSellSource(String type);

	/**
	 * 获取所有销售员信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:59:07
	 * @return
	 */
	public List<Consult> getSeller(String type);

	/**
	 * 获取所有经办人
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午3:59:42
	 * @return
	 */
	public List<Consult> getHandler(String type);

	/**
	 * 保存新咨询数据到数据库
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月6日 下午6:01:57
	 * @return
	 */
	public int saveConsult(Consult consult);

	/**
	 * 按条件查询咨询记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月7日 下午2:45:33
	 * @param consult
	 * @return
	 */
	public Grid getConsult(Consult consult, Parameter parameter);

	/**
	 * 根据ID查询记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月8日 下午4:48:52
	 * @param id
	 * @return
	 */
	public Consult getConsultById(String id);

	/**
	 * 编辑指定ID记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月8日 下午4:48:52
	 * @param id
	 * @return
	 */
	public int updateConsult(Consult consult);

	/**
	 * 删除自定ID的咨询记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月10日 上午10:59:44
	 * @param id
	 * @return
	 */
	public int deleteConsult(String id);
	
	public Grid GetShengRiXueYuan(String StudentMonth, Parameter parameter);
}
