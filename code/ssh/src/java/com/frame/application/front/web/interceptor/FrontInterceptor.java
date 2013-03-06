package com.frame.application.front.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 * @author
 *
 */
public class FrontInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object nextInterceptor, Exception arg3)
			throws Exception {
		System.out.println("13、执行完成后执行，一般用于在1当中创建的对象，在这里可以进行释放，例如数据库连接之类的");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("12、执行完控制器后并未生成视图前执行");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object nextInterceptor) throws Exception {
		System.out.println("11、请求到达控制器前执行");
		return true;
	}

}
