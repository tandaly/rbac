package com.frame.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.model.User;
import com.frame.util.SystemConstants;

/**
 * 主页控制器
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 上午1:08:38
 */
@Controller
@RequestMapping(SystemConstants.PROJECT_PATH)
public class IndexConstroller {

	/**
	 * 跳转到主页面
	 * @return
	 */
	@RequestMapping("index")
	public Object index(HttpSession session)
	{
		
		if(null == session)
		{
			return "redirect:"+SystemConstants.PROJECT_PATH+"/loginView" + SystemConstants.REQUEST_SUFFIX;
		}
		
		User user = (User) session.getAttribute(SystemConstants.USER_IN_SESSION);
		if(null == user)
		{
			return "redirect:"+SystemConstants.PROJECT_PATH+"/loginView" + SystemConstants.REQUEST_SUFFIX;
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/index");
		mav.addObject(user);
		return mav;
	}
	
	@RequestMapping(value = "ajaxGetSysLeftMenuTree", method = RequestMethod.POST)
	public void ajaxGetSysLeftMenuTree(String parentId)
	{
		
	}
}
