<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>

  </head>
  
  <body>
  	<a href="loginView.do">登陆</a>
  	<font color="red">${errorMsg}</font>
  	<form action="register.do" method="post">
  		<spring:message code="username"></spring:message>：<input type="text" name="userName"/> <br/>
  		<spring:message code="password"></spring:message>： <input type="password" name="password" /> <br/>
  		<input type="submit" value="<spring:message code='register' ></spring:message>"/>
  	</form>
  	
  </body>
</html>
