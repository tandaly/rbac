package com.frame.dao;

import com.frame.common.dao.CommonDao;
import com.frame.common.page.PageParamMap;
import com.frame.common.page.Pagination;
import com.frame.model.Role;

/**
 * 角色Dao接口
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-3-3 下午7:58:24
 */
public interface RoleDao extends CommonDao {

	public Role load(Long id);
	
	/**
	 * 分页查询角色列表
	 * @return
	 */
	//public Pagination findObjectsByPage(PageParamMap pageParamMap);
}
