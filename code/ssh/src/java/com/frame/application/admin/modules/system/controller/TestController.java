package com.frame.application.admin.modules.system.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.frame.application.admin.modules.system.model.User;
/**
 * 测试控制器
 * @author 
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

	/**
	 * 日期数据绑定(格式转换)
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	
	/**
	 * 测试requestMapping （返回的视图，框架默认为/user/test1.jsp）
	 */
	@RequestMapping("/test1")
	public void testRequestMapping()
	{
	}
	
	/**
	 * 采用GET方式
	 */
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public void testRequestMethod()
	{
	}
	
	/**
	 * 采用POST方式
	 */
	@RequestMapping(value="/test2", method=RequestMethod.POST)
	public void testRequestMethod2()
	{
	}
	
	/**
	 * 动态路径参数  
	 * @param userName
	 */
	@RequestMapping("/test3/{name}")
	public void testPathVariable(@PathVariable("name")String userName)
	{
	}
	
	/**
	 * 动态路径参数  
	 * @param name
	 */
	@RequestMapping("/test4/{name}")
	public void testPathVariable2(@PathVariable()String name)
	{
	}
	
	/**
	 * 取得request
	 * @param request
	 */
	@RequestMapping("/test5")
	public void testRequest(HttpServletRequest request)
	{
	}
	
	/**
	 * 取得response
	 * @param response
	 */
	@RequestMapping("/test6")
	public void testResponse(HttpServletResponse response)
	{
	}
	
	/**
	 * 取得PrintWriter
	 * @param response
	 */
	@RequestMapping("/test6")
	public void testPrintWriter(PrintWriter out)
	{
		out.print("");
	}
	
	/**
	 * 取得request 和response
	 * @param request
	 * @param response
	 */
	@RequestMapping("/test7")
	public void testRequestAndResponse(HttpServletRequest request, HttpServletResponse response)
	{
	}
	
	/**
	 * 取得model对象
	 * @param model
	 */
	@RequestMapping("/test8")
	public void testMap(Map<String, Object> model)
	{
		model.put("list", null);
	}
	
	/**
	 * 取得cookie
	 * @param name
	 */
	@RequestMapping("/test9")
	public void testCookie(@CookieValue("name") String name)
	{
	}
	
	/**
	 * 取得自定义对象(表单)
	 * @param user
	 */
	@RequestMapping("/test10")
	public void testUser(User user)
	{
	}
	
	/**
	 * 返回视图名
	 * @return
	 */
	@RequestMapping("/test11")
	public String testViewName()
	{
		return "viewName";
	}
	
	/**
	 * 重定向请求
	 * @return
	 */
	@RequestMapping("/test12")
	public String testViewName2()
	{
		return "redirect:viewName";
	}
	
	/**
	 * 返回模型数据
	 * @return
	 */
	@RequestMapping("/test13")
	public Map<String, Object> testModel()
	{
		Map<String, Object> model = new HashMap<String, Object>();
		return model;
	}
	
	/**
	 * 返回视图和模型
	 * @return
	 */
	@RequestMapping("/test14")
	public ModelAndView testModelAndView()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewName");
		mav.addAllObjects(new HashMap<String, Object>());
		return mav;
	}
	
	/**
	 * 返回模型数据(页面取得时候，框架默认 userList)
	 * @return
	 */
	@RequestMapping("/test15")
	public List<User> testList()
	{
		return null;
	}
	
	/**
	 * 返回用户数据(页面取得时候，框架默认 user)
	 * @return
	 */
	@RequestMapping("/test16")
	public User testUserView()
	{
		return new User();
	}
	
	
	
	
}
