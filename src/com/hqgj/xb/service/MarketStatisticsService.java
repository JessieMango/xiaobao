package com.hqgj.xb.service;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.ChartsList;
import com.hqgj.xb.bean.highcharts.DiagramCharts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:39:23
 */
public interface MarketStatisticsService {
	
	
	public Charts getXiaoQuZiXunLiang(String starttime,String endtime);
	public Charts getZiXunXiaoShouYuan(String starttime,String endtime);
	public Charts getZiXunLaiYuan (String starttime,String endtime);
	public Charts getBaoMingLaiYuan(String starttime,String endtime);
	public Charts getBaoMingXiaoShouYuan(String starttime,String endtime);
	public Charts getGongLiXueXiao(String starttime,String endtime);
	public Charts getJuZhuQuYu(String starttime,String endtime);
	public Charts getXueShengNianLing(String starttime,String endtime);
	public DiagramCharts getMeiYueXinSheng(String statisticalYear);
	public DiagramCharts getZiXunLaiYuanQuShi(String statisticalYear);
	public ChartsList getQianTaiBaoMingLiang(String starttime,String endtime,String studentType); 
	public DiagramCharts getBaoMingLaiYuanQuShi(String statisticalYear);
}
