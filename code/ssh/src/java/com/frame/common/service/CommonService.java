package com.frame.common.service;

import com.frame.common.page.PageParamMap;
import com.frame.common.page.Pagination;

/**
 * 角色业务接口
 * @author Tandaly
 * @date 2013-3-5 下午2:32:53
 */
public interface CommonService {

	/**
	 * 分页查询
	 * @param pageParamMap
	 * @return
	 */
	public Pagination fetchObjectsByPage(PageParamMap pageParamMap);
}
