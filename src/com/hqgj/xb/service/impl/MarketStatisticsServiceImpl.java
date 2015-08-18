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
	public pieCharts getXiaoQuZiXunLiang(String starttime,String endtime,String xiaoqu) {
		return marketStatisticsDAO.getXiaoQuZiXunLiang( starttime, endtime, xiaoqu);
	}

}
