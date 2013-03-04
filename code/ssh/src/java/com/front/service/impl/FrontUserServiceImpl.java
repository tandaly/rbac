package com.front.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.front.dao.FrontUserDao;
import com.front.model.FrontUser;
import com.front.service.FrontUserService;
/**
 * 用户信息业务逻辑操作
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-8 下午6:18:41
 */
@Service
@Transactional
public class FrontUserServiceImpl implements FrontUserService {

	@Autowired
	private FrontUserDao frontUserDao;
	
	@PostConstruct
	public void init()
	{
		
	}
	
	@Override
	public FrontUser loginCheck(FrontUser user) {
		FrontUser u  = frontUserDao.queryUserByUserName(user.getUserName());
		if(null != user.getPassword() && null != u 
				&& user.getPassword().equals(u.getPassword())){
			return u;
		}
		else{
			return null;
		}
	}

	@Override
	public boolean register(FrontUser user) {
		FrontUser u =  frontUserDao.queryUserByUserName(user.getUserName());
		if(null == u || null == u.getId()){
			frontUserDao.insertUser(user);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public FrontUser fetchFrontUser(Integer id) {
		return this.frontUserDao.queryFrontUserById(id);
	}

}