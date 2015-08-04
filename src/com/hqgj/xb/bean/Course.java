package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 上午9:14:45
 */
public class Course {
	private String courseTypeCode;
	private String courseTypeName;
	private String courseTypeSeq;
	private String courseSeq;
	private String courseCode;;
	private String courseName;
	private String edit;
	private String delete;

	public String getCourseTypeCode() {
		return courseTypeCode;
	}

	public void setCourseTypeCode(String courseTypeCode) {
		this.courseTypeCode = courseTypeCode;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseSeq() {
		return courseSeq;
	}

	public void setCourseSeq(String courseSeq) {
		this.courseSeq = courseSeq;
	}

	public String getCourseTypeSeq() {
		return courseTypeSeq;
	}

	public void setCourseTypeSeq(String courseTypeSeq) {
		this.courseTypeSeq = courseTypeSeq;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月3日 上午9:17:02
	 */
	public Course() {
		super();
	}

}
