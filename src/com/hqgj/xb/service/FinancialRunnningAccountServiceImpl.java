package com.hqgj.xb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.FinancialRunnningAccount;
import com.hqgj.xb.bean.StudentClass;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.FinancialRunnningAccountDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月29日 下午4:55:04
 */
@Service
public class FinancialRunnningAccountServiceImpl implements
		FinancialRunnningAccountService {
	@Autowired
	private FinancialRunnningAccountDAO financialRunnningAccountDAO;

	@Override
	public int addFinancialRunnningAccount(
			FinancialRunnningAccount financialRunnningAccount) {
		return financialRunnningAccountDAO
				.addFinancialRunnningAccount(financialRunnningAccount);
	}

	@Override
	public List<Dictionary> getTypeCode(String type) {
		return financialRunnningAccountDAO.getTypeCode(type);
	}

	@Override
	public List<Dictionary> getPayWayCode(String type) {
		return financialRunnningAccountDAO.getPayWayCode(type);
	}

	@Override
	public List<Dictionary> getOperateCode(String type) {
		return financialRunnningAccountDAO.getOperateCode(type);
	}

	@Override
	public Grid getFinancialRunnningAccount(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter) {
		return financialRunnningAccountDAO.getFinancialRunnningAccount(
				financialRunnningAccount, parameter);
	}

	@Override
	public int deleteFinancialRunnningAccount(String id, String type) {
		return financialRunnningAccountDAO.deleteFinancialRunnningAccount(id, type);
	}

	@Override
	public Grid getFinancialRunnningAccountOfTrash(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter) {
		return financialRunnningAccountDAO.getFinancialRunnningAccountOfTrash(financialRunnningAccount, parameter);
	}

	@Override
	public List<FinancialRunnningAccount> getRunningwaterDaily(String startTime,String pageCode,String userId) {
		return financialRunnningAccountDAO.getRunningwaterDaily(startTime,pageCode,userId);
	}

	@Override
	public int zhuanBan(StudentClass studentClass,
			FinancialRunnningAccount financialRunnningAccount) {
		
		return financialRunnningAccountDAO.zhuanBan(studentClass, financialRunnningAccount);
	}

}
