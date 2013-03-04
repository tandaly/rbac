package com.front.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.front.model.FrontUser;
import com.front.service.FrontUserService;
import com.front.util.FrontConstants;

/**
 * 用户控制器
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 上午1:08:38
 */
@Controller
@RequestMapping(FrontConstants.PROJECT_PATH)
public class FrontUserConstroller {

	@Autowired
	private FrontUserService frontUserService;
	
	
	/**
	 * 跳转到用户信息页面
	 * @return
	 */
	@RequestMapping("fetchFrontUser/{id}")
	public Object fetchFrontUser(@PathVariable("id")Integer userId, HttpSession session)
	{
		
		if(null == session || null == userId)
		{
			return "redirect:/"+FrontConstants.PROJECT_PATH+"/loginView" + FrontConstants.REQUEST_SUFFIX;
		}
		
		FrontUser user = (FrontUser) session.getAttribute(FrontConstants.USER_IN_SESSION);
		if(null == user)
		{
			return "redirect:/"+FrontConstants.PROJECT_PATH+"/loginView" + FrontConstants.REQUEST_SUFFIX;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/userinfo");
		mav.addObject(this.frontUserService.fetchFrontUser(userId));
		
		return mav;
	}
}
