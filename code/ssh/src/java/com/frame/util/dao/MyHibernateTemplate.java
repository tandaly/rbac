package com.frame.util.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyHibernateTemplate extends HibernateTemplate{
	
//	@SuppressWarnings("unchecked")
//	public List search(final Class<?> entityType,final String search, final String... fields) throws DataAccessException {
//		return executeWithNativeSession(new HibernateCallback<List>() {
//			public List doInHibernate(Session session) throws HibernateException {
//				FullTextSession fullTextSession = Search.getFullTextSession(session);
//				QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(entityType).get();
//				org.apache.lucene.search.Query query =qb.keyword().onFields(fields).matching(search).createQuery();
//				org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query,entityType);
//				prepareQuery(hibQuery);
//				return hibQuery.list();
//			}
//		});
//	}
	
	@SuppressWarnings("rawtypes")
	public List find(final String queryString,final int startResult,final int maxResult, final Object... values) throws DataAccessException {
		return executeWithNativeSession(new HibernateCallback<List>() {
			public List doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
					}
				}
				queryObject.setMaxResults(maxResult);
				queryObject.setFirstResult(startResult);
				return queryObject.list();
			}
		});
	}
	
	public Integer getResultSize(final String queryString,final Object... values) throws DataAccessException {
		return executeWithNativeSession(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				prepareQuery(queryObject);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
					}
				}
				
				return ((Long) queryObject.iterate().next()).intValue();
			}
		});
	}
	

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
