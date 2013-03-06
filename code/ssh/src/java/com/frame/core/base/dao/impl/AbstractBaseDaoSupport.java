package com.frame.core.base.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@org.springframework.transaction.annotation.Transactional
/**
 * 顶级抽象dao基础支持类
 * @author Tandaly
 * @date 2013-3-6 下午1:47:01
 */
@Repository
public abstract class AbstractBaseDaoSupport {

	/**
	 * session工厂
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * hibernate模版
	 */
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
