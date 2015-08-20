package com.hqgj.xb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
import com.hqgj.xb.service.FinancialStatisticsService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月20日 下午10:19:34
 */
@Controller
@RequestMapping(value = "/securityJsp")
public class FinancialStatisticsController {
	@Autowired
	private FinancialStatisticsService financialStatisticsService;
	@RequestMapping(value = "/caiwu/getLiuShuiZhang", method = RequestMethod.POST)
	public @ResponseBody Grid getLiuShuiZhang() {
		return financialStatisticsService.getLiuShuiZhang();
	}
	
	@RequestMapping(value = "/caiwu/getLiuShuiAnXiaoQu", method = RequestMethod.POST)
	public @ResponseBody Charts getLiuShuiAnXiaoQu(String starttime,String endtime) {
		return financialStatisticsService.getLiuShuiAnXiaoQu(starttime,endtime);
	}
	@RequestMapping(value = "/caiwu/getLiuShuiYueDuiBi", method = RequestMethod.POST)
	public @ResponseBody DiagramCharts getLiuShuiYueDuiBi(String statisticalYear) {
		return financialStatisticsService.getLiuShuiYueDuiBi(statisticalYear);
	}
	@RequestMapping(value = "/caiwu/getLiuShuiAnRenYuan", method = RequestMethod.POST)
	public @ResponseBody Charts getLiuShuiAnRenYuan(String starttime,String endtime) {
		return financialStatisticsService.getLiuShuiAnRenYuan(starttime,endtime);
	}
	
	@RequestMapping(value = "/caiwu/getTuiFeiAnXiaoQu", method = RequestMethod.POST)
	public @ResponseBody Charts getTuiFeiAnXiaoQu(String starttime,String endtime) {
		return financialStatisticsService.getTuiFeiAnXiaoQu(starttime,endtime);
	}
	@RequestMapping(value = "/caiwu/getXueFeiAnKeCheng", method = RequestMethod.POST)
	public @ResponseBody Charts getXueFeiAnKeCheng(String starttime,String endtime) {
		return financialStatisticsService.getXueFeiAnKeCheng(starttime,endtime);
	}
	@RequestMapping(value = "/caiwu/getTuiFeiAnKeCheng", method = RequestMethod.POST)
	public @ResponseBody Charts getTuiFeiAnKeCheng(String starttime,String endtime) {
		return financialStatisticsService.getTuiFeiAnKeCheng(starttime,endtime);
	}
	
}
