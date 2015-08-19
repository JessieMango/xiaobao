package com.hqgj.xb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hqgj.xb.bean.highcharts.pieCharts;
import com.hqgj.xb.service.MarketStatisticsService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:41:46
 */
@Controller
@RequestMapping(value = "/securityJsp/page")
public class MarketStatisticsController {
	
	@Autowired
	private MarketStatisticsService  marketStatisticsService;
	
	
	
	@RequestMapping(value = "/shichang/getXiaoQuZiXunLiang", method = RequestMethod.POST)
	public @ResponseBody pieCharts getXiaoQuZiXunLiang(String starttime,String endtime) {
		return marketStatisticsService.getXiaoQuZiXunLiang( starttime, endtime);
	}

	@RequestMapping(value = "/shichang/getZiXunLaiYuan", method = RequestMethod.POST)
	public @ResponseBody pieCharts getZiXunLaiYuan(String starttime,String endtime) {
		return marketStatisticsService.getZiXunLaiYuan( starttime, endtime);
	}
	
	
	@RequestMapping(value = "/shichang/getZiXunXiaoShouYuan", method = RequestMethod.POST)
	public @ResponseBody pieCharts getZiXunXiaoShouYuan(String starttime,String endtime) {
		return marketStatisticsService.getZiXunXiaoShouYuan( starttime, endtime);
	}
	
	@RequestMapping(value = "/shichang/getBaoMingLaiYuan", method = RequestMethod.POST)
	public @ResponseBody pieCharts getBaoMingLaiYuan(String starttime,String endtime) {
		return marketStatisticsService.getBaoMingLaiYuan( starttime, endtime);
	}
	
	@RequestMapping(value = "/shichang/getBaoMingXiaoShouYuan", method = RequestMethod.POST)
	public @ResponseBody pieCharts getBaoMingXiaoShouYuan(String starttime,String endtime) {
		return marketStatisticsService.getBaoMingXiaoShouYuan( starttime, endtime);
	}
	
	
	@RequestMapping(value = "/shichang/getGongLiXueXiao", method = RequestMethod.POST)
	public @ResponseBody pieCharts getGongLiXueXiao(String starttime,String endtime) {
		return marketStatisticsService.getGongLiXueXiao( starttime, endtime);
	}
	@RequestMapping(value = "/shichang/getJuZhuQuYu", method = RequestMethod.POST)
	public @ResponseBody pieCharts getJuZhuQuYu(String starttime,String endtime) {
		return marketStatisticsService.getJuZhuQuYu( starttime, endtime);
	}
	
}
