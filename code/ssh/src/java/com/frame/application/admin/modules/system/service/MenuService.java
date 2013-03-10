package com.frame.application.admin.modules.system.service;

import java.io.Serializable;
import java.util.List;

import com.frame.application.admin.modules.system.model.MenuTreeBean;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.service.BaseService;


/**
 * 菜单业务接口
 * @author Tandaly
 * @date 2013-3-5 下午2:32:53
 */
public interface MenuService extends BaseService{

	/**
	 * 根据父结点查询最大子节点菜单编号
	 * @param parentNo
	 * @return
	 */
	public String fetchMaxMenuNoByParentNo(String parentNo);
	
	/**
	 * 检验菜单名是否可用
	 * @param parentNo
	 * @param menuName
	 * @return
	 */
	public boolean checkMenuName(String parentNo, String menuName);
	
	/**
	 * 获取所有菜单树
	 * @return
	 */
	public List<MenuTreeBean> fetchMenuTrees();
	
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
	
	/**
	 * 分页查询菜单
	 * @param pageParamMap
	 * @return
	 */
	public Pagination fetchMenusByPage(PageParamMap pageParamMap);

}
