package com.frame.core.base.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.frame.BaseTest;
import com.frame.application.admin.modules.system.popedom.model.Role;
import com.frame.application.admin.modules.system.popedom.model.User;
import com.frame.core.base.dao.BaseDao;

public class BaseDaoImplTest extends BaseTest{

	@Resource(name = "baseDaoImpl")
	private BaseDao baseDao;
	
	@Test
	public void test() {
		String hql = " FROM User u, Role r WHERE u.userName = 'admin'";
		List<Object[]> list = this.baseDao.queryMultiObjects(hql);
		
		for(Object[] o:list)
		{
			User user = (User) o[0];
			Role role = (Role)o[1];
			
			System.out.println("用户：" + user.getUserName());
			System.out.println("角色：" + role.getRoleName());
		}
	}

}
