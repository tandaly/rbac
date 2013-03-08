package com.frame.application.admin.modules.system.service;

import java.io.Serializable;
import java.util.List;

import com.frame.application.admin.modules.system.model.MenuTreeBean;
import com.frame.core.base.service.BaseService;


/**
 * 菜单业务接口
 * @author Tandaly
 * @date 2013-3-5 下午2:32:53
 */
public interface MenuService extends BaseService{

	/**
	 * 根据用户ID获取菜单树
	 * @return
	 */
	public List<MenuTreeBean> fetchMenuTreesByUserId(Serializable userId);
	
	/**
	 * 根据用户ID查询系统左菜单树根
	 * @param userId
	 * @return
	 */
	public List<MenuTreeBean> fetchSysLeftMenuTreeRoot(Serializable userId);
	
	/**
	 * 根据用户ID和父结点查询系统左菜单子结点树
	 * @param userId
	 * @param parentId
	 * @return
	 */
	public List<MenuTreeBean> fetchSysLeftMenuTreeChild(Serializable userId, Serializable parentId);

}
