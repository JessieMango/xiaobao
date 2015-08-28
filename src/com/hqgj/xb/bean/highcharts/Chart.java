package com.hqgj.xb.bean.highcharts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月28日 下午4:42:40
 */
//用于控制图表的3D显示
public class Chart {
	private String type;
	private int margin;
	private  Options3d options3d;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMargin() {
		return margin;
	}
	public void setMargin(int margin) {
		this.margin = margin;
	}
	public Options3d getOptions3d() {
		return options3d;
	}
	public void setOptions3d(Options3d options3d) {
		this.options3d = options3d;
	}
}
