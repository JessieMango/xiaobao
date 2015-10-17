package com.hqgj.xb.bean.easyui;

public class Parameter {
	/**
	 * datagrid 参数 页码
	 */
	private int page;
	/**
	 * datagrid 参数 每页的行数
	 */
	private int rows;
	/**
	 * 页面标识
	 */
	private String pageCode;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 截止时间
	 */
	private String endTime;

	/**
	 * 返回所有用户时 0表示返回所有用户 1表示返回指定允许登录用户
	 */
	private String islogin;

	
	public String getIslogin() {
		return islogin;
	}

	public void setIslogin(String islogin) {
		this.islogin = islogin;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

}
