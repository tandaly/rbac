package com.frame.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.frame.common.dao.CommonDaoSupport;
import com.frame.common.dao.Finder;
import com.frame.common.page.PageParamMap;
import com.frame.common.page.Pagination;
import com.frame.dao.UserDao;
import com.frame.model.User;
/**
 * 用户实体数据层实现
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午10:03:20
 */
@Repository
public class UserDaoImpl extends CommonDaoSupport implements UserDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public User queryUserByUserName(String userName) {
		String hql = "FROM User WHERE userName=? ";
		//Query query =  this.getSession().createQuery(hql);
		List<User> list = super.getHibernateTemplate().find(hql, userName);
		//query.setParameter(0, userName);
		
		//return (User) query.uniqueResult();
		
		if(null == list || 0 == list.size())
		{
			return null;
		}
		
		return list.get(0);
	}

//	@Override
//	public Pagination findObjectsByPage(PageParamMap pageParamMap) {
//		String hql = "From User u WHERE 1=1 ";
//		
//		Finder f = Finder.create(hql);
//		
//		/***************************组拼查询条件 start***************************/
//		Object userName = pageParamMap.get("userName");//用户名查询条件
//		if(null != userName && !"".equals(userName))
//		{
//			f.append("AND u.userName LIKE :userName");
//			f.setParam("userName", "%" + userName + "%");
//		}
//		/***************************组拼查询条件 end***************************/
//		
//		return super.find(f, pageParamMap.getPageNo(),
//				pageParamMap.getPageSize());
//	}

}