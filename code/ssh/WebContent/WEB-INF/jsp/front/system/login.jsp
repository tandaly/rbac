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
	<title>分享快乐 传递幸福-ShareTea</title>
	<meta content="width=device-width" name="viewport">
	<!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<meta content="authenticity_token" name="csrf-param">
	<meta content="lfu6X4m8+P8j3f1LQE5ZGA8z7tyPNDF/3/kGHcbch9I="
		name="csrf-token">
	
	<link href="css/application.css" media="screen" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="js/common/jquery.js"></script>
	<script type="text/javascript" src="js/front/system/login.js"></script>

</head>
<body>
	<header id="header">
		<div class="inner cf">
			<a href="#" class="logo"><img alt="ShareTea"
				src="images/logo.png" width="100px" height="100px"></a><span
				class="slogan">Share a cup of happy</span>
				<span style="float: left; margin: 23px 0 0 10px; padding: 30px 0 0 10px;">
					<a href="front/index.htm" class="signin-btn">首页</a>
				</span> 
				<span style="float: left; margin: 23px 0 0 10px; padding: 30px 0 0 10px;">
					<a href="front/index.htm" class="signin-btn">社区</a>
				</span> 
				<span style="float: left; margin: 23px 0 0 10px; padding: 30px 0 0 10px;">
					<a href="front/index.htm" class="signin-btn">数据</a>
				</span>
			<nav class="top-nav">
				<ul>
					<li><a href="#">探索</a></li>
					<li><a href="#">帮助</a></li>
					<li><a href="#">关于</a></li>
				</ul>
			</nav>
			<div class="user-nav fix">
				<form accept-charset="UTF-8" action="#" id="search-form"
					method="get">
					<div style="margin: 0; padding: 0; display: inline"></div>
					<input id="keyword" name="keyword" placeholder="搜索 ..." type="text">
					<button class="icon-search" type="submit">q</button>
				</form>
				<span class="divider"></span><a href="front/loginView.htm"
					class="signin-btn"><spring:message code="login"></spring:message></a>
			</div>
		</div>
	</header>
	<div id="content">
		<div class="inner cf">
			<!--[if lt IE 9]><p class="chromeframe alert alert-error">
          <i class="icon-exclamation-sign"></i>我们强烈建议您<a href="http://browsehappy.com">升级浏览器</a>，或<a href="http://www.google.com/chromeframe">安装 Google Chrome 浏览器内嵌框架</a>。</p><![endif]-->
			<div class="module" id="signin">
				<header class="module-hd">
					<h1>用户登陆</h1>
				</header>
				<div class="module-bd">
					<form accept-charset="UTF-8" action="" onsubmit="return login()"
						class="form-page form-horizontal" id="loginForm" method="post">
						<div style="margin: 0; padding: 0; display: inline"></div>
						<div class="control-group" align="center">
							<font color="red" id="errorMsg">&nbsp;</font>
						</div>
						<div class="control-group">
							<label class="control-label" for="user_login"> <font
								color="red">*</font> <spring:message code="username"></spring:message>：
							</label>
							<div class="controls">
								<input autofocus="autofocus" class="input-large" id="user_login"
									name="userName" size="30" type="text">


							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="user_password"> <font
								color="red">*</font> <spring:message code="password"></spring:message>：
							</label>
							<div class="controls">
								<input class="input-large" id="user_password" name="password"
									size="30" type="password">
							</div>
						</div>
						<div class="control-group remember-me">
							<div class="controls">
								<label class="checkbox" for="user_remember_me"><input
									name="user[remember_me]" type="hidden" value="0"><input
									id="user_remember_me" name="user[remember_me]" type="checkbox"
									value="1">记住我</label>
							</div>
						</div>
						<div class="form-actions">
							<input class="btn btn-large btn-primary" name="commit"
								type="submit"
								value="<spring:message code="login"></spring:message>">
							<ul class="help-block">
								<li>还不是 ShareTea 的用户吗？<a href="front/registerView.htm">注册</a>成为我们的成员！
								</li>
								<li>忘记密码了？没关系，点击<a href="#">找回密码</a>。
								</li>
							</ul>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<footer id="footer">
		<div class="inner cf">
			<p id="copyright">
				© 2013 ShareTea<br />如意棒、跟斗云、蜗牛、手势、你觉得像什么？发挥你的想象力吧！！！哈哈哈
			</p>
		</div>
	</footer>
</body>
</html>