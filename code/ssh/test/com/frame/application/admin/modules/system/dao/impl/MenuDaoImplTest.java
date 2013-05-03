package com.frame.application.admin.modules.system.dao.impl;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.frame.BaseTest;
import com.frame.application.admin.modules.system.popedom.dao.MenuDao;
import com.frame.application.admin.modules.system.popedom.model.Menu;
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
	
	@Test
	public void testDeleteByIds()
	{
		Menu menu = (Menu) this.menuDao.findById(Menu.class, new Long(8));
		
		this.menuDao.delete(menu);
	}
	
	@Test
	public void testQueryMaxMenuNoByParentNo()
	{
		String result = this.menuDao.queryMaxMenuNoByParentNo("1");
		
		Assert.assertEquals("1003", result);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll()
	{
		Menu menu = new Menu();
		menu.setParentNo("-1");
		menu.setMenuNo("2");
		
		List<Menu> list = this.menuDao.findAll(menu);
		
		Assert.assertSame(0, list.size());
	}
}
