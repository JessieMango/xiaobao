package com.hqgj.xb.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.RecordLesson;
import com.hqgj.xb.dao.RecordLessonDAO;

/**
 * @datetime 2015年10月12日 下午3:15:05
 * @author 崔兴伟
 */
@Repository
public class RecordLessonDAOImpl implements RecordLessonDAO {
	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int addRecordLesson(RecordLesson recordLesson) {
		java.util.List<RecordLesson> recordLessons = new ArrayList<RecordLesson>();
		String[] stucheckbox = recordLesson.getStucheckbox().split(",");
		String[] disciplinePoints = recordLesson.getDisciplinePoints().split(
				",");
		String[] activePoints = recordLesson.getActivePoints().split(",");
		String[] comment = recordLesson.getComment().split(",");
		String[] studentCode = recordLesson.getStudentCode().split(",");
		for (int i = 0; i < stucheckbox.length; i++) {
			if (StringUtils.equals("on", stucheckbox[i])) {
				RecordLesson rlLesson = new RecordLesson();
				rlLesson.setId(UUID.randomUUID().toString());
				rlLesson.setActivePoints(activePoints[i]);
				rlLesson.setDisciplinePoints(disciplinePoints[i]);
				rlLesson.setActualNumber(recordLesson.getActualNumber());
				rlLesson.setStudentCode(studentCode[i]);
				rlLesson.setComment(comment[i]);
				rlLesson.setClassCode(recordLesson.getClassCode());
				rlLesson.setLessonContent(recordLesson.getLessonContent());
				rlLesson.setLessonNumbers(recordLesson.getLessonNumbers());
				rlLesson.setRemark(recordLesson.getRemark());
				rlLesson.setOperateDate(recordLesson.getOperateDate());
				rlLesson.setHandlerCode(recordLesson.getHandlerCode());
				rlLesson.setTeacher(recordLesson.getTeacher());
				rlLesson.setAssistant(recordLesson.getAssistant());
				rlLesson.setAfterTask(recordLesson.getAfterTask());
				recordLessons.add(rlLesson);
				Map<String, String> map = new HashMap<String, String>();
				map.put("classCode", recordLesson.getClassCode());
				map.put("studentCode", studentCode[i]);
				map.put("lessonNumbers", recordLesson.getLessonNumbers());
				this.nJdbcTemplate
						.update("update StudentClass set realClassTimes=realClassTimes+:lessonNumbers where classCode=:classCode and studentCode=:studentCode",
								map);
			}
		}
		SqlParameterSource[] parameterSources = SqlParameterSourceUtils
				.createBatch(recordLessons.toArray());
		String sqlAdd = "INSERT INTO RecordLesson(id,studentCode,classCode,disciplinePoints,activePoints,comment,"
				+ "lessonNumbers,lessonContent,afterTask,remark,lessonDate,handlerCode,teacher,assistant) values "
				+ "(:id,:studentCode,:classCode,:disciplinePoints,:activePoints,:comment,:lessonNumbers,:lessonContent,"
				+ ":afterTask,:remark,:lessonDate,:handlerCode,:teacher,:assistant)";
		int[] n = this.nJdbcTemplate.batchUpdate(sqlAdd, parameterSources);
		return n.length;
	}

}
