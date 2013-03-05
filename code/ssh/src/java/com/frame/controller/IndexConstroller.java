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
		
		if(null != treeId && "1".equals(treeId))
		{
			TreeBean userTree = new TreeBean();
			userTree.setTreeId("1001");
			userTree.setName("用户管理");
			userTree.setUrl("frame/toUserList.do");
			userTree.setTarget("mainFrame");
			userTree.setParentId("1");
			
			list.add(userTree);
			
			TreeBean roleTree = new TreeBean();
			roleTree.setTreeId("1002");
			roleTree.setName("角色管理");
			roleTree.setUrl("frame/toRoleList.do");
			roleTree.setTarget("mainFrame");
			roleTree.setParentId("1");
			
			
			list.add(roleTree);
		}
		else {
			System.out.println("--没有子树--");
		}
		
		HtmlUtil.writerJson(response, list);
	}
}
