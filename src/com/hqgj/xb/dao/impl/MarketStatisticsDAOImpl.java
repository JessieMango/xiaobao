package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.highcharts.Data;
import com.hqgj.xb.bean.highcharts.Series;
import com.hqgj.xb.bean.highcharts.Title;
import com.hqgj.xb.bean.highcharts.pieCharts;
import com.hqgj.xb.dao.MarketStatisticsDAO;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月17日 下午4:48:26
 */
@Repository
public class MarketStatisticsDAOImpl implements MarketStatisticsDAO {
	private static final Logger logger = Logger
			.getLogger(ResourceDaoImpl.class);

	private NamedParameterJdbcTemplate npJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	
	@Override
	public pieCharts getXiaoQuZiXunLiang(String starttime,String endtime,String xiaoqu) {
		
		String sql = "select School.schoolName schoolName,count(School.schoolName) countNum from Consult LEFT OUTER JOIN School on Consult.handleSchoolCode=School.schoolCode "
				+ "where Consult.consultDate between :starttime and :endtime group by School.schoolName";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		paramMap.put("xiaoqu", xiaoqu );

		pieCharts piecharts = new pieCharts();
		//设置标题
		Title title=new Title();
		title.setText("校区咨询量统计");
		piecharts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setType("pie");
		series.setName("校区咨询量");
	
		final List<Data> results = new ArrayList<Data>();
		this.npJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Data data =new Data();
					
						data.setName(rs.getString("schoolName"));
						if(StringUtils.isNotBlank(rs.getString("countNum"))){
							data.setY(Integer.parseInt(rs.getString("countNum")));
						}else{
							data.setY(0);
						}
						results.add(data);
					}
				});
		logger.info(results );
		series.setData(results);
		piecharts.setSeries(series);

		return piecharts;
	}

}
