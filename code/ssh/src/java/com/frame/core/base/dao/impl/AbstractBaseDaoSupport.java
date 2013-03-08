package com.frame.core.base.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.frame.core.base.page.Pagination;
import com.frame.core.base.page.SimplePage;
import com.frame.core.base.util.hibernate.Finder;

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
	
	
	/*-------------------------------------------------------/
	 * 华丽的分割线 
	 *------------------------------------------------------*/

	/**
	 * 将查询COUNT结果作为长整数来显示. HQL = select count(id) from Entity
	 * 
	 * @param hql 查询语句
	 * @param args 参数列表
	 * @return 整型数字
	 */
	@SuppressWarnings("rawtypes")
	public Integer queryForCount( final String hql, final Object... args) 
	{
		List list = getHibernateTemplate().executeFind(new HibernateCallback() 
		{
			 public Object doInHibernate(Session session)
			 throws HibernateException, SQLException 
			 {
				 Query query = session.createQuery(hql);
				 
				 for(int i =0; i < args.length; i++) 
				 {
					 query.setParameter(i, args[i]);
				 }
				 
	
				 List list = query.list();
				 return list;
			 }
		});
		
		// Hibernate做count计算返回一般都是对象
		return Integer.parseInt(list.get(0) + "");		
	}
	
	
	/**
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param values
	 *            如果hql有多个个参数需要传入，values就是传入的参数数组
	 * @param offset
	 *            第一条记录索引
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("rawtypes")
	public List pageQuery(final String hql, int currentPage,
			final int pageSize, final Object... values) {
		if (currentPage == 0) {
			currentPage = 1;
		}

		final int curPage = currentPage;

		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);

				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						query.setParameter(i, values[i]);
					}
				}

				List result = query.setFirstResult((curPage - 1) * pageSize)
						.setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * 通过Finder获得分页数据
	 * 
	 * @param finder
	 *            Finder对象
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页条数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected Pagination find(final Finder finder, int pageNo, int pageSize) {
		if(pageNo < 1)
			pageNo = SimplePage.PAGENO;
		if(pageSize < 1)
			pageSize = SimplePage.PAGESIZE;
		
		int totalCount = countQueryResult(finder);
		
		Pagination p = new Pagination(pageNo, pageSize, totalCount);
		if (totalCount < 1) {
			p.setList(new ArrayList());
			return p;
		}
		final int firstResult = p.getFirstResult();
		final int pageSize2 = p.getPageSize();
		List list = getHibernateTemplate().executeFind(new HibernateCallback() 
		{
			 public Object doInHibernate(Session session)
			 throws HibernateException, SQLException 
			 {
				 Query query = session.createQuery(finder.getOrigHql());
					finder.setParamsToQuery(query);
					query.setFirstResult(firstResult);
					query.setMaxResults(pageSize2);
					if (finder.isCacheable()) {
						query.setCacheable(true);
					}
					
					return query.list();
			 }
		});
		
		
		p.setList(list);
		return p;
	}

	/**
	 * 获得Finder的记录总数
	 * 
	 * @param finder
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected int countQueryResult(final Finder finder) {
		final String hql = finder.getRowCountHql();
		List list = getHibernateTemplate().executeFind(new HibernateCallback() 
		{
			 public Object doInHibernate(Session session)
			 throws HibernateException, SQLException 
			 {
				 Query query = session.createQuery(hql);
				 finder.setParamsToQuery(query);
				 if (finder.isCacheable()) {
					query.setCacheable(true);
				 }
				 return query.list();
			 }
		});
		
		// Hibernate做count计算返回一般都是对象
		return Integer.parseInt(list.get(0) + "");
		
//		Query query = getSession().createQuery(finder.getRowCountHql());
//		finder.setParamsToQuery(query);
//		if (finder.isCacheable()) {
//			query.setCacheable(true);
//		}
//		return ((Number) query.iterate().next()).intValue();
	}
	
	
	/**
	 * 多表联合查询并返回多个表的数据
	 * @param finder
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<Object[]> queryMultiObjectsResult(final String hql)
	{
		List<Object[]> list  = this.getHibernateTemplate().executeFind(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				
				List<Object[]> list = new ArrayList<Object[]>();
				for(Object o:query.list())
				{
					list.add((Object[]) o);
				}
				
				return list;
			}
		});
		
		return list; 
	}

	
	
	
}
