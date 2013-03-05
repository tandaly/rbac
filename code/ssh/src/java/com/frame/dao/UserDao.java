package com.frame.dao;

import com.frame.common.dao.BaseDao;
import com.frame.model.User;
/**
 * 用户实体数据持久层接口
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午10:21:39
 */
public interface UserDao extends BaseDao{
	
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	public User queryUserByUserName(String userName);

	
}