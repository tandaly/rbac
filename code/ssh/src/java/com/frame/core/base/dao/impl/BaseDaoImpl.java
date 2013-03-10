package com.frame.core.base.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.frame.core.base.dao.BaseDao;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.util.hibernate.Finder;

/**
 * 通用dao操作支持实现类   所有DAO类的实现必须继承该类
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-19 下午5:17:14
 */
@Repository
public class BaseDaoImpl extends AbstractBaseDaoSupport implements
		BaseDao {

	
	@Override
	public void save(Object entity) {
		super.getHibernateTemplate().save(entity);
		//super.getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(Object entity) {
		super.getHibernateTemplate().saveOrUpdate(entity);
		//super.getSession().saveOrUpdate(entity);
	}
	
	@Override
	public void update(Object entity) {
		super.getHibernateTemplate().update(entity);
		//super.getSession().update(entity);
	}
	
	@Override
	public void delete(Object entity) {
		super.getHibernateTemplate().delete(entity);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Integer deleteByIds(String entityName, final Serializable[] ids) {
		final String hql = "DELETE " +  entityName + " WHERE id IN (:ids)";
		
		return (Integer) getHibernateTemplate().execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setParameterList("ids", ids);
				return query.executeUpdate();
			}
			
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Integer deleteById(String entityName, final Long id) {
		final String hql = "DELETE " + entityName + " WHERE id = " + id;

		return (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);

						return query.executeUpdate();

					}
				});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object findById(Class entityType, Serializable id) {
		return super.getHibernateTemplate().get(entityType, id);
		//return super.getSession().get(entityType, id);
	}

	@Override
	public Object findById(String entityName, Serializable id) {
		return super.getHibernateTemplate().get(entityName, id);
		//return super.getSession().get(entityName, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findAll(Object entity) {
		return super.getHibernateTemplate().findByExample(entity);
	}
	
	@Override
	public Pagination findObjectsByPage(PageParamMap pageParamMap) {
		StringBuffer hql = new StringBuffer();
		
		hql.append("From ").append(pageParamMap.getEntityName()).append(" o WHERE 1=1 ");
		
		Finder f = Finder.create(hql.toString());
		
		/***************************组拼查询条件 start***************************/
		Set<Entry<String, Object>> sets = pageParamMap.entrySet();
		
		for(Entry<String, Object> entry:sets)
		{
			Object o = entry.getValue();
			if(null != o && !"".equals(o))
			{
				f.append(" AND o.").append(entry.getKey()).append(" LIKE :").append(entry.getKey());
				f.setParam(entry.getKey(), o);
			}
		}
		System.out.println("查询----" + f.getOrigHql());
		/***************************组拼查询条件 end***************************/
		
		return this.find(f, pageParamMap.getPageNo(),
				pageParamMap.getPageSize());
	}


	@Override
	public List<Object[]> queryMultiObjects(String hql) {
		return super.queryMultiObjectsResult(hql);
	}


	
	
	
	

}
