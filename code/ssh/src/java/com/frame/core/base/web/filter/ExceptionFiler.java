package com.frame.core.base.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frame.core.exception.service.ServiceException;

/**
 * 业务异常过滤器
 * 
 * @author Tandaly
 * @date 2013-3-7 下午4:17:31
 */
public class ExceptionFiler implements Filter {

	private String errorPage;// 跳转的错误信息页面

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		// 捕获你抛出的业务异常
		try {
			chain.doFilter(req, res);
		} catch (Exception e) {
			System.out.println("出现异常");
			if (e instanceof ServiceException) {// 如果是你定义的业务异常
				System.out.println("ServiceException异常");
				request.setAttribute("ServiceException", e);// 存储业务异常信息类
				request.getRequestDispatcher(errorPage).forward(request,
						response);// 跳转到信息提示页面！！
			}
			e.printStackTrace();
		}
	}

	// 初始化读取你配置的提示页面路径
	public void init(FilterConfig config) throws ServletException {
		// 读取错误信息提示页面路径
		errorPage = config.getInitParameter("errorPage");
		if (null == errorPage || "".equals(errorPage)) {
			throw new RuntimeException(
					"没有配置错误信息跳转页面,请再web.xml中进行配置\n<init-param>\n<param-name>errorPage</param-name>\n<param-value>/error.jsp</param-value>\n </init-param>\n路径可以是你自己设定的任何有效路径页面！！");
			// System.out.println("没有配置错误信息跳转页面");
		}
	}

}
