package com.hqgj.xb.bean;

/**
 * 支出项目
 * 
 * @author 崔兴伟
 * @datetime 2015年8月4日 上午11:07:10
 */
public class Expenditure {
	private String id; // 支出项目ID
	private String expenditureProjectName; // 支出项目名称
	private String expenditureProjectSeq;
	private String expenditureCode; // 支出大类编码
	private String expenditureName;
	private String expenditureSeq;

	/**
	 * 用于前台界面控制
	 */
	private String edit;
	private String delete;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExpenditureProjectName() {
		return expenditureProjectName;
	}

	public void setExpenditureProjectName(String expenditureProjectName) {
		this.expenditureProjectName = expenditureProjectName;
	}

	public String getExpenditureProjectSeq() {
		return expenditureProjectSeq;
	}

	public void setExpenditureProjectSeq(String expenditureProjectSeq) {
		this.expenditureProjectSeq = expenditureProjectSeq;
	}

	public String getExpenditureCode() {
		return expenditureCode;
	}

	public void setExpenditureCode(String expenditureCode) {
		this.expenditureCode = expenditureCode;
	}

	public String getExpenditureName() {
		return expenditureName;
	}

	public void setExpenditureName(String expenditureName) {
		this.expenditureName = expenditureName;
	}

	public String getExpenditureSeq() {
		return expenditureSeq;
	}

	public void setExpenditureSeq(String expenditureSeq) {
		this.expenditureSeq = expenditureSeq;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 上午11:12:50
	 */
	public Expenditure() {
	}

}
