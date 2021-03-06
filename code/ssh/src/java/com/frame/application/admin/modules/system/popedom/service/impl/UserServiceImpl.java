package com.frame.application.admin.modules.system.popedom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frame.application.admin.modules.system.popedom.dao.UserDao;
import com.frame.application.admin.modules.system.popedom.model.User;
import com.frame.application.admin.modules.system.popedom.service.UserService;
import com.frame.core.base.service.impl.BaseServiceImpl;
import com.frame.core.exception.service.ServiceException;
/**
 * 用户业务操作实现
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午9:56:34
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	/**
	 * 用户登陆
	 */
	@Override
	public User loginCheck(User user) throws ServiceException{
		User u  = userDao.queryUserByUserName(user.getUserName());
		if(null != user.getPassword() && null != u 
				&& user.getPassword().equals(u.getPassword())){
			return u;
		}
		else{
			return null;
		}
	}

	/**
	 * 用户注册
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean register(User user) throws ServiceException{
		if(null == user || null == user.getUserName() 
				|| "".equals(user.getUserName().trim()) 
				|| null == user.getPassword()
				|| "".equals(user.getPassword())
				) //用户名或者密码不能为空
			return false;
		
		User u =  userDao.queryUserByUserName(user.getUserName().trim());
		if(u == null || u.getId()==null){
			user.setUserName(user.getUserName().trim());//用户名去前后空格
			userDao.save(user);
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteUser(Long id) throws ServiceException{
		try {
			this.userDao.deleteById("User", id);
		} catch (Exception e) {
			throw new ServiceException("业务异常：删除用户失败！");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> fetchUsers() throws ServiceException{
		User user = new User();
		return this.userDao.findAll(user);
	}

	@Override
	public User queryUserById(Long id) throws ServiceException{
		return (User) this.userDao.findById(User.class, id);
	}

	@Override
	public boolean updateUser(User user) throws ServiceException {
		this.userDao.update(user);
		return true;
	}



}