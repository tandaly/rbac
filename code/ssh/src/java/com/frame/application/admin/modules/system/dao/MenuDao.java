package com.frame.application.admin.modules.system.dao;

import java.io.Serializable;
import java.util.List;

import com.frame.application.admin.modules.system.model.Menu;
import com.frame.core.base.dao.BaseDao;

/**
 * 菜单Dao接口
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-3-3 下午7:48:52
 */
public interface MenuDao extends BaseDao {

	/**
	 * 根据用户ID查询菜单
	 * @param userId
	 * @return
	 */
	public List<Menu> queryMenusByUserId(Serializable userId);
	
	/**
	 * 根据用户ID查询系统左菜单树根
	 * @param userId
	 * @return
	 */
	public List<Menu> querySysLeftMenuTreeRoot(Serializable userId);
	
	/**
	 * 根据用户ID和父结点查询系统左菜单子结点树
	 * @param userId
	 * @param parentId
	 * @return
	 */
	public List<Menu> querySysLeftMenuTreeChild(Serializable userId, Serializable parentId);

}
