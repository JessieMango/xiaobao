package com.hqgj.xb.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.bean.ClassTimePlan;
import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.dao.ClassRoomDAO;
import com.hqgj.xb.dao.ClassSDAO;
import com.hqgj.xb.dao.UserDao;
import com.hqgj.xb.util.MD5Util;

/**
 * @author 崔兴伟
 * @datetime 2015年8月13日 下午2:31:36
 */
@Repository
public class ClassSDAOImpl implements ClassSDAO {
	private Logger logger = Logger.getLogger(ClassSDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ClassRoomDAO classRoomDAO;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int addClass(ClassS cla, ClassTimePlan classTimePlan) {
		cla.setClassCode(UUID.randomUUID().toString());
		cla.setClassState("0"); // 默认未开课
		cla = handlerDictionary(cla);

		List<ClassTimePlan> classTimePlans = new ArrayList<ClassTimePlan>();
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday1())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday1());
			ctp.setStartTime(classTimePlan.getStartTime1());
			ctp.setEndTime(classTimePlan.getEndTime1());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday2())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday2());
			ctp.setStartTime(classTimePlan.getStartTime2());
			ctp.setEndTime(classTimePlan.getEndTime2());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday3())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday3());
			ctp.setStartTime(classTimePlan.getStartTime3());
			ctp.setEndTime(classTimePlan.getEndTime3());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday4())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday4());
			ctp.setStartTime(classTimePlan.getStartTime4());
			ctp.setEndTime(classTimePlan.getEndTime4());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday5())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday5());
			ctp.setStartTime(classTimePlan.getStartTime5());
			ctp.setEndTime(classTimePlan.getEndTime5());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday6())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday6());
			ctp.setStartTime(classTimePlan.getStartTime6());
			ctp.setEndTime(classTimePlan.getEndTime6());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday7())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday7());
			ctp.setStartTime(classTimePlan.getStartTime7());
			ctp.setEndTime(classTimePlan.getEndTime7());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			classTimePlans.add(ctp);
		}

		String sql = "insert into Class (classCode,nameM,courseCode,schoolCode,tuitionType,tuition,classTimes,startDate,endDate,dateUndetermined,"
				+ "teacherCode,assistantCode,classRoomCode,ratedNumber,remark,classState) values (:classCode,:nameM,:courseCode,:schoolCode,:tuitionType,"
				+ ":tuition,:classTimes,:startDate,:endDate,:dateUndetermined,:teacherCode,:assistantCode,:classRoomCode,:ratedNumber,:remark,:classState)";
		SqlParameterSource nParameterSource = new BeanPropertySqlParameterSource(
				cla);
		int n1 = this.nJdbcTemplate.update(sql, nParameterSource);
		String sqlBatch = "insert into ClassTimePlan (id,week,startTime,endTime,classCode) values (:id,:week,:startTime,:endTime,:classCode)";
		SqlParameterSource[] parameterSources = SqlParameterSourceUtils
				.createBatch(classTimePlans.toArray());
		int[] ninserts = this.nJdbcTemplate.batchUpdate(sqlBatch,
				parameterSources);
		logger.info("班级" + cla.getNameM() + ":每周上" + ninserts.length + "天课");
		return n1;
	}

	public ClassS handlerDictionary(ClassS classS) {
		boolean result = false;
		// 教师处理
		List<User> users = userDao.getUsersByRoleId("4");
		if (StringUtils.isNotBlank(classS.getTeacherCode())) {
			for (User user : users) {
				if (StringUtils.equals(user.getUserId(),
						classS.getTeacherCode())) {
					classS.setTeacherCode(user.getUserId());
					result = true;
				}
			}
			if (!result) {
				classS.setTeacherName(classS.getTeacherCode());
				classS.setTeacherCode(UUID.randomUUID().toString());

				String sqlUser = "insert into User (userId,username) "
						+ "values (:userId,:username)";
				String sqlUser_Role = "insert into User_Role (user_id,role_id) values (:userId,:roleId)";
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", classS.getTeacherCode());
				map.put("username", classS.getTeacherName());
				map.put("roleId", "4");
				this.nJdbcTemplate.update(sqlUser, map);
				this.nJdbcTemplate.update(sqlUser_Role, map);
			}
		}

		// 助教处理
		result = false;
		users = userDao.getUsersByRoleId("11");
		if (StringUtils.isNotBlank(classS.getAssistantCode())) {
			for (User user : users) {
				if (StringUtils.equals(user.getUserId(),
						classS.getAssistantCode())) {
					classS.setAssistantCode(user.getUserId());
					result = true;
				}
			}
			if (!result) {
				classS.setAssistantName(classS.getAssistantCode());
				classS.setAssistantCode(UUID.randomUUID().toString());

				String sqlUser = "insert into User (userId,username) "
						+ "values (:userId,:username)";
				String sqlUser_Role = "insert into User_Role (user_id,role_id) values (:userId,:roleId)";
				Map<String, String> map = new HashMap<String, String>();
				map.put("userId", classS.getAssistantCode());
				map.put("username", classS.getAssistantName());
				map.put("roleId", "11");
				this.nJdbcTemplate.update(sqlUser, map);
				this.nJdbcTemplate.update(sqlUser_Role, map);
			}
		}

		// 教室处理
		result = false;
		List<ClassS> classSs = classRoomDAO.getClassRooms();
		if (StringUtils.isNotBlank(classS.getClassRoomCode())) {
			for (ClassS classroom : classSs) {
				if (StringUtils.equals(classroom.getClassRoomCode(),
						classS.getClassRoomCode())) {
					classS.setClassRoomCode(classroom.getClassRoomCode());
					result = true;
				}
			}
			if (!result) {
				classS.setClassRoomName(classS.getClassRoomCode());
				classS.setClassRoomCode(UUID.randomUUID().toString());

				String sql = "insert into ClassRoom (classRoomCode,classRoomName) "
						+ "values (:classRoomCode,:classRoomName)";
				Map<String, String> map = new HashMap<String, String>();
				map.put("classRoomCode", classS.getClassRoomCode());
				map.put("classRoomName", classS.getClassRoomName());
				this.nJdbcTemplate.update(sql, map);
			}
		}

		return classS;
	}
}
