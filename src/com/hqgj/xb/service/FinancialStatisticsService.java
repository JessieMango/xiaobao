package com.hqgj.xb.service;
import java.util.List;

import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.ExpenseAccount;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
import com.hqgj.xb.bean.highcharts.mixedgraph.MixedCharts;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月20日 下午10:20:34
 */
public interface FinancialStatisticsService {
	public int addExpenseAccount(ExpenseAccount expenseAccount);
	public ExpenseAccount getExpenseAccountById(String id);
	public int updateExpenseAccount(ExpenseAccount expenseAccount);
	public int deleteExpenseAccount(String id);
	public Grid getExpenseAccount(ExpenseAccount expenseAccount, Parameter parameter );
	public List<Dictionary> getAllExpenditure(String type);
	public List<Dictionary> getAllExpenditureProject(String type);
	
	
	public Grid getZhiChuAnDaLei(String starttime,String endtime,Parameter parameter);
	public  Grid getZhiChuAnZiXiang(String starttime,String endtime,Parameter parameter);
	public Grid getZhiChuAnXiaoQu(String starttime,String endtime,Parameter parameter);
	public Grid getZhiChuYueDuiBi(String statisticalYear,Parameter parameter);
	
	
	
	public Charts getLiuShuiAnXiaoQu(String starttime,String endtime);
	public  DiagramCharts getLiuShuiYueDuiBi(String statisticalYear);
	public Charts getLiuShuiAnRenYuan(String starttime,String endtime);
	public Charts getTuiFeiAnXiaoQu(String starttime,String endtime);
	public Charts getXueFeiAnKeCheng(String starttime,String endtime);
	public Charts getTuiFeiAnKeCheng(String starttime,String endtime);
}
