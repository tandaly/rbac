package com.service.implement;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.frame.BaseCommonTest;
import com.frame.model.User;
import com.frame.service.UserService;


public class UserServiceTest extends BaseCommonTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testLoginCheck(){
		User user = new User();
		user.setUserName("谭飞");
		user.setPassword("123");
		if(null!=userService.loginCheck(user))
			System.out.println("------OK!!-----");
		else
			System.out.println("------Sorry!!-----");
	}
	
	@Test
	public void testRegister(){
		User user = new User();
		user.setUserName("谭飞");
		user.setPassword("123");
		System.out.println(userService.register(user));
	}

}