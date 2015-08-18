package com.hqgj.xb.service;

import com.hqgj.xb.bean.highcharts.pieCharts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:39:23
 */
public interface MarketStatisticsService {
	
	
	public pieCharts getXiaoQuZiXunLiang(String starttime,String endtime,String xiaoqu);

}
