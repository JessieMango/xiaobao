package com.hqgj.xb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqgj.xb.bean.Resource;
import com.hqgj.xb.dao.ResourceDao;

/**
 * @author 崔兴伟
 * @datetime 2015年7月16日 下午6:23:38
 */
@Repository
public class ResourceDaoImpl implements ResourceDao {
	private static final Logger logger = Logger
			.getLogger(ResourceDaoImpl.class);

	private NamedParameterJdbcTemplate npJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.npJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Resource> getResource() {
		String sql = "SELECT r.id,r.iconCls,r.createTime,r.nameM,r.resourceType_id,r.resoure_id,r.target,r.updateTime,r.url from resource r LEFT OUTER JOIN resourcetype rt on rt.id=r.resourceType_id "
				+ "WHERE r.resourceType_id=0 and r.resoure_id is NULL and r.flag=1 ORDER BY r.seq ";
		List<Resource> results = this.npJdbcTemplate.query(sql,
				new RowMapper<Resource>() {
					@Override
					public Resource mapRow(ResultSet rs, int index)
							throws SQLException {
						Resource resource = new Resource();
						resource.setCreateTime(rs.getString("createTime"));
						resource.setIconCls(rs.getString("iconCls"));
						resource.setId(rs.getString("id"));
						resource.setName(rs.getString("nameM"));
						resource.setResource_id(rs.getString("resoure_id"));
						resource.setResourceType_id(rs
								.getString("resourceType_id"));
						resource.setTarget(rs.getString("target"));
						resource.setUpdateTime(rs.getString("updateTime"));
						resource.setUrl(rs.getString("url"));
						return resource;
					}
				});
		logger.info("有" + results.size() + "条父菜单");
		return results;
	}

	@Override
	public List<Resource> getSubResource(String pid) {
		String sql = "SELECT r.id,r.iconCls,r.createTime,r.nameM,r.resourceType_id,r.resoure_id,r.target,r.updateTime,r.url from resource r LEFT OUTER JOIN resourcetype rt on rt.id=r.resourceType_id "
				+ "WHERE r.resourceType_id=0 and r.resoure_id like :pid and r.flag=1  ORDER BY r.seq ";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("pid", "%" + pid + "%");
		List<Resource> results = this.npJdbcTemplate.query(sql, paramMap,
				new RowMapper<Resource>() {
					@Override
					public Resource mapRow(ResultSet rs, int index)
							throws SQLException {
						Resource resource = new Resource();
						resource.setCreateTime(rs.getString("createTime"));
						resource.setIconCls(rs.getString("iconCls"));
						resource.setId(rs.getString("id"));
						resource.setName(rs.getString("nameM"));
						resource.setResource_id(rs.getString("resoure_id"));
						resource.setResourceType_id(rs
								.getString("resourceType_id"));
						resource.setTarget(rs.getString("target"));
						resource.setUpdateTime(rs.getString("updateTime"));
						resource.setUrl(rs.getString("url"));
						return resource;
					}
				});
		logger.info("有" + results.size() + "条子菜单");
		return results;
	}

}
