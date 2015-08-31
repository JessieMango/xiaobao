package com.hqgj.xb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqgj.xb.bean.Resource;
import com.hqgj.xb.dao.ResourceDao;
import com.hqgj.xb.service.ResourceService;

/**
 * @author 崔兴伟
 * @datetime 2015年7月20日 下午2:32:19
 */
@Service
public class ResourceServiceImpl implements ResourceService {
	@Autowired
	private ResourceDao resourceDao;

	@Override
	public List<Resource> getResource() {
		return resourceDao.getResource();
	}

	@Override
	public List<Resource> getSubResource(String pid) {
		return resourceDao.getSubResource(pid);
	}

	@Override
	public List<Resource> getAllResource() {
		return resourceDao.getAllResource();
	}

}
