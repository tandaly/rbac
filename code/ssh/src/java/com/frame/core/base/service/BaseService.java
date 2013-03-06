package com.frame.core.base.service;

import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;

/**
 * 角色业务接口
 * @author Tandaly
 * @date 2013-3-5 下午2:32:53
 */
public interface BaseService {

	/**
	 * 分页查询
	 * @param pageParamMap
	 * @return
	 */
	public Pagination fetchObjectsByPage(PageParamMap pageParamMap);
}
