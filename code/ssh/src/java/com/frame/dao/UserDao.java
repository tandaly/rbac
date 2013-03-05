package com.frame.dao;

import com.frame.common.dao.CommonDao;
import com.frame.common.page.PageParamMap;
import com.frame.common.page.Pagination;
import com.frame.model.User;
/**
 * 用户实体数据持久层接口
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午10:21:39
 */
public interface UserDao extends CommonDao{
	
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public User queryUserByUserName(String userName);
	
	/**
	 * 分页查询用户列表
	 * @return
	 */
	//public Pagination findObjectsByPage(PageParamMap pageParamMap);
	
}