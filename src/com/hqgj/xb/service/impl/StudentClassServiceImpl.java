package com.hqgj.xb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Consult;
import com.hqgj.xb.bean.StudentClass;
import com.hqgj.xb.bean.StudentClass_TextbookFee;
import com.hqgj.xb.dao.ConsultDAO;
import com.hqgj.xb.dao.StudentClassDAO;
import com.hqgj.xb.service.StudentClassService;

/**
 * @author 崔兴伟
 * @datetime 2015年8月24日 下午5:41:29
 */
@Service
public class StudentClassServiceImpl implements StudentClassService {
	@Autowired
	private StudentClassDAO studentClassDAO;

	@Autowired
	private ConsultDAO consultDAO;

	public int addStudentClassTextBookFee(StudentClass studentClass) {
		List<StudentClass> studentClasses = new ArrayList<StudentClass>(); // 报名表
		List<StudentClass_TextbookFee> studentClass_TextbookFees = new ArrayList<StudentClass_TextbookFee>(); // 杂费项
		if (StringUtils.isNotBlank(studentClass.getClassCode1())) {
			StudentClass tStudentClass = new StudentClass();
			tStudentClass.setId(UUID.randomUUID().toString());
			tStudentClass.setClassCode(studentClass.getClassCode1());
			tStudentClass.setEnrollDate(studentClass.getEnrollDate());
			tStudentClass.setTuitionRemark(studentClass.getTuitionRemark1());
			tStudentClass.setStudentCode(studentClass.getStudentCode());
			tStudentClass.setPayTypeCode(studentClass.getPayTypeCode());
			tStudentClass.setDiscountType(studentClass.getDiscountType1());
			tStudentClass.setRealTuition(studentClass.getRealTuition1());
			tStudentClass.setSellerCode(studentClass.getSellerCode());
			tStudentClass.setSellSourceCode(studentClass.getSellSourceCode());
			tStudentClass.setStudentType("1"); // 默认为新生
			tStudentClass.setIsMiddle("0"); 
			tStudentClass.setHandlerCode(studentClass.getHandlerCode());
			tStudentClass.setHandleSchoolCode(studentClass
					.getHandleSchoolCode());
			if (StringUtils.equals("3", studentClass.getDiscountType1())) {
				tStudentClass.setDiscount(studentClass.getDiscount1());
			}
			if (StringUtils.equals("2", studentClass.getDiscountType1())) {
				tStudentClass.setPreferentialPrice(studentClass
						.getPreferntial1());
				tStudentClass.setIsMiddle("1"); // 学生类型为插班
			}
			if (StringUtils.equals("4", studentClass.getDiscountType1())) {
				tStudentClass.setReduceMoney(studentClass.getReduceMoney1());
			}

			// 添加杂费项
			String[] textBookFeeStrings = studentClass.getTextBookFeeCode1()
					.split(",");
			String[] numberStrings = studentClass.getNum1().split(",");
			for (int i = 0; i < textBookFeeStrings.length; i++) {
				if (!StringUtils.equals("0", numberStrings[i])) {
					StudentClass_TextbookFee studentClass_TextbookFee = new StudentClass_TextbookFee();
					studentClass_TextbookFee
							.setId(UUID.randomUUID().toString());
					studentClass_TextbookFee.setNumbers(numberStrings[i]);
					studentClass_TextbookFee
							.setTextbookFeeCode(textBookFeeStrings[i]);
					studentClass_TextbookFee.setStudentClassCode(tStudentClass
							.getId());
					studentClass_TextbookFees.add(studentClass_TextbookFee);
				}
			}
			studentClasses.add(tStudentClass);

		}
		if (StringUtils.isNotBlank(studentClass.getClassCode2())) {
			StudentClass tStudentClass = new StudentClass();
			tStudentClass.setId(UUID.randomUUID().toString());
			tStudentClass.setClassCode(studentClass.getClassCode2());
			tStudentClass.setEnrollDate(studentClass.getEnrollDate());
			tStudentClass.setTuitionRemark(studentClass.getTuitionRemark2());
			tStudentClass.setStudentCode(studentClass.getStudentCode());
			tStudentClass.setPayTypeCode(studentClass.getPayTypeCode());
			tStudentClass.setDiscountType(studentClass.getDiscountType2());
			tStudentClass.setRealTuition(studentClass.getRealTuition2());
			tStudentClass.setSellerCode(studentClass.getSellerCode());
			tStudentClass.setSellSourceCode(studentClass.getSellSourceCode());
			tStudentClass.setHandleSchoolCode(studentClass
					.getHandleSchoolCode());
			tStudentClass.setStudentType("1"); // 默认为新生
			tStudentClass.setIsMiddle("0"); 
			tStudentClass.setHandlerCode(studentClass.getHandlerCode());
			if (StringUtils.equals("3", studentClass.getDiscountType2())) {
				tStudentClass.setDiscount(studentClass.getDiscount2());
			}
			if (StringUtils.equals("2", studentClass.getDiscountType2())) {
				tStudentClass.setPreferentialPrice(studentClass
						.getPreferntial2());
				tStudentClass.setIsMiddle("1"); // 学生类型为插班
			}
			if (StringUtils.equals("4", studentClass.getDiscountType2())) {
				tStudentClass.setReduceMoney(studentClass.getReduceMoney2());
			}

			// 添加杂费项

			String[] textBookFeeStrings = studentClass.getTextBookFeeCode2()
					.split(",");
			String[] numberStrings = studentClass.getNum2().split(",");
			for (int i = 0; i < textBookFeeStrings.length; i++) {
				if (!StringUtils.equals("0", numberStrings[i])) {
					StudentClass_TextbookFee studentClass_TextbookFee = new StudentClass_TextbookFee();
					studentClass_TextbookFee
							.setId(UUID.randomUUID().toString());
					studentClass_TextbookFee.setNumbers(numberStrings[i]);
					studentClass_TextbookFee
							.setTextbookFeeCode(textBookFeeStrings[i]);
					studentClass_TextbookFee.setStudentClassCode(tStudentClass
							.getId());
					studentClass_TextbookFees.add(studentClass_TextbookFee);
				}
			}
			studentClasses.add(tStudentClass);

		}

		if (StringUtils.isNotBlank(studentClass.getClassCode3())) {
			StudentClass tStudentClass = new StudentClass();
			tStudentClass.setId(UUID.randomUUID().toString());
			tStudentClass.setClassCode(studentClass.getClassCode3());
			tStudentClass.setEnrollDate(studentClass.getEnrollDate());
			tStudentClass.setTuitionRemark(studentClass.getTuitionRemark3());
			tStudentClass.setStudentCode(studentClass.getStudentCode());
			tStudentClass.setPayTypeCode(studentClass.getPayTypeCode());
			tStudentClass.setDiscountType(studentClass.getDiscountType3());
			tStudentClass.setRealTuition(studentClass.getRealTuition3());
			tStudentClass.setSellerCode(studentClass.getSellerCode());
			tStudentClass.setSellSourceCode(studentClass.getSellSourceCode());
			tStudentClass.setHandleSchoolCode(studentClass
					.getHandleSchoolCode());
			tStudentClass.setStudentType("1"); // 默认为新生
			tStudentClass.setIsMiddle("0"); 
			tStudentClass.setHandlerCode(studentClass.getHandlerCode());
			if (StringUtils.equals("3", studentClass.getDiscountType3())) {
				tStudentClass.setDiscount(studentClass.getDiscount3());
			}
			if (StringUtils.equals("2", studentClass.getDiscountType3())) {
				tStudentClass.setPreferentialPrice(studentClass
						.getPreferntial3());
				tStudentClass.setIsMiddle("1"); // 学生类型为插班
			}
			if (StringUtils.equals("4", studentClass.getDiscountType3())) {
				tStudentClass.setReduceMoney(studentClass.getReduceMoney3());
			}

			// 添加杂费项
			String[] textBookFeeStrings = studentClass.getTextBookFeeCode3()
					.split(",");
			String[] numberStrings = studentClass.getNum3().split(",");
			for (int i = 0; i < textBookFeeStrings.length; i++) {
				if (!StringUtils.equals("0", numberStrings[i])) {
					StudentClass_TextbookFee studentClass_TextbookFee = new StudentClass_TextbookFee();
					studentClass_TextbookFee
							.setId(UUID.randomUUID().toString());
					studentClass_TextbookFee.setNumbers(numberStrings[i]);
					studentClass_TextbookFee
							.setTextbookFeeCode(textBookFeeStrings[i]);
					studentClass_TextbookFee.setStudentClassCode(tStudentClass
							.getId());
					studentClass_TextbookFees.add(studentClass_TextbookFee);
				}
			}

			studentClasses.add(tStudentClass);
		}
		return studentClassDAO.addStudentClass(studentClasses,
				studentClass_TextbookFees);
	}

	@Override
	public int addStudentClass(StudentClass studentClass) {
		Consult consult = new Consult();
		int banlance = 0;
		if (StringUtils.isNotBlank(studentClass.getClassCode1())) {
			int arr = 0;
			if (StringUtils.isBlank(studentClass.getArre1())) {
				arr = 0;
			} else {
				arr = Integer.parseInt(studentClass.getArre1());
			}
			banlance += arr;
		}
		if (StringUtils.isNotBlank(studentClass.getClassCode2())) {
			int arr = 0;
			if (StringUtils.isBlank(studentClass.getArre2())) {
				arr = 0;
			} else {
				arr = Integer.parseInt(studentClass.getArre2());
			}
			banlance += arr;
		}
		if (StringUtils.isNotBlank(studentClass.getClassCode3())) {
			int arr = 0;
			if (StringUtils.isBlank(studentClass.getArre3())) {
				arr = 0;
			} else {
				arr = Integer.parseInt(studentClass.getArre3());
			}
			banlance += arr;
		}
		consult.setId(studentClass.getStudentCode());
		consult.setAvailabelPoints(studentClass.getPoints());
		consult.setBanlance(banlance + "");
		consult.setState("1");
		int n = consultDAO.updateConsult(consult, 2);
		if (n != 0) {
			return addStudentClassTextBookFee(studentClass);
		} else {
			return 0;
		}
	}

	@Override
	public int addStudentClassNo(StudentClass studentClass, Consult consult) {
		int banlance = 0;
		if (StringUtils.isNotBlank(studentClass.getClassCode1())) {
			int arr = 0;
			if (StringUtils.isBlank(studentClass.getArre1())) {
				arr = 0;
			} else {
				arr = Integer.parseInt(studentClass.getArre1());
			}
			banlance += arr;
		}
		if (StringUtils.isNotBlank(studentClass.getClassCode2())) {
			int arr = 0;
			if (StringUtils.isBlank(studentClass.getArre2())) {
				arr = 0;
			} else {
				arr = Integer.parseInt(studentClass.getArre2());
			}
			banlance += arr;
		}
		if (StringUtils.isNotBlank(studentClass.getClassCode3())) {
			int arr = 0;
			if (StringUtils.isBlank(studentClass.getArre3())) {
				arr = 0;
			} else {
				arr = Integer.parseInt(studentClass.getArre3());
			}
			banlance += arr;
		}
		consult.setAvailabelPoints(studentClass.getPoints());
		consult.setBanlance(banlance + "");
		consult.setState("1");
		consult.setId(UUID.randomUUID().toString()); // 设置咨询表ID
		consult.setFlag("1");
		studentClass.setStudentCode(consult.getId());
		int n = consultDAO.saveConsult(consult);
		if (n != 0) {
			return addStudentClassTextBookFee(studentClass);
		} else {
			return 0;
		}
	}

}
