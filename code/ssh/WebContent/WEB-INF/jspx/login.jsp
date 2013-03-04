<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登陆页面</title>

  </head>
  
  <body>
  	<a href="registerView.do">注册</a>
  	<font color="red">${errorMsg}</font>
  	<form action="login.do" method="post">
  		<spring:message code="username"></spring:message>：<input type="text" name="userName"/> <br/>
  		<spring:message code="password"></spring:message>： <input type="password" name="password" /> <br/>
  		<!-- 生日：<input type="text" name="birthday" /> <br/>-->
  		<input type="submit" value="<spring:message code='login' ></spring:message>"/>
  	</form>
  </body>
</html>
