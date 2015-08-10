package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.School;
import com.hqgj.xb.bean.User;
import com.hqgj.xb.bean.easyui.Grid;
import com.hqgj.xb.bean.easyui.Parameter;
import com.hqgj.xb.dao.ConsultDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月6日 下午4:09:07
 */
@Repository
public class ConsultDAOImpl implements ConsultDAO {
	private Logger logger = Logger.getLogger(ConsultDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Consult> getCouncilSchools(String type) {
		String sql = "select * from DCouncilSchool order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setCouncilSchoolCode(rs.getString("id"));
						consult.setCouncilSchool(rs.getString("nameM"));
						return consult;
					}
				});
		return results;
	}

	@Override
	public List<Consult> getWillDegree(String type) {
		String sql = "select * from DWillDegreeCode order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setWillDegreeCode(rs.getString("id"));
						consult.setWillDegree(rs.getString("nameM"));
						return consult;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Consult temp = new Consult();
			temp.setWillDegreeCode("qb");
			temp.setWillDegree("全部意向度");
			results.add(0, temp);
		}
		return results;
	}

	@Override
	public List<Consult> getMark(String type) {
		String sql = "select * from DMark order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setMarkCode(rs.getString("id"));
						consult.setMark(rs.getString("nameM"));
						return consult;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Consult temp = new Consult();
			temp.setMarkCode("qb");
			temp.setMark("全部标记");
			results.add(0, temp);
		}
		return results;
	}

	@Override
	public List<Consult> getSellSource(String type) {
		String sql = "select * from DSellSource order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setSellSourceCode(rs.getString("id"));
						consult.setSellSource(rs.getString("nameM"));
						return consult;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Consult temp = new Consult();
			temp.setSellSourceCode("qb");
			temp.setSellSource("全部来源");
			results.add(0, temp);
		}
		return results;
	}

	@Override
	public List<Consult> getSeller(String type) {
		String sql = "select * from DSeller order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setSellerCode(rs.getString("id"));
						consult.setSeller(rs.getString("nameM"));
						return consult;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Consult temp = new Consult();
			temp.setSellerCode("qb");
			temp.setSeller("全部销售");
			results.add(0, temp);
		}
		return results;
	}

	@Override
	public List<Consult> getHandler(String type) {
		String sql = "select * from DHandler order by seq ";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setHandlerCode(rs.getString("id"));
						consult.setHandler(rs.getString("nameM"));
						return consult;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Consult temp = new Consult();
			temp.setHandlerCode("qb");
			temp.setHandler("全部经办");
			results.add(0, temp);
		}
		return results;
	}

	@Override
	public int saveConsult(Consult consult) {
		boolean result = false;
		consult.setId(UUID.randomUUID().toString()); // 设置咨询表ID
		consult.setState("0"); // 默认咨询时没有报名
		// 公立学校处理
		List<Consult> consults = getCouncilSchools(null);
		if (StringUtils.isNotBlank(consult.getCouncilSchoolCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getCouncilSchoolCode(),
						cs.getCouncilSchoolCode())) {
					consult.setCouncilSchoolCode(cs.getCouncilSchoolCode()); // 如果字典表中有直接把该公立学校的编码存入咨询表
					result = true;
				}
			}
			if (!result) { // 如果字典表中没有直接把该公立学校，要把该公立学校插入公立学校字典表
				consult.setCouncilSchool(consult.getCouncilSchoolCode());
				consult.setCouncilSchoolCode(UUID.randomUUID().toString());
				// 插入公立学校字典表
				String sql = "insert into DCouncilSchool(id,nameM) values(:councilSchoolCode,:councilSchool)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 标记处理
		result = false;
		consults = getMark(null);
		if (StringUtils.isNotBlank(consult.getMarkCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getMarkCode(), cs.getMarkCode())) {
					consult.setMarkCode(cs.getMarkCode()); // 如果字典表中有直接把该标记的编码存入咨询表
					result = true;
				}
			}
			if (!result) { // 如果字典表中没有直接把该标记，要把该标记插入标记字典表
				consult.setMark(consult.getMarkCode());
				consult.setMarkCode(UUID.randomUUID().toString());
				String sql = "insert into DMark(id,nameM) values(:markCode,:mark)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 销售来源处理
		result = false;
		consults = getSellSource(null);
		if (StringUtils.isNotBlank(consult.getSellSourceCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getSellSourceCode(),
						cs.getSellSourceCode())) {
					consult.setSellSourceCode(cs.getSellSourceCode()); // 如果字典表中有直接把该销售来源的编码存入咨询表
					result = true;
				}
			}
			if (!result) { // 如果字典表中没有直接把该销售来源，要把该销售来源插入销售来源字典表
				consult.setSellSource(consult.getSellSourceCode());
				consult.setSellSourceCode(UUID.randomUUID().toString());
				String sql = "insert into DSellSource(id,nameM) values(:sellSourceCode,:sellSource)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 销售员处理
		result = false;
		consults = getSeller(null);
		if (StringUtils.isNotBlank(consult.getSellerCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getSellerCode(),
						cs.getSellerCode())) {
					consult.setSellerCode(cs.getSellerCode());
					result = true;
				}
			}
			if (!result) {
				consult.setSeller(consult.getSellerCode());
				consult.setSellerCode(UUID.randomUUID().toString());
				String sql = "insert into DSeller(id,nameM) values(:sellerCode,:seller)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 经办人处理
		result = false;
		consults = getHandler(null);
		if (StringUtils.isNotBlank(consult.getHandlerCode())) {
			for (Consult cs : consults) {
				if (StringUtils.equals(consult.getHandlerCode(),
						cs.getHandlerCode())) {
					consult.setHandlerCode(cs.getHandlerCode());
					result = true;
				}
			}
			if (!result) {
				consult.setHandler(consult.getHandler());
				consult.setHandlerCode(consult.getHandlerCode());
				String sql = "insert into DHandler(id,nameM) values(:handlerCode,:handler)";
				SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
						consult);
				this.nJdbcTemplate.update(sql, consultParameterSource);
			}
		}

		// 插入咨询表
		String sql = "insert into Consult(id,nameM,gender,consultDate,birthday,motherTel,fatherTel,otherTel,councilSchoolCode,"
				+ "class_grade,liveArea,others,consultWayCode,consultCourseCode,consultContent,willDegreeCode,sellSource,seller,"
				+ "handleSchoolCode,handler,mark,state) values(:id,:nameM,:gender,:consultDate,:birthday,:motherTel,:fatherTel,:otherTel,"
				+ ":councilSchoolCode,:class_grade,:liveArea,:others,:consultWayCode,:consultCourseCode,:consultContent,:willDegreeCode,"
				+ ":sellSourceCode,:sellerCode,:handleSchoolCode,:handlerCode,:markCode,:state)";
		SqlParameterSource consultParameterSource = new BeanPropertySqlParameterSource(
				consult);

		return this.nJdbcTemplate.update(sql, consultParameterSource);
	}

	@Override
	public List<Consult> getConsultWay(String type) {
		String sql = "select * from DConsultWayCode";
		List<Consult> results = this.nJdbcTemplate.query(sql,
				new RowMapper<Consult>() {
					@Override
					public Consult mapRow(ResultSet rs, int index)
							throws SQLException {
						Consult consult = new Consult();
						consult.setConsultWayCode(rs.getString("id"));
						consult.setConsultWay(rs.getString("nameM"));
						return consult;
					}
				});
		if (StringUtils.equals(type, "1")) {
			Consult temp = new Consult();
			temp.setConsultWayCode("qb");
			temp.setConsultWay("全部方式");
			results.add(0, temp);
		}
		return results;
	}

	@Override
	public Grid getConsult(Consult consult, Parameter parameter) {
		String select = "select c.id,c.nameM,c.gender,c.consultDate,(DATE_FORMAT(NOW(),'%Y')-DATE_FORMAT(c.birthday,'%Y')) birthday,c.motherTel,c.fatherTel,c.otherTel,dcs.id councilSchoolCode,"
				+ "dcs.nameM councilSchool,c.class_grade,c.liveArea,c.others,c.consultContent,c.state,c.consultWayCode,"
				+ "dcw.nameM consultWay,c.consultCourseCode,ct.nameM consultCourse,c.willDegreeCode,dw.nameM willDegree,c.sellSource sellSourceCode,dss.nameM sellSource,"
				+ "c.seller sellerCode,ds.nameM seller,c.handleSchoolCode,s.schoolName handleSchool,c.handler handlerCode,dh.nameM handler,"
				+ "c.mark markCode,dm.nameM mark from Consult c left outer join DCouncilSchool dcs on dcs.id=councilSchoolCode "
				+ "left outer join DConsultWayCode dcw on dcw.id=c.consultWayCode left outer join CourseType ct on ct.courseTypeCode=c.consultCourseCode "
				+ "left outer join DWillDegreeCode dw on dw.id=c.willDegreeCode left outer join DSellSource dss on dss.id=c.sellSource "
				+ "left outer join DSeller ds on ds.id=c.seller left outer join School s on s.schoolCode=c.handleSchoolCode "
				+ "left outer join DHandler dh on dh.id=c.handler left outer join DMark dm on dm.id=c.mark ";
		select += "where ";
		if (StringUtils.equals(consult.getStartTime(), consult.getEndTime())) {

		} else {

		}
		if (StringUtils.equals("qb", consult.getMarkCode())) {

		}
		if (StringUtils.equals("qb", consult.getConsultWayCode())) {

		}
		if (StringUtils.equals("qb", consult.getHandleSchoolCode())) {

		}
		if (StringUtils.equals("qb", consult.getState())) {

		}
		if (StringUtils.equals("qb", consult.getConsultCourseCode())) {

		}
		if (StringUtils.equals("qb", consult.getWillDegreeCode())) {

		}
		if (StringUtils.equals("qb", consult.getSellSourceCode())) {

		}
		if (StringUtils.equals("qb", consult.getSellerCode())) {

		}
		if (StringUtils.equals("qb", consult.getHandlerCode())) {

		}
		if (StringUtils.equals("1", consult.getOrder())) {

		}
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(
				consult);
		final List<Consult> results = new ArrayList<Consult>();
		this.nJdbcTemplate.query(select, namedParameters,
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Consult consult = new Consult();
						consult.setId(rs.getString("id"));
						consult.setBirthday(rs.getString("birthday"));
						consult.setClass_grade(rs.getString("class_grade"));
						consult.setConsultContent(rs
								.getString("consultContent"));
						consult.setConsultCourse(rs.getString("consultCourse"));
						consult.setConsultCourseCode(rs
								.getString("consultCourseCode"));
						consult.setConsultDate(rs.getString("consultDate"));
						consult.setConsultWay(rs.getString("consultWay"));
						consult.setConsultWayCode(rs
								.getString("consultWayCode"));
						consult.setCouncilSchool(rs.getString("councilSchool"));
						consult.setCouncilSchoolCode(rs
								.getString("councilSchoolCode"));
						consult.setFatherTel(rs.getString("fatherTel"));
						consult.setGender(rs.getString("gender"));
						consult.setHandler(rs.getString("handler"));
						consult.setHandlerCode(rs.getString("handlerCode"));
						consult.setHandleSchool(rs.getString("handleSchool"));
						consult.setHandleSchoolCode(rs
								.getString("handleSchoolCode"));
						consult.setLiveArea(rs.getString("liveArea"));
						consult.setMark(rs.getString("mark"));
						consult.setMarkCode(rs.getString("markCode"));
						consult.setMotherTel(rs.getString("motherTel"));
						consult.setNameM(rs.getString("nameM"));
						consult.setOthers(rs.getString("others"));
						consult.setOtherTel(rs.getString("otherTel"));
						consult.setSeller(rs.getString("seller"));
						consult.setSellerCode(rs.getString("sellerCode"));
						consult.setSellSource(rs.getString("sellSource"));
						consult.setSellSourceCode(rs
								.getString("sellSourceCode"));
						consult.setState(rs.getString("state"));
						consult.setWillDegree(rs.getString("willDegree"));
						consult.setWillDegreeCode(rs
								.getString("willDegreeCode"));
						results.add(consult);
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
