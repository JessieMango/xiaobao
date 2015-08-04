package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.TextBookFee;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 下午5:44:02
 */
public interface TextBookFeeService {
	/**
	 * 后期指定类型所有记录
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 下午5:37:48
	 * @param type
	 *            1代表教材 2代表杂费
	 * @return
	 */
	public List<TextBookFee> getAllTextBookFees(String type);

	/**
	 * 获取教材杂项类型字典表
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 下午5:39:12
	 * @return
	 */
	public List<TextBookFee> getDTextBookFeesType();

	/**
	 * 获取指定ID教材杂项的所有信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 下午5:39:41
	 * @param id
	 * @return
	 */
	public TextBookFee getTextBookFee(String id);
	/**
	 * 添加指定教材杂项的信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 下午5:40:05
	 * @param textBookFee
	 * @return
	 */
	public int addTextBookFee(TextBookFee textBookFee);

	/**
	 * 更新指定教材杂项的信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 下午5:40:05
	 * @param textBookFee
	 * @return
	 */
	public int updateTextBookFee(TextBookFee textBookFee);

	/**
	 * 删除指定的教材杂项信息
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 下午5:43:20
	 * @param id
	 * @return
	 */
	public int deleteTextBookFee(String id);
}
