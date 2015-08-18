package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.dao.ClassRoomDAO;
import com.hqgj.xb.service.ClassRoomService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月14日 上午9:58:24
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {
	@Autowired
	private ClassRoomDAO classRoomDAO;

	@Override
	public List<ClassS> getClassRooms(String type) {
		return classRoomDAO.getClassRooms(type);
	}

	@Override
	public int addClassRoom(ClassS classS) {
		return classRoomDAO.addClassRoom(classS);
	}

}
