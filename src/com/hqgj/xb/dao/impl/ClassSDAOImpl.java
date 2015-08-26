package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.ClassS;
import com.hqgj.xb.bean.ClassTimePlan;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.ClassRoomDAO;
import com.hqgj.xb.dao.ClassSDAO;
import com.hqgj.xb.dao.UserDao;

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
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday1());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday1());
			}
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
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday2());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday2());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday3())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday3());
			ctp.setStartTime(classTimePlan.getStartTime3());
			ctp.setEndTime(classTimePlan.getEndTime3());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday3());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday3());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday4())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday4());
			ctp.setStartTime(classTimePlan.getStartTime4());
			ctp.setEndTime(classTimePlan.getEndTime4());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday4());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday4());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday5())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday5());
			ctp.setStartTime(classTimePlan.getStartTime5());
			ctp.setEndTime(classTimePlan.getEndTime5());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday5());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday5());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday6())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday6());
			ctp.setStartTime(classTimePlan.getStartTime6());
			ctp.setEndTime(classTimePlan.getEndTime6());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday6());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday6());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday7())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday7());
			ctp.setStartTime(classTimePlan.getStartTime7());
			ctp.setEndTime(classTimePlan.getEndTime7());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday7());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday7());
			}
			classTimePlans.add(ctp);
		}

		String sql = "insert into Class (classCode,nameM,courseCode,courseTypeCode,schoolCode,tuitionType,tuition,classTimes,startDate,endDate,dateUndetermined,"
				+ "teacherCode,assistantCode,classRoomCode,ratedNumber,remark,classState,weekString) values (:classCode,:nameM,:courseCode,:courseTypeCode,:schoolCode,:tuitionType,"
				+ ":tuition,:classTimes,:startDate,:endDate,:dateUndetermined,:teacherCode,:assistantCode,:classRoomCode,:ratedNumber,:remark,:classState,:weekString)";
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
		List<User> users = userDao.getUsersByRoleId("4", false);
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
		users = userDao.getUsersByRoleId("11", false);
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
		List<ClassS> classSs = classRoomDAO.getClassRooms(null);
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

	@Override
	public Grid getClass(ClassS classS, Parameter parameter) {
		String select = "select c.nameM,c.courseTypeCode,c.schoolCode,s.schoolName,c.weekString,c.classCode,c.courseCode,co.nameM courseName,c.tuitionType,c.tuition,c.classTimes,c.classState,"
				+ "c.startDate,c.endDate,c.dateUndetermined,c.teacherCode,u.username teacherName,c.assistantCode,uu.username assistantName,"
				+ "c.classRoomCode,cr.classRoomName,c.ratedNumber,c.remark from Class c left outer  join School s on s.schoolCode=c.schoolCode "
				+ "left outer join Course co on co.courseCode=c.courseCode left outer join ClassRoom cr on cr.classRoomCode=c.classRoomCode "
				+ "left outer join User u on u.userId=c.teacherCode left outer join User uu on uu.userId=c.assistantCode";
		if (classS.getSchoolCode() != null) { // 如果是按照条件2查询
			if ((!StringUtils.equals("qb", classS.getSchoolCode())
					|| !StringUtils.equals("qb", classS.getCourseTypeCode())
					|| !StringUtils.equals("qb", classS.getTeacherCode())
					|| !StringUtils.equals("qb", classS.getTuitionType())
					|| !StringUtils.equals("qb", classS.getWeek())
					|| !StringUtils.equals("qb", classS.getYear())
					|| !StringUtils.equals("qb", classS.getMonth())
					|| !StringUtils.equals("qb", classS.getClassRoomCode()) || !StringUtils
						.equals("qb", classS.getClassState()))) {
				select += " where ";
				int time = 0;
				if (!StringUtils.equals("qb", classS.getSchoolCode())) {
					select += " c.schoolCode=:schoolCode ";
					time++;
				}
				if (!StringUtils.equals("qb", classS.getCourseTypeCode())) {
					if (0 < time) {
						select += "and c.courseTypeCode=:courseTypeCode ";
					} else {
						select += " c.courseTypeCode=:courseTypeCode ";
					}
					time++;
				}
				if (!StringUtils.equals("qb", classS.getClassState())) {
					if (0 < time) {
						select += "and c.classState=:classState ";
					} else {
						select += " c.classState=:classState ";
					}
					time++;
				}
				if (!StringUtils.equals("qb", classS.getTeacherCode())) {
					if (0 < time) {
						select += "and c.teacherCode=:teacherCode ";
					} else {
						select += "c.teacherCode=:teacherCode ";
					}
					time++;
				}
				if (!StringUtils.equals("qb", classS.getTuitionType())) {
					if (0 < time) {
						select += "and c.tuitionType=:tuitionType ";
					} else {
						select += "c.tuitionType=:tuitionType ";
					}
					time++;
				}
				if (!StringUtils.equals("qb", classS.getWeek())) {
					classS.setWeekString("%" + classS.getWeek() + "%");
					if (0 < time) {
						select += "and c.weekString like :weekString ";
					} else {
						select += "c.weekString like :weekString ";
					}
					time++;
				}
				if (!StringUtils.equals("qb", classS.getYear())) {
					if (0 < time) {
						select += "and DATE_FORMAT(c.startDate, '%Y')=:year ";
					} else {
						select += "DATE_FORMAT(c.startDate, '%Y')=:year ";
					}
					time++;
				}
				if (!StringUtils.equals("qb", classS.getMonth())) {
					if (0 < time) {
						select += "and DATE_FORMAT(c.startDate, '%c')=:month ";
					} else {
						select += "DATE_FORMAT(c.startDate, '%c')=:month ";
					}
					time++;
				}
				if (!StringUtils.equals("qb", classS.getClassRoomCode())) {
					if (0 < time) {
						select += "and c.classRoomCode=:classRoomCode ";
					} else {
						select += "c.classRoomCode=:classRoomCode ";
					}
					time++;

				}
			}

			if (StringUtils.equals("1", classS.getOrder())) {
				select += " order by c.startDate";
			} else if (StringUtils.equals("2", classS.getOrder())) {
				select += " order by c.teacherCode ";
			} else if (StringUtils.equals("3", classS.getOrder())) {
				select += " order by c.classRoomCode ";
			} else if (StringUtils.equals("4", classS.getOrder())) {
				select += " order by c.tuitionType ";
			}
		} else if (StringUtils.isNotBlank(classS.getNameM())) { // 按照条件1
			if (StringUtils.isNotBlank(classS.getNameM())) {
				select += " where c.nameM=:nameM ";
			}
		} else { // 默认查询全部班级信息

		}
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				classS);
		final List<ClassS> results = new ArrayList<ClassS>();
		this.nJdbcTemplate.query(select, namedParameters,
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						ClassS classS = new ClassS();
						classS.setAssistantCode(rs.getString("assistantCode"));
						classS.setAssistantName(rs.getString("assistantName"));
						classS.setClassCode(rs.getString("classCode"));
						classS.setClassRoomCode(rs.getString("classRoomCode"));
						classS.setClassRoomName(rs.getString("classRoomName"));
						classS.setClassState(rs.getString("classState"));
						classS.setClassTimes(rs.getString("classTimes"));
						classS.setCourseCode(rs.getString("courseCode"));
						classS.setCourseName(rs.getString("courseName"));
						classS.setCourseTypeCode(rs.getString("courseTypeCode"));
						classS.setDateUndetermined(rs
								.getString("dateUndetermined"));
						classS.setEndDate(rs.getString("endDate"));
						classS.setNameM(rs.getString("nameM"));
						classS.setRatedNumber(rs.getString("ratedNumber"));
						classS.setRemark(rs.getString("remark"));
						classS.setSchoolCode(rs.getString("schoolCode"));
						classS.setSchoolName(rs.getString("schoolName"));
						classS.setStartDate(rs.getString("startDate"));
						classS.setTeacherCode(rs.getString("teacherCode"));
						classS.setTeacherName(rs.getString("teacherName"));
						classS.setTuition(rs.getString("tuition"));
						classS.setTuitionType(rs.getString("tuitionType"));
						classS.setWeekString(rs.getString("weekString"));
						results.add(classS);
					}
				});

		String sqlTime = "select * from ClassTimePlan order by classCode";
		final List<ClassTimePlan> classTimePlans = new ArrayList<ClassTimePlan>();
		this.nJdbcTemplate.query(sqlTime, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				ClassTimePlan classTimePlan = new ClassTimePlan();
				classTimePlan.setId(rs.getString("id"));
				classTimePlan.setWeek(rs.getString("week"));
				classTimePlan.setStartTime(rs.getString("startTime"));
				classTimePlan.setEndTime(rs.getString("endTime"));
				classTimePlan.setClassCode(rs.getString("classCode"));
				classTimePlans.add(classTimePlan);
			}
		});

		// 把每个班的上课时间转换成[classCode,[time1,time2...]]这种形式
		String first = "", last = "";
		final List<ClassTimePlan> classTimePlansAfters = new ArrayList<ClassTimePlan>();
		ClassTimePlan temp = new ClassTimePlan();
		for (ClassTimePlan cPlan : classTimePlans) {
			first = cPlan.getClassCode();
			if (StringUtils.equals(cPlan.getWeek(), "1")) {
				cPlan.setWeek("周一 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "2")) {
				cPlan.setWeek("周二 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "3")) {
				cPlan.setWeek("周三 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "4")) {
				cPlan.setWeek("周四 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "5")) {
				cPlan.setWeek("周五 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "6")) {
				cPlan.setWeek("周六 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "7")) {
				cPlan.setWeek("周日 ");
			}
			if (StringUtils.equals(first, last)) {
				temp.setStartTime1(temp.getStartTime1() + "," + cPlan.getWeek()
						+ cPlan.getStartTime() + "-" + cPlan.getEndTime());
			} else {
				if (StringUtils.isNotBlank(last)) {
					classTimePlansAfters.add(temp);
				}
				temp = new ClassTimePlan();
				temp.setClassCode(cPlan.getClassCode());
				temp.setStartTime1(cPlan.getWeek() + cPlan.getStartTime() + "-"
						+ cPlan.getEndTime());
			}
			last = cPlan.getClassCode();
		}
		classTimePlansAfters.add(temp);

		for (ClassTimePlan cPlan : classTimePlansAfters) {
			for (ClassS cS : results) {
				if (StringUtils.equals(cS.getClassCode(), cPlan.getClassCode())) {
					cS.setWeekString(cPlan.getStartTime1());
				}
			}
		}

		Grid grid = new Grid();
		if ((int) parameter.getPage() > 0) {
			int page = (int) parameter.getPage();
			int rows = (int) parameter.getRows();
			int fromIndex = (page - 1) * rows;
			int toIndex = (results.size() <= page * rows && results.size() >= (page - 1)
					* rows) ? results.size() : page * rows;
			grid.setRows(results.subList(fromIndex, toIndex));
			grid.setTotal(results.size());

		} else {
			grid.setRows(results);
		}
		return grid;
	}

	@Override
	public int deleteClass(String classCode) {
		String sqlDelete = "delete from Class where classCode=:classCode";
		Map<String, String> map = new HashMap<String, String>();
		map.put("classCode", classCode);
		return this.nJdbcTemplate.update(sqlDelete, map);
	}

	@Override
	public ClassS getClassSByClassCode(String classCode) {
		String select = "select c.nameM,c.courseTypeCode,c.schoolCode,c.weekString,c.courseCode,c.tuitionType,c.tuition,c.classTimes,c.classState,"
				+ "c.startDate,c.endDate,c.dateUndetermined,c.teacherCode,c.assistantCode,"
				+ "c.classRoomCode,c.ratedNumber,c.remark from Class c where c.classCode=:classCode ";
		Map<String, String> map = new HashMap<String, String>();
		map.put("classCode", classCode);
		final ClassS result = this.nJdbcTemplate.queryForObject(select, map,
				new RowMapper<ClassS>() {
					@Override
					public ClassS mapRow(ResultSet rs, int index)
							throws SQLException {
						ClassS classS = new ClassS();
						classS.setAssistantCode(rs.getString("assistantCode"));
						classS.setClassRoomCode(rs.getString("classRoomCode"));
						classS.setClassState(rs.getString("classState"));
						classS.setClassTimes(rs.getString("classTimes"));
						classS.setCourseCode(rs.getString("courseCode"));
						classS.setCourseTypeCode(rs.getString("courseTypeCode"));
						classS.setDateUndetermined(rs
								.getString("dateUndetermined"));
						classS.setEndDate(rs.getString("endDate"));
						classS.setNameM(rs.getString("nameM"));
						classS.setRatedNumber(rs.getString("ratedNumber"));
						classS.setRemark(rs.getString("remark"));
						classS.setSchoolCode(rs.getString("schoolCode"));
						classS.setStartDate(rs.getString("startDate"));
						classS.setTeacherCode(rs.getString("teacherCode"));
						classS.setTuition(rs.getString("tuition"));
						classS.setTuitionType(rs.getString("tuitionType"));
						classS.setWeekString(rs.getString("weekString"));
						return classS;
					}
				});

		String sqlTime = "select * from ClassTimePlan  where classCode=:classCode order by classCode";
		final List<ClassTimePlan> classTimePlans = new ArrayList<ClassTimePlan>();
		this.nJdbcTemplate.query(sqlTime, map, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				ClassTimePlan classTimePlan = new ClassTimePlan();
				classTimePlan.setId(rs.getString("id"));
				classTimePlan.setWeek(rs.getString("week"));
				classTimePlan.setStartTime(rs.getString("startTime"));
				classTimePlan.setEndTime(rs.getString("endTime"));
				classTimePlan.setClassCode(rs.getString("classCode"));
				classTimePlans.add(classTimePlan);
			}
		});

		// 把每个班的上课时间转换成[classCode,[time1,time2...]]这种形式
		String first = "", last = "";
		final List<ClassTimePlan> classTimePlansAfters = new ArrayList<ClassTimePlan>();
		ClassTimePlan temp = new ClassTimePlan();
		for (ClassTimePlan cPlan : classTimePlans) {
			first = cPlan.getClassCode();
			if (StringUtils.equals(first, last)) {
				temp.setStartTime1(temp.getStartTime1() + ";" + cPlan.getWeek()
						+ "," + cPlan.getStartTime() + "," + cPlan.getEndTime());
			} else {
				if (StringUtils.isNotBlank(last)) {
					classTimePlansAfters.add(temp);
				}
				temp = new ClassTimePlan();
				temp.setClassCode(cPlan.getClassCode());
				temp.setStartTime1(cPlan.getWeek() + "," + cPlan.getStartTime()
						+ "," + cPlan.getEndTime());
			}
			last = cPlan.getClassCode();
		}
		classTimePlansAfters.add(temp);

		result.setWeekString(classTimePlansAfters.get(0).getStartTime1());
		return result;
	}

	@Override
	public int updateClass(ClassS cla, ClassTimePlan classTimePlan) {
		cla = handlerDictionary(cla);

		List<ClassTimePlan> classTimePlans = new ArrayList<ClassTimePlan>();
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday1())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday1());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday1());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday1());
			}
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
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday2());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday2());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday3())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday3());
			ctp.setStartTime(classTimePlan.getStartTime3());
			ctp.setEndTime(classTimePlan.getEndTime3());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday3());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday3());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday4())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday4());
			ctp.setStartTime(classTimePlan.getStartTime4());
			ctp.setEndTime(classTimePlan.getEndTime4());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday4());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday4());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday5())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday5());
			ctp.setStartTime(classTimePlan.getStartTime5());
			ctp.setEndTime(classTimePlan.getEndTime5());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday5());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday5());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday6())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday6());
			ctp.setStartTime(classTimePlan.getStartTime6());
			ctp.setEndTime(classTimePlan.getEndTime6());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday6());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday6());
			}
			classTimePlans.add(ctp);
		}
		if (StringUtils.isNotBlank(classTimePlan.getTimingWeekday7())) {
			ClassTimePlan ctp = new ClassTimePlan();
			ctp.setWeek(classTimePlan.getTimingWeekday7());
			ctp.setStartTime(classTimePlan.getStartTime7());
			ctp.setEndTime(classTimePlan.getEndTime7());
			ctp.setClassCode(cla.getClassCode());
			ctp.setId(UUID.randomUUID().toString());
			if (StringUtils.isNotBlank(cla.getWeekString())) {
				cla.setWeekString(cla.getWeekString()
						+ classTimePlan.getTimingWeekday7());
			} else {
				cla.setWeekString(classTimePlan.getTimingWeekday7());
			}
			classTimePlans.add(ctp);
		}

		String sql = "update Class set nameM=:nameM,tuition=:tuition,courseTypeCode=:courseTypeCode,courseCode=:courseCode,schoolCode=:schoolCode,"
				+ "classTimes=:classTimes,startDate=:startDate,endDate=:endDate,dateUndetermined=:dateUndetermined,teacherCode=:teacherCode,"
				+ "assistantCode=:assistantCode,classRoomCode=:classRoomCode,"
				+ "ratedNumber=:ratedNumber,remark=:remark,weekString=:weekString where classCode=:classCode";
		String sqlDelete = "delete from ClassTimePlan where classCode=:classCode";
		String sqlBatch = "insert into ClassTimePlan (id,week,startTime,endTime,classCode) values (:id,:week,:startTime,:endTime,:classCode)";
		SqlParameterSource nParameterSource = new BeanPropertySqlParameterSource(
				cla);
		Map<String, String> map = new HashMap<String, String>();
		map.put("classCode", cla.getClassCode());
		int n2 = this.nJdbcTemplate.update(sqlDelete, map);
		SqlParameterSource[] parameterSources = SqlParameterSourceUtils
				.createBatch(classTimePlans.toArray());
		this.nJdbcTemplate.batchUpdate(sqlBatch, parameterSources);
		int n1 = this.nJdbcTemplate.update(sql, nParameterSource);
		return n1 + n2;
	}

	@Override
	public List<ClassS> getClassSByCourseCode(String courseCode) {
		String select = "select c.classCode,c.nameM,c.courseTypeCode,c.schoolCode,s.schoolName,c.weekString,c.tuitionType,c.tuition,c.classTimes,c.classState,"
				+ "c.startDate,c.endDate,c.dateUndetermined,c.teacherCode,u.username teacherName, "
				+ "c.ratedNumber,c.remark from Class c left outer  join School s on s.schoolCode=c.schoolCode "
				+ "left outer join Course co on co.courseCode=c.courseCode  "
				+ "left outer join User u on u.userId=c.teacherCode where c.courseCode=:courseCode";

		Map<String, String> map = new HashMap<String, String>();
		map.put("courseCode", courseCode);
		final List<ClassS> results = new ArrayList<ClassS>();
		this.nJdbcTemplate.query(select, map, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				ClassS classS = new ClassS();
				classS.setClassCode(rs.getString("classCode"));
				classS.setClassState(rs.getString("classState"));
				classS.setClassTimes(rs.getString("classTimes"));
				classS.setCourseTypeCode(rs.getString("courseTypeCode"));
				classS.setDateUndetermined(rs.getString("dateUndetermined"));
				classS.setEndDate(rs.getString("endDate"));
				classS.setNameM(rs.getString("nameM"));
				classS.setRatedNumber(rs.getString("ratedNumber"));
				classS.setSchoolCode(rs.getString("schoolCode"));
				classS.setSchoolName(rs.getString("schoolName"));
				classS.setStartDate(rs.getString("startDate"));
				classS.setTeacherCode(rs.getString("teacherCode"));
				classS.setTeacherName(rs.getString("teacherName"));
				classS.setTuition(rs.getString("tuition"));
				classS.setTuitionType(rs.getString("tuitionType"));
				classS.setWeekString(rs.getString("weekString"));
				results.add(classS);
			}
		});

		String sqlTime = "select * from ClassTimePlan order by classCode";
		final List<ClassTimePlan> classTimePlans = new ArrayList<ClassTimePlan>();
		this.nJdbcTemplate.query(sqlTime, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				ClassTimePlan classTimePlan = new ClassTimePlan();
				classTimePlan.setId(rs.getString("id"));
				classTimePlan.setWeek(rs.getString("week"));
				classTimePlan.setStartTime(rs.getString("startTime"));
				classTimePlan.setEndTime(rs.getString("endTime"));
				classTimePlan.setClassCode(rs.getString("classCode"));
				classTimePlans.add(classTimePlan);
			}
		});

		// 把每个班的上课时间转换成[classCode,[time1,time2...]]这种形式
		String first = "", last = "";
		final List<ClassTimePlan> classTimePlansAfters = new ArrayList<ClassTimePlan>();
		ClassTimePlan temp = new ClassTimePlan();
		for (ClassTimePlan cPlan : classTimePlans) {
			first = cPlan.getClassCode();
			if (StringUtils.equals(cPlan.getWeek(), "1")) {
				cPlan.setWeek("周一 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "2")) {
				cPlan.setWeek("周二 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "3")) {
				cPlan.setWeek("周三 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "4")) {
				cPlan.setWeek("周四 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "5")) {
				cPlan.setWeek("周五 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "6")) {
				cPlan.setWeek("周六 ");
			} else if (StringUtils.equals(cPlan.getWeek(), "7")) {
				cPlan.setWeek("周日 ");
			}
			if (StringUtils.equals(first, last)) {
				temp.setStartTime1(temp.getStartTime1() + "|" + cPlan.getWeek()
						+ cPlan.getStartTime() + "-" + cPlan.getEndTime());
			} else {
				if (StringUtils.isNotBlank(last)) {
					classTimePlansAfters.add(temp);
				}
				temp = new ClassTimePlan();
				temp.setClassCode(cPlan.getClassCode());
				temp.setStartTime1(cPlan.getWeek() + cPlan.getStartTime() + "-"
						+ cPlan.getEndTime());
			}
			last = cPlan.getClassCode();
		}
		classTimePlansAfters.add(temp);

		for (ClassTimePlan cPlan : classTimePlansAfters) {
			for (ClassS cS : results) {
				if (StringUtils.equals(cS.getClassCode(), cPlan.getClassCode())) {
					cS.setWeekString(cPlan.getStartTime1());
				}
			}
		}
		for (ClassS cS : results) {
			String startDate = "", tuition = "";
			if (StringUtils.equals("1", cS.getDateUndetermined())) {
				startDate = "开班日期待定 ";
			} else {
				startDate = cS.getStartDate() + "开班 ";
			}
			if (StringUtils.equals(cS.getTuitionType(), "1")) {
				tuition = "/期";
			} else if (StringUtils.equals(cS.getTuitionType(), "2")) {
				tuition = "/次";
			} else if (StringUtils.equals(cS.getTuitionType(), "3")) {
				tuition = "/月";
			}
			cS.setNameM(cS.getSchoolName() + "> " + startDate
					+ cS.getTeacherName() + "●" + "￥" + cS.getTuition()
					+ tuition + "●" + cS.getNameM() + "●" + cS.getWeekString());
		}
		ClassS tc = new ClassS();
		tc.setClassCode("qb");
		tc.setNameM("请选择班级");
		results.add(0, tc);
		return results;
	}
}
