package com.hqgj.xb.dao;

import com.hqgj.xb.bean.highcharts.pieCharts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:40:25
 */
public interface MarketStatisticsDAO {
	
	public pieCharts getXiaoQuZiXunLiang(String starttime,String endtime);
	public pieCharts getZiXunXiaoShouYuan(String starttime,String endtime);
	public pieCharts getZiXunLaiYuan (String starttime,String endtime);
	public pieCharts getBaoMingLaiYuan(String starttime,String endtime);
	public pieCharts getBaoMingXiaoShouYuan(String starttime,String endtime);
	public pieCharts getGongLiXueXiao(String starttime,String endtime);
	public pieCharts getJuZhuQuYu(String starttime,String endtime);
}
