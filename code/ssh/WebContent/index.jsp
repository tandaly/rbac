<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<base href="${pageContext.request.contextPath}/" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>read me</title>
	</head>
	<body>
		<div style="width:100%;text-align:right;">【<a href="admin/loginView.do">登陆</a>】</div>
		<pre>
		
		【今日事项】(2013-03-08)
			
			【2013-03-07】
			1、为了支持freemarker，添加了两个jar包
				spring-context-support-3.2.0.M1.jar (http://www.findjar.cn/showjar.x?id=697)
				com.springsource.freemarker-2.3.18.jar (http://ebr.springsource.com/repository/app/bundle/version/detail?name=com.springsource.freemarker&version=2.3.18)
				
			2、为了支持邮件发送，添加了一个jar包
				mail.jar(http://www.findjar.cn/showjar.x?id=926)
				
			3、字节码操作，利用cglib给javabean动态添加属性
			   cglib.jar(http://www.findjar.cn/showjar.x?id=278)
			   asm-3.3.jar(http://www.findjar.cn/showjar.x?id=1258)
			
			   
		【BUG单】(以后进行修复，目前只记录)
			1、
				问题描述：打开两个浏览器同时登陆一个帐号，同时进入用户管理列表；然后第任意一个用户进行删除，在另外一个浏览器中执行修改和删除操作会产生错误，这时应该给前台一个提示。其它模块也有类似的问题。
			   	解决方案：在执行操作时应当判断所操作的对象是否存在，如存在就进行操作，如不存在就给用户一个提示。
			
			
		【环境要求】
			Eclipse WTP+tomcat6
			jar需要放在lib下，不要放在lib下的文件夹下，不然找不到
		</pre>
	</body>
</html>