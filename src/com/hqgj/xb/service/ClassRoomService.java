package com.hqgj.xb.service;

import java.util.List;

import com.hqgj.xb.bean.ClassS;

/**
 * @author 崔兴伟
 * @datetime 2015年8月14日 上午9:57:47
 */
public interface ClassRoomService {
	/**
	 * 获取所有教室
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月14日 上午9:56:29
	 * @param type
	 *            type=1表示commobox查询需要，后台插入全部一列
	 * @return
	 */
	public List<ClassS> getClassRooms(String type);

	/**
	 * 添加教室
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月14日 上午9:57:21
	 * @param classS
	 * @return
	 */
	public int addClassRoom(ClassS classS);
}
