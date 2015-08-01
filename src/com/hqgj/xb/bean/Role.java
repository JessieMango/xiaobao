package com.hqgj.xb.bean;

/**
 * @author 崔兴伟
 * @datetime 2015年7月30日 上午10:14:38
 */
public class Role {
	private String role_id;
	private String roleName;
	private String permission;
	private String permission_id;
	private String isDefault;
	private String description;

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月30日 上午10:18:14
	 */
	public Role() {
	}

}
