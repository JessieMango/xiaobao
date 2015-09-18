package com.hqgj.xb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
import com.hqgj.xb.bean.highcharts.mixedcharts.MixedCharts;
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
	
	
	//查询校区的咨询量
	@RequestMapping(value = "/shichang/getXiaoQuZiXunLiang", method = RequestMethod.POST)
	public @ResponseBody Charts getXiaoQuZiXunLiang(String starttime,String endtime) {
		return marketStatisticsService.getXiaoQuZiXunLiang( starttime, endtime);
	}
	//咨询来源
	@RequestMapping(value = "/shichang/getZiXunLaiYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getZiXunLaiYuan(String starttime,String endtime) {
		return marketStatisticsService.getZiXunLaiYuan( starttime, endtime);
	}
	
	//销售员被咨询的量
	@RequestMapping(value = "/shichang/getZiXunXiaoShouYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getZiXunXiaoShouYuan(String starttime,String endtime) {
		return marketStatisticsService.getZiXunXiaoShouYuan( starttime, endtime);
	}
	//学生报名来源
	@RequestMapping(value = "/shichang/getBaoMingLaiYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getBaoMingLaiYuan(String starttime,String endtime) {
		return marketStatisticsService.getBaoMingLaiYuan( starttime, endtime);
	}
	//学生报名的销售员，即销售员的销售业绩
	@RequestMapping(value = "/shichang/getBaoMingXiaoShouYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getBaoMingXiaoShouYuan(String starttime,String endtime) {
		return marketStatisticsService.getBaoMingXiaoShouYuan( starttime, endtime);
	}
	
	//学生所述的公立学校
	@RequestMapping(value = "/shichang/getGongLiXueXiao", method = RequestMethod.POST)
	public @ResponseBody Charts getGongLiXueXiao(String starttime,String endtime) {
		return marketStatisticsService.getGongLiXueXiao( starttime, endtime);
	}
	//学生居住的区域统计
	@RequestMapping(value = "/shichang/getJuZhuQuYu", method = RequestMethod.POST)
	public @ResponseBody Charts getJuZhuQuYu(String starttime,String endtime) {
		return marketStatisticsService.getJuZhuQuYu( starttime, endtime);
	}
	//学生的年龄
	@RequestMapping(value = "/shichang/getXueShengNianLing", method = RequestMethod.POST)
	public @ResponseBody Charts getXueShengNianLing(String starttime,String endtime) {
		return marketStatisticsService.getXueShengNianLing( starttime, endtime);
	}
	//学校每个月所招收到的学生
	@RequestMapping(value = "/shichang/getMeiYueXinSheng", method = RequestMethod.POST)
	public @ResponseBody DiagramCharts getMeiYueXinSheng(String statisticalYear) {
		return marketStatisticsService.getMeiYueXinSheng( statisticalYear);
	}
	//学生每个月的咨询趋势
	@RequestMapping(value = "/shichang/getZiXunLaiYuanQuShi", method = RequestMethod.POST)
	public @ResponseBody DiagramCharts getZiXunLaiYuanQuShi(String statisticalYear) {
		return marketStatisticsService.getZiXunLaiYuanQuShi(statisticalYear);
	}
	//学生前台报名的数量统计
	@RequestMapping(value = "/shichang/getQianTaiBaoMingLiang", method = RequestMethod.POST)
	public @ResponseBody MixedCharts getQianTaiBaoMingLiang(String starttime,String endtime,String studentType) {
		return marketStatisticsService.getQianTaiBaoMingLiang(starttime,endtime,studentType);
	}
	//学生报名的来源趋势
	@RequestMapping(value = "/shichang/getBaoMingLaiYuanQuShi", method = RequestMethod.POST)
	public @ResponseBody DiagramCharts getBaoMingLaiYuanQuShi(String statisticalYear) {
		return marketStatisticsService.getBaoMingLaiYuanQuShi(statisticalYear);
	}
	
	
}
