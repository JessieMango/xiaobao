package com.hqgj.xb.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 记上课
 * 
 * @author 崔兴伟
 * @datetime 2015年9月18日 下午5:42:09
 */
class Comment {
	private String comment;
	private String disciplinePoints;
	private String activePoints;
	private String studentCode;

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
	 * @datetime 2015年9月19日 下午12:04:05
	 */
	public Comment() {

	}

}

public class RecordLesson {

	private String id;
	private String classCode;
	private String lessonNumbers;
	private String lessonContent;
	private String afterTask;
	private String remark;
	private String operateDate;
	private String handlerCode;
	private String comment;
	private String disciplinePoints;
	private String activePoints;
	private String studentCode;
	List<Comment> comments = new ArrayList<Comment>();

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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
