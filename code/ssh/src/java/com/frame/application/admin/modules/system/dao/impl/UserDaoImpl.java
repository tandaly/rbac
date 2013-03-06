package com.frame.application.admin.modules.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.application.admin.modules.system.dao.UserDao;
import com.frame.application.admin.modules.system.model.User;
import com.frame.core.base.dao.impl.BaseDaoImpl;
/**
 * 用户实体数据层实现
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午10:03:20
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public User queryUserByUserName(String userName) {
		String hql = "FROM User WHERE userName=? ";
		//Query query =  this.getSession().createQuery(hql);
		List<User> list = super.getHibernateTemplate().find(hql, userName);
		//query.setParameter(0, userName);
		
		//return (User) query.uniqueResult();
		
		if(null == list || 0 == list.size())
		{
			return null;
		}
		
		return list.get(0);
	}


}