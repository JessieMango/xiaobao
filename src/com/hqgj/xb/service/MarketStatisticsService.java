package com.hqgj.xb.service;


import com.hqgj.xb.bean.highcharts.Charts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:39:23
 */
public interface MarketStatisticsService {
	
	
	public Charts getXiaoQuZiXunLiang(String starttime,String endtime);
	public Charts getZiXunXiaoShouYuan(String starttime,String endtime);
	public Charts getZiXunLaiYuan (String starttime,String endtime);
	public Charts getBaoMingLaiYuan(String starttime,String endtime);
	public Charts getBaoMingXiaoShouYuan(String starttime,String endtime);
	public Charts getGongLiXueXiao(String starttime,String endtime);
	public Charts getJuZhuQuYu(String starttime,String endtime);
}
