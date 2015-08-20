package com.hqgj.xb.bean.highcharts;

import java.util.List;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月20日 上午9:48:47
 */
public class DiagramSeries {
    private List<Integer> data;
    private String name;
    
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
