package com.hqgj.xb.bean.highcharts.mixedgraph;

import java.util.List;
import com.hqgj.xb.bean.highcharts.Title;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月27日 下午6:02:06
 */
public class MixedCharts {
	
	 private Title title; 
	 private XAxis xAxis;
	 private Labels labels ;
	 //修改了Series类，增加了type属性
	 private List<Series> series;
	 private List<String> center;
	 private String size;
	 private Boolean showInLegend;
	 public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public Labels getLabels() {
		return labels;
	}
	public void setLabels(Labels labels) {
		this.labels = labels;
	}
	public List<Series> getSeries() {
		return series;
	}
	public void setSeries(List<Series> series) {
		this.series = series;
	}
	public List<String> getCenter() {
		return center;
	}
	public void setCenter(List<String> center) {
		this.center = center;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Boolean getShowInLegend() {
		return showInLegend;
	}
	public void setShowInLegend(Boolean showInLegend) {
		this.showInLegend = showInLegend;
	}
	public XAxis getxAxis() {
		return xAxis;
	}
	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}
	
	 
	 
}
