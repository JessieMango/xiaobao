package com.hqgj.xb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.highcharts.pieCharts;
import com.hqgj.xb.dao.MarketStatisticsDAO;
import com.hqgj.xb.service.MarketStatisticsService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:50:00
 */
@Service
public class MarketStatisticsServiceImpl implements MarketStatisticsService {
	@Autowired
	private MarketStatisticsDAO marketStatisticsDAO;
	@Override
	public pieCharts getXiaoQuZiXunLiang(String starttime,String endtime) {
		return marketStatisticsDAO.getXiaoQuZiXunLiang( starttime, endtime);
	}
	@Override
	public pieCharts getZiXunXiaoShouYuan(String starttime, String endtime) {
		return marketStatisticsDAO.getZiXunXiaoShouYuan(starttime,endtime);
	}
	@Override
	public pieCharts getZiXunLaiYuan(String starttime, String endtime) {
		return marketStatisticsDAO.getZiXunLaiYuan(starttime, endtime);
	}
	@Override
	public pieCharts getBaoMingLaiYuan(String starttime, String endtime) {
		return marketStatisticsDAO.getBaoMingLaiYuan(starttime, endtime);
	}
	@Override
	public pieCharts getBaoMingXiaoShouYuan(String starttime, String endtime) {
		return marketStatisticsDAO.getBaoMingXiaoShouYuan(starttime, endtime);
	}
	@Override
	public pieCharts getGongLiXueXiao(String starttime, String endtime) {
		return marketStatisticsDAO.getGongLiXueXiao(starttime, endtime);
	}
	@Override
	public pieCharts getJuZhuQuYu(String starttime, String endtime) {
		return marketStatisticsDAO.getJuZhuQuYu(starttime, endtime);
	}
	

}
