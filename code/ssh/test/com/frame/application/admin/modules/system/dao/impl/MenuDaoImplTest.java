package com.frame.application.admin.modules.system.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.frame.BaseTest;
import com.frame.application.admin.modules.system.dao.MenuDao;
import com.frame.application.admin.modules.system.model.Menu;
/**
 * 菜单dao测试
 * @author Tandaly
 * @date 2013-3-8 上午11:03:29
 */
public class MenuDaoImplTest extends BaseTest{

	@Resource
	private MenuDao menuDao;
	
	@Test
	public void testQueryMenusByUserId() {
		
		List<Menu> menus = this.menuDao.queryMenusByUserId(new Long(1));
		
		for(Menu menu:menus)
		{
			System.out.println(menu.getMenuName());
		}
	}

}
