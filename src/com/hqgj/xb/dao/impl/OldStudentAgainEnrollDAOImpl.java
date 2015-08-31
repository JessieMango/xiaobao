package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.OldStudentAgainEnroll;
import com.hqgj.xb.bean.StudentClass_TextbookFee;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.OldStudentAgainEnrollDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月26日 下午5:16:10
 */
@Repository
public class OldStudentAgainEnrollDAOImpl implements OldStudentAgainEnrollDAO {
	private Logger logger = Logger
			.getLogger(OldStudentAgainEnrollDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Grid getOldStudentAgainEnrolls(
			OldStudentAgainEnroll oldStudentAgainEnroll, Parameter parameter) {
		Map<String, String> map = new HashMap<String, String>();
		SqlParameterSource nParameterSource = new BeanPropertySqlParameterSource(
				oldStudentAgainEnroll);
		String select = " select c.id consultId,sc.id,c.banlance,c.availabelPoints,c.gender,c.nameM,(DATE_FORMAT(NOW(),'%Y')-DATE_FORMAT(c.birthday,'%Y')) birthday,c.otherTel,"
				+ "cs.nameM className,co.nameM courseName,u.username teacherName,sc.realTuition,sc.enrollDate,sc.discountType,"
				+ "sc.preferentialPrice,sc.reduceMoney,sc.discount,dss.nameM sellSource,ds.nameM seller,c.liveArea,dcs.nameM councilSchool,"
				+ "sc.studentType,dh.nameM handler,s.schoolName handleSchool,dscs.nameM studentState,cs.tuition  from Consult c "
				+ "left outer join StudentClass sc on c.id=sc.studentCode left outer join Class cs on cs.classCode=sc.classCode  "
				+ "left outer join Course co on co.courseCode=cs.courseCode left outer join User u on u.userId=cs.teacherCode  "
				+ "left outer join DSellSource dss on dss.id=sc.sellSourceCode left outer join DSeller ds on ds.id=sc.sellerCode  "
				+ "left outer join DCouncilSchool dcs on dcs.id=c.councilSchoolCode left outer join DHandler dh on dh.id=sc.handlerCode  "
				+ "left outer join School s on s.schoolCode=sc.handleSchoolCode left outer join DStudentClassStatus dscs on dscs.id=sc.studentState where c.state=1";
		if (StringUtils.isBlank(oldStudentAgainEnroll.getTelTail())
				&& StringUtils.isBlank(oldStudentAgainEnroll.getNameM())
				&& StringUtils.isBlank(oldStudentAgainEnroll.getStartTime())) { // 默认情况
			select += " and c.nameM='^&' ";
		} else {
			if (StringUtils.isNotBlank(oldStudentAgainEnroll.getNameM())
					|| StringUtils.isNotBlank(oldStudentAgainEnroll
							.getTelTail())) { // 条件一查询
				if (StringUtils.isNotBlank(oldStudentAgainEnroll.getNameM())) {
					map.put("nameM", oldStudentAgainEnroll.getNameM());
					select += " and c.nameM=:nameM ";
				}
				if (StringUtils.isNotBlank(oldStudentAgainEnroll.getTelTail())) {
					map.put("telTail",
							"%"
									+ StringUtils.trim(oldStudentAgainEnroll
											.getTelTail()));
					select += " and c.otherTel like :telTail ";
				}
			} else { // 条件二查询
				select += " and sc.enrollDate between :startTime and :endTime "; // 报名时间
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getHandleSchoolCode())) { // 经办学校
					select += " and sc.handleSchoolCode=:handleSchoolCode ";
				}
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getTeacherCode())) { // 老师
					select += " and cs.teacherCode=:teacherCode ";
				}
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getDiscountType())) { // 学费类型
					select += " and sc.discountType=:discountType ";
				}
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getStudentState())) { // 状态
					select += " and sc.studentState=:studentState ";
				}
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getSellerCode())) { // 销售
					select += " and sc.sellerCode=:sellerCode ";
				}
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getCourseTypeCode())) { // 课程
					select += " and cs.courseTypeCode=:courseTypeCode ";
				}
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getStudentType())) { // 类型
					select += " and sc.studentType=:studentType ";
				}
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getSellSourceCode())) { // 来源
					select += " and sc.sellSourceCode=:sellSourceCode ";
				}
				if (!StringUtils.equals("qb",
						oldStudentAgainEnroll.getHandlerCode())) { // 经办
					select += " and sc.handlerCode=:handlerCode ";
				}
				if (StringUtils.equals("1", oldStudentAgainEnroll.getOrder())) {
					select += " order by sc.enrollDate ";
				} else if (StringUtils.equals("2",
						oldStudentAgainEnroll.getOrder())) {
					select += " order by sc.studentState ";
				} else if (StringUtils.equals("3",
						oldStudentAgainEnroll.getOrder())) {
					select += " order by sc.sellSourceCode ";
				} else if (StringUtils.equals("4",
						oldStudentAgainEnroll.getOrder())) {
					select += " order by c.nameM ";
				} else if (StringUtils.equals("5",
						oldStudentAgainEnroll.getOrder())) {
					select += " order by c.birthday asc ";
				} else if (StringUtils.equals("6",
						oldStudentAgainEnroll.getOrder())) {
					select += " order by cs.courseTypeCode ";
				} else if (StringUtils.equals("7",
						oldStudentAgainEnroll.getOrder())) {
					select += " order by sc.handlerCode ";
				}
			}
		}
		logger.info(select);
		List<OldStudentAgainEnroll> results = this.nJdbcTemplate.query(select,
				nParameterSource, new RowMapper<OldStudentAgainEnroll>() {
					@Override
					public OldStudentAgainEnroll mapRow(ResultSet rs, int index)
							throws SQLException {
						OldStudentAgainEnroll oldStudentAgainEnroll = new OldStudentAgainEnroll();
						float money = 0;
						/**
						 * 计算是否欠费
						 */
						if (StringUtils.equals("1", // 原价
								rs.getString("discountType"))) {
							money = Float.parseFloat(rs
									.getString("realTuition"))
									- Float.parseFloat(rs.getString("tuition"));
							oldStudentAgainEnroll.setRealShouldTuition(rs
									.getString("tuition")); // 实际应交学费
							if (money < 0) {
								oldStudentAgainEnroll.setLackMoney(money + "");
							} else {
								oldStudentAgainEnroll.setLackMoney(money+"");
							}
						}
						if (StringUtils.equals("2", // 优惠
								rs.getString("discountType"))) {
							money = Float.parseFloat(rs
									.getString("realTuition"))
									- (Float.parseFloat(rs.getString("tuition")) - Float.parseFloat(rs
											.getString("preferentialPrice")));
							oldStudentAgainEnroll.setRealShouldTuition((Float
									.parseFloat(rs.getString("tuition")) - Float
									.parseFloat(rs
											.getString("preferentialPrice")))
									+ ""); // 实际应交学费
							if (money < 0) {
								oldStudentAgainEnroll.setLackMoney(money + "");
							} else {
								oldStudentAgainEnroll.setLackMoney(money+"");
							}
						}
						if (StringUtils.equals("3", // 打折
								rs.getString("discountType"))) {
							money = (float) (Float.parseFloat(rs
									.getString("realTuition")) - Float
									.parseFloat(rs.getString("tuition"))
									* Float.parseFloat(rs.getString("discount"))
									/ 10.0);
							oldStudentAgainEnroll.setRealShouldTuition(Float
									.parseFloat(rs.getString("tuition"))
									* Float.parseFloat(rs.getString("discount"))
									/ 10.0 + ""); // 实际应交学费
							if (money < 0) {
								oldStudentAgainEnroll.setLackMoney(money + "");
							} else {
								oldStudentAgainEnroll.setLackMoney(money+"");
							}
						}
						if (StringUtils.equals("4",
								rs.getString("discountType"))) { // 插班
							money = Float.parseFloat(rs
									.getString("realTuition"))
									- (Float.parseFloat(rs.getString("tuition")) - Float
											.parseFloat(rs
													.getString("reduceMoney")));
							oldStudentAgainEnroll.setRealShouldTuition((Float
									.parseFloat(rs.getString("tuition")) - Float
									.parseFloat(rs.getString("reduceMoney")))
									+ "");// 实际应交学费
							if (money < 0) {
								oldStudentAgainEnroll.setLackMoney(money + "");
							} else {
								oldStudentAgainEnroll.setLackMoney(money+"");
							}
						}
						oldStudentAgainEnroll.setId(rs.getString("id"));
						oldStudentAgainEnroll.setGender(rs.getString("gender"));
						oldStudentAgainEnroll.setNameM(rs.getString("nameM"));
						oldStudentAgainEnroll.setBirthday(rs
								.getString("birthday"));
						oldStudentAgainEnroll.setOtherTel(rs
								.getString("otherTel"));
						oldStudentAgainEnroll.setClassName(rs
								.getString("className"));
						oldStudentAgainEnroll.setCourseName(rs
								.getString("courseName"));
						oldStudentAgainEnroll.setTeacherName(rs
								.getString("teacherName"));
						oldStudentAgainEnroll.setRealTuition(rs
								.getString("realTuition"));
						oldStudentAgainEnroll.setReduceMoney(rs
								.getString("reduceMoney"));
						oldStudentAgainEnroll.setSeller(rs.getString("seller"));
						oldStudentAgainEnroll.setSellSource(rs
								.getString("sellSource"));
						oldStudentAgainEnroll.setDiscount(rs
								.getString("discount"));
						oldStudentAgainEnroll.setDiscountType(rs
								.getString("discountType"));
						oldStudentAgainEnroll.setCouncilSchool(rs
								.getString("councilSchool"));
						oldStudentAgainEnroll.setAvailabelPoints(rs
								.getString("availabelPoints"));
						oldStudentAgainEnroll.setBanlance(rs
								.getString("banlance"));
						oldStudentAgainEnroll.setConsultId(rs
								.getString("consultId"));
						oldStudentAgainEnroll.setPreferentialPrice(rs
								.getString("preferentialPrice"));
						oldStudentAgainEnroll.setEnrollDate(rs
								.getString("enrollDate"));
						oldStudentAgainEnroll.setLiveArea(rs
								.getString("liveArea"));
						oldStudentAgainEnroll.setHandler(rs
								.getString("handler"));
						oldStudentAgainEnroll.setHandleSchool(rs
								.getString("handleSchool"));
						oldStudentAgainEnroll.setStudentState(rs
								.getString("studentState"));
						oldStudentAgainEnroll.setStudentType(rs
								.getString("studentType"));
						return oldStudentAgainEnroll;
					}
				});
		String sql = "select st.*,t.type,t.price from StudentClass_TextbookFee st left outer join TextBookFee t "
				+ "on t.id=st.textbookFeeCode order by studentClassCode";
		List<StudentClass_TextbookFee> studentClass_TextbookFees = this.nJdbcTemplate
				.query(sql, new RowMapper<StudentClass_TextbookFee>() {
					@Override
					public StudentClass_TextbookFee mapRow(ResultSet rs,
							int index) throws SQLException {
						StudentClass_TextbookFee studentClass_TextbookFee = new StudentClass_TextbookFee();
						studentClass_TextbookFee.setId(rs.getString("id"));
						studentClass_TextbookFee.setNumbers(rs
								.getString("numbers"));
						studentClass_TextbookFee.setStudentClassCode(rs
								.getString("studentClassCode"));
						studentClass_TextbookFee.setType(rs.getString("type"));
						studentClass_TextbookFee.setPrice(rs.getString("price"));
						return studentClass_TextbookFee;
					}
				});
		for (OldStudentAgainEnroll oStudentAgainEnroll : results) {
			oStudentAgainEnroll.setTextBook("0");
			oStudentAgainEnroll.setFee("0");
			for (StudentClass_TextbookFee rs : studentClass_TextbookFees) {
				if (StringUtils.equals(oStudentAgainEnroll.getId(),
						rs.getStudentClassCode())
						&& StringUtils.equals("1", rs.getType())) {
					oStudentAgainEnroll
							.setTextBook((Float.parseFloat(rs.getNumbers())
									* Float.parseFloat(rs.getPrice()) + Float
										.parseFloat(oStudentAgainEnroll
												.getTextBook()))
									+ "");
				}
				if (StringUtils.equals(oStudentAgainEnroll.getId(),
						rs.getStudentClassCode())
						&& StringUtils.equals("2", rs.getType())) {
					oStudentAgainEnroll
							.setFee((Float.parseFloat(rs.getNumbers())
									* Float.parseFloat(rs.getPrice()) + Float
										.parseFloat(oStudentAgainEnroll
												.getFee()))
									+ "");
				}
			}
		}
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
