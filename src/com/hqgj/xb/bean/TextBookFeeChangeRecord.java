package com.hqgj.xb.bean;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * 教材出入库记录
 * 
 * @author 崔兴伟
 * @datetime 2015年9月8日 下午12:25:41
 */
public class TextBookFeeChangeRecord {
	private String id;
	private String location;
	private String textbookFee_id;
	private String operate;
	private String number;
	private String operateDate;
	private String handler;
	private String remark;

	/**
	 * 教材转库
	 */
	private String fromLocation; // 转出的库房
	private String toLocation; // 转入的库房
	

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTextbookFee_id() {
		return textbookFee_id;
	}

	public void setTextbookFee_id(String textbookFee_id) {
		this.textbookFee_id = textbookFee_id;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年9月8日 下午12:27:00
	 */
	public TextBookFeeChangeRecord() {

	}

}