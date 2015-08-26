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
import com.hqgj.xb.bean.easyui.SessionInfo;
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
		String sql="select School.schoolCode schoolCode,School.schoolName schoolName,ExpenseAccount.payDate payDate,"
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
						expenseAccount.setSchoolCode(rs.getString("schoolCode"));
						expenseAccount.setSchoolName(rs.getString("schoolName"));
						expenseAccount.setPayDate(rs.getString("payDate"));
						expenseAccount.setExpenditureProjectCode(rs.getString("expenditureProjectCode"));
						expenseAccount.setExpenditureCode(rs.getString("expenditureCode"));
						expenseAccount.setMoneyAmount(rs.getString("moneyAmount"));
						expenseAccount.setRemarks(rs.getString("remarks"));
						expenseAccount.setDhandlernameM(rs.getString("dHandlerNameM"));
						return expenseAccount;
					}});
		return result;
	}

	@Override
	public int updateExpenseAccount(ExpenseAccount expenseAccount) {
		String sql = "update ExpenseAccount set payDate=:payDate,schoolCode=:schoolCode,expenditureCode=:expenditureCode,expenditureProjectCode=:expenditureProjectCode,moneyAmount=:moneyAmount,dhandlerId=:dhandlerId,remarks=:remarks where id=:id";
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
		String sql = "select ExpenseAccount.payDate payDate,School.schoolCode schoolCode,School.schoolName schoolName,"
				+ "ExpenseAccount.expenditureProjectCode expenditureProjectCode,ExpenditureProject.nameM expenditureProjectnameM,"
				+ "Expenditure.nameM expenditurenameM,ExpenseAccount.expenditureCode expenditureCode,"
				+ "ExpenseAccount.moneyAmount moneyAmount,ExpenseAccount.remarks remarks,DHandler.nameM dHandlerNameM"
				+ " from ExpenseAccount left join Expenditure on ExpenseAccount.expenditureCode=Expenditure.code "
				+ " left join ExpenditureProject on ExpenseAccount.expenditureProjectCode=ExpenditureProject.id "
				+ " left join DHandler on ExpenseAccount.dhandlerId=DHandler.id "
				+ " left join School on ExpenseAccount.schoolCode=School.schoolCode ";
		//////////参数的设置？？？
		
		
		final List<ExpenseAccount> results = new ArrayList<ExpenseAccount>();
		SqlParameterSource expenseaccountParameterSource = new BeanPropertySqlParameterSource(expenseAccount);
		this.npJdbcTemplate.query(sql, expenseaccountParameterSource,new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				ExpenseAccount expenseAccount = new ExpenseAccount();
				expenseAccount.setPayDate(rs.getString("payDate"));
				expenseAccount.setSchoolCode(rs.getString("schoolCode"));
				expenseAccount.setSchoolName(rs.getString("schoolName"));
				expenseAccount.setExpenditureProjectCode(rs.getString("expenditureProjectCode"));
				expenseAccount.setExpenditureProjectnameM(rs.getString("expenditureProjectnameM"));
				expenseAccount.setExpenditureCode(rs.getString("expenditurenameM"));
				expenseAccount.setExpenditurenameM(rs.getString("expenditureCode"));
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
