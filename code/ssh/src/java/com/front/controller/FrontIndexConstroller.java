package com.front.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.front.model.FrontUser;
import com.front.service.FrontMoodService;
import com.front.util.FrontConstants;

/**
 * 主页控制器
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 上午1:08:38
 */
@Controller
@RequestMapping(FrontConstants.PROJECT_PATH)
public class FrontIndexConstroller {

	@Autowired
	private FrontMoodService frontMoodService;
	
	
	/**
	 * 跳转到主页面
	 * @return
	 */
	@RequestMapping("index")
	public Object index(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("system/index");
		FrontUser user = null;
		if(null != session)
		{
			//return "redirect:loginView" + FrontConstants.REQUEST_SUFFIX;
		
			user = (FrontUser) session.getAttribute(FrontConstants.USER_IN_SESSION);
			if(null != user)
			{
				//return "redirect:loginView" + FrontConstants.REQUEST_SUFFIX;
				mav.addObject(user);
			}
		}
		
		
		
		//获取心情列表
		mav.addObject("frontMoods", this.frontMoodService.fetchFrontMoods());
		
		return mav;
	}
}
