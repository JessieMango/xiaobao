package com.hqgj.xb.bean.easyui;

import javax.management.loading.PrivateClassLoader;

public class Parameter {
	/**
	 * datagrid 参数 页码
	 */
	private int page;
	/**
	 * datagrid 参数 每页的行数
	 */
	private int rows;
	private String startTime;
	private String endTime;

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

}
