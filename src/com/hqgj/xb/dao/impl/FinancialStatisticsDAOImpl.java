package com.hqgj.xb.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
import com.hqgj.xb.dao.FinancialStatisticsDAO;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月20日 下午10:23:54
 */
@Repository
public class FinancialStatisticsDAOImpl implements FinancialStatisticsDAO {
	private static final Logger logger = Logger
			.getLogger(ResourceDaoImpl.class);

	private NamedParameterJdbcTemplate npJdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public Grid getLiuShuiZhang() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Charts getLiuShuiAnXiaoQu(String starttime, String endtime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagramCharts getLiuShuiYueDuiBi(String statisticalYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Charts getLiuShuiAnRenYuan(String starttime, String endtime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Charts getTuiFeiAnXiaoQu(String starttime, String endtime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Charts getXueFeiAnKeCheng(String starttime, String endtime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Charts getTuiFeiAnKeCheng(String starttime, String endtime) {
		// TODO Auto-generated method stub
		return null;
	}

}
