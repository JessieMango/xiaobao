package com.hqgj.xb.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.highcharts.pieCharts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:39:23
 */
public interface MarketStatisticsService {
	
	
	public pieCharts getXiaoQuZiXunLiang(String starttime,String endtime);
	public pieCharts getZiXunXiaoShouYuan(String starttime,String endtime);
	public pieCharts getZiXunLaiYuan (String starttime,String endtime);
	public pieCharts getBaoMingLaiYuan(String starttime,String endtime);
	public pieCharts getBaoMingXiaoShouYuan(String starttime,String endtime);
	public pieCharts getGongLiXueXiao(String starttime,String endtime);
	public pieCharts getJuZhuQuYu(String starttime,String endtime);
}
