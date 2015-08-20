package com.hqgj.xb.service;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月20日 下午10:20:34
 */
public interface FinancialStatisticsService {
	public  Grid getLiuShuiZhang();
	public Charts getLiuShuiAnXiaoQu(String starttime,String endtime);
	public  DiagramCharts getLiuShuiYueDuiBi(String statisticalYear);
	public Charts getLiuShuiAnRenYuan(String starttime,String endtime);
	public Charts getTuiFeiAnXiaoQu(String starttime,String endtime);
	public Charts getXueFeiAnKeCheng(String starttime,String endtime);
	public Charts getTuiFeiAnKeCheng(String starttime,String endtime);
}
