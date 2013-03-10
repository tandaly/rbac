package com.frame.application.admin.modules.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.frame.application.admin.modules.system.model.User;
import com.frame.application.admin.modules.system.service.UserService;
import com.frame.core.base.controller.BaseController;
import com.frame.core.base.page.PageParamMap;
import com.frame.core.base.page.Pagination;
import com.frame.core.base.util.HtmlUtil;
import com.frame.core.base.util.SystemConstants;

/**
 * 用户管理控制器
 * @author tandaly(tandaly001@gmail.com)
 * @date 2013-2-24 下午2:01:31
 */
@Controller
@RequestMapping(SystemConstants.PROJECT_PATH)
public class UserConstroller extends BaseController{

	@Resource
	private UserService userService;
	
	/**
	 * 跳转到添加用户页面
	 * @return
	 */
	@RequestMapping(value = "/toAddUser", method = RequestMethod.GET)
	public String toAddUser()
	{
		return "system/user/addUser";
	}
	
	/**
	 * 添加用户
	 * @param response
	 * @param user
	 * @param password2
	 */
	@RequestMapping(value = "/addUser" , method = RequestMethod.POST)
	public void addUser(HttpServletResponse response, User user, String password2)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		//验证添加用户参数
		if(null == user)
		{
			result.put("msg", "fail");
		}
		else if(null == user.getUserName() || "".equals(user.getUserName().trim()) || 
				null == user.getPassword() || "".equals(user.getPassword())
				){
			result.put("msg", "hasNull");
		}else if(!user.getPassword().equals(password2)){
			result.put("msg", "password");
		}else{	
			user.setRegisterDate(new Date());
			//执行添加用户业务操作
			if(this.userService.register(user))
			{
				result.put("msg", "success");
			}else {
				result.put("msg", "exist");
			}
		}
		
		HtmlUtil.writerJson(response, result);
	}
	
	/**
	 * 删除用户
	 * @param response
	 * @param id
	 */
	@RequestMapping(value = "/deleteUser")
	public void deleteUser(HttpServletResponse response, Long id)
	{
		String result = "";
		
		if(null != id)
		{
			this.userService.deleteUser(id);
			result = "success";
		}
		else {
			result = "fail";
		}
		
		HtmlUtil.writerJson(response, result);
		
	}
	
	/**
	 * 跳转到修改用户页面
	 * @return
	 */
	@RequestMapping(value = "/toUpdateUser", method = RequestMethod.GET)
	public String toUpdateUser(Long id, ModelMap model)
	{
		User user = this.userService.queryUserById(id);
		model.addAttribute(user);
		
		return "system/user/updateUser";
	}
	
	/**
	 * 修改用户
	 * @param response
	 * @param user
	 * @param oldPassword
	 */
	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public void updateUser(HttpServletResponse response, User user, String oldPassword)
	{
		
	}
	
	/**
	 * 跳转到用户列表页面
	 * @param pageNo
	 * @param pageSize
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toUserList", method = RequestMethod.GET)
	public String toUserList()
	{
		return "system/user/userList";
	}
	
	/**
	 * ajax分页查询用户列表
	 * @param page
	 * @param pageSize
	 * @param response
	 * @param userName
	 */
	@RequestMapping(value = "/ajaxUserList", method = RequestMethod.POST)
	public void ajaxUserList(HttpServletResponse response, int page, Integer pageSize, User user)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		PageParamMap pageParamMap = new PageParamMap("User", page, pageSize);
		
		/***********************封装查询条件 start*******************/
		if(null != user)
		{
			if(null != user.getUserName() && !"".equals(user.getUserName().trim()))
				pageParamMap.put("userName", "%" + user.getUserName() + "%");
			
			if(null != user.getPassword() && !"".equals(user.getPassword()))
				pageParamMap.put("password", user.getPassword());
		}
		/***********************封装查询条件 start*******************/
		
		//分页查询
		Pagination pagination = this.userService.fetchObjectsByPage(pageParamMap);
		
		//输出分页
		super.writerPagination(response, pagination, result);
	}
}
