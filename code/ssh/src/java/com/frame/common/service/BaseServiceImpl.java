package com.frame.common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.common.dao.BaseDao;
import com.frame.common.page.PageParamMap;
import com.frame.common.page.Pagination;
/**
 * 角色业务接口实现
 * @author Tandaly
 * @date 2013-3-5 下午2:33:29
 */
@Service
public class BaseServiceImpl implements BaseService {

	@Resource(name = "baseDaoImpl")
	private BaseDao baseDao;
	
	@Override
	public Pagination fetchObjectsByPage(PageParamMap pageParamMap) {
		return this.baseDao.findObjectsByPage(pageParamMap);
	}

}
