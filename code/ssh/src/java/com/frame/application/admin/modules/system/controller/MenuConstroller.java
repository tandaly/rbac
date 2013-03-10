package com.frame.application.admin.modules.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frame.application.admin.modules.system.model.Menu;
import com.frame.application.admin.modules.system.model.MenuTreeBean;
import com.frame.application.admin.modules.system.service.MenuService;
import com.frame.core.base.controller.BaseController;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.util.HtmlUtil;
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
	 * 跳转到新增菜单页面
	 * @param parentNo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"toAddMenu"}, method = RequestMethod.GET)
	public String toAddMenu(String parentNo, ModelMap model)
	{
		model.put("parentNo", parentNo);
		String menuNo = this.menuService.fetchMaxMenuNoByParentNo(parentNo);
		
		model.put("menuNo", menuNo == null?(parentNo + "001"):(Long.valueOf(menuNo) + 1) );
		return "system/menu/addMenu";
	}
	
	/**
	 * 新增菜单
	 * @param response
	 * @param menu
	 */
	@RequestMapping(value = "/addMenu" , method = RequestMethod.POST)
	public void addUser(HttpServletResponse response, Menu menu)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		//验证参数
		if(null == menu)
		{
			result.put("msg", "fail");
		}
		else if(null == menu.getMenuName() || "".equals(menu.getMenuName().trim()) 
				){
			result.put("msg", "hasNull");
		}else{	
			
			try {
				//验证该菜单是否存在
				if(this.menuService.checkMenuName(menu.getParentNo(), menu.getMenuName()))
				{
					result.put("msg", "exist");
				}
				else {
					menu.setOrderNo(menu.getMenuNo());
					this.menuService.save(menu);
					result.put("msg", "success");
				}
			} catch (Exception e) {
				result.put("msg", "fail");
				e.printStackTrace();
			}
		}
		
		HtmlUtil.writerJson(response, result);
	}
	
	/**
	 * 跳转到菜单框架页面
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toMenuFrame", method = RequestMethod.GET)
	public String toMenuFrame()
	{
		return "system/menu/menuFrame";
	}
	
	/**
	 * 跳转到菜单列表页面
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toMenuList", method = RequestMethod.GET)
	public String toMenuList(String parentNo, ModelMap model)
	{
		model.put("parentNo", parentNo);
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
//		if(null != menu)
//		{
//			if(null != menu.getParentNo() && !"".equals(menu.getParentNo().trim()))
//			{
//				pageParamMap.put("menuNo", menu.getParentNo());
//				pageParamMap.put("parentNo", menu.getParentNo());
//			}
//			
//			if(null != menu.getMenuName() && !"".equals(menu.getMenuName().trim()))
//				pageParamMap.put("menuName", "%" + menu.getMenuName() + "%");
//			
//		}
		menu.setMenuNo(menu.getParentNo());
		pageParamMap.put("menu", menu);
		/***********************封装查询条件 start*******************/
		
		//分页查询
		Pagination pagination = this.menuService.fetchMenusByPage(pageParamMap);
		
		//输出分页
		super.writerPagination(response, pagination, result);
	}
	
	/**
	 * 获取菜单树
	 * @param response
	 */
	@RequestMapping(value = {"ajaxGetMenusTree"}, method = RequestMethod.POST)
	public void ajaxGetMenusTree(HttpServletResponse response)
	{
		List<MenuTreeBean> menuTrees = this.menuService.fetchMenuTrees();
		

		MenuTreeBean menuTree = new MenuTreeBean();
		menuTree.setTreeId("-1");
		menuTree.setParentId(null);
		menuTree.setName("根结点");
		menuTree.setIsParent(true);
		
		menuTrees.add(menuTree);
		
		
		HtmlUtil.writerJson(response, menuTrees);
	}
}
