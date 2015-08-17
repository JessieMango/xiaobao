package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年8月11日 下午4:02:16
 */
public class ClassS {
	private String classCode; // 班级编码
	private String nameM; // 班级名称
	private String courseCode; // 课程编码
	private String courseName; // 课程名称
	private String courseTypeCode; // 课程编码
	private String courseTypeName; // 课程名称
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
	private String assistantCode; // 助教编码 关联User表
	private String assistantName; // 助教
	private String classRoomCode; // 教室编码
	private String classRoomName; // 教室名称
	private String ratedNumber; // 额定人数
	private String remark; // 备注
	private String weekString; // 上课日期例如123表示周一周二周三
	private String classState; // 班级状态 0未开课 1上课中 2已结课
	private String startDate2; // 开课日期 2代表按次，3代表按时间时的开课日期
	/**
	 * 前台传过来的参数
	 */
	private String week;
	private String order;
	private String year;
	private String month;

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月14日 上午9:26:14
	 */
	public ClassS() {

	}

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

	public String getClassRoomCode() {
		return classRoomCode;
	}

	public void setClassRoomCode(String classRoomCode) {
		this.classRoomCode = classRoomCode;
	}

	public String getClassRoomName() {
		return classRoomName;
	}

	public void setClassRoomName(String classRoomName) {
		this.classRoomName = classRoomName;
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

	public String getStartDate2() {
		return startDate2;
	}

	public void setStartDate2(String startDate2) {
		this.startDate2 = startDate2;
	}

	public String getAssistantCode() {
		return assistantCode;
	}

	public void setAssistantCode(String assistantCode) {
		this.assistantCode = assistantCode;
	}

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}

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

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeekString() {
		return weekString;
	}

	public void setWeekString(String weekString) {
		this.weekString = weekString;
	}

}
