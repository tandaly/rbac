package com.frame.application.admin.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 * @author tanfei(619606426@qq.com)
 * @date 2013-2-3 下午9:55:23
 */
public class AdminInterceptor implements HandlerInterceptor {

	private long startTime = 0;
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object nextInterceptor, Exception arg3)
			throws Exception {
		System.out.println("3、执行完成后执行，一般用于在1当中创建的对象，在这里可以进行释放，例如数据库连接之类的");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView model) throws Exception {
		System.out.println("2、执行完控制器后并未生成视图前执行");
		long endTime = System.currentTimeMillis();
		
		long responseTime = endTime - this.startTime;
		if(null != model)
			model.getModel().put("responseTime", responseTime);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object nextInterceptor) throws Exception {
		System.out.println("1、请求到达控制器前执行");
		this.startTime = System.currentTimeMillis();
		return true;
	}

}
