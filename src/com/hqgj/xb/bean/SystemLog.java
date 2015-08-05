package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年8月4日 下午3:02:17
 */
public class SystemLog {
	private String id;
	private String operateTime;
	private String username;
	private String operateType;
	private String message;
	private String operateName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年8月4日 下午3:05:27
	 */
	public SystemLog() {
	}

}
