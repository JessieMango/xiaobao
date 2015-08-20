package com.hqgj.xb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.ChartsList;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
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
	public @ResponseBody Charts getXiaoQuZiXunLiang(String starttime,String endtime) {
		return marketStatisticsService.getXiaoQuZiXunLiang( starttime, endtime);
	}

	@RequestMapping(value = "/shichang/getZiXunLaiYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getZiXunLaiYuan(String starttime,String endtime) {
		return marketStatisticsService.getZiXunLaiYuan( starttime, endtime);
	}
	
	
	@RequestMapping(value = "/shichang/getZiXunXiaoShouYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getZiXunXiaoShouYuan(String starttime,String endtime) {
		return marketStatisticsService.getZiXunXiaoShouYuan( starttime, endtime);
	}
	
	@RequestMapping(value = "/shichang/getBaoMingLaiYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getBaoMingLaiYuan(String starttime,String endtime) {
		return marketStatisticsService.getBaoMingLaiYuan( starttime, endtime);
	}
	
	@RequestMapping(value = "/shichang/getBaoMingXiaoShouYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getBaoMingXiaoShouYuan(String starttime,String endtime) {
		return marketStatisticsService.getBaoMingXiaoShouYuan( starttime, endtime);
	}
	
	
	@RequestMapping(value = "/shichang/getGongLiXueXiao", method = RequestMethod.POST)
	public @ResponseBody Charts getGongLiXueXiao(String starttime,String endtime) {
		return marketStatisticsService.getGongLiXueXiao( starttime, endtime);
	}
	@RequestMapping(value = "/shichang/getJuZhuQuYu", method = RequestMethod.POST)
	public @ResponseBody Charts getJuZhuQuYu(String starttime,String endtime) {
		return marketStatisticsService.getJuZhuQuYu( starttime, endtime);
	}
	
	@RequestMapping(value = "/shichang/getXueShengNianLing", method = RequestMethod.POST)
	public @ResponseBody Charts getXueShengNianLing(String starttime,String endtime) {
		return marketStatisticsService.getXueShengNianLing( starttime, endtime);
	}
	
	@RequestMapping(value = "/shichang/getMeiYueXinSheng", method = RequestMethod.POST)
	public @ResponseBody DiagramCharts getMeiYueXinSheng(String statisticalYear) {
		return marketStatisticsService.getMeiYueXinSheng( statisticalYear);
	}
	@RequestMapping(value = "/shichang/getZiXunLaiYuanQuShi", method = RequestMethod.POST)
	public @ResponseBody DiagramCharts getZiXunLaiYuanQuShi(String statisticalYear) {
		return marketStatisticsService.getZiXunLaiYuanQuShi(statisticalYear);
	}
	@RequestMapping(value = "/shichang/getQianTaiBaoMingLiang", method = RequestMethod.POST)
	public @ResponseBody ChartsList getQianTaiBaoMingLiang(String starttime,String endtime,String studentType) {
		return marketStatisticsService.getQianTaiBaoMingLiang(starttime,endtime,studentType);
	}
	@RequestMapping(value = "/shichang/getBaoMingLaiYuanQuShi", method = RequestMethod.POST)
	public @ResponseBody DiagramCharts getBaoMingLaiYuanQuShi(String statisticalYear) {
		return marketStatisticsService.getBaoMingLaiYuanQuShi(statisticalYear);
	}
	
	
}
