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
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${init.username}")//在system.properties中修改
	private String initUserName; //初始化用户名 
	
	@Value("${init.password}")
	private String initPassword;//初始化密码
	
	/**
	 * 初始化数据库表数据
	 */
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
			
			Menu mSysMenu = new Menu();
			mSysMenu.setMenuNo("1001003");
			mSysMenu.setParentNo("1001");
			mSysMenu.setMenuUrl("frame/toMenuList.do");
			mSysMenu.setMenuName("菜单管理");
			mSysMenu.setOrderNo(mSysMenu.getMenuNo());
			
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
			
			mSysMenu.getPrivileges().add(p);
			p.getMenus().add(mSysMenu);
			
			//4.初始化角色表
			Role role = new Role();
			role.setRoleName("系统管理员");
			
			//5.给角色分配权限
			p.getRoles().add(role);
			role.getPrivileges().add(p);
			
			//6.初始化用户表
			User user = new User();
			user.setUserName(this.initUserName);
			user.setPassword(this.initPassword);
			user.setRegisterDate(new Date());
			
			//7.给用户分配角色
			role.getUsers().add(user);
			user.getRoles().add(role);
			
			//8.保存操作
			session.save(mSys);
			session.save(mSysPriv);
			session.save(mSysUser);
			session.save(mSysRole);
			session.save(mSysMenu);
			
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


	@Override
	public List<Object[]> queryMultiObjects(String hql) {
		return super.queryMultiObjectsResult(hql);
	}
	
	
	
	

}
