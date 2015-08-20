package com.hqgj.xb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
import com.hqgj.xb.dao.FinancialStatisticsDAO;
import com.hqgj.xb.service.FinancialStatisticsService;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月20日 下午10:27:13
 */
@Service
public class FinancialStatisticsServiceImpl implements
		FinancialStatisticsService {
	@Autowired
	private FinancialStatisticsDAO  financialStatisticsDAO;
	
	@Override
	public Grid getLiuShuiZhang() {
		return financialStatisticsDAO.getLiuShuiZhang();
	}

	@Override
	public Charts getLiuShuiAnXiaoQu(String starttime, String endtime) {
		return financialStatisticsDAO.getLiuShuiAnXiaoQu(starttime, endtime);
	}

	@Override
	public DiagramCharts getLiuShuiYueDuiBi(String statisticalYear) {
		return financialStatisticsDAO.getLiuShuiYueDuiBi(statisticalYear);
	}

	@Override
	public Charts getLiuShuiAnRenYuan(String starttime, String endtime) {
		return financialStatisticsDAO.getLiuShuiAnRenYuan(starttime, endtime);
	}

	@Override
	public Charts getTuiFeiAnXiaoQu(String starttime, String endtime) {
		return financialStatisticsDAO.getTuiFeiAnXiaoQu(starttime, endtime);
	}

	@Override
	public Charts getXueFeiAnKeCheng(String starttime, String endtime) {
		return financialStatisticsDAO.getXueFeiAnKeCheng(starttime, endtime);
	}

	@Override
	public Charts getTuiFeiAnKeCheng(String starttime, String endtime) {
		return financialStatisticsDAO.getTuiFeiAnKeCheng(starttime, endtime);
	}
	

}
