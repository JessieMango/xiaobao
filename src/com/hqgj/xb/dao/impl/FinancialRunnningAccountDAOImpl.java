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
import com.hqgj.xb.bean.StudentClass;
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
		} else if (StringUtils.equals("9",
				financialRunnningAccount.getOperateCode())) { // 退费
			map.put("balance", financialRunnningAccount.getBalance());
			map.put("returnTuitionReason",
					financialRunnningAccount.getReturnTuitionReason());
			n2 = this.nJdbcTemplate
					.update("update StudentClass set studentState=4,returnTuitionReason=:returnTuitionReason where id=:studentClass_id",
							map);
			if (StringUtils.equals("on",
					financialRunnningAccount.getIsBanlance())) { // 如果剩余学费转为余额
				map.put("realMoney", financialRunnningAccount.getBalance());
				financialRunnningAccount.setRemark("退费"
						+ financialRunnningAccount.getBalance() + "元转为余额");
				n3 = this.nJdbcTemplate
						.update("update Consult set banlance=banlance+:realMoney,availabelPoints=availabelPoints+:realMoney where id=:consultId",
								map);
			} else { // 余额不变
				financialRunnningAccount.setRemark("退费"
						+ financialRunnningAccount.getBalance() + "元");
				financialRunnningAccount.setBalance("");
			}
			financialRunnningAccount.setRealMoney("-"
					+ financialRunnningAccount.getBalance());
			financialRunnningAccount.setTypeCode("1");
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

	private Grid queryFinancialRunnningAccount(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter, String select) {
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
		return queryFinancialRunnningAccount(financialRunnningAccount,
				parameter, select);
	}

	@Override
	public int deleteFinancialRunnningAccount(String id, String type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		String updateById = "update FinancialRunnningAccount set flag=0 where id=:id ";
		String restoreById = "update FinancialRunnningAccount set flag=1 where id=:id ";
		String deleteById = "delete from FinancialRunnningAccount where id=:id ";
		int n = 0;
		if (StringUtils.equals("1", type)) {
			n = this.nJdbcTemplate.update(updateById, map);
		} else if (StringUtils.equals("2", type)) {
			n = this.nJdbcTemplate.update(deleteById, map);
		} else if (StringUtils.equals("3", type)) {
			n = this.nJdbcTemplate.update(restoreById, map);
		}
		return n;
	}

	@Override
	public Grid getFinancialRunnningAccountOfTrash(
			FinancialRunnningAccount financialRunnningAccount,
			Parameter parameter) {
		String select = "select fra.id,dfo.nameM operate,cl.nameM className,fra.realMoney,dt.nameM payWay,fra.balance,fra.feeState,"
				+ "fra.remark,	c.nameM studentName,c.gender,s.schoolName,dh.nameM handler,fra.operateDate	"
				+ "from FinancialRunnningAccount fra left outer join DPayType dt on dt.id=fra.payWayCode	"
				+ "left outer join DFinancialOperate dfo on dfo.id=fra.operateCode	left outer join DFinancialType dft on dft.id=fra.typeCode	"
				+ "left outer join StudentClass sc on sc.id=fra.studentClass_id	"
				+ "left outer join Class cl on cl.classCode=sc.classCode	left outer join Consult c on c.id=sc.studentCode	"
				+ "left outer join DHandler dh on fra.handlerCode=dh.id left outer join School s on fra.handleSchoolCode=s.schoolCode	where fra.flag=0";
		return queryFinancialRunnningAccount(financialRunnningAccount,
				parameter, select);
	}

	@Override
	public List<FinancialRunnningAccount> getRunningwaterDaily(
			String startTime, String pageCode, String userId) {
		logger.info("startTime:" + startTime + ";pageCode:" + pageCode);
		Map<String, String> map = new HashMap<String, String>();
		map.put("startTime", startTime);
		map.put("userId", userId);
		// 现金方式交的费用
		String select1 = "select f.typeCode,sum(f.realMoney) feeState  from FinancialRunnningAccount f where f.payWayCode=1 and f.operateDate=:startTime    ";
		if (StringUtils.equals(pageCode, "me")) {
			select1 += " and handlerCode=:userId ";
		}
		select1 += " group by f.typeCode";
		List<FinancialRunnningAccount> result1 = this.nJdbcTemplate.query(
				select1, map, new RowMapper<FinancialRunnningAccount>() {
					@Override
					public FinancialRunnningAccount mapRow(ResultSet rs,
							int index) throws SQLException {
						FinancialRunnningAccount temp = new FinancialRunnningAccount();
						temp.setTypeCode(rs.getString("typeCode"));
						temp.setFeeState(rs.getString("feeState"));
						return temp;
					}
				});
		// 刷卡/支票/转账/网络
		String select2 = "select f.typeCode,sum(f.realMoney) realMoney  from FinancialRunnningAccount f where f.payWayCode in (2,3,4,5) and f.operateDate=:startTime  ";
		if (StringUtils.equals(pageCode, "me")) {
			select2 += " and handlerCode=:userId ";
		}
		select2 += " group by f.typeCode";
		List<FinancialRunnningAccount> result2 = this.nJdbcTemplate.query(
				select2, map, new RowMapper<FinancialRunnningAccount>() {
					@Override
					public FinancialRunnningAccount mapRow(ResultSet rs,
							int index) throws SQLException {
						FinancialRunnningAccount temp = new FinancialRunnningAccount();
						temp.setTypeCode(rs.getString("typeCode"));
						temp.setRealMoney(rs.getString("realMoney"));
						return temp;
					}
				});
		// 算合计
		String select3 = "select f.typeCode,sum(f.realMoney) remark from FinancialRunnningAccount f where f.payWayCode in (1,2,3,4,5) and f.operateDate=:startTime  ";
		if (StringUtils.equals(pageCode, "me")) {
			select3 += " and handlerCode=:userId ";
		}
		select3 += " group by f.typeCode";
		List<FinancialRunnningAccount> result3 = this.nJdbcTemplate.query(
				select3, map, new RowMapper<FinancialRunnningAccount>() {
					@Override
					public FinancialRunnningAccount mapRow(ResultSet rs,
							int index) throws SQLException {
						FinancialRunnningAccount temp = new FinancialRunnningAccount();
						temp.setTypeCode(rs.getString("typeCode"));
						temp.setRemark(rs.getString("remark"));
						return temp;
					}
				});
		List<FinancialRunnningAccount> result = new ArrayList<FinancialRunnningAccount>();
		FinancialRunnningAccount temp1 = new FinancialRunnningAccount(); // 学费
		temp1.setTypeCode("1");
		FinancialRunnningAccount temp2 = new FinancialRunnningAccount(); // 教材杂费
		temp2.setTypeCode("2");
		FinancialRunnningAccount temp3 = new FinancialRunnningAccount(); // 合计
		temp3.setTypeCode("3");

		float number = 0;
		for (FinancialRunnningAccount tAccount : result1) { // 现金
			if (StringUtils.equals("1", tAccount.getTypeCode())) {
				temp1.setFeeState(tAccount.getFeeState());
			}
			if (StringUtils.equals("2", tAccount.getTypeCode())) {
				temp2.setFeeState(tAccount.getFeeState());
			}
			number += Float.parseFloat(tAccount.getFeeState());
		}
		temp3.setFeeState(number + "");

		number = 0;
		for (FinancialRunnningAccount tAccount : result2) { // 刷卡/支票/转账/网络
			if (StringUtils.equals("1", tAccount.getTypeCode())) {
				temp1.setRealMoney(tAccount.getRealMoney());
			}
			if (StringUtils.equals("2", tAccount.getTypeCode())) {
				temp2.setRealMoney(tAccount.getRealMoney());
			}
			number += Float.parseFloat(tAccount.getRealMoney());
		}
		temp3.setRealMoney(number + "");

		number = 0;
		for (FinancialRunnningAccount tAccount : result3) { // 合计
			if (StringUtils.equals("1", tAccount.getTypeCode())) {
				temp1.setRemark(tAccount.getRemark());
			}
			if (StringUtils.equals("2", tAccount.getTypeCode())) {
				temp2.setRemark(tAccount.getRemark());
			}
			number += Float.parseFloat(tAccount.getRemark());
		}
		temp3.setRemark(number + "");

		result.add(temp1);
		result.add(temp2);
		result.add(temp3);
		return result;
	}

	@Override
	public int zhuanBan(StudentClass studentClass,
			FinancialRunnningAccount financialRunnningAccount) {
		int n1 = 0;
		int n2 = 0;
		int n3 = 0; // 转出
		int n4 = 0; // 转入
		int n5 = 0; // 按其缴费
		int n6 = 0; // 增加学生
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", financialRunnningAccount.getConsultId());
		map.put("remark", studentClass.getRemark());
		map.put("studentClass_id",
				financialRunnningAccount.getStudentClass_id());
		studentClass.setId(financialRunnningAccount.getStudentClass_id());
		SqlParameterSource studentClassParameterSource = new BeanPropertySqlParameterSource(
				studentClass);
		String sqlZhuanChu = "update StudentClass set studentState=2,remark=:remark where id=:studentClass_id "; // 修改学生状态为转出
		n1 = this.nJdbcTemplate.update(sqlZhuanChu, map); // 转出
		studentClass.setStudentCode(financialRunnningAccount.getConsultId()); // 学生ID
		studentClass.setStudentType("2");// 学生类型为老生
		studentClass.setId(UUID.randomUUID().toString()); // 设置报名表ID
		if (StringUtils.equals(studentClass.getDiscountType(), "4")) { // 如果插班生
			studentClass.setIsMiddle("1");
		} else {
			studentClass.setIsMiddle("0");
		}
		if (StringUtils.equals("bu", studentClass.getBuOrTui())) { // 补款
			studentClass.setRealTuition(studentClass.getMoneyOfLack());
			studentClass.setTuitionRemark("补交了" + studentClass.getRealTuition()
					+ "元");
		} else { // 退款
			studentClass.setRealTuition("-" + studentClass.getMoneyOfReturn());
			studentClass.setTuitionRemark("退款了"
					+ studentClass.getMoneyOfReturn() + "元");
		}

		studentClassParameterSource = new BeanPropertySqlParameterSource(
				studentClass);

		String sqlZhuanRu = "insert into StudentClass (id,classCode,studentCode,tuitionRemark,enrollDate,payTypeCode,realTuition,"
				+ "discountType,preferentialPrice,reduceMoney,discount,sellerCode,handleSchoolCode,sellSourceCode,studentType,isMiddle,handlerCode) values (:id,:classCode,"
				+ ":studentCode,:tuitionRemark,:enrollDate,:payTypeCode,:realTuition,:discountType,:preferentialPrice,:reduceMoney,"
				+ ":discount,:sellerCode,:handleSchoolCode,:sellSourceCode,:studentType,:isMiddle,:handlerCode)";
		n2 = this.nJdbcTemplate.update(sqlZhuanRu, studentClassParameterSource);

		String sqlLiuShui = "insert into FinancialRunnningAccount(operateDate,operateCode,typeCode,payWayCode,handlerCode,handleSchoolCode,feeState,remark,"
				+ "studentClass_id,realMoney,balance,flag) values (:operateDate,:operateCode,:typeCode,:payWayCode,:handlerCode,:handleSchoolCode,"
				+ ":feeState,:remark,:studentClass_id,:realMoney,:balance,:flag) ";

		// operateCode=5 转班转出
		financialRunnningAccount.setOperateDate(studentClass.getEnrollDate()); // 操作日期
		financialRunnningAccount.setOperateCode("5");
		financialRunnningAccount.setTypeCode("1"); // 类型为学费余额
		financialRunnningAccount.setPayWayCode("6"); // 转班转出退款 付款方式为为学费
		financialRunnningAccount.setRealMoney("-"
				+ financialRunnningAccount.getBanlanceOfZhuanban()); // 转出
		// 交的的钱为负
		financialRunnningAccount.setBalance(financialRunnningAccount
				.getBanlanceOfZhuanban());
		financialRunnningAccount.setRemark("(原班剩余学费转余额)");
		financialRunnningAccount.setHandlerCode(studentClass.getHandlerCode());
		financialRunnningAccount.setHandleSchoolCode(studentClass
				.getHandleSchoolCode());

		SqlParameterSource fParameterSource = new BeanPropertySqlParameterSource(
				financialRunnningAccount);
		n3 = this.nJdbcTemplate.update(sqlLiuShui, fParameterSource);

		// operateCode=4转班转入
		financialRunnningAccount.setOperateCode("4");
		financialRunnningAccount.setTypeCode("1"); // 类型为学费余额
		financialRunnningAccount.setPayWayCode("7"); // 转班转入 用余额付款
		if (StringUtils.equals("tui", studentClass.getBuOrTui())) {
			financialRunnningAccount.setRealMoney("0");
			financialRunnningAccount.setBalance("-"
					+ financialRunnningAccount.getRealTuition());
			map.put("banlance", studentClass.getMoneyOfReturn()); // 转为余额的数目
			n6 = this.nJdbcTemplate
					.update("update Consult set banlance=banlance+:banlance where id=:id ",
							map);
		} else {
			financialRunnningAccount.setRealMoney("0");
			financialRunnningAccount.setBalance("-"
					+ financialRunnningAccount.getBanlanceOfZhuanban());
		}
		financialRunnningAccount.setRemark("(使用原班剩余学费)");
		fParameterSource = new BeanPropertySqlParameterSource(
				financialRunnningAccount);
		n4 = this.nJdbcTemplate.update(sqlLiuShui, fParameterSource);

		// 按期缴费
		if (studentClass.getMoneyOfLack() != null
				&& Float.parseFloat(studentClass.getMoneyOfLack()) > 0) {
			financialRunnningAccount.setOperateCode("2");
			financialRunnningAccount.setPayWayCode(studentClass
					.getPayTypeCode());
			financialRunnningAccount.setRemark("使用余额后额外需要缴费"
					+ (Float.parseFloat(studentClass.getMoneyOfLack()) + Float
							.parseFloat(financialRunnningAccount
									.getBanlanceOfZhuanban())) + "元");
			financialRunnningAccount
					.setRealMoney(studentClass.getMoneyOfLack());
			fParameterSource = new BeanPropertySqlParameterSource(
					financialRunnningAccount);
			n5 = this.nJdbcTemplate.update(sqlLiuShui, fParameterSource);
		}

		return n1 + n2 + n3 + n4 + n5 + n6;
	}
}
