package com.hqgj.xb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.RecordLesson;
import com.hqgj.xb.dao.RecordLessonDAO;
import com.hqgj.xb.service.RecordLessonService;

/**
 * @datetime 2015年10月12日 下午3:13:42
 * @author 崔兴伟
 */
@Service
public class RecordLessonServiceImpl implements RecordLessonService {
	@Autowired
	private RecordLessonDAO recordLessonDAO;
	
	@Override
	public int addRecordLesson(RecordLesson recordLesson) {
		return recordLessonDAO.addRecordLesson(recordLesson);
	}

}
