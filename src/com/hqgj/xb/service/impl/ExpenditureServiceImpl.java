package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Expenditure;
import com.hqgj.xb.dao.ExpenditureDAO;
import com.hqgj.xb.service.ExpenditureService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 上午11:14:23
 */
@Service
public class ExpenditureServiceImpl implements ExpenditureService{
	@Autowired
	private ExpenditureDAO expenditureDAO;
	@Override
	public List<Expenditure> getAllExpenditureProjects() {
		List<Expenditure> expenditures = expenditureDAO.getAllExpenditureProjects();
		for(Expenditure expenditure : expenditures){
			expenditure.setEdit(expenditure.getExpenditureName());
			expenditure.setDelete(expenditure.getExpenditureName());
		}
		return expenditures;
	}

	@Override
	public Expenditure getExpenditure(String id) {
		return expenditureDAO.getExpenditure(id);
	}

	@Override
	public Expenditure getExpenditureProject(String id) {
		return expenditureDAO.getExpenditureProject(id);
	}

	@Override
	public List<Expenditure> getAllExpenditures() {
		return expenditureDAO.getAllExpenditures();
	}

	@Override
	public int addExpenditure(Expenditure expenditure) {
		return expenditureDAO.addExpenditure(expenditure);
	}

	@Override
	public int addExpenditureProject(Expenditure expenditure) {
		return expenditureDAO.addExpenditureProject(expenditure);
	}

	@Override
	public int updateExpenditure(Expenditure expenditure) {
		return expenditureDAO.updateExpenditure(expenditure);
	}

	@Override
	public int updateExpenditureProject(Expenditure expenditure) {
		return expenditureDAO.updateExpenditureProject(expenditure);
	}

	@Override
	public int deleteExpenditure(String id) {
		return expenditureDAO.deleteExpenditure(id);
	}

	@Override
	public int deleteExpenditureProject(String id) {
		return expenditureDAO.deleteExpenditureProject(id);
	}

}
