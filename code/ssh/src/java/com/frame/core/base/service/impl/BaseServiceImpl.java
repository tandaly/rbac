package com.frame.core.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frame.core.base.dao.BaseDao;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.service.BaseService;
/**
 * 角色业务接口实现
 * @author Tandaly
 * @date 2013-3-5 下午2:33:29
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BaseServiceImpl implements BaseService {

	@Resource(name = "baseDaoImpl")
	private BaseDao baseDao;
	
	@Override
	public Pagination fetchObjectsByPage(PageParamMap pageParamMap) {
		return this.baseDao.findObjectsByPage(pageParamMap);
	}

	@Override
	public void save(Object entity) {
		this.baseDao.save(entity);
	}

}
