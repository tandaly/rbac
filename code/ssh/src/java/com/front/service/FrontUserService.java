package com.front.service;

import com.front.model.FrontUser;

public interface FrontUserService {
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean register(FrontUser user);
	
	/**
	 * 用户登陆校验
	 * @param user
	 * @return
	 */
	public FrontUser loginCheck(FrontUser user);
	
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	public FrontUser fetchFrontUser(Integer id);
}