package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Consult;
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
	public List<Consult> getCouncilSchools() {
		return consultDAO.getCouncilSchools();
	}

	@Override
	public List<Consult> getWillDegree() {
		return consultDAO.getWillDegree();
	}

	@Override
	public List<Consult> getMark() {
		return consultDAO.getMark();
	}

	@Override
	public List<Consult> getSellSource() {
		return consultDAO.getSellSource();
	}

	@Override
	public List<Consult> getSeller() {
		return consultDAO.getSeller();
	}

	@Override
	public List<Consult> getHandler() {
		return consultDAO.getHandler();
	}

	@Override
	public int saveConsult(Consult consult) {
		return consultDAO.saveConsult(consult);
	}

}
