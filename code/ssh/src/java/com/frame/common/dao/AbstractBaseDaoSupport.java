package com.frame.common.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@org.springframework.transaction.annotation.Transactional
@Repository
public abstract class AbstractBaseDaoSupport{

	private SessionFactory sessionFactory;
	
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		if(null == hibernateTemplate)
			setHibernateTemplate(new HibernateTemplate(getSessionFactory()));
		return hibernateTemplate;
	}
	
	public SessionFactory getSessionFactory()
	{
		return this.sessionFactory;
	}
	
//	protected Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
	
	
}
