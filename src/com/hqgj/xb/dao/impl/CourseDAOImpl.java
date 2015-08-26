package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.Course;
import com.hqgj.xb.dao.CourseDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 上午9:31:23
 */
@Repository
public class CourseDAOImpl implements CourseDAO {
	private Logger logger = Logger.getLogger(CourseDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Course> getAllCourses(String courseTypeCode) {
		Map<String, String> map = new HashMap<String, String>();
		String sql = "	select c.courseCode courseCode,c.nameM courseName,c.seq courseSeq,ct.courseTypeCode courseTypeCode,ct.nameM courseTypeName,ct.seq courseTypeSeq "
				+ "from Course c  left outer join CourseType ct on c.courseTypeCode=ct.courseTypeCode ";
		if (StringUtils.isNotBlank(courseTypeCode)) {
			map.put("courseTypeCode", courseTypeCode);
			sql += " where c.courseTypeCode=:courseTypeCode ";
		}
		sql += " order by ct.seq,c.seq";
		List<Course> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<Course>() {
					@Override
					public Course mapRow(ResultSet rs, int index)
							throws SQLException {
						Course course = new Course();
						course.setCourseCode(rs.getString("courseCode"));
						course.setCourseName(rs.getString("courseName"));
						course.setCourseSeq(rs.getString("courseSeq"));
						course.setCourseTypeCode(rs.getString("courseTypeCode"));
						course.setCourseTypeName(rs.getString("courseTypeName"));
						course.setCourseTypeSeq(rs.getString("courseTypeSeq"));
						return course;
					}
				});
		return results;
	}

	@Override
	public List<Course> getCourseTypes(String type) {
		String sql = "	select ct.courseTypeCode courseTypeCode,ct.nameM courseTypeName,ct.seq courseTypeSeq from  CourseType ct  ";
		if (StringUtils.equals(type, "1")) {
			sql += " where ct.courseTypeCode<>'qb' ";
		}
		if (StringUtils.equals(type, "2") || StringUtils.equals(type, "3")) {
			sql += " where ct.courseTypeCode<>'qb' ";
		}
		sql += " order by ct.seq";
		List<Course> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Course>() {
					@Override
					public Course mapRow(ResultSet rs, int index)
							throws SQLException {
						Course course = new Course();
						course.setCourseTypeCode(rs.getString("courseTypeCode"));
						course.setCourseTypeName(rs.getString("courseTypeName"));
						course.setCourseTypeSeq(rs.getString("courseTypeSeq"));
						return course;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Course temp = new Course();
			temp.setCourseTypeCode("qb");
			temp.setCourseTypeName("全部课程类");
			results.add(0, temp);
		}
		if (StringUtils.equals(type, "2")) {
			Course temp = new Course();
			temp.setCourseTypeCode("qq");
			temp.setCourseTypeName("请选择课程");
			results.add(0, temp);
		}
		return results;
	}

	@Override
	public Course getCourseById(String id) {
		String sql = "select c.nameM courseName,c.seq courseSeq,c.courseTypeCode courseTypeCode  from  Course c  where c.courseCode=:courseCode ";

		Map<String, String> map = new HashMap<String, String>();
		map.put("courseCode", id);
		final Course result = this.nJdbcTemplate.queryForObject(sql, map,
				new RowMapper<Course>() {
					@Override
					public Course mapRow(ResultSet rs, int index)
							throws SQLException {
						Course course = new Course();
						course.setCourseName(rs.getString("courseName"));
						course.setCourseSeq(rs.getString("courseSeq"));
						course.setCourseTypeCode(rs.getString("courseTypeCode"));
						return course;
					}
				});
		return result;
	}

	@Override
	public Course getCourseTypeById(String id) {
		String sql = "select nameM courseTypeName,seq courseTypeSeq from  CourseType where courseTypeCode=:courseTypeCode ";
		Map<String, String> map = new HashMap<String, String>();
		map.put("courseTypeCode", id);
		final Course result = this.nJdbcTemplate.queryForObject(sql, map,
				new RowMapper<Course>() {
					@Override
					public Course mapRow(ResultSet rs, int index)
							throws SQLException {
						Course course = new Course();
						course.setCourseTypeName(rs.getString("courseTypeName"));
						course.setCourseTypeSeq(rs.getString("courseTypeSeq"));
						return course;
					}
				});
		return result;
	}

	@Override
	public int addCourseType(Course course) {
		course.setCourseTypeCode(UUID.randomUUID().toString());
		String sql = "insert into CourseType(courseTypeCode,nameM,seq) values (:courseTypeCode,:courseTypeName,:courseTypeSeq)";
		SqlParameterSource courseParameterSource = new BeanPropertySqlParameterSource(
				course);
		return this.nJdbcTemplate.update(sql, courseParameterSource);
	}

	@Override
	public int addCourse(Course course) {
		course.setCourseCode(UUID.randomUUID().toString());
		String sql = "insert into Course(courseCode,nameM,seq,courseTypeCode) values (:courseCode,:courseName,:courseSeq,:courseTypeCode)";
		SqlParameterSource courseParameterSource = new BeanPropertySqlParameterSource(
				course);
		int n1 = this.nJdbcTemplate.update(sql, courseParameterSource);
		return n1;
	}

	@Override
	public int updateCourseType(Course course) {
		String sql = "update CourseType set nameM=:courseTypeName,seq=:courseTypeSeq where courseTypeCode=:courseTypeCode";
		SqlParameterSource courseParameterSource = new BeanPropertySqlParameterSource(
				course);
		return this.nJdbcTemplate.update(sql, courseParameterSource);
	}

	@Override
	public int updateCourse(Course course) {
		String sql = "update Course set nameM=:courseName,seq=:courseSeq,courseTypeCode=:courseTypeCode where courseCode=:courseCode";
		SqlParameterSource courseParameterSource = new BeanPropertySqlParameterSource(
				course);
		int n1 = this.nJdbcTemplate.update(sql, courseParameterSource);
		return n1;
	}

	@Override
	public int deleteCourseType(String id) {
		String sql = "delete from CourseType  where courseTypeCode=:code";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("code", id);
		return this.nJdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int deleteCourse(String id) {
		String sql = "delete from Course  where courseCode=:code";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("code", id);
		return this.nJdbcTemplate.update(sql, paramMap);
	}

}
