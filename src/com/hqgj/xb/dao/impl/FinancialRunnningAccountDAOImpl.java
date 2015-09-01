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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.Dictionary;
import com.hqgj.xb.bean.FinancialRunnningAccount;
import com.hqgj.xb.bean.StudentClass_TextbookFee;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.FinancialRunnningAccountDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月29日 下午4:54:44
 */
@Repository
public class FinancialRunnningAccountDAOImpl implements
		FinancialRunnningAccountDAO {
	private Logger logger = Logger
			.getLogger(FinancialRunnningAccountDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int addFinancialRunnningAccount(
			FinancialRunnningAccount financialRunnningAccount) {
		String insertFRA = "insert into FinancialRunnningAccount(operateDate,operateCode,typeCode,payWayCode,handlerCode,handleSchoolCode,feeState,remark,"
				+ "studentClass_id,realMoney,balance,flag) values (:operateDate,:operateCode,:typeCode,:payWayCode,:handlerCode,:handleSchoolCode,"
				+ ":feeState,:remark,:studentClass_id,:realMoney,:balance,:flag)";
		int n1 = 0; // 流水表更新
		int n2 = 0; // 报名表更新
		int n3 = 0; // 咨询表更新
		Map<String, String> map = new HashMap<String, String>();
		map.put("studentClass_id",
				financialRunnningAccount.getStudentClass_id());
		map.put("consultId", financialRunnningAccount.getConsultId());
		if (StringUtils.equals("8", financialRunnningAccount.getOperateCode())) { // 如果是补费
			float realMoney = Float.parseFloat(financialRunnningAccount
					.getRealMoney());
			float realTuition = Float.parseFloat(financialRunnningAccount
					.getRealTuition());
			float realShouldTuition = Float.parseFloat(financialRunnningAccount
					.getRealShouldTuition());
			String realTuitionString = "";
			if ((realShouldTuition - realTuition) < realMoney) { // 如果补得费用不够这一门课缺的费用
				realTuitionString = realShouldTuition + "";
			} else {
				realTuitionString = (realTuition + realMoney) + "";
			}
			map.put("realMoney", realMoney + "");
			map.put("realTuitionString", realTuitionString);
			n2 = this.nJdbcTemplate
					.update("update StudentClass set realTuition=:realTuitionString where id=:studentClass_id",
							map);
			n3 = this.nJdbcTemplate
					.update("update Consult set banlance=banlance+:realMoney,availabelPoints=availabelPoints+:realMoney where id=:consultId",
							map);
		} else if (StringUtils.equals("3",
				financialRunnningAccount.getOperateCode())) { // 如果是购买教材
			List<StudentClass_TextbookFee> studentClass_TextbookFees = new ArrayList<StudentClass_TextbookFee>(); // 杂费项
			// 添加杂费项
			String[] textBookFeeStrings = financialRunnningAccount
					.getTextBookFeeCode().split(",");
			String[] numberStrings = financialRunnningAccount.getNum().split(
					",");
			for (int i = 0; i < textBookFeeStrings.length; i++) {
				if (!StringUtils.equals("0", numberStrings[i])) {
					StudentClass_TextbookFee studentClass_TextbookFee = new StudentClass_TextbookFee();
					studentClass_TextbookFee
							.setId(UUID.randomUUID().toString());
					studentClass_TextbookFee.setNumbers(numberStrings[i]);
					studentClass_TextbookFee
							.setTextbookFeeCode(textBookFeeStrings[i]);
					studentClass_TextbookFee
							.setStudentClassCode(financialRunnningAccount
									.getId());
					studentClass_TextbookFees.add(studentClass_TextbookFee);
				}
			}
			map.put("realMoney", financialRunnningAccount.getRealMoney());
			n3 = this.nJdbcTemplate
					.update("update Consult set availabelPoints=availabelPoints+:realMoney where id=:consultId",
							map);
		} else if (StringUtils.equals("7",
				financialRunnningAccount.getOperateCode())) { // 预存余额
			map.put("balance", financialRunnningAccount.getBalance());
			if (StringUtils.equals("6",
					financialRunnningAccount.getPayWayCode())) { // 余额付款,停课
				map.put("realMoney", "0");
				map.put("stopClassReason",
						financialRunnningAccount.getStopClassReason());
				n2 = this.nJdbcTemplate
						.update("update StudentClass set studentState=3,stopClassReason=:stopClassReason where id=:studentClass_id",
								map);
				n3 = this.nJdbcTemplate
						.update("update Consult set banlance=banlance+:balance,availabelPoints=availabelPoints+:realMoney where id=:consultId",
								map);
				logger.info("realMoney:" + map.get("realMoney") + ";balance;"
						+ map.get("balance") + ";consultId:"
						+ map.get("consultId") + ";n3:" + n3);
			} else {
				map.put("realMoney", financialRunnningAccount.getRealMoney());
				n3 = this.nJdbcTemplate
						.update("update Consult set banlance=banlance+:realMoney,availabelPoints=availabelPoints+:realMoney where id=:consultId",
								map);
			}
		}
		SqlParameterSource nParameterSource = new BeanPropertySqlParameterSource(
				financialRunnningAccount);
		n1 = this.nJdbcTemplate.update(insertFRA, nParameterSource);

		return n1 + n2 + n3;
	}

	@Override
	public List<Dictionary> getTypeCode(String type) {
		String sql = "select * from DFinancialType ";
		List<Dictionary> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("id"));
						dictionary.setNameM(rs.getString("nameM"));
						return dictionary;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Dictionary dictionary = new Dictionary();
			dictionary.setId("qb");
			dictionary.setNameM("全部类型");
			results.add(0, dictionary);
		}
		return results;
	}

	@Override
	public List<Dictionary> getPayWayCode(String type) {
		String sql = "select * from  DPayType";
		List<Dictionary> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("id"));
						dictionary.setNameM(rs.getString("nameM"));
						return dictionary;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Dictionary dictionary = new Dictionary();
			dictionary.setId("qb");
			dictionary.setNameM("全部方式");
			results.add(0, dictionary);
		}
		return results;
	}

	@Override
	public List<Dictionary> getOperateCode(String type) {
		String sql = "select * from DFinancialOperate ";
		List<Dictionary> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Dictionary>() {
					@Override
					public Dictionary mapRow(ResultSet rs, int index)
							throws SQLException {
						Dictionary dictionary = new Dictionary();
						dictionary.setId(rs.getString("id"));
						dictionary.setNameM(rs.getString("nameM"));
						return dictionary;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Dictionary dictionary = new Dictionary();
			dictionary.setId("qb");
			dictionary.setNameM("全部操作");
			results.add(0, dictionary);
		}
		return results;
	}

	@Override
	public Grid getFinancialRunnningAccount(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter) {
		String select = "select fra.id,dfo.nameM operate,cl.nameM className,fra.realMoney,dt.nameM payWay,fra.balance,fra.feeState,"
				+ "fra.remark,	c.nameM studentName,c.gender,s.schoolName,dh.nameM handler,fra.operateDate	"
				+ "from FinancialRunnningAccount fra left outer join DPayType dt on dt.id=fra.payWayCode	"
				+ "left outer join DFinancialOperate dfo on dfo.id=fra.operateCode	left outer join DFinancialType dft on dft.id=fra.typeCode	"
				+ "left outer join StudentClass sc on sc.id=fra.studentClass_id	"
				+ "left outer join Class cl on cl.classCode=sc.classCode	left outer join Consult c on c.id=sc.studentCode	"
				+ "left outer join DHandler dh on fra.handlerCode=dh.id left outer join School s on fra.handleSchoolCode=s.schoolCode	where fra.flag=1";
		SqlParameterSource nParameterSource = new BeanPropertySqlParameterSource(
				financialRunnningAccount);
		if (StringUtils.isBlank(financialRunnningAccount.getId())
				&& StringUtils.isBlank(financialRunnningAccount
						.getStudentName())
				&& StringUtils.isBlank(financialRunnningAccount.getStartTime())) { // 默认情况
			select += " and c.nameM='^&' ";
		} else {
			if (StringUtils.isNotBlank(financialRunnningAccount
					.getStudentName())
					|| StringUtils.isNotBlank(financialRunnningAccount.getId())) {
				if (StringUtils.isNotBlank(financialRunnningAccount
						.getStudentName())) {
					select += " and c.nameM=:studentName ";
				}
				if (StringUtils.isNotBlank(financialRunnningAccount.getId())) {
					select += " and fra.id=:id ";
				}
			} else { // 条件二查询
				select += " and fra.operateDate between :startTime and :endTime ";
				if (!StringUtils.equals("qb",
						financialRunnningAccount.getOperateCode())) {
					select += " and fra.operateCode=:operateCode ";
				}
				if (!StringUtils.equals("qb",
						financialRunnningAccount.getTypeCode())) {
					select += " and fra.typeCode=:typeCode ";
				}
				if (!StringUtils.equals("qb",
						financialRunnningAccount.getPayWayCode())) {
					select += " and fra.payWayCode=:payWayCode ";
				}
				if (!StringUtils.equals("qb",
						financialRunnningAccount.getCourseTypeCode())) {
					select += " and fra.courseTypeCode=:courseTypeCode ";
				}
				if (!StringUtils.equals("qb",
						financialRunnningAccount.getHandlerCode())) {
					select += " and fra.handlerCode=:handlerCode ";
				}
				if (!StringUtils.equals("qb",
						financialRunnningAccount.getHandleSchoolCode())) {
					select += " and fra.handleSchoolCode=:handleSchoolCode ";
				}
				if (!StringUtils.equals("qb",
						financialRunnningAccount.getFeeState())) {
					select += " and fra.feeState=:feeState ";
				}
				if (StringUtils.equals("1",
						financialRunnningAccount.getSchoolCode())) {

				}
				if (StringUtils
						.equals("1", financialRunnningAccount.getOrder())) {
					select += " order by fra.operateDate ";
				} else if (StringUtils.equals("2",
						financialRunnningAccount.getOrder())) {
					select += " order by fra.handlerCode ";
				}
			}
		}
		List<FinancialRunnningAccount> results = this.nJdbcTemplate.query(
				select, nParameterSource,
				new RowMapper<FinancialRunnningAccount>() {
					@Override
					public FinancialRunnningAccount mapRow(ResultSet rs,
							int index) throws SQLException {
						FinancialRunnningAccount fra = new FinancialRunnningAccount();
						fra.setId(rs.getString("id"));
						fra.setOperate(rs.getString("operate"));
						fra.setClassName(rs.getString("className"));
						fra.setRealMoney(rs.getString("realMoney"));
						fra.setPayWay(rs.getString("payWay"));
						fra.setBalance(rs.getString("balance"));
						fra.setFeeState(rs.getString("feeState"));
						fra.setRemark(rs.getString("remark"));
						fra.setStudentName(rs.getString("studentName"));
						fra.setGender(rs.getString("gender"));
						fra.setHandleSchool(rs.getString("schoolName"));
						fra.setHandler(rs.getString("handler"));
						fra.setOperateDate(rs.getString("operateDate"));
						return fra;
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

}
