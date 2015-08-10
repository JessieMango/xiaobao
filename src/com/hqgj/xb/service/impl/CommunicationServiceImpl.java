package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Communication;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.CommunicationDAO;
import com.hqgj.xb.service.CommunicationService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月10日 上午9:45:11
 */
@Service
public class CommunicationServiceImpl implements CommunicationService {
	@Autowired
	private CommunicationDAO communicationDAO;

	@Override
	public Grid getCommunications(Communication communication,Parameter parameter) {
		return communicationDAO.getCommunications(communication,parameter);
	}

	@Override
	public Communication getCommunicationById(String id) {
		return communicationDAO.getCommunicationById(id);
	}

	@Override
	public List<Communication> getCommunicationByConsultId(String id) {
		return communicationDAO.getCommunicationByConsultId(id);
	}

	@Override
	public int addCommunication(Communication communication) {
		return communicationDAO.addCommunication(communication);
	}

	@Override
	public int updateCommunication(Communication communication) {
		return communicationDAO.updateCommunication(communication);
	}

	@Override
	public int deleteCommunicationById(String id) {
		return communicationDAO.deleteCommunicationById(id);
	}

}
