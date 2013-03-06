package com.frame.application.front.modules.index.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frame.application.front.modules.index.model.FrontMood;
import com.frame.application.front.modules.index.model.FrontUser;
import com.frame.application.front.modules.index.service.FrontMoodService;
import com.frame.application.front.util.FrontConstants;
/**
 * 心情控制器
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-9 下午1:33:47
 */
@Controller
@RequestMapping(FrontConstants.PROJECT_PATH)
public class FrontMoodController {

	@Resource
	private FrontMoodService frontMoodService;
	
	/**
	 * 发表心情
	 * @param frontMood
	 * @return
	 */
	@RequestMapping(value="publishFrontMood", method=RequestMethod.POST)
	public String publishFrontMood(FrontMood frontMood, HttpSession session)
	{
		FrontUser fu = (FrontUser)session.getAttribute(FrontConstants.USER_IN_SESSION);
		if(null == fu)
		{//Session 用户为空
			return "redirect:loginView" + FrontConstants.REQUEST_SUFFIX;
		}
		
		//心情内容不能为空
		if(null != frontMood && !"".equals(frontMood.getPublishContent().trim()))
		{
			frontMood.setFrontUser(fu); 
			this.frontMoodService.publishMood(frontMood);
		}
		
		return "redirect:index" + FrontConstants.REQUEST_SUFFIX;
	}
}
