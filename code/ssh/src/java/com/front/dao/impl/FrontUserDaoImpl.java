package com.front.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.util.dao.MyHibernateTemplate;
import com.front.dao.FrontUserDao;
import com.front.model.FrontUser;


@Repository
public class FrontUserDaoImpl implements FrontUserDao {
	
	@Autowired
	private MyHibernateTemplate hibernateTemplate;

	@Override
	public void insertUser(FrontUser user) {
		this.hibernateTemplate.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public FrontUser queryUserByUserName(String userName) {
		String queryString = "FROM FrontUser fu WHERE fu.userName=?";
		List<FrontUser> list = this.hibernateTemplate.find(queryString, userName);
		
		if(list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public FrontUser queryFrontUserById(Integer id) {
		return this.hibernateTemplate.get(FrontUser.class, id);
	}

}