package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年8月24日 下午5:37:30
 */
public class StudentClass {
	private String id; // 报名ID
	private String classCode; // 对应班级编码->班级表
	private String studentCode; // 学生编码->咨询表
	private String tuitionRemark; // 学费备注
	private String enrollDate; // 报名日期
	private String payTypeCode; // 支付方式
	private String discountType; // 收费类型 1原价;2优惠;3折扣;4插班
	private String preferentialPrice; // 优惠金额
	private String discount; // 打折时的折扣
	private String sellerCode; // 销售员编码
	private String sellSourceCode; // 销售来源
	private String handleSchoolCode; // 经办学校
	private String studentType; // 1代表新生，2代表插班，3代表老生
	private String realTuition; // 实收学费
	private String reduceMoney; // 插班时减免的学费
	private String isMiddle; // 是否为插班生 0不是，1是
	private String handlerCode;// 经办人编码
	private String remark; // 备注（转班备注）
	/**
	 * 用于接收前台参数
	 */
	private String classCode1; // 报名第一科的课程号
	private String discountType1; // 第一科的收费类型
	private String preferntial1; // 第一科的优惠数
	private String discount1; // 第一科的打折数
	private String reduceMoney1; // 第一科减免数
	private String realTuition1; // 第一科实交学费
	private String arre1; // 第一科的余额正表示预存，负表示欠费
	private String textBookFeeCode1; // 第一科包含的学杂费编码
	private String tuitionRemark1; // 学费备注
	private String num1; // 第一科表示的学杂费编码对应的数量

	private String classCode2;
	private String discountType2;
	private String preferntial2;
	private String discount2;
	private String reduceMoney2;
	private String realTuition2;
	private String arre2;
	private String tuitionRemark2;
	private String textBookFeeCode2;
	private String num2;

	private String classCode3;
	private String discountType3;
	private String preferntial3;
	private String discount3;
	private String reduceMoney3;
	private String realTuition3;
	private String arre3;
	private String tuitionRemark3;
	private String textBookFeeCode3;
	private String num3;

	private String money; // 报名交的总钱数
	private String points; // 积分

	/**
	 * 转班时的补费，退费
	 */
	private String moneyOfLack; // 转班应补
	private String moneyOfReturn; // 转班应退
	private String buOrTui; //补款或者退款

	
	public String getBuOrTui() {
		return buOrTui;
	}

	public void setBuOrTui(String buOrTui) {
		this.buOrTui = buOrTui;
	}

	public String getMoneyOfLack() {
		return moneyOfLack;
	}

	public void setMoneyOfLack(String moneyOfLack) {
		this.moneyOfLack = moneyOfLack;
	}

	public String getMoneyOfReturn() {
		return moneyOfReturn;
	}

	public void setMoneyOfReturn(String moneyOfReturn) {
		this.moneyOfReturn = moneyOfReturn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getIsMiddle() {
		return isMiddle;
	}

	public void setIsMiddle(String isMiddle) {
		this.isMiddle = isMiddle;
	}

	public String getRealTuition() {
		return realTuition;
	}

	public void setRealTuition(String realTuition) {
		this.realTuition = realTuition;
	}

	public String getTuitionRemark1() {
		return tuitionRemark1;
	}

	public void setTuitionRemark1(String tuitionRemark1) {
		this.tuitionRemark1 = tuitionRemark1;
	}

	public String getTuitionRemark2() {
		return tuitionRemark2;
	}

	public void setTuitionRemark2(String tuitionRemark2) {
		this.tuitionRemark2 = tuitionRemark2;
	}

	public String getTuitionRemark3() {
		return tuitionRemark3;
	}

	public void setTuitionRemark3(String tuitionRemark3) {
		this.tuitionRemark3 = tuitionRemark3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getReduceMoney() {
		return reduceMoney;
	}

	public void setReduceMoney(String reduceMoney) {
		this.reduceMoney = reduceMoney;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getTuitionRemark() {
		return tuitionRemark;
	}

	public void setTuitionRemark(String tuitionRemark) {
		this.tuitionRemark = tuitionRemark;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getPayTypeCode() {
		return payTypeCode;
	}

	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getPreferentialPrice() {
		return preferentialPrice;
	}

	public void setPreferentialPrice(String preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public String getSellSourceCode() {
		return sellSourceCode;
	}

	public void setSellSourceCode(String sellSourceCode) {
		this.sellSourceCode = sellSourceCode;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public String getHandleSchoolCode() {
		return handleSchoolCode;
	}

	public void setHandleSchoolCode(String handleSchoolCode) {
		this.handleSchoolCode = handleSchoolCode;
	}

	public String getClassCode1() {
		return classCode1;
	}

	public void setClassCode1(String classCode1) {
		this.classCode1 = classCode1;
	}

	public String getDiscountType1() {
		return discountType1;
	}

	public void setDiscountType1(String discountType1) {
		this.discountType1 = discountType1;
	}

	public String getPreferntial1() {
		return preferntial1;
	}

	public void setPreferntial1(String preferntial1) {
		this.preferntial1 = preferntial1;
	}

	public String getDiscount1() {
		return discount1;
	}

	public void setDiscount1(String discount1) {
		this.discount1 = discount1;
	}

	public String getReduceMoney1() {
		return reduceMoney1;
	}

	public void setReduceMoney1(String reduceMoney1) {
		this.reduceMoney1 = reduceMoney1;
	}

	public String getRealTuition1() {
		return realTuition1;
	}

	public void setRealTuition1(String realTuition1) {
		this.realTuition1 = realTuition1;
	}

	public String getArre1() {
		return arre1;
	}

	public void setArre1(String arre1) {
		this.arre1 = arre1;
	}

	public String getTextBookFeeCode1() {
		return textBookFeeCode1;
	}

	public void setTextBookFeeCode1(String textBookFeeCode1) {
		this.textBookFeeCode1 = textBookFeeCode1;
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getClassCode2() {
		return classCode2;
	}

	public void setClassCode2(String classCode2) {
		this.classCode2 = classCode2;
	}

	public String getDiscountType2() {
		return discountType2;
	}

	public void setDiscountType2(String discountType2) {
		this.discountType2 = discountType2;
	}

	public String getPreferntial2() {
		return preferntial2;
	}

	public void setPreferntial2(String preferntial2) {
		this.preferntial2 = preferntial2;
	}

	public String getDiscount2() {
		return discount2;
	}

	public void setDiscount2(String discount2) {
		this.discount2 = discount2;
	}

	public String getReduceMoney2() {
		return reduceMoney2;
	}

	public void setReduceMoney2(String reduceMoney2) {
		this.reduceMoney2 = reduceMoney2;
	}

	public String getRealTuition2() {
		return realTuition2;
	}

	public void setRealTuition2(String realTuition2) {
		this.realTuition2 = realTuition2;
	}

	public String getArre2() {
		return arre2;
	}

	public void setArre2(String arre2) {
		this.arre2 = arre2;
	}

	public String getTextBookFeeCode2() {
		return textBookFeeCode2;
	}

	public void setTextBookFeeCode2(String textBookFeeCode2) {
		this.textBookFeeCode2 = textBookFeeCode2;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getClassCode3() {
		return classCode3;
	}

	public void setClassCode3(String classCode3) {
		this.classCode3 = classCode3;
	}

	public String getDiscountType3() {
		return discountType3;
	}

	public void setDiscountType3(String discountType3) {
		this.discountType3 = discountType3;
	}

	public String getPreferntial3() {
		return preferntial3;
	}

	public void setPreferntial3(String preferntial3) {
		this.preferntial3 = preferntial3;
	}

	public String getDiscount3() {
		return discount3;
	}

	public void setDiscount3(String discount3) {
		this.discount3 = discount3;
	}

	public String getReduceMoney3() {
		return reduceMoney3;
	}

	public void setReduceMoney3(String reduceMoney3) {
		this.reduceMoney3 = reduceMoney3;
	}

	public String getRealTuition3() {
		return realTuition3;
	}

	public void setRealTuition3(String realTuition3) {
		this.realTuition3 = realTuition3;
	}

	public String getArre3() {
		return arre3;
	}

	public void setArre3(String arre3) {
		this.arre3 = arre3;
	}

	public String getTextBookFeeCode3() {
		return textBookFeeCode3;
	}

	public void setTextBookFeeCode3(String textBookFeeCode3) {
		this.textBookFeeCode3 = textBookFeeCode3;
	}

	public String getNum3() {
		return num3;
	}

	public void setNum3(String num3) {
		this.num3 = num3;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月24日 下午5:40:21
	 */
	public StudentClass() {

	}

}
