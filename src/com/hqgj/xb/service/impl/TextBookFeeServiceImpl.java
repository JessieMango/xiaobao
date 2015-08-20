package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.TextBookFee;
import com.hqgj.xb.dao.TextBookFeeDAO;
import com.hqgj.xb.service.TextBookFeeService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 下午5:44:49
 */
@Service
public class TextBookFeeServiceImpl implements TextBookFeeService {
	@Autowired
	private TextBookFeeDAO textBookFeeDAO;
	@Override
	public List<TextBookFee> getAllTextBookFees(String type) {
		return textBookFeeDAO.getAllTextBookFees(type);
	}

	@Override
	public List<TextBookFee> getDTextBookFeesType() {
		return textBookFeeDAO.getDTextBookFeesType();
	}

	@Override
	public TextBookFee getTextBookFee(String id) {
		return textBookFeeDAO.getTextBookFee(id);
	}

	@Override
	public int updateTextBookFee(TextBookFee textBookFee) {
		return textBookFeeDAO.updateTextBookFee(textBookFee);
	}

	@Override
	public int deleteTextBookFee(String id) {
		return textBookFeeDAO.deleteTextBookFee(id);
	}

	@Override
	public int addTextBookFee(TextBookFee textBookFee) {
		return textBookFeeDAO.addTextBookFee(textBookFee);
	}

	@Override
	public List<TextBookFee> getTextBookFeesByCourseType(String courseTypeCode,String type) {
		return textBookFeeDAO.getTextBookFeesByCourseType(courseTypeCode,type);
	}

}
