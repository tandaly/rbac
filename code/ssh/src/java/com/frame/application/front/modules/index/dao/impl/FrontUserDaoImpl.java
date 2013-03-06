package com.frame.application.front.modules.index.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.application.front.modules.index.dao.FrontUserDao;
import com.frame.application.front.modules.index.model.FrontUser;
import com.frame.core.base.dao.impl.BaseDaoImpl;


@Repository
public class FrontUserDaoImpl extends BaseDaoImpl implements FrontUserDao {

	@Override
	public void insertUser(FrontUser user) {
		super.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public FrontUser queryUserByUserName(String userName) {
		String queryString = "FROM FrontUser fu WHERE fu.userName=?";
		List<FrontUser> list = super.getHibernateTemplate().find(queryString, userName);
		
		if(list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public FrontUser queryFrontUserById(Integer id) {
		return super.getHibernateTemplate().get(FrontUser.class, id);
	}

}