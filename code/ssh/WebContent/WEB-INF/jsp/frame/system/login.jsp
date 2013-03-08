<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<link rel="Shortcut Icon" href="images/logo.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>登陆</title>
<meta content="width=device-width" name="viewport">
<link
	href="css/application.css"
	media="screen" rel="stylesheet" type="text/css">
<!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	
</head>
<body>
	
	<div id="content" role="main">
		<div class="inner cf">
			<!--[if lt IE 9]><p class="chromeframe alert alert-error">
          <i class="icon-exclamation-sign"></i>我们强烈建议您<a href="http://browsehappy.com">升级浏览器</a>，或<a href="http://www.google.com/chromeframe">安装 Google Chrome 浏览器内嵌框架</a>。</p><![endif]-->
			<div class="module" id="signin">
				<header class="module-hd">
					<h1>系统登陆</h1>
				</header>
				<div class="module-bd">
					<form accept-charset="UTF-8" action="frame/login.do"
						class="form-page form-horizontal" id="new_user" method="post">
						<div style="margin: 0; padding: 0; display: inline">
							<input name="utf8" type="hidden" value="✓"><input
								name="authenticity_token" type="hidden"
								value="lfu6X4m8+P8j3f1LQE5ZGA8z7tyPNDF/3/kGHcbch9I=">
						</div>
						<div class="control-group" align="center">
							<font color="red">${errorMsg}&nbsp;</font>
						</div>
						<div class="control-group">
							<label class="control-label" for="user_login"> 
							<font color="red">*</font>
							<spring:message
									code="username"></spring:message>：
							</label>
							<div class="controls">
								<input autofocus="autofocus" class="input-large" id="user_login"
									name="userName" size="30" type="text" value="super">


							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="user_password"> 
							<font color="red">*</font>
							<spring:message
									code="password"></spring:message>：
							</label>
							<div class="controls">
								<input class="input-large" id="user_password"
									name="password" size="30" type="password" value="123456">
							</div>
						</div>
						<div class="form-actions" style="text-align:right;padding-right:160px;">
							<input class="btn btn-large btn-primary" name="commit"
								type="submit"
								value="<spring:message code="login"></spring:message>">
							<input class="btn btn-large btn-primary" name="commit"
								type="button" onclick="location.href='frame/registerView.do';"
								value="<spring:message code="register"></spring:message>">
						
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</body>
</html>