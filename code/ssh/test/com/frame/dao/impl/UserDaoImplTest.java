package com.frame.dao.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.frame.BaseCommonTest;
import com.frame.application.admin.modules.system.dao.UserDao;

public class UserDaoImplTest extends BaseCommonTest {

	@Autowired
	private UserDao userDao;
	/*
	@Autowired
	private RoleDao roleDao;
	
	@Test
	public void testSave() {
		User user = new User();
		
		user.setUserName("test2"+System.currentTimeMillis());
		user.setPassword("1112");
		
		
		this.userDao.save(user);
		
	}
	
	@Test
	public void testSave2()
	{
		Role role = new Role();
		role.setRoleName("角色" + System.currentTimeMillis());
		
		User user = new User();
		user.setUserName("tandaly" + System.currentTimeMillis());
		user.setPassword("111");
		
		role.getUsers().add(user);
		user.getRoles().add(role);
		
		this.userDao.save(user);
	}
	
	@Test
	public void testSave3()
	{
		//Role role = new Role();
		//role.setRoleName("Jiaose" + System.currentTimeMillis());
		
		Role role = (Role) this.roleDao.load(new Long(1));
		//Role role = (Role) this.roleDao.findById(Role.class, new Long(1));
		
		Usergroup usergroup = new Usergroup();
		usergroup.setUsergroupName("用户组" + System.currentTimeMillis());
		
		User user = new User();
		user.setUserName("tandaly" + System.currentTimeMillis());
		user.setPassword("111");
		
		usergroup.getUsers().add(user);
		user.getUsergroups().add(usergroup);
		
		user.getRoles().add(role);
		role.getUsers().add(user);
		
		this.userDao.save(user);
	}
	
	@Test
	public void testFindById()
	{
		
		User user = (User) this.userDao.findById(User.class, new Long(1));
		
		if(null == user)
		{
			fail("查询失败");
		}
		else {
			System.out.println("id=" + user.getId() 
					+ "\n userName=" + user.getUserName());
		}
	}
	
	@Test
	public void testFindCount()
	{
		
	}
*/
	
	@Test
	public void testInitDB()
	{
		this.userDao.initDB();
	}
}
