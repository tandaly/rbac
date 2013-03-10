package com.frame.application.admin.modules.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.application.admin.modules.system.model.MenuTreeBean;
import com.frame.application.admin.modules.system.model.User;
import com.frame.application.admin.modules.system.service.MenuService;
import com.frame.core.base.controller.BaseController;
import com.frame.core.base.util.HtmlUtil;
import com.frame.core.base.util.SystemConstants;

/**
 * 主页控制器
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-2-3 上午1:08:38
 */
@Controller
@RequestMapping(SystemConstants.PROJECT_PATH)
public class IndexConstroller extends BaseController{

	@Resource
	private MenuService menuService;
	
	/**
	 * 跳转到建设页
	 * @return
	 */
	@RequestMapping("build")
	public String build()
	{
		return "system/build";
	}
	
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
	
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping(value = "home")
	public String home()
	{
		return "system/home";
	}
	

	/**
	 * ajax获得系统左菜单根节点树
	 * @param response
	 */
	@RequestMapping(value = "ajaxGetSysLeftMenuTreeRoot", method = RequestMethod.POST)
	public void ajaxGetSysLeftMenuTreeRoot(HttpSession session, HttpServletResponse response)
	{
		List<MenuTreeBean> menuTrees = null;
		
		User user = (User) session.getAttribute(SystemConstants.USER_IN_SESSION);
		if(null != user)
		{
			menuTrees = this.menuService.fetchSysLeftMenuTreeRoot(user.getId());
		}
		
		//TODO 测试用 
		MenuTreeBean demo = new MenuTreeBean();
		demo.setTreeId("2");
		demo.setName("测试管理");
		demo.setIsParent(true);
		
		menuTrees.add(demo);
		
		HtmlUtil.writerJson(response, menuTrees);
	}
	
	/**
	 * ajax获得系统左菜单子叶子结点
	 * @param response
	 * @param treeId
	 */
	@RequestMapping(value = "ajaxGetSysLeftMenuTreeChild", method = RequestMethod.POST)
	public void ajaxGetSysLeftMenuTreeChild(HttpSession session, HttpServletResponse response, String treeId)
	{
		List<MenuTreeBean> menuTrees = null;
		
		User user = (User) session.getAttribute(SystemConstants.USER_IN_SESSION);
		if(null != user)
		{
			menuTrees = this.menuService.fetchSysLeftMenuTreeChild(user.getId(), treeId);
		}
		
		//TODO 测试用
		if(null != treeId)
		{
			switch(Integer.valueOf(treeId))
			{
			case 2:
			MenuTreeBean mailTree = new MenuTreeBean();
			mailTree.setTreeId("2001");
			mailTree.setParentId("2");
			mailTree.setName("freeMarker模版");
			mailTree.setLinkUrl("freeMarker/hello.do");
			
			menuTrees.add(mailTree);
		
			break;
			}
		}
		
		HtmlUtil.writerJson(response, menuTrees);
	}
}
