package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.ConsultDAO;
import com.hqgj.xb.service.ConsultService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月6日 下午4:03:07
 */
@Service
public class ConsultSeriveImpl implements ConsultService {

	@Autowired
	private ConsultDAO consultDAO;

	
	@Override
	public List<Consult> getCouncilSchools(String type) {
		return consultDAO.getCouncilSchools(type);
	}

	@Override
	public List<Consult> getWillDegree(String type) {
		return consultDAO.getWillDegree(type);
	}

	@Override
	public List<Consult> getMark(String type) {
		return consultDAO.getMark(type);
	}

	@Override
	public List<Consult> getSellSource(String type) {
		return consultDAO.getSellSource(type);
	}

	@Override
	public List<Consult> getSeller(String type) {
		return consultDAO.getSeller(type);
	}

	@Override
	public List<Consult> getHandler(String type) {
		return consultDAO.getHandler(type);
	}

	@Override
	public int saveConsult(Consult consult) {
		return consultDAO.saveConsult(consult);
	}

	@Override
	public List<Consult> getConsultWay(String type) {
		return consultDAO.getConsultWay(type);
	}

	@Override
	public Grid getConsult(Consult consult, Parameter parameter) {
		return consultDAO.getConsult(consult, parameter);
	}

	@Override
	public Consult getConsultById(String id) {
		return consultDAO.getConsultById(id);
	}

	@Override
	public int updateConsult(Consult consult) {
		return consultDAO.updateConsult(consult);
	}

	@Override
	public int deleteConsult(String id) {
		return consultDAO.deleteConsult(id);
	}

}
