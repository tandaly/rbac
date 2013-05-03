package com.frame.application.admin.modules.system.popedom.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.frame.application.admin.modules.system.popedom.dao.MenuDao;
import com.frame.application.admin.modules.system.popedom.model.Menu;
import com.frame.core.base.dao.impl.BaseDaoImpl;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.util.hibernate.Finder;

/**
 * 菜单Dao实现
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-3-3 下午7:49:56
 */
@Repository
public class MenuDaoImpl extends BaseDaoImpl implements MenuDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> queryMenusByUserId(Serializable userId) {
		String hql = "SELECT m FROM Menu m JOIN m.privileges ps JOIN ps.roles rs JOIN rs.users us " +
				" WHERE us.id = ? AND m.parentNo = '-1'";
		
		return super.getHibernateTemplate().find(hql, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> querySysLeftMenuTreeRoot(Serializable userId) {
		String hql = "SELECT DISTINCT m FROM Menu m JOIN m.privileges ps JOIN ps.roles rs JOIN rs.users us " +
				" WHERE us.id = ? AND m.parentNo = '-1'";
		
		return super.getHibernateTemplate().find(hql, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> querySysLeftMenuTreeChild(Serializable userId,
			Serializable parentId) {
		String hql = "SELECT DISTINCT m FROM Menu m JOIN m.privileges ps JOIN ps.roles rs JOIN rs.users us " +
				" WHERE us.id = ? AND m.parentNo = ?";
		
		return super.getHibernateTemplate().find(hql, userId, parentId);
	}

	@Override
	public Pagination queryMenusByPage(PageParamMap pageParamMap) {
		
		Menu menu = (Menu) pageParamMap.get("menu");
		
		StringBuffer hql = new StringBuffer();
		hql.append("SELECT DISTINCT m From Menu m WHERE m.menuNo = :menuNo OR m.parentNo = :parentNo ");
		
		Finder f = Finder.create(hql.toString());
		
		f.setParam("menuNo", menu.getMenuNo());
		f.setParam("parentNo", menu.getParentNo());
		
		if(null != menu.getMenuName() && !"".equals(menu.getMenuName()))
		{
			f.append(" AND m.menuName LIKE :menuName");
			f.setParam("menuName", menu.getMenuName());
		}
		
		/***************************组拼查询条件 start***************************/
		
		System.out.println("查询----" + f.getOrigHql());
		/***************************组拼查询条件 end***************************/
		
		return this.find(f, pageParamMap.getPageNo(),
				pageParamMap.getPageSize());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String queryMaxMenuNoByParentNo(final String parentNo) {
		
		return super.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public String doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = " SELECT MAX(m.menuNo) FROM Menu m WHERE m.parentNo = :parentNo";
				Query query = session.createQuery(hql);
				query.setParameter("parentNo", parentNo);
				return (String) query.uniqueResult();
			}
			
		});
		
	}
	
}
