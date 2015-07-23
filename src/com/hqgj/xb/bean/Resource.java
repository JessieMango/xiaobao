package com.hqgj.xb.bean;

/**
 * 资源实体
 * 
 * @author 崔兴伟
 * @datetime 2015年7月16日 下午6:17:23
 */
public class Resource {
	private String id;
	private String createTime;
	private String updateTime;
	private String iconCls;
	private String name;
	private String target;
	private String url;
	private String resource_id;
	private String resourceType_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	public String getResourceType_id() {
		return resourceType_id;
	}

	public void setResourceType_id(String resourceType_id) {
		this.resourceType_id = resourceType_id;
	}

	/**
	 * 
	 * @author 崔兴伟
	 * @datetime 2015年7月16日 下午6:19:45
	 */
	public Resource() {
	}

}
