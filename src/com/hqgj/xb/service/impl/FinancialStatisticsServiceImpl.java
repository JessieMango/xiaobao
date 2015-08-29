package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.ExpenseAccount;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
import com.hqgj.xb.bean.highcharts.mixedgraph.MixedCharts;
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
	public int addExpenseAccount(ExpenseAccount expenseAccount) {
		return financialStatisticsDAO.addExpenseAccount(expenseAccount);
	}

	@Override
	public ExpenseAccount getExpenseAccountById(String id) {
		return financialStatisticsDAO.getExpenseAccountById(id);
	}

	@Override
	public int updateExpenseAccount(ExpenseAccount expenseAccount) {
		return financialStatisticsDAO.updateExpenseAccount(expenseAccount);
	}
	@Override
	public int deleteExpenseAccount(String id) {
		return financialStatisticsDAO.deleteExpenseAccount(id);
	}

	@Override
	public Grid getExpenseAccount(ExpenseAccount expenseAccount, Parameter parameter) {
		return financialStatisticsDAO.getExpenseAccount(expenseAccount,parameter);
	}

	@Override
	public List<Dictionary> getAllExpenditure(String type) {
		return financialStatisticsDAO.getAllExpenditure(type);
	}

	@Override
	public List<Dictionary> getAllExpenditureProject(String type) {
		return financialStatisticsDAO.getAllExpenditureProject(type);
	}
	@Override
	public Grid getZhiChuAnDaLei(String starttime, String endtime,Parameter parameter) {
		return financialStatisticsDAO.getZhiChuAnDaLei(starttime, endtime,parameter);
	}
	@Override
	public Grid getZhiChuAnZiXiang(String starttime, String endtime,
			Parameter parameter) {
		return financialStatisticsDAO.getZhiChuAnZiXiang(starttime, endtime, parameter);
	}

	@Override
	public Grid getZhiChuAnXiaoQu(String starttime, String endtime,
			Parameter parameter) {
		return financialStatisticsDAO.getZhiChuAnXiaoQu(starttime, endtime, parameter);
	}

	@Override
	public Grid getZhiChuYueDuiBi(String statisticalYear, Parameter parameter) {
		return financialStatisticsDAO.getZhiChuYueDuiBi(statisticalYear, parameter);
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
