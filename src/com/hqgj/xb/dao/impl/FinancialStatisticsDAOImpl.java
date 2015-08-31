package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.hqgj.xb.bean.highcharts.Data;
import com.hqgj.xb.bean.highcharts.Series;
import com.hqgj.xb.bean.highcharts.Title;
import com.hqgj.xb.dao.FinancialStatisticsDAO;
import com.hqgj.xb.util.CommonUtil;

/**
 * @author 鲁宗豪
 * @datetime 2015年8月20日 下午10:23:54
 */
@Repository
public class FinancialStatisticsDAOImpl implements FinancialStatisticsDAO {
	private static final Logger logger = Logger
			.getLogger(ResourceDaoImpl.class);
	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public List<Dictionary> getAllExpenditure(String type) {
		String sql = "select code,nameM from Expenditure order by seq ";
		List<Dictionary> results = this.nJdbcTemplate.query(sql,
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
		List<Dictionary> results = this.nJdbcTemplate.query(sql,map,
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
		return this.nJdbcTemplate.update(sql, ExParameterSource);
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

		final ExpenseAccount result = this.nJdbcTemplate.queryForObject(sql, paramMap,
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
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(
				expenseAccount);
		return this.nJdbcTemplate.update(sql, paramSource);
	}

	@Override
	public int deleteExpenseAccount(String id) {
		String sqlDete = "DELETE from ExpenseAccount WHERE id=:id";
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		return this.nJdbcTemplate.update(sqlDete, map);
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
		final List<ExpenseAccount> results = new ArrayList<ExpenseAccount>();
		SqlParameterSource expenseaccountParameterSource = new BeanPropertySqlParameterSource(expenseAccount);
		this.nJdbcTemplate.query(sql, expenseaccountParameterSource,new RowCallbackHandler() {
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
	public Grid getZhiChuAnDaLei(String starttime, String endtime,Parameter parameter) {
		String sql = "select Expenditure.nameM ExpenditurenameM,count(*) Numberofaccounts,sum(ExpenseAccount.moneyAmount) summoneyAmount "
				+ "from Expenditure left outer join ExpenseAccount on Expenditure.code=ExpenseAccount.expenditureCode "
				+" where  ExpenseAccount.payDate between :starttime and :endtime "
				+ " group by Expenditure.code ";
			
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		
		final List<ExpenseAccount> results = new ArrayList<ExpenseAccount>();
		this.nJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						ExpenseAccount expenseAccount=new ExpenseAccount();
						expenseAccount.setExpenditurenameM(rs.getString("ExpenditurenameM"));
						
						if(StringUtils.isEmpty(rs.getString("summoneyAmount")))
						{
							expenseAccount.setSummoneyAmount("0");
							expenseAccount.setNumberofaccounts("0");
						}
						else {
							expenseAccount.setNumberofaccounts(rs.getString("Numberofaccounts"));
							expenseAccount.setSummoneyAmount(rs.getString("summoneyAmount"));
						}
						
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
	public Grid getZhiChuAnZiXiang(String starttime, String endtime,
			Parameter parameter) {
		String sql = "select ExpenditureProject.nameM ExpenditurenameM,count(*) Numberofaccounts,sum(ExpenseAccount.moneyAmount) summoneyAmount "
				+ "from ExpenditureProject left outer join ExpenseAccount on ExpenditureProject.id=ExpenseAccount.expenditureProjectCode "
				+" where  ExpenseAccount.payDate between :starttime and :endtime "
				+ " group by ExpenditureProject.id";
			
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		
		final List<ExpenseAccount> results = new ArrayList<ExpenseAccount>();
		this.nJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						ExpenseAccount expenseAccount=new ExpenseAccount();
						expenseAccount.setExpenditurenameM(rs.getString("ExpenditurenameM"));
						
						if(StringUtils.isEmpty(rs.getString("summoneyAmount")))
						{
							expenseAccount.setSummoneyAmount("0");
							expenseAccount.setNumberofaccounts("0");
						}
						else {
							expenseAccount.setNumberofaccounts(rs.getString("Numberofaccounts"));
							expenseAccount.setSummoneyAmount(rs.getString("summoneyAmount"));
						}
						
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
	public Grid getZhiChuAnXiaoQu(String starttime, String endtime,
			Parameter parameter) {
		////此处有问题，全部校区如何处理？？？？
		String sql = "select School.schoolName ExpenditurenameM,count(*) Numberofaccounts,sum(ExpenseAccount.moneyAmount) summoneyAmount "
				+ "from School left outer join ExpenseAccount on School.schoolCode=ExpenseAccount.schoolCode "
				+ "  group by School.schoolCode";
			
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );
		
		final List<ExpenseAccount> results = new ArrayList<ExpenseAccount>();
		this.nJdbcTemplate.query(sql, paramMap,
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						ExpenseAccount expenseAccount=new ExpenseAccount();
						expenseAccount.setExpenditurenameM(rs.getString("ExpenditurenameM"));
						
						if(StringUtils.isEmpty(rs.getString("summoneyAmount")))
						{
							expenseAccount.setSummoneyAmount("0");
							expenseAccount.setNumberofaccounts("0");
						}
						else {
							expenseAccount.setNumberofaccounts(rs.getString("Numberofaccounts"));
							expenseAccount.setSummoneyAmount(rs.getString("summoneyAmount"));
						}
						
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
	public Grid getZhiChuYueDuiBi(String statisticalYear, Parameter parameter) {
		String sql="select DATE_FORMAT(payDate,'%m') ExpenditurenameM,count(*) Numberofaccounts,sum(moneyAmount) summoneyAmount "
				+ "from ExpenseAccount "
				+ "where DATE_FORMAT(payDate,'%Y')=:statisticalYear "
				+ "group by ExpenditurenameM "
				+ "order by ExpenditurenameM";
			if(StringUtils.isEmpty(statisticalYear))
			{
				statisticalYear=CommonUtil.getSystemDate().substring(0,4);
			}
			logger.info(statisticalYear);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("statisticalYear",  statisticalYear );
		List<ExpenseAccount> results= this.nJdbcTemplate.query(sql, paramMap,
				new RowMapper<ExpenseAccount>() {
					@Override
					public ExpenseAccount mapRow(ResultSet rs, int index)
							throws SQLException {
						ExpenseAccount expenseAccount=new ExpenseAccount();
						expenseAccount.setExpenditurenameM(rs.getString("ExpenditurenameM"));
						expenseAccount.setNumberofaccounts(rs.getString("Numberofaccounts"));
						expenseAccount.setSummoneyAmount(rs.getString("summoneyAmount"));
						return expenseAccount;
					}
				});
		List<ExpenseAccount> temp=new ArrayList<ExpenseAccount>();
		if(results.size()>0)
		{
			int j;
			for(j=1;j<Integer.parseInt(results.get(0).getExpenditurenameM());j++)
			{
				ExpenseAccount expenseAccount=new ExpenseAccount();
				expenseAccount.setExpenditurenameM(""+j);
				expenseAccount.setNumberofaccounts("0");
				expenseAccount.setSummoneyAmount("0");
				temp.add(expenseAccount);
			}
			temp.add(results.get(0));
			j++;
			int resultssize=1;
			for(int i=0;i<results.size()-1;i++)
			{
				int minIndex=Integer.parseInt(results.get(i).getExpenditurenameM());
				int maxIndex=Integer.parseInt(results.get(i+1).getExpenditurenameM());
				for(;j>minIndex&&j<maxIndex;j++)
				{
					ExpenseAccount expenseAccount=new ExpenseAccount();
					expenseAccount.setExpenditurenameM(""+j);
					expenseAccount.setNumberofaccounts("0");
					expenseAccount.setSummoneyAmount("0");
					temp.add(expenseAccount);
				}
				temp.add(results.get(resultssize++));
				j++;
			}
			for(;j<13;j++)
			{
				ExpenseAccount expenseAccount=new ExpenseAccount();
				expenseAccount.setExpenditurenameM(""+j);
				expenseAccount.setNumberofaccounts("0");
				expenseAccount.setSummoneyAmount("0");
				temp.add(expenseAccount);
			}
		}
		else {
			for(int j=1;j<13;j++)
			{
				ExpenseAccount expenseAccount=new ExpenseAccount();
				expenseAccount.setExpenditurenameM(""+j);
				expenseAccount.setNumberofaccounts("0");
				expenseAccount.setSummoneyAmount("0");
				temp.add(expenseAccount);
			}
		}
		results=temp;
		
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
	
	
	//账户收入统计
	@Override
	public Charts getLiuShuiAnXiaoQu(String starttime, String endtime) {
		String sql="select School.schoolName schoolName,sum(FinancialRunnningAccount.realMoney) realMoney"
				+ " from School left outer join FinancialRunnningAccount on School.schoolCode=FinancialRunnningAccount.handleSchoolCode "
				+ "where FinancialRunnningAccount.operateDate between :starttime and :endtime "
				+ " group by School.schoolCode";
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );

		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("流水按校区");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("流水按校区");
		
		List<Data> results= this.nJdbcTemplate.query(sql, paramMap,
				new RowMapper<Data>() {
					@Override
					public Data mapRow(ResultSet rs, int index)
							throws SQLException {
						Data data=new Data();
						data.setName(rs.getString("schoolName"));
						if(StringUtils.isEmpty(rs.getString("realMoney")))
						{
							data.setY(0);
						}
						else {
							data.setY(Float.parseFloat(rs.getString("realMoney")));
						}
						return data;
					}
				});
		series.setData(results);
		charts.setSeries(series);
		return charts;
	}
	@Override
	public Charts getLiuShuiAnRenYuan(String starttime, String endtime) {
		String sql=" select DHandler.nameM DHandlernameM,sum(FinancialRunnningAccount.realMoney) realMoney "
				+ " from DHandler left outer join FinancialRunnningAccount on DHandler.id=FinancialRunnningAccount.handlerCode "
				+ " where FinancialRunnningAccount.operateDate between :starttime and :endtime "
				+ " group by DHandler.id ";
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );

		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("流水按人员");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("流水按人员");
		
		List<Data> results= this.nJdbcTemplate.query(sql, paramMap,
				new RowMapper<Data>() {
					@Override
					public Data mapRow(ResultSet rs, int index)
							throws SQLException {
						Data data=new Data();
						data.setName(rs.getString("DHandlernameM"));
						if(StringUtils.isEmpty(rs.getString("realMoney")))
						{
							data.setY(0);
						}
						else {
							data.setY(Float.parseFloat(rs.getString("realMoney")));
						}
						return data;
					}
				});
		series.setData(results);
		charts.setSeries(series);
		return charts;
	}
	@Override
	public Charts getXueFeiAnKeCheng(String starttime, String endtime) {
		String sql=" (select Course.nameM CoursenameM,sum(StudentClass.realTuition) realTuition "
				+ "from Course left outer join Class on Course.courseCode=Class.courseCode "
				+ "left outer join StudentClass on Class.classCode=StudentClass.classCode "
				+ "where StudentClass.studentState in (1,2,3) or StudentClass.studentState is null "
				+ "group by Course.courseCode) "
				+ "union "
				+ "(select Course.nameM CoursenameM,sum(StudentClass.realTuition)=null realTuition "
				+ "from Course left outer join Class on Course.courseCode=Class.courseCode "
				+ "left outer join StudentClass on Class.classCode=StudentClass.classCode "
				+ "where StudentClass.studentState =4 or StudentClass.studentState is null "
				+ "group by Course.courseCode)";
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );

		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("学费按课程");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("学费按课程");
		
		List<Data> results= this.nJdbcTemplate.query(sql, paramMap,
				new RowMapper<Data>() {
					@Override
					public Data mapRow(ResultSet rs, int index)
							throws SQLException {
						Data data=new Data();
						data.setName(rs.getString("CoursenameM"));
						if(StringUtils.isEmpty(rs.getString("realTuition")))
						{
							data.setY(0);
						}
						else {
							data.setY(Float.parseFloat(rs.getString("realTuition")));
						}
						return data;
					}
				});
		series.setData(results);
		charts.setSeries(series);
		return charts;
	}

	@Override
	public Charts getTuiFeiAnKeCheng(String starttime, String endtime) {
		String sql=" (select Course.nameM CoursenameM,sum(StudentClass.realTuition) realTuition "
				+ "from Course left outer join Class on Course.courseCode=Class.courseCode "
				+ "left outer join StudentClass on Class.classCode=StudentClass.classCode "
				+ "where StudentClass.studentState =4 or StudentClass.studentState is null "
				+ "group by Course.courseCode) "
				+ "union "
				+ "(select Course.nameM CoursenameM,sum(StudentClass.realTuition)=null realTuition "
				+ "from Course left outer join Class on Course.courseCode=Class.courseCode "
				+ "left outer join StudentClass on Class.classCode=StudentClass.classCode"
				+ " where StudentClass.studentState in (1,2,3) or StudentClass.studentState is null "
				+ "group by Course.courseCode)";
		
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );

		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("学费按课程");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("学费按课程");
		
		List<Data> results= this.nJdbcTemplate.query(sql, paramMap,
				new RowMapper<Data>() {
					@Override
					public Data mapRow(ResultSet rs, int index)
							throws SQLException {
						Data data=new Data();
						data.setName(rs.getString("CoursenameM"));
						if(StringUtils.isEmpty(rs.getString("realTuition")))
						{
							data.setY(0);
						}
						else {
							data.setY(Float.parseFloat(rs.getString("realTuition")));
						}
						return data;
					}
				});
		series.setData(results);
		charts.setSeries(series);
		return charts;
	}
	//退费按校区		
	@Override
	public Charts getTuiFeiAnXiaoQu(String starttime, String endtime) {
		String sql="(select School.schoolName schoolName,sum(StudentClass.realTuition) realTuition "
				+ "from School left outer join StudentClass on School.schoolCode=StudentClass.handleSchoolCode"
				+ " where StudentClass.studentState =4 or StudentClass.studentState is null "
				+ "group by School.schoolCode)"
				+ "union"
				+ "(select School.schoolName schoolName,sum(StudentClass.realTuition)=null realTuition "
				+ "from School left outer join StudentClass on School.schoolCode=StudentClass.handleSchoolCode "
				+ "where StudentClass.studentState in (1,2,3) or StudentClass.studentState is null "
				+ "group by School.schoolCode)";
	
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("starttime",  starttime );
		paramMap.put("endtime", endtime );

		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("退费按校区");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("退费按校区");
		
		List<Data> results= this.nJdbcTemplate.query(sql, paramMap,
				new RowMapper<Data>() {
					@Override
					public Data mapRow(ResultSet rs, int index)
							throws SQLException {
						Data data=new Data();
						data.setName(rs.getString("schoolName"));
						if(StringUtils.isEmpty(rs.getString("realTuition")))
						{
							data.setY(0);
						}
						else {
							data.setY(Float.parseFloat(rs.getString("realTuition")));
						}
						return data;
					}
				});
		series.setData(results);
		charts.setSeries(series);
		return charts;
	}
	
	@Override
	public Charts getLiuShuiYueDuiBi(String statisticalYear) {
		String sql="select DATE_FORMAT(enrollDate,'%m') enrollDateMonth,sum(StudentClass.realTuition) realTuition "
				+ "from StudentClass where DATE_FORMAT(enrollDate,'%Y')=:statisticalYear "
				+ "group by enrollDateMonth";
		logger.info(statisticalYear);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("statisticalYear",  statisticalYear );

		Charts charts = new Charts();
		//设置标题
		Title title=new Title();
		title.setText("流水月对比");
		charts.setTitle(title);

		//设置Series
		Series series=new Series();
		series.setName("流水月对比");
		List<Data> results= this.nJdbcTemplate.query(sql, paramMap,
				new RowMapper<Data>() {
					@Override
					public Data mapRow(ResultSet rs, int index)
							throws SQLException {
						Data data=new Data();
						data.setName(rs.getString("enrollDateMonth"));
						if(StringUtils.isEmpty(rs.getString("realTuition")))
						{
							data.setY(0);
						}
						else {
							data.setY(Float.parseFloat(rs.getString("realTuition")));
						}
						return data;
					}
				});
		List<Data> temp=new ArrayList<Data>();
		if(results.size()>0)
		{
			int j;
			for(j=1;j<Integer.parseInt(results.get(0).getName());j++)
			{
				Data data=new Data();
				data.setName(convertNumToMonth(j));
				data.setY(0);
				temp.add(data);
			}
			Data data1=results.get(0);
			data1.setName(convertNumToMonth(Integer.parseInt(data1.getName())));
			temp.add(data1);
			j++;
			int resultssize=1;
			for(int i=0;i<results.size()-1;i++)
			{
				int minIndex=Integer.parseInt(results.get(i).getName());
				int maxIndex=Integer.parseInt(results.get(i+1).getName());
				for(;j>minIndex&&j<maxIndex;j++)
				{
					Data data=new Data();
					data.setName(convertNumToMonth(j));
					data.setY(0);
					temp.add(data);
				}
				data1=results.get(resultssize++);
				data1.setName(convertNumToMonth(Integer.parseInt(data1.getName())));
				temp.add(data1);
				j++;
			}
			for(;j<13;j++)
			{
				Data data=new Data();
				data.setName(convertNumToMonth(j));
				data.setY(0);
				temp.add(data);
			}
		}
		else {
			for(int j=1;j<13;j++)
			{
				Data data=new Data();
				data.setName(convertNumToMonth(j));
				data.setY(0);
				temp.add(data);
			}
		}
		results=temp;
		series.setData(results);
		charts.setSeries(series);
		return charts;
	}
	
	private String convertNumToMonth(int Num) {
		String result="";
		switch (Num) {
		case 1:	
			result="一月";
			break;
		case 2:
			result="二月";
			break;
		case 3:	
			result="三月";
			break;
		case 4:	
			result="四月";
			break;
		case 5:	
			result="五月";
			break;
		case 6:	
			result="六月";
			break;
		case 7:	
			result="七月";
			break;
		case 8:	
			result="八月";
			break;
		case 9:	
			result="九月";
			break;
		case 10:	
			result="十月";
			break;
		case 11:
			result="十一月";
			break;
		case 12:	
			result="十二月";
			break;
		default:
			result="一月";
			break;
		}
		return result;
	}

}
