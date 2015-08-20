package com.hqgj.xb.bean.highcharts;

import java.util.List;

/**
 * @author 鲁宗豪   曲线图bean
 * @datetime 2015年8月20日 上午8:23:45
 */
public class DiagramCharts {
	 private Title title; 
	 private  List<DiagramSeries> Diagramseries;
	 
	 
	public List<DiagramSeries> getDiagramseries() {
		return Diagramseries;
	}
	public void setDiagramseries(List<DiagramSeries> diagramseries) {
		Diagramseries = diagramseries;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}

}
