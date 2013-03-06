package com.frame.application.front.modules.index.service;

import com.frame.application.front.modules.index.model.FrontUser;
import com.frame.core.base.service.BaseService;

public interface FrontUserService extends BaseService{
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