package com.frame.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.bean.TreeBean;
import com.frame.model.User;
import com.frame.util.HtmlUtil;
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
	public void ajaxGetSysLeftMenuTreeRoot(HttpServletResponse response)
	{
		List<TreeBean> list = new ArrayList<TreeBean>();
		
		TreeBean root = new TreeBean();
		root.setTreeId("1");
		root.setName("系统管理");
		root.setClick("return false;");
		root.setIsParent(true);
		
		list.add(root);
		
		HtmlUtil.writerJson(response, list);
	}
	
	/**
	 * ajax获得系统左菜单子叶子结点
	 * @param response
	 * @param treeId
	 */
	@RequestMapping(value = "ajaxGetSysLeftMenuTreeChild", method = RequestMethod.POST)
	public void ajaxGetSysLeftMenuTreeChild(HttpServletResponse response, String treeId)
	{
		List<TreeBean> list = new ArrayList<TreeBean>();
		
		if(null != treeId)
		{
			switch(Integer.valueOf(treeId))
			{
			case 1:
				TreeBean pTree = new TreeBean();
				pTree.setTreeId("1001");
				pTree.setParentId("1");
				pTree.setName("权限管理");
				pTree.setClick("return false;");
				pTree.setIsParent(true);
				
				list.add(pTree);
				
				break;
			case 1001:
				TreeBean userTree = new TreeBean();
				userTree.setTreeId("1001001");
				userTree.setParentId("1001");
				userTree.setName("用户管理");
				userTree.setUrl("frame/toUserList.do");
				userTree.setTarget("mainFrame");
				//userTree.setIcon("user.gif");
				
				list.add(userTree);
				
				TreeBean roleTree = new TreeBean();
				roleTree.setTreeId("1001002");
				roleTree.setParentId("1001");
				roleTree.setName("角色管理");
				roleTree.setUrl("frame/toRoleList.do");
				roleTree.setTarget("mainFrame");
				//roleTree.setIcon("role.gif");
				
				list.add(roleTree);
				
				break;
			}
		}
		else {
			System.out.println("--没有子树--");
		}
		
		HtmlUtil.writerJson(response, list);
	}
}
