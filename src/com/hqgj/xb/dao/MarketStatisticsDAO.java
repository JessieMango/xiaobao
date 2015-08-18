package com.hqgj.xb.dao;

import com.hqgj.xb.bean.highcharts.pieCharts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:40:25
 */
public interface MarketStatisticsDAO {
	
	public pieCharts getXiaoQuZiXunLiang(String starttime,String endtime,String xiaoqu);

}
