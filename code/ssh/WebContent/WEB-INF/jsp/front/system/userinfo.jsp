<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
	<link rel="Shortcut Icon" href="images/logo.ico" type="image/x-icon">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>分享快乐 传递幸福-ShareTea</title>
	<meta content="width=device-width" name="viewport">
	<link href="css/application.css" media="screen" rel="stylesheet"
		type="text/css">
	<!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<meta content="authenticity_token" name="csrf-param">
	<meta content="lfu6X4m8+P8j3f1LQE5ZGA8z7tyPNDF/3/kGHcbch9I="
		name="csrf-token">
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/index.css" rel="stylesheet">
	<script type="text/javascript" src="js/common/jquery.js"></script>
	<script type="text/javascript" src="js/front/system/index.js"></script>
</head>
<body>

	<header id="header">
		<div class="inner cf">
			<a href="#" class="logo"> 
				<img src="images/logo.png" style="width:100px; height:100px;"/>
			</a> <span
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
					<li>
							当前登陆人：<a href="front/fetchFrontUser/${frontUser.id}.htm"><font color="red">${frontUser.userName}</font></a>
					</li>
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
					<button class="icon-search" type="submit"></button>
				</form>
				<span class="divider"></span>
					<c:if test="${frontUser !=null}">
							<a href="front/logout.htm" class="signin-btn">注销</a>
					</c:if>
				
			</div>
		</div>
	</header>
	<!--[if lt IE 9]>
		<div class="inner cf">
	<p class="chromeframe alert alert-error">
          <i class="icon-exclamation-sign"></i>我们强烈建议您<a href="http://browsehappy.com">升级浏览器</a>，或<a href="http://www.google.com/chromeframe">安装 Google Chrome 浏览器内嵌框架</a>。</p>
       </div>
     <![endif]-->

	<div class="container">
		<br clear="all">

		<div class="row-fluid">
			<div style="float:left;width:70%;">
				<br clear="all">
				<div class="module" id="signin" style="width: 96%;">
					<header class="module-hd">
						<h1>基本信息</h1>
					</header>
					<div class="module-bd">
						<div style="padding-left:10px;font-size: 12px;line-height: 30px;margin-bottom: 5px;position: relative;display: block;">
							<div style="float:left;width:100px;text-align:right;color:#808080;">用户名：</div>
							<div style="align:left;">${frontUser.userName}</div>
						</div>
						<div style="padding-left:10px;font-size: 12px;line-height: 30px;margin-bottom: 5px;position: relative;display: block;">
							<div style="float:left;width:100px;text-align:right;color:#808080;">密码：</div>
							<div style="align:left;">******</div>
						</div>
					</div>
				</div>
			</div>
			<div style="float:left;width:30%;">
				<br clear="all">
				<div class="module" id="signin" style="width: 100%;">
					<header class="module-hd">
						<h1>${frontUser.userName}</h1>
					</header>
					<div class="module-bd">
						<div style="padding-left:10px;">个性的我，成就梦想！！！</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

	<footer id="footer">
		<div class="inner cf">
			<p id="copyright">© 2013 ShareTea</p>
		</div>
	</footer>
</body>
</html>
