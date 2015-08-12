package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年8月11日 下午4:02:16
 */
public class Class {
	private String classCode; // 班级编码
	private String nameM; // 班级名称
	private String courseCode; // 课程编码
	private String courseName; // 课程名称
	private String schoolCode; // 学校编码
	private String schoolName;
	private String tuitionType; // 收费类型 1代表按期，2代表按次，3代表按时间
	private String tuition; // 学费标准
	private String classTimes; // 课时数
	private String startDate; // 开课日期
	private String endDate; // 结课日期
	private String dateUndetermined; // 开课日期待定 1代表日期待定
	private String teacherCode; // 教师编码 关联User表
	private String teacherName; // 教师姓名
	private String assistant; // 助教
	private String classroomCode; // 教室编码
	private String classroomName; // 教室名称
	private String ratedNumber; // 额定人数
	private String remark; // 备注
	private String classState; // 班级状态

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getNameM() {
		return nameM;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public void setNameM(String nameM) {
		this.nameM = nameM;
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

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getTuitionType() {
		return tuitionType;
	}

	public void setTuitionType(String tuitionType) {
		this.tuitionType = tuitionType;
	}

	public String getTuition() {
		return tuition;
	}

	public void setTuition(String tuition) {
		this.tuition = tuition;
	}

	public String getClassTimes() {
		return classTimes;
	}

	public void setClassTimes(String classTimes) {
		this.classTimes = classTimes;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDateUndetermined() {
		return dateUndetermined;
	}

	public void setDateUndetermined(String dateUndetermined) {
		this.dateUndetermined = dateUndetermined;
	}

	public String getTeacherCode() {
		return teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public String getClassroomCode() {
		return classroomCode;
	}

	public void setClassroomCode(String classroomCode) {
		this.classroomCode = classroomCode;
	}

	public String getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	public String getRatedNumber() {
		return ratedNumber;
	}

	public void setRatedNumber(String ratedNumber) {
		this.ratedNumber = ratedNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getClassState() {
		return classState;
	}

	public void setClassState(String classState) {
		this.classState = classState;
	}

}
