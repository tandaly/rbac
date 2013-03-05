package com.frame.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frame.common.service.BaseServiceImpl;
import com.frame.dao.UserDao;
import com.frame.model.User;
import com.frame.service.UserService;
/**
 * 用户业务操作实现
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午9:56:34
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 用户登陆
	 */
	@Override
	@Transactional(readOnly = true)
	public User loginCheck(User user) {
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
	public boolean register(User user) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> fetchUsers() {
		User user = new User();
		return this.userDao.findAll(user);
	}

	@Override
	public User queryUserById(Long id) {
		return (User) this.userDao.findById(User.class, id);
	}

	@Override
	public void deleteUser(Long id) {
		this.userDao.deleteById("User", id);
	}

}