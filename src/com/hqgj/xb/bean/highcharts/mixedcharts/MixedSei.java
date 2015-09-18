package com.hqgj.xb.bean.highcharts.mixedcharts;

import java.util.List;

/**
 * @author 鲁宗豪
 * @datetime 2015年9月17日 上午8:08:14
 */
public class MixedSei {
	 private String type;
	 private String name;
	 private List<Float> data;
	 private List<Integer> center;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Float> getData() {
		return data;
	}
	public void setData(List<Float> data) {
		this.data = data;
	}
	public List<Integer> getCenter() {
		return center;
	}
	public void setCenter(List<Integer> center) {
		this.center = center;
	}
}
