package com.frame.dao.impl;

import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.frame.BaseCommonTest;
import com.frame.dao.RoleDao;
import com.frame.model.Menu;
import com.frame.model.Privilege;
import com.frame.model.Role;
import com.frame.model.User;

public class RoleDaoImplTest extends BaseCommonTest {

	@Autowired
	private RoleDao roleDao;
/*	
	@Test
	public void testSave() {
		Role role = new Role();
		
		role.setRoleName("角色" + System.currentTimeMillis());
		
		this.roleDao.save(role);
	}
	
	@Test
	public void testSave2() {
		Role role = new Role();
		role.setRoleName("角色" + System.currentTimeMillis());
		
		User user = new User();
		user.setUserName("tandaly" + System.currentTimeMillis());
		user.setPassword("111");
		
		role.getUsers().add(user);
		user.getRoles().add(role);
		
		this.roleDao.save(role);
	}
	
	@Test
	public void testSave3()
	{
		Menu menu = new Menu();
		menu.setMenuName("menu" + System.currentTimeMillis());
		menu.setMenuUrl("");
		
		Privilege privilege = new Privilege();
		privilege.setPrivilegeType("menu");
		
		menu.getPrivileges().add(privilege);
		privilege.getMenus().add(menu);
		
		Role role = new Role();
		role.setRoleName("角色" + System.currentTimeMillis());
		
		privilege.getRoles().add(role);
		role.getPrivileges().add(privilege);
		
		
		this.roleDao.save(role);
		
	}
	
	@Test
	public void testFindById()
	{
		Role role = (Role) this.roleDao.findById(Role.class, new Long(2));
		
		Assert.assertNotNull(role);
		
		Iterator<User> it = role.getUsers().iterator();
		
		while(it.hasNext())
		{
			User user = it.next();
			
			System.out.println("用户=" + user.getUserName());
		}
	}
*/
}
