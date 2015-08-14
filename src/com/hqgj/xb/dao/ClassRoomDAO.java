package com.hqgj.xb.dao;

import java.util.List;

import com.hqgj.xb.bean.ClassS;

/**
 * @author 崔兴伟
 * @datetime 2015年8月14日 上午9:55:41
 */
public interface ClassRoomDAO {
	/**
	 * 获取所有教室
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月14日 上午9:56:29
	 * @return
	 */
	public List<ClassS> getClassRooms();

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
