package com.frame.core.base.service;

import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.exception.service.ServiceException;

/**
 * 角色业务接口
 * @author Tandaly
 * @date 2013-3-5 下午2:32:53
 */
public interface BaseService {
	
	/**
	 * 新增操作
	 * @param entity
	 */
	public void save(Object entity) throws ServiceException;

	/**
	 * 分页查询
	 * @param pageParamMap
	 * @return
	 */
	public Pagination fetchObjectsByPage(PageParamMap pageParamMap)throws ServiceException;
}
