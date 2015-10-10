package com.hqgj.xb.bean;

/**
 * 记上课
 * 
 * @author 崔兴伟
 * @datetime 2015年9月18日 下午5:42:09
 */

public class RecordLesson {

	private String id; // 记上课表主键
	private String classCode; // 班级编码
	private String lessonNumbers; // 课时数
	private String lessonContent; // 上课内容
	private String afterTask; // 课后作业
	private String remark; // 备注
	private String operateDate; // 记上课日期
	private String handlerCode; // 经办人编码
	private String comment; // 十字评语
	private String disciplinePoints; // 纪律专注评分
	private String activePoints; // 活跃参与评分
	private String studentCode; // 学生编码
	private String studentName; // 学生姓名
	private String teacher;// 老师名字
	private String assistant; // 助教名字
	private String actualNumber; // 班级总人数

	public String getActualNumber() {
		return actualNumber;
	}

	public void setActualNumber(String actualNumber) {
		this.actualNumber = actualNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getLessonNumbers() {
		return lessonNumbers;
	}

	public void setLessonNumbers(String lessonNumbers) {
		this.lessonNumbers = lessonNumbers;
	}

	public String getLessonContent() {
		return lessonContent;
	}

	public void setLessonContent(String lessonContent) {
		this.lessonContent = lessonContent;
	}

	public String getAfterTask() {
		return afterTask;
	}

	public void setAfterTask(String afterTask) {
		this.afterTask = afterTask;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDisciplinePoints() {
		return disciplinePoints;
	}

	public void setDisciplinePoints(String disciplinePoints) {
		this.disciplinePoints = disciplinePoints;
	}

	public String getActivePoints() {
		return activePoints;
	}

	public void setActivePoints(String activePoints) {
		this.activePoints = activePoints;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年10月9日 下午5:27:50
	 */
	public RecordLesson() {
	}

}
