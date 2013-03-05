package com.frame.service;

import java.util.List;

import com.frame.common.service.BaseService;
import com.frame.model.User;
/**
 * 用户业务操作接口
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午9:55:39
 */
public interface UserService extends BaseService{
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * 用户登陆验证
	 * @param user
	 * @return
	 */
	public User loginCheck(User user);
	
	/**
	 * 获得用户列表
	 * @return
	 */
	public List<User> fetchUsers();
	
	/**
	 * 根据主键查询用户
	 * @param id
	 * @return
	 */
	public User queryUserById(Long id);
	
	/**
	 * 根据主键删除用户
	 * @param id
	 */
	public void deleteUser(Long id);
	
}