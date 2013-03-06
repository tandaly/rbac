package com.frame.application.admin.modules.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frame.application.admin.modules.system.model.Menu;
import com.frame.application.admin.modules.system.service.MenuService;
import com.frame.core.base.controller.BaseController;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.util.SystemConstants;
/**
 * 菜单控制器
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-3-5 下午2:01:31
 */
@Controller
@RequestMapping(SystemConstants.PROJECT_PATH)
public class MenuConstroller extends BaseController{

	@Resource
	private MenuService menuService;
	
	
	
	/**
	 * 跳转到菜单列表页面
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toMenuList", method = RequestMethod.GET)
	public String toMenuList()
	{
		return "system/menu/menuList";
	}
	
	/**
	 * ajax分页查询菜单列表
	 * @param page
	 * @param pageSize
	 * @param response
	 * @param userName
	 */
	@RequestMapping(value = "/ajaxMenuList", method = RequestMethod.POST)
	public void ajaxRoleList(HttpServletResponse response, int page, Integer pageSize, Menu menu)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		PageParamMap pageParamMap = new PageParamMap("Menu", page, pageSize);
		
		/***********************封装查询条件 start*******************/
		if(null != menu)
		{
			if(null != menu.getMenuName() && !"".equals(menu.getMenuName().trim()))
				pageParamMap.put("menuName", menu.getMenuName());
			
		}
		/***********************封装查询条件 start*******************/
		
		//分页查询
		Pagination pagination = this.menuService.fetchObjectsByPage(pageParamMap);
		
		//输出分页
		super.writerPagination(response, pagination, result);
	}
}
