package com.frame.application.admin.modules.system.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frame.application.admin.modules.system.dao.MenuDao;
import com.frame.application.admin.modules.system.model.Menu;
import com.frame.application.admin.modules.system.model.MenuTreeBean;
import com.frame.application.admin.modules.system.service.MenuService;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.service.impl.BaseServiceImpl;

/**
 * 菜单业务接口实现
 * 
 * @author Tandaly
 * @date 2013-3-5 下午2:33:29
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {

	@Resource
	private MenuDao menuDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuTreeBean> fetchMenuTrees() {
		return switchMenusToTreeMenus(this.menuDao.findAll(new Menu()));
	}
	
	@Override
	public List<MenuTreeBean> fetchMenuTreesByUserId(Serializable userId) {
		return switchMenusToTreeMenus(this.menuDao.queryMenusByUserId(userId));
	}

	@Override
	public List<MenuTreeBean> fetchSysLeftMenuTreeRoot(Serializable userId) {
		return switchMenusToTreeMenus(this.menuDao
				.querySysLeftMenuTreeRoot(userId));
	}

	@Override
	public List<MenuTreeBean> fetchSysLeftMenuTreeChild(Serializable userId,
			Serializable parentId) {
		return switchMenusToTreeMenus(this.menuDao.querySysLeftMenuTreeChild(
				userId, parentId));
	}

	/**
	 * 将菜单表数据转换为菜单树
	 * @param menus
	 * @return
	 */
	public List<MenuTreeBean> switchMenusToTreeMenus(List<Menu> menus) {
		List<MenuTreeBean> menuTrees = new ArrayList<MenuTreeBean>();

		for (Menu menu : menus) {
			MenuTreeBean menuTree = new MenuTreeBean();

			menuTree.setTreeId(menu.getMenuNo());
			menuTree.setParentId(menu.getParentNo());
			menuTree.setName(menu.getMenuName());
			if (null == menu.getMenuUrl()
					|| "".equals(menu.getMenuUrl().trim())) {
				menuTree.setIsParent(true);
			}else {
				menuTree.setLinkUrl(menu.getMenuUrl());
			}
			
			menuTrees.add(menuTree);
		}

		return menuTrees;
	}

	@Override
	public Pagination fetchMenusByPage(PageParamMap pageParamMap) {
		return this.menuDao.queryMenusByPage(pageParamMap);
	}

	@Override
	public String fetchMaxMenuNoByParentNo(String parentNo) {
		return this.menuDao.queryMaxMenuNoByParentNo(parentNo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkMenuName(String parentNo, String menuName) {
		boolean result = true;
		Menu m = new Menu();
		m.setParentNo(parentNo);
		m.setMenuName(menuName);
		
		List<Menu> list = this.menuDao.findAll(m);
		
		if(0 == list.size())
		{
			result = false;
		}
		m = null;//释放内存
		return result;
	}


}
