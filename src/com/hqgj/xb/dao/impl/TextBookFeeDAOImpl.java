package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.TextBookFee;
import com.hqgj.xb.bean.TextBookFeeChangeRecord;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.TextBookFeeDAO;
import com.hqgj.xb.util.CommonUtil;

/**
 * @author 崔兴伟
 * @datetime 2015年8月3日 下午5:47:00
 */
@Repository
public class TextBookFeeDAOImpl implements TextBookFeeDAO {
	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<TextBookFee> getAllTextBookFees(String type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		String sql = "select t.id id,t.courseTypeCode courseTypeCode,t.seq,t.nameM,t.price,t.points,t.type,ct.nameM courseTypeName,t.isEnableExchange isEnableExchange from TextBookFee t "
				+ "left outer join CourseType ct on ct.courseTypeCode=t.courseTypeCode where t.type=:type";
		List<TextBookFee> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setCourseTypeCode(rs
								.getString("courseTypeCode"));
						textBookFee.setCourseTypeName(rs
								.getString("courseTypeName"));
						textBookFee.setId(rs.getString("id"));
						textBookFee.setNameM(rs.getString("nameM"));
						textBookFee.setPoints(rs.getString("points"));
						textBookFee.setPrice(rs.getString("price"));
						textBookFee.setSeq(rs.getString("seq"));
						textBookFee.setType(rs.getString("type"));
						textBookFee.setIsEnableExchange(rs
								.getString("isEnableExchange"));
						return textBookFee;
					}
				});
		return results;
	}

	@Override
	public List<TextBookFee> getDTextBookFeesType() {
		String sql = "select *  from DTextBookFee ";
		List<TextBookFee> results = this.nJdbcTemplate.query(sql,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setType(rs.getString("code"));
						textBookFee.setDnameM(rs.getString("nameM"));
						return textBookFee;
					}
				});
		return results;
	}

	@Override
	public TextBookFee getTextBookFee(String id) {
		String sql = "select t.courseTypeCode courseTypeCode,t.seq,t.nameM,t.price,t.points,t.type,ct.nameM courseTypeName,t.isEnableExchange isEnableExchange from TextBookFee t "
				+ "left outer join CourseType ct on ct.courseTypeCode=t.courseTypeCode where t.id=:id ";

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		final TextBookFee result = this.nJdbcTemplate.queryForObject(sql, map,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setCourseTypeCode(rs
								.getString("courseTypeCode"));
						textBookFee.setNameM(rs.getString("nameM"));
						textBookFee.setPoints(rs.getString("points"));
						textBookFee.setPrice(rs.getString("price"));
						textBookFee.setSeq(rs.getString("seq"));
						textBookFee.setType(rs.getString("type"));
						textBookFee.setIsEnableExchange(rs
								.getString("isEnableExchange"));
						return textBookFee;
					}
				});
		return result;
	}

	@Override
	public int updateTextBookFee(TextBookFee textBookFee) {
		if (!StringUtils.isNotEmpty(textBookFee.getIsEnableExchange())) {
			textBookFee.setIsEnableExchange("0");
		}
		String sql = "update TextBookFee set courseTypeCode=:courseTypeCode,seq=:seq,nameM=:nameM,price=:price,points=:points,type=:type,isEnableExchange=:isEnableExchange where id=:id";
		SqlParameterSource textBookFeeParameterSource = new BeanPropertySqlParameterSource(
				textBookFee);
		return this.nJdbcTemplate.update(sql, textBookFeeParameterSource);
	}

	@Override
	public int deleteTextBookFee(String id) {
		String sql = "delete from TextBookFee where id=:code";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("code", id);
		return this.nJdbcTemplate.update(sql, paramMap);
	}

	@Override
	public int addTextBookFee(TextBookFee textBookFee) {
		textBookFee.setId(UUID.randomUUID().toString());
		if (!StringUtils.isNotEmpty(textBookFee.getIsEnableExchange())) {
			textBookFee.setIsEnableExchange("0");
		}
		String sql = "insert into TextBookFee(id,courseTypeCode,seq,nameM,price,points,type,isEnableExchange) values (:id,:courseTypeCode,:seq,:nameM,:price,:points,:type,:isEnableExchange)";

		SqlParameterSource textBookFeeParameterSource = new BeanPropertySqlParameterSource(
				textBookFee);
		return this.nJdbcTemplate.update(sql, textBookFeeParameterSource);
	}

	@Override
	public List<TextBookFee> getTextBookFeesByCourseType(String courseTypeCode,
			String type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("courseTypeCode", courseTypeCode);
		String sql = "select t.id id,t.courseTypeCode courseTypeCode,t.seq,t.nameM,t.price,t.points,t.type,ct.nameM courseTypeName,t.isEnableExchange isEnableExchange from TextBookFee t "
				+ "left outer join CourseType ct on ct.courseTypeCode=t.courseTypeCode where t.courseTypeCode=:courseTypeCode or t.courseTypeCode='qb' ";
		List<TextBookFee> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setCourseTypeCode(rs
								.getString("courseTypeCode"));
						textBookFee.setCourseTypeName(rs
								.getString("courseTypeName"));
						textBookFee.setId(rs.getString("id"));
						textBookFee.setNameM(rs.getString("nameM"));
						textBookFee.setPoints(rs.getString("points"));
						textBookFee.setPrice(rs.getString("price"));
						textBookFee.setSeq(rs.getString("seq"));
						textBookFee.setType(rs.getString("type"));
						textBookFee.setIsEnableExchange(rs
								.getString("isEnableExchange"));
						return textBookFee;
					}
				});
		return results;
	}

	@Override
	public List<TextBookFee> getKuCun(String courseTypeCode, String type) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("courseTypeCode", courseTypeCode);
		String sql = "select id,nameM,num1,num2,(num1+num2) total  from TextBookFee  where type=1  ";
		if (StringUtils.isNotBlank(courseTypeCode)) {
			sql += " and courseTypeCode=:courseTypeCode ";
		}
		List<TextBookFee> results = this.nJdbcTemplate.query(sql, map,
				new RowMapper<TextBookFee>() {
					@Override
					public TextBookFee mapRow(ResultSet rs, int index)
							throws SQLException {
						TextBookFee textBookFee = new TextBookFee();
						textBookFee.setId(rs.getString("id"));
						textBookFee.setNameM(rs.getString("nameM"));
						textBookFee.setNum1(rs.getString("num1"));
						textBookFee.setNum2(rs.getString("num2"));
						textBookFee.setTotal(rs.getString("total"));
						return textBookFee;
					}
				});
		if (StringUtils.equals(type, "qb")) {
			TextBookFee textBookFee = new TextBookFee();
			textBookFee.setId("qb");
			textBookFee.setNameM("全部");
			results.add(0, textBookFee);
		}
		return results;
	}

	@Override
	public int chuRuKu(TextBookFeeChangeRecord changeRecord) {
		SqlParameterSource nParameterSource = new BeanPropertySqlParameterSource(
				changeRecord);
		String insert = "insert into TextBookFeeChangeRecord (id,location,textbookFee_id,operate,number,operateDate,handler,remark) values "
				+ " (:id,:location,:textbookFee_id,:operate,:number,:operateDate,:handler,:remark)";
		String update = "";
		int n1 = 0;
		int n2 = 0;
		if (StringUtils.equals("1", changeRecord.getOperate())) { // 入库
			if (StringUtils.equals("1", changeRecord.getLocation())) { // 库房
				update = " update TextBookFee set num1=num1+:number where id=:textbookFee_id ";
			}
			if (StringUtils.equals("2", changeRecord.getLocation())) { // 学校
				update = " update TextBookFee set num2=num2+:number where id=:textbookFee_id ";
			}
		}
		if (StringUtils.equals("2", changeRecord.getOperate())) { // 出库
			if (StringUtils.equals("1", changeRecord.getLocation())) { // 库房
				update = " update TextBookFee set num1=num1-:number where id=:textbookFee_id ";
			}
			if (StringUtils.equals("2", changeRecord.getLocation())) { // 学校
				update = " update TextBookFee set num2=num2-:number where id=:textbookFee_id ";
			}
		}
		n1 = this.nJdbcTemplate.update(insert, nParameterSource);
		n2 = this.nJdbcTemplate.update(update, nParameterSource);
		return n1 + n2;
	}

	@Override
	public int zhuanKu(TextBookFeeChangeRecord changeRecord) {
		/**
		 * 转出
		 */
		TextBookFeeChangeRecord fromKu = new TextBookFeeChangeRecord();
		fromKu.setId(UUID.randomUUID().toString());
		fromKu.setLocation(changeRecord.getFromLocation());
		fromKu.setNumber(changeRecord.getNumber());
		fromKu.setHandler(changeRecord.getHandler());
		fromKu.setOperate("2");
		fromKu.setTextbookFee_id(changeRecord.getTextbookFee_id());
		fromKu.setOperateDate(changeRecord.getOperateDate());
		fromKu.setRemark("转出>" + changeRecord.getRemark());
		int n1 = chuRuKu(fromKu);
		/**
		 * 转入
		 */
		TextBookFeeChangeRecord toKu = new TextBookFeeChangeRecord();
		toKu.setId(UUID.randomUUID().toString());
		toKu.setLocation(changeRecord.getToLocation());
		toKu.setOperate("1");
		toKu.setNumber(changeRecord.getNumber());
		toKu.setHandler(changeRecord.getHandler());
		toKu.setTextbookFee_id(changeRecord.getTextbookFee_id());
		toKu.setOperateDate(changeRecord.getOperateDate());
		toKu.setRemark("转入>" + changeRecord.getRemark());
		int n2 = chuRuKu(toKu);
		return n1 + n2;
	}

	@Override
	public Grid getKuCunBianDongJiLu(TextBookFeeChangeRecord changeRecord,
			Parameter parameter) {
		Map<String, String> map = new HashMap<String, String>();
		String sql = "select tc.id,tc.location,tc.operate,tc.number,tc.operateDate,tc.handler,tc.remark,tb.nameM textbookFee_id"
				+ " from TextBookFeeChangeRecord tc left outer join TextBookFee tb on tb.id=tc.textbookFee_id  ";
		if (StringUtils.isNotBlank(parameter.getStartTime())) {
			map.put("startTime", parameter.getStartTime());
			map.put("endTime", parameter.getEndTime());
			sql += " where tc.operateDate between :startTime and :endTime ";
			if (!StringUtils.equals("qb", changeRecord.getLocation())) {
				map.put("location", changeRecord.getLocation());
				sql += " and tc.location=:location ";
			}
			if (!StringUtils.equals("qb", changeRecord.getTextbookFee_id())) {
				map.put("textbookFee_id", changeRecord.getTextbookFee_id());
				sql += " and tc.textbookFee_id=:textbookFee_id";
			}
		} else {
			map.put("startTime", CommonUtil.getSystemDate());
			map.put("endTime", CommonUtil.getSystemDate());
			sql += " where tc.operateDate between :startTime and :endTime ";
		}
		List<TextBookFeeChangeRecord> results = this.nJdbcTemplate.query(sql,
				map, new RowMapper<TextBookFeeChangeRecord>() {
					@Override
					public TextBookFeeChangeRecord mapRow(ResultSet rs,
							int index) throws SQLException {
						TextBookFeeChangeRecord textBookFeeChangeRecord = new TextBookFeeChangeRecord();
						textBookFeeChangeRecord.setId(rs.getString("id"));
						textBookFeeChangeRecord.setHandler(rs
								.getString("handler"));
						textBookFeeChangeRecord.setLocation(rs
								.getString("location"));
						textBookFeeChangeRecord.setNumber(rs
								.getString("number"));
						textBookFeeChangeRecord.setOperate(rs
								.getString("operate"));
						textBookFeeChangeRecord.setOperateDate(rs
								.getString("operateDate"));
						textBookFeeChangeRecord.setRemark(rs
								.getString("remark"));
						textBookFeeChangeRecord.setTextbookFee_id(rs
								.getString("textbookFee_id"));
						return textBookFeeChangeRecord;
					}
				});
		System.out.println(sql);
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
	public int updateTextBookFeeChangeRecord(
			TextBookFeeChangeRecord changeRecord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTextBookFeeChangeRecord(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TextBookFeeChangeRecord getTextBookFeeChangeRecordById(String id) {
		String sql = "select * from TextBookFeeChangeRecord  where textbookFee_id=:id ";
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		final TextBookFeeChangeRecord result = this.nJdbcTemplate
				.queryForObject(sql, map,
						new RowMapper<TextBookFeeChangeRecord>() {
							@Override
							public TextBookFeeChangeRecord mapRow(ResultSet rs,
									int index) throws SQLException {
								TextBookFeeChangeRecord textBookFeeChangeRecord = new TextBookFeeChangeRecord();
								textBookFeeChangeRecord.setHandler(rs
										.getString("handler"));
								textBookFeeChangeRecord.setLocation(rs
										.getString("location"));
								textBookFeeChangeRecord.setNumber(rs
										.getString("number"));
								textBookFeeChangeRecord.setOperate(rs
										.getString("operate"));
								textBookFeeChangeRecord.setOperateDate(rs
										.getString("operateDate"));
								textBookFeeChangeRecord.setRemark(rs
										.getString("remark"));
								textBookFeeChangeRecord.setTextbookFee_id(rs
										.getString("textbookFee_id"));
								return textBookFeeChangeRecord;
							}
						});
		return result;
	}

}
