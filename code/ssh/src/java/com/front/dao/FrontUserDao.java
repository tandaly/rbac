package com.front.dao;

import com.front.model.FrontUser;

public interface FrontUserDao {
	/**
	 * 插入用户信息
	 * @param user
	 */
	public void insertUser(FrontUser user);
	
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public FrontUser queryUserByUserName(String userName);
	
	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 */
	public FrontUser queryFrontUserById(Integer id);
}