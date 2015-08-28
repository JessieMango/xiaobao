package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.ExpenseAccount;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.bean.highcharts.Charts;
import com.hqgj.xb.bean.highcharts.DiagramCharts;
import com.hqgj.xb.bean.highcharts.Title;
import com.hqgj.xb.bean.highcharts.mixedgraph.Items;
import com.hqgj.xb.bean.highcharts.mixedgraph.Labels;
import com.hqgj.xb.bean.highcharts.mixedgraph.MixedCharts;
import com.hqgj.xb.bean.highcharts.mixedgraph.Series;
import com.hqgj.xb.bean.highcharts.mixedgraph.Style;
import com.hqgj.xb.bean.highcharts.mixedgraph.XAxis;
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
	public List<Dictionary> getAllExpenditure(String type) {
		String sql = "select code,nameM from Expenditure order by seq ";
		List<Dictionary> results = this.npJdbcTemplate.query(sql,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("code"));
						dictionary.setNameM(rs.getString("nameM"));
						return dictionary;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Dictionary temp = new Dictionary();
			temp.setId("qb");
			temp.setNameM("--全部--");
			results.add(0, temp);
		}
		if (StringUtils.equals(type, "2")) {
			Dictionary temp = new Dictionary();
			temp.setId("qq");
			temp.setNameM("请选择支出大类");
			results.add(0, temp);
		}
		return results;
	}

	@Override
	public List<Dictionary> getAllExpenditureProject(String ExpenditureID) {
		String sql = "select ExpenditureProject.id ExpenditureProjectid,ExpenditureProject.nameM ExpenditureProjectnameM from ExpenditureProject ";
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotBlank(ExpenditureID)) {
		map.put("ExpenditureID", ExpenditureID);
		sql += " where epCode=:ExpenditureID ";
		}
	sql += " order by seq ";
		List<Dictionary> results = this.npJdbcTemplate.query(sql,map,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("ExpenditureProjectid"));
						dictionary.setNameM(rs.getString("ExpenditureProjectnameM"));
						return dictionary;
					}
				});
		return results;
	}
	@Override
	public int addExpenseAccount(ExpenseAccount expenseAccount) {
		expenseAccount.setId(UUID.randomUUID().toString());
		String sql = "insert into ExpenseAccount(id,payDate,schoolCode,expenditureCode,expenditureProjectCode,moneyAmount,dhandlerId,remarks) values "
										+ " (:id,:payDate,:schoolCode,:expenditureCode,:expenditureProjectCode,:moneyAmount,:dhandlerId,:remarks)";
		SqlParameterSource ExParameterSource = new BeanPropertySqlParameterSource(
				expenseAccount);
		return this.npJdbcTemplate.update(sql, ExParameterSource);
	}

	@Override
	public ExpenseAccount getExpenseAccountById(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		logger.info(id);
		String sql="select ExpenseAccount.id ExpenseAccountid,School.schoolCode schoolCode,School.schoolName schoolName,ExpenseAccount.payDate payDate,"
				+ "ExpenseAccount.expenditureProjectCode expenditureProjectCode,ExpenseAccount.expenditureCode expenditureCode,"
				+ "ExpenseAccount.moneyAmount moneyAmount,ExpenseAccount.remarks remarks,DHandler.nameM dHandlerNameM"
				+ " from ExpenseAccount left join Expenditure on ExpenseAccount.expenditureCode=Expenditure.code "
				+ " left join ExpenditureProject on ExpenseAccount.expenditureProjectCode=ExpenditureProject.id "
				+ " left join DHandler on ExpenseAccount.dhandlerId=DHandler.id "
				+ " left join School on ExpenseAccount.schoolCode=School.schoolCode "
				+ " where ExpenseAccount.id=:id ";

		final ExpenseAccount result = this.npJdbcTemplate.queryForObject(sql, paramMap,
				new RowMapper<ExpenseAccount>() {
					@Override
					public ExpenseAccount mapRow(ResultSet rs, int index)
							throws SQLException {
						ExpenseAccount expenseAccount = new ExpenseAccount();
						expenseAccount.setId(rs.getString("ExpenseAccountid"));
						expenseAccount.setSchoolCode(rs.getString("schoolCode"));
						expenseAccount.setSchoolName(rs.getString("schoolName"));
						expenseAccount.setPayDate(rs.getString("payDate"));
						expenseAccount.setExpenditureProjectCode(rs.getString("expenditureProjectCode"));
						expenseAccount.setExpenditureCode(rs.getString("expenditureCode"));
						expenseAccount.setMoneyAmount(rs.getString("moneyAmount"));
						expenseAccount.setRemarks(rs.getString("remarks"));
						expenseAccount.setDhandlernameM(rs.getString("dHandlerNameM"));
						logger.info(expenseAccount.getDhandlernameM());
						return expenseAccount;
					}});
		
		return result;
	}

	@Override
	public int updateExpenseAccount(ExpenseAccount expenseAccount) {
		String sql = "update ExpenseAccount set payDate=:payDate,schoolCode=:schoolCode,expenditureCode=:expenditurenameM,expenditureProjectCode=:expenditureProjectnameM,moneyAmount=:moneyAmount,remarks=:remarks where id=:id";
		logger.info(sql);
		logger.info(expenseAccount);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(
				expenseAccount);
		return this.npJdbcTemplate.update(sql, paramSource);
	}

	@Override
	public int deleteExpenseAccount(String id) {
		String sqlDete = "DELETE from ExpenseAccount WHERE id=:id";
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		return this.npJdbcTemplate.update(sqlDete, map);
	}

	@Override
	public Grid getExpenseAccount(ExpenseAccount expenseAccount, Parameter parameter) {
		String sql = "select ExpenseAccount.id id,ExpenseAccount.payDate payDate,School.schoolCode schoolCode,School.schoolName schoolName,"
				+ "ExpenseAccount.expenditureProjectCode expenditureProjectCode,ExpenditureProject.nameM expenditureProjectnameM,"
				+ "Expenditure.nameM expenditurenameM,ExpenseAccount.expenditureCode expenditureCode,"
				+ "ExpenseAccount.moneyAmount moneyAmount,ExpenseAccount.remarks remarks,DHandler.nameM dHandlerNameM"
				+ " from ExpenseAccount left join Expenditure on ExpenseAccount.expenditureCode=Expenditure.code "
				+ " left join ExpenditureProject on ExpenseAccount.expenditureProjectCode=ExpenditureProject.id "
				+ " left join DHandler on ExpenseAccount.dhandlerId=DHandler.id "
				+ " left join School on ExpenseAccount.schoolCode=School.schoolCode ";
		
		if(StringUtils.isNotBlank(expenseAccount.getStartTime()))
		{
			sql+=" where payDate between :startTime and :endTime ";
			
				if (!StringUtils.equals("qb", expenseAccount.getSchoolCode()))
				{
					sql+=" and School.schoolCode=:schoolCode ";			
				}
				if (!StringUtils.equals("qb", expenseAccount.getExpenditureCode()))
				{
					sql+=" and expenditureCode=:expenditureCode ";			
				}
				if (!StringUtils.equals("qb", expenseAccount.getDhandlerId()))
				{
					sql+=" and DHandler.id=:dhandlerId ";			
				}
				if (StringUtils.isNotBlank(expenseAccount.getExpenditureProjectCode())&&!StringUtils.equals("qb", expenseAccount.getExpenditureProjectCode()))
				{
					sql+=" and expenditureProjectCode=:expenditureProjectCode ";			
				}
				if (StringUtils.isNotBlank(expenseAccount.getRemarks())&&!StringUtils.equals("qb", expenseAccount.getRemarks()))
				{
					String temp=expenseAccount.getRemarks();
					temp="%"+temp+"%";
					expenseAccount.setRemarks(temp);
					sql+=" and remarks like :remarks ";			
				}
		}
		logger.info(sql);
		final List<ExpenseAccount> results = new ArrayList<ExpenseAccount>();
		SqlParameterSource expenseaccountParameterSource = new BeanPropertySqlParameterSource(expenseAccount);
		this.npJdbcTemplate.query(sql, expenseaccountParameterSource,new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				ExpenseAccount expenseAccount = new ExpenseAccount();
				expenseAccount.setId(rs.getString("id"));
				expenseAccount.setPayDate(rs.getString("payDate"));
				expenseAccount.setSchoolCode(rs.getString("schoolCode"));
				expenseAccount.setSchoolName(rs.getString("schoolName"));
				expenseAccount.setExpenditureProjectCode(rs.getString("expenditureProjectCode"));
				expenseAccount.setExpenditureProjectnameM(rs.getString("expenditureProjectnameM"));
				expenseAccount.setExpenditureCode(rs.getString("expenditureCode"));
				expenseAccount.setExpenditurenameM(rs.getString("expenditurenameM"));
				expenseAccount.setMoneyAmount(rs.getString("moneyAmount"));
				expenseAccount.setRemarks(rs.getString("remarks"));
				expenseAccount.setDhandlernameM(rs.getString("dHandlerNameM"));
				results.add(expenseAccount);
			}
		});
		Grid grid = new Grid();
		if ((int) parameter.getPage() > 0) {
			int page = (int) parameter.getPage();
			int rows = (int) parameter.getRows();
			int fromIndex = (page - 1) * rows;
			int toIndex = (results.size() <= page * rows && results.size() >= (page - 1)
					* rows) ? results.size() : page * rows;
			grid.setRows(results.subList(fromIndex, toIndex));
			grid.setTotal(results.size());

		} else {
			grid.setRows(results);
		}
		return grid;
	}
	@Override
	public MixedCharts getZhiChuAnDaLei(String starttime, String endtime) {
		String sql = "select Expenditure.nameM ExpenditurenameM,count(*) Numberofaccounts,sum(ExpenseAccount.moneyAmount) from ExpenseAccount left join Expenditure on ExpenseAccount.expenditureCode=Expenditure.code group by ExpenseAccount.expenditureCode ";
			
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		
		final MixedCharts mixedCharts = new MixedCharts();
		
		  
		  Labels labels =new Labels();
		  mixedCharts.setLabels(labels);
		  List<Items> items=new ArrayList<Items>();
		  labels.setItems(items);
		  Items Items0=new Items();
		  Items0.setHtml("开支部门");
		  Style style=new Style();
		  style.setColor("(Highcharts.theme && Highcharts.theme.textColor) || 'black'");
		  style.setLeft("50px");
		  style.setTop("18px");
		  Items0.setStyle(style);
		  items.add(Items0);
		  
		  
		  List<String> center=new ArrayList<String>();
		  center.add("80");
		  center.add("100");
		  mixedCharts.setCenter(center);
		  
		  String size="100";
		  mixedCharts.setSize(size);
		  
		  Boolean showInLegend=false;
		  mixedCharts.setShowInLegend(showInLegend);
		  
		//设置标题
		Title title=new Title();
		title.setText("支出按大类统计表");
		mixedCharts.setTitle(title);

		
		this.npJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						
						 //1动态数据
						  XAxis xAxis=new XAxis();
						  List<String> categories;
						  if(null == mixedCharts.getxAxis()||null==mixedCharts.getxAxis().getCategories())
						  {
							  categories=new ArrayList<String>();
						  }
						  else {
							  categories=mixedCharts.getxAxis().getCategories();
						  }
						  categories.add(rs.getString("ExpenditurenameM"));
						  xAxis.setCategories(categories);
						  mixedCharts.setxAxis(xAxis);
						  
						  //2动态数据
						  List<Series> series;
						  if (null != mixedCharts.getSeries())
						  {
							  series=mixedCharts.getSeries();
						  }
						  else {
							  series=new ArrayList<Series>();
						}
						  
						  Series seriesobj=new Series();
						  seriesobj.setType("column");
						  seriesobj.setName("账目条数");
						  List<Integer> data=new ArrayList<Integer>();
						  
						  if(StringUtils.isNotBlank(rs.getString("Numberofaccounts")))
						  {
						  data.add(Integer.parseInt(rs.getString("Numberofaccounts")));
						  }
						  else {
							  data.add(0);
						}
						  seriesobj.setData(data);
						  series.add(seriesobj);
						  mixedCharts.setSeries(series);
					}
				});
			return mixedCharts;
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
