package com.frame.core.base.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.frame.application.admin.modules.system.model.Menu;
import com.frame.application.admin.modules.system.model.Privilege;
import com.frame.application.admin.modules.system.model.Role;
import com.frame.application.admin.modules.system.model.User;
import com.frame.core.base.dao.BaseDao;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.page.SimplePage;
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
	public void initDB() {
		SessionFactory sf = super.getSessionFactory();
		//修改为create表 TODO
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		try {
			//1.初始化菜单表
			/*************顶级菜单****************/
			Menu mSys = new Menu();
			mSys.setMenuNo("1");
			mSys.setMenuName("系统管理");
			mSys.setClick("return false;");
			mSys.setOrderNo(mSys.getMenuNo());
			
			/*************二级菜单****************/
			Menu mSysPriv = new Menu();
			mSysPriv.setMenuNo("1001");
			mSysPriv.setParentNo("1");
			mSysPriv.setMenuName("权限管理");
			mSysPriv.setClick("return false;");
			mSysPriv.setOrderNo(mSysPriv.getMenuNo());
			
			/*************三级菜单****************/
			Menu mSysUser = new Menu();
			mSysUser.setMenuNo("1001001");
			mSysUser.setParentNo("1001");
			mSysUser.setMenuUrl("frame/toUserList.do");
			mSysUser.setMenuName("用户管理");
			mSysUser.setOrderNo(mSysUser.getMenuNo());
			
			Menu mSysRole = new Menu();
			mSysRole.setMenuNo("1001002");
			mSysRole.setParentNo("1001");
			mSysRole.setMenuUrl("frame/toRoleList.do");
			mSysRole.setMenuName("角色管理");
			mSysRole.setOrderNo(mSysRole.getMenuNo());
			
			//2.初始化权限表
			Privilege p = new Privilege();
			p.setPrivilegeName("系统权限");
			
			
			//3.给权限分配菜单
			mSys.getPrivileges().add(p);
			p.getMenus().add(mSys);
			
			mSysPriv.getPrivileges().add(p);
			p.getMenus().add(mSysPriv);
			
			mSysUser.getPrivileges().add(p);
			p.getMenus().add(mSysUser);
			
			mSysRole.getPrivileges().add(p);
			p.getMenus().add(mSysRole);
			
			//4.初始化角色表
			Role role = new Role();
			role.setRoleName("系统管理员");
			
			//5.给角色分配权限
			p.getRoles().add(role);
			role.getPrivileges().add(p);
			
			//6.初始化用户表
			User user = new User();
			user.setUserName("admin");
			user.setPassword("admin");
			user.setRegisterDate(new Date());
			
			//7.给用户分配角色
			role.getUsers().add(user);
			user.getRoles().add(role);
			
			//8.保存操作
			session.save(mSys);
			session.save(mSysPriv);
			session.save(mSysUser);
			session.save(mSysRole);
			
			session.save(p);
			
			session.save(role);
			
			session.save(user);
			
			
			session.getTransaction().commit();
			session.flush();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	
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
		//super.getSession().delete(entity);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Integer deleteById(String entityName, final Long id) {
		final String hql = "delete " + entityName + " where id = " + id;

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
				f.setParam(entry.getKey(), "%" + o + "%");
			}
		}
		System.out.println("查询----" + f.getOrigHql());
		/***************************组拼查询条件 end***************************/
		
		return this.find(f, pageParamMap.getPageNo(),
				pageParamMap.getPageSize());
	}
	
	

}