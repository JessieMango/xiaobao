package com.hqgj.xb.bean.highcharts;

import java.util.List;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月15日 下午5:21:30
 */
public class Series {
		private String type;
	    private List<Data> data;
	    private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Data> getData() {
			return data;
		}
		public void setData(List<Data> data) {
			this.data = data;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	
}
