package com.frame.application.front.modules.index.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.application.front.modules.index.model.FrontUser;
import com.frame.application.front.modules.index.service.FrontUserService;
import com.frame.application.front.util.FrontConstants;
import com.frame.application.front.util.ResponseUtils;
/**
 * 登陆控制器
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 上午1:11:39
 */
@Controller
@RequestMapping(FrontConstants.PROJECT_PATH)
public class FrontLoginController {

	Logger log = Logger.getLogger(getClass());
	
	@Resource
	private FrontUserService userService;//用户业务操作对象
	
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
	public ModelAndView register(FrontUser user, HttpServletRequest request)
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
		}else {
			//fm.setFrontUser(user);
			if(this.userService.register(user))
			{//注册成功
				mav.setViewName("redirect:/"+FrontConstants.PROJECT_PATH+"/loginView"+FrontConstants.REQUEST_SUFFIX);
			}else {//注册失败，该用于已经注册
				mav.setViewName("system/register");
				mav.addObject("errorMsg", "该用户名已被注册");
			}
		}
		
		return mav;
	}
	
	/**
	 * 登陆操作
	 * @param user
	 * @return
	 * @throws JSONException 
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void login(FrontUser user, HttpSession session, HttpServletResponse response) throws JSONException
	{
		//ModelAndView mav = new ModelAndView();
		JSONObject json = new JSONObject();
		
		if(null == user || "".equals(user.getUserName().trim()) 
				|| "".equals(user.getPassword()))
		{
			json.put("errorMsg", "用户名或密码不能为空");
			ResponseUtils.renderJson(response, json.toString());
			return ;
		}
		
		FrontUser u = userService.loginCheck(user);
		if(null == u)
		{
			log.error("登陆失败");
			//mav.setViewName("system/login");
			//mav.addObject("errorMsg", "用户名或密码错误");
			json.put("errorMsg", "用户名或密码错误");
		}else {
			log.info("登陆成功");
			//mav.setViewName("redirect:/"+FrontConstants.PROJECT_PATH+"/index" + FrontConstants.REQUEST_SUFFIX);
			session.setAttribute(FrontConstants.USER_IN_SESSION, u);
			json.put("errorMsg", "success");
		}
		ResponseUtils.renderJson(response, json.toString());
		//return mav;
	}
	
//	@RequestMapping(value="login2", consumes={"application/json"})
//	public void login2(HttpServletResponse response)
//	{
//		JSONObject json = new JSONObject();
//		
//			json.put("errorMsg", "success");
//		ResponseUtils.renderJson(response, json.toString());
//	}
	
	
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
			FrontUser user = (FrontUser) session.getAttribute(FrontConstants.USER_IN_SESSION);
			if(null != user)
			{
				log.info(user.getUserName() + "退出系统了");
			}
			
			session.invalidate();
		}
		
		return "redirect:loginView" + FrontConstants.REQUEST_SUFFIX;
	}
	
}
