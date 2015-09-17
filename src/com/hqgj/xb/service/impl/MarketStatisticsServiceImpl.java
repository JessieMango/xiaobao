package com.hqgj.xb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
import com.hqgj.xb.bean.highcharts.mixedcharts.MixedCharts;
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
	public Charts getXiaoQuZiXunLiang(String starttime,String endtime) {
		return marketStatisticsDAO.getXiaoQuZiXunLiang( starttime, endtime);
	}
	@Override
	public Charts getZiXunXiaoShouYuan(String starttime, String endtime) {
		return marketStatisticsDAO.getZiXunXiaoShouYuan(starttime,endtime);
	}
	@Override
	public Charts getZiXunLaiYuan(String starttime, String endtime) {
		return marketStatisticsDAO.getZiXunLaiYuan(starttime, endtime);
	}
	@Override
	public Charts getBaoMingLaiYuan(String starttime, String endtime) {
		return marketStatisticsDAO.getBaoMingLaiYuan(starttime, endtime);
	}
	@Override
	public Charts getBaoMingXiaoShouYuan(String starttime, String endtime) {
		return marketStatisticsDAO.getBaoMingXiaoShouYuan(starttime, endtime);
	}
	@Override
	public Charts getGongLiXueXiao(String starttime, String endtime) {
		return marketStatisticsDAO.getGongLiXueXiao(starttime, endtime);
	}
	@Override
	public Charts getJuZhuQuYu(String starttime, String endtime) {
		return marketStatisticsDAO.getJuZhuQuYu(starttime, endtime);
	}
	@Override
	public Charts getXueShengNianLing(String starttime, String endtime) {
		return marketStatisticsDAO.getXueShengNianLing(starttime, endtime);
	}
	
	@Override
	public MixedCharts getQianTaiBaoMingLiang(String starttime,
			String endtime, String studentType) {
		return marketStatisticsDAO.getQianTaiBaoMingLiang(starttime, endtime, studentType);
	}
	@Override
	public DiagramCharts getBaoMingLaiYuanQuShi(String statisticalYear) {
		return marketStatisticsDAO.getBaoMingLaiYuanQuShi(statisticalYear);
	}
	@Override
	public DiagramCharts getMeiYueXinSheng(String statisticalYear) {
		return marketStatisticsDAO.getMeiYueXinSheng(statisticalYear);
	}
	@Override
	public DiagramCharts getZiXunLaiYuanQuShi(String statisticalYear) {
		return marketStatisticsDAO.getZiXunLaiYuanQuShi(statisticalYear);
	}
	

}
