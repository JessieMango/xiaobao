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
import com.hqgj.xb.bean.highcharts.Charts;
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
	public Charts getXiaoQuZiXunLiang(String starttime,String endtime) {
		
		String sql = "select School.schoolName schoolName,count(School.schoolName) countNum from Consult LEFT OUTER JOIN School on Consult.handleSchoolCode=School.schoolCode "
				+ "where Consult.consultDate between :starttime and :endtime group by School.schoolName";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );

		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("校区咨询量统计");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
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
		charts.setSeries(series);

		return charts;
	}
	
	
	@Override
	public Charts getZiXunLaiYuan(String starttime,String endtime) {
		String sql = "select DSellSource.nameM nameM,count(Consult.sellSource) countNum from DSellSource left join Consult on DSellSource.id=Consult.sellSource "
				+ "where Consult.consultDate between :starttime and :endtime group by nameM ";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("咨询来源统计");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("咨询来源统计");
	
		final List<Data> results = new ArrayList<Data>();
		this.npJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Data data =new Data();
					
						data.setName(rs.getString("nameM"));
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
		charts.setSeries(series);

		return charts;
	}
	@Override
	public Charts getZiXunXiaoShouYuan(String starttime,String endtime) {
		String sql = "select DSeller.nameM nameM,count(Consult.seller) countNum from DSeller left join Consult on DSeller.id=Consult.seller "
				+ "where Consult.consultDate between :starttime and :endtime group by nameM ";
			
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("咨询销售员");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("咨询销售员");
	
		final List<Data> results = new ArrayList<Data>();
		this.npJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Data data =new Data();
					
						data.setName(rs.getString("nameM"));
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
		charts.setSeries(series);

		return charts;
	}


	@Override
	public Charts getBaoMingLaiYuan(String starttime, String endtime) {
		String sql = "select DSellSource.nameM nameM,count(DSellSource.id) countNum from DSellSource left join StudentClass on DSellSource.id=StudentClass.sellSource "
				+ "where StudentClass.enrollDate between :starttime and :endtime group by nameM ";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("报名来源");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("报名来源");
	
		final List<Data> results = new ArrayList<Data>();
		this.npJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Data data =new Data();
					
						data.setName(rs.getString("nameM"));
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
		charts.setSeries(series);

		return charts;
	}

	@Override
	public Charts getBaoMingXiaoShouYuan(String starttime, String endtime) {
		String sql = "select DSeller.nameM nameM,count(DSeller.id) countNum from DSeller left join StudentClass on DSeller.id=StudentClass.seller "
				+ "where StudentClass.enrollDate between :starttime and :endtime group by nameM ";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("报名销售员");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("报名销售员");
	
		final List<Data> results = new ArrayList<Data>();
		this.npJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Data data =new Data();
					
						data.setName(rs.getString("nameM"));
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
		charts.setSeries(series);

		return charts;
	}


	@Override
	public Charts getGongLiXueXiao(String starttime, String endtime) {
		String sql = "select DCouncilSchool.nameM nameM,count(DCouncilSchool.id) countNum from DCouncilSchool left join Consult on DCouncilSchool.id=Consult.councilSchoolCode "
				+ "where Consult.consultDate between :starttime and :endtime group by nameM ";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("公立学校");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("公立学校");
	
		final List<Data> results = new ArrayList<Data>();
		this.npJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Data data =new Data();
					
						data.setName(rs.getString("nameM"));
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
		charts.setSeries(series);

		return charts;
	}


	@Override
	public Charts getJuZhuQuYu(String starttime, String endtime) {
		String sql = "select Consult.liveArea nameM,count(Consult.liveArea) countNum from Consult "
				+ "where Consult.consultDate between :starttime and :endtime group by nameM ";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("居住区域咨询量统计");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("居住区域咨询量统计");
	
		final List<Data> results = new ArrayList<Data>();
		this.npJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Data data =new Data();
					
						data.setName(rs.getString("nameM"));
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
		charts.setSeries(series);

		return charts;
	}
}
