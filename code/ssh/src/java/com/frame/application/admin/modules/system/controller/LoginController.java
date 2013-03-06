package com.frame.application.admin.modules.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.application.admin.modules.system.model.User;
import com.frame.application.admin.modules.system.service.UserService;
import com.frame.core.base.util.SystemConstants;
/**
 * 登陆控制器
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 上午1:11:39
 */
@Controller
@RequestMapping(SystemConstants.PROJECT_PATH)
public class LoginController {

	Logger log = Logger.getLogger(getClass());
	
	@Resource
	private UserService userService;//用户业务操作对象
	
	/**
	 * 日期数据绑定(格式转换)
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping(value="registerView", method=RequestMethod.GET)
	public String registerView()
	{
		return "system/register";
	}
	
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping(value="loginView", method=RequestMethod.GET)
	public String loginView()
	{
		return "system/login";
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView register(User user, HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView();
		
		if(null == user || null == user.getUserName() 
				|| "".equals(user.getUserName().trim()) 
				|| null == user.getPassword()
				|| "".equals(user.getPassword())
				) //用户名或者密码不能为空
		{
			mav.setViewName("system/register");
			mav.addObject("errorMsg", "用户名或密码不能为空");
		}else if(!user.getPassword().equals(request.getParameter("confirmPassword")))
		{
			mav.setViewName("system/register");
			mav.addObject("errorMsg", "两次输入的密码不一致");
		}else if(this.userService.register(user))
		{//注册成功
			mav.setViewName("system/login");
		}else {//注册失败，该用于已经注册
			mav.setViewName("system/register");
			mav.addObject("errorMsg", "该用户名已被注册");
		}
		
		return mav;
	}
	
	/**
	 * 登陆操作
	 * @param user
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(User user, HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		
		User u = userService.loginCheck(user);
		if(null == u)
		{
			log.error("登陆失败");
			mav.setViewName("system/login");
			mav.addObject("errorMsg", "用户名或密码错误");
		}else {
			log.info("登陆成功");
			mav.setViewName("redirect:index" + SystemConstants.REQUEST_SUFFIX);
			session.setAttribute(SystemConstants.USER_IN_SESSION, u);
		}
		
		return mav;
	}
	
	
	/**
	 * 退出登陆
	 * @param session
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session)
	{
		if(null != session)
		{
			User user = (User) session.getAttribute(SystemConstants.USER_IN_SESSION);
			if(null != user)
			{
				log.info(user.getUserName() + "退出系统了");
			}
			
			session.invalidate();
		}
		
		return "redirect:"+SystemConstants.PROJECT_PATH+"loginView" + SystemConstants.REQUEST_SUFFIX;
	}
	
}
