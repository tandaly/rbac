package com.frame.application.admin.modules.system.popedom.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frame.application.admin.modules.system.popedom.model.Role;
import com.frame.application.admin.modules.system.popedom.service.RoleService;
import com.frame.core.base.controller.BaseController;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.util.SystemConstants;
/**
 * 角色控制器
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-3-5 下午2:01:31
 */
@Controller
@RequestMapping(SystemConstants.PROJECT_PATH + "system/popedom/role/")
public class RoleConstroller extends BaseController{

	@Resource
	private RoleService roleService;
	
	
	
	/**
	 * 跳转到角色列表页面
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toRoleList", method = RequestMethod.GET)
	public String toRoleList()
	{
		return "system/popedom/role/roleList";
	}
	
	/**
	 * ajax分页查询用户列表
	 * @param page
	 * @param pageSize
	 * @param response
	 * @param userName
	 */
	@RequestMapping(value = "/ajaxRoleList", method = RequestMethod.POST)
	public void ajaxRoleList(HttpServletResponse response, int page, Integer pageSize, Role role)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		PageParamMap pageParamMap = new PageParamMap("Role", page, pageSize);
		
		/***********************封装查询条件 start*******************/
		if(null != role)
		{
			if(null != role.getRoleName() && !"".equals(role.getRoleName().trim()))
				pageParamMap.put("roleName", "%" + role.getRoleName() + "%");
			
		}
		/***********************封装查询条件 start*******************/
		
		//分页查询
		Pagination pagination = this.roleService.fetchObjectsByPage(pageParamMap);
		
		//输出分页
		super.writerPagination(response, pagination, result);
	}
}
