package com.hqgj.xb.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.StudentClass;
import com.hqgj.xb.bean.StudentClass_TextbookFee;
import com.hqgj.xb.dao.StudentClassDAO;

/**
 * @author 崔兴伟
 * @datetime 2015年8月24日 下午5:41:42
 */
@Repository
public class StudentClassDAOImpl implements StudentClassDAO {
	private Logger logger = Logger.getLogger(StudentClassDAOImpl.class);

	private NamedParameterJdbcTemplate nJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.nJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int addStudentClass(List<StudentClass> studentClasses,
			List<StudentClass_TextbookFee> studentClass_TextbookFees) {
		String sqlSC = "insert into StudentClass (id,classCode,studentCode,tuitionRemark,enrollDate,payTypeCode,realTuition,"
				+ "discountType,preferentialPrice,reduceMoney,discount,sellerCode,handleSchoolCode,sellSourceCode,studentType,isMiddle,handlerCode) values (:id,:classCode,"
				+ ":studentCode,:tuitionRemark,:enrollDate,:payTypeCode,:realTuition,:discountType,:preferentialPrice,:reduceMoney,"
				+ ":discount,:sellerCode,:handleSchoolCode,:sellSourceCode,:studentType,:isMiddle,:handlerCode)";
		String sqlSCTF = "insert into StudentClass_TextbookFee (id,studentClassCode,textbookFeeCode,numbers) "
				+ "values (:id,:studentClassCode,:textbookFeeCode,:numbers)";
		SqlParameterSource[] parameterSources1 = SqlParameterSourceUtils
				.createBatch(studentClasses.toArray());
		SqlParameterSource[] parameterSources2 = SqlParameterSourceUtils
				.createBatch(studentClass_TextbookFees.toArray());
		int[] n1 = this.nJdbcTemplate.batchUpdate(sqlSC, parameterSources1);
		int[] n2 = this.nJdbcTemplate.batchUpdate(sqlSCTF, parameterSources2);
		logger.info(n1.length);
		logger.info(n2.length);
		return n1.length + n2.length;
	}

}
