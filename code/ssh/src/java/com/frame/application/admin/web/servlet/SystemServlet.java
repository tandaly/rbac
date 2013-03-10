package com.frame.application.admin.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.frame.core.base.dao.impl.InitDB;
import com.frame.core.base.util.spring.SpringFactory;
/**
 * 服务器启动时初始化操作
 * @author Tandaly
 * @date 2013-3-6 上午11:05:42
 */
public class SystemServlet extends HttpServlet
{
	
    /**
	 * 序列号
	 */
	private static final long serialVersionUID = -53411255141980767L;

	//销毁
    public void destroy()
    {
        super.destroy();
    }
    
    //初始化主方法
    public void init() throws ServletException
    {
    	System.out.println("----------------初始化操作开始------------");
    	System.out.println("--开始获得操作bean");
    	//InitDB  initDB = SpringFactory.getBean("initDB");
    	System.out.println("--开始进行数据库初始化操作");
    	//initDB.excute();
    	System.out.println("--初始化完成");
    	
    }
   
}
