package com.frame.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.frame.common.dao.CommonDaoSupport;
import com.frame.dao.RoleDao;
import com.frame.model.Role;

/**
 * 角色Dao实现
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-3-3 下午7:58:38
 */
@Repository
public class RoleDaoImpl extends CommonDaoSupport implements RoleDao {

	@Override
	public Role load(Long id) {
		//Session session = super.getSession();
		//session.beginTransaction();
		//Role role = super.hibernateTemplate.load(Role.class, id);
		//Role role = (Role) session.load(Role.class, id);
		//session.getTransaction().commit();
		//return (Role) super.getSession().get(Role.class, id);
		
		return super.getHibernateTemplate().load(Role.class, id);
	}

}
