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
	public @ResponseBody pieCharts getXiaoQuZiXunLiang(String starttime,String endtime,String xiaoqu) {
		return marketStatisticsService.getXiaoQuZiXunLiang( starttime, endtime, xiaoqu);
	}

}
