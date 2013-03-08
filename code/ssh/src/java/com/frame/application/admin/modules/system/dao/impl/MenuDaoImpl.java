package com.frame.application.admin.modules.system.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.application.admin.modules.system.dao.MenuDao;
import com.frame.application.admin.modules.system.model.Menu;
import com.frame.core.base.dao.impl.BaseDaoImpl;

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
				" WHERE us.id = ? AND m.parentNo is null";
		
		return super.getHibernateTemplate().find(hql, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> querySysLeftMenuTreeRoot(Serializable userId) {
		String hql = "SELECT m FROM Menu m JOIN m.privileges ps JOIN ps.roles rs JOIN rs.users us " +
				" WHERE us.id = ? AND m.parentNo is null";
		
		return super.getHibernateTemplate().find(hql, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> querySysLeftMenuTreeChild(Serializable userId,
			Serializable parentId) {
		String hql = "SELECT m FROM Menu m JOIN m.privileges ps JOIN ps.roles rs JOIN rs.users us " +
				" WHERE us.id = ? AND m.parentNo = ?";
		
		return super.getHibernateTemplate().find(hql, userId, parentId);
	}
	
}
