<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base
	href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
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
<script type="text/javascript" src="js/common/drag.js"></script>
<script type="text/javascript" src="js/front/system/index.js"></script>

<style type="text/css">
.qz_dialog_layer {
	border: 1px solid #999;
	position: absolute;
	box-shadow: 0 0 5px #535658;
	font-size: 12px;
	border-radius: 5px;
}

.qz_dialog_layer_title {
	height: 31px;
	border-bottom: 1px solid #E5E5E5;
	background: #F3F3F3;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.qz_dialog_layer_title h3 {
	float: left;
	height: 31px;
	color: #4C4C4C;
	font-size: 12px;
	line-height: 31px;
	overflow: hidden;
	margin: 0;
	padding-left: 10px;
	font-weight: bold;
	text-shadow: 0 1px 1px #FFF;
}

.qz_dialog_layer_cont {
	color: #5F5F5F;
	background-color: white;
}

.qz_dialog_layer_title .qz_dialog_btn_close {
	background-color: transparent;
	background-image: url(images/close.png);
	background-position: 10px 11px;
	background-repeat: no-repeat;
	border: 0 none;
	cursor: pointer;
	float: right;
	font-size: 0;
	height: 28px;
	line-height: 100px;
	width: 30px;
	position: relative;
}
</style>

<style type="text/css">
	#page_mask {
		display: none;
		position: fixed;
		top: 0%;
		left: 0%;
		width: 100%;
		height: 100%;
		background-color: black;
		z-index: 6000;
		-moz-opacity: 0.3;
		opacity: .30;
		filter: alpha(opacity = 30);
	}
</style>

</head>
<body>

	<header id="header">
		<div class="inner cf">
			<a href="#" class="logo"> <img src="images/logo.png"
				style="width: 100px; height: 100px;" />
			</a> <span class="slogan"><img src="images/nuli.gif"/></span> <span
				style="float: left; margin: 23px 0 0 10px; padding: 30px 0 0 10px;">
				<a href="front/index.htm" class="signin-btn">首页</a>
			</span> <span
				style="float: left; margin: 23px 0 0 10px; padding: 30px 0 0 10px;">
				<a href="front/index.htm" class="signin-btn">社区</a>
			</span> <span
				style="float: left; margin: 23px 0 0 10px; padding: 30px 0 0 10px;">
				<a href="javascript:;" onclick="login();" class="signin-btn">数据</a>
			</span>
			<nav class="top-nav">
				<ul>
					<li><c:if test="${frontUser==null}">
							欢迎您，游客!
							<script type="text/javascript" src="js/front/system/login.js"></script>
							<div class="qz_dialog_layer"
								style="display: none; z-index: 9001; position: absolute; top: 200px; left: 394px; width: 402px; -webkit-transition: top;"
								id="page_dialog">
								<div id="dialog_main_1" class="qz_dialog_layer_main">
									<div id="page_dialog_title" class="qz_dialog_layer_title"
										style="cursor: move;">
										<h3 id="dialog_title_1">登录</h3>
										<button id="page_dialog_close" title="关闭"
											class="qz_dialog_btn_close">
											<span class="none">╳</span>
										</button>
									</div>
									<div id="dialog_content_1" class="qz_dialog_layer_cont"
										style="height: 204px;">





										<div class="module-bd">
											<form accept-charset="UTF-8" action="" onsubmit="return login()"
												class="form-horizontal" id="loginForm" method="post">
												<div class="control-group" align="center">
													<font color="red" id="errorMsg">&nbsp;</font>
												</div>
												<div class="control-group">
													<label class="control-label" for="user_login"> <font
														color="red">*</font> <spring:message code="username"></spring:message>：
													</label>
													<div class="controls">
														<input autofocus="autofocus" class="input-large"
															id="user_login" name="userName" size="30" type="text">


													</div>
												</div>
												<div class="control-group">
													<label class="control-label" for="user_password"> <font
														color="red">*</font> <spring:message code="password"></spring:message>：
													</label>
													<div class="controls">
														<input class="input-large" id="user_password"
															name="password" size="30" type="password">
													</div>
												</div>
												<div align="center">
													<input class="btn-large btn-primary" name="commit"
														type="submit"
														value="<spring:message code="login"></spring:message>">
												</div>
											</form>
										</div>







									</div>
								</div>
							</div>
							<div id="page_mask"></div>
						</c:if> <c:if test="${frontUser != null}">
							当前登陆人：<a href="front/fetchFrontUser/${frontUser.id}.htm"><font
								color="red">${frontUser.userName}</font></a>
						</c:if></li>
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
				<c:if test="${frontUser ==null}">
					<a href="javascript:;"
						onclick="javascript:$('#page_mask').css({display:'block'});$('#page_dialog').css({display:'block'});"
						class="signin-btn">登陆</a>
				</c:if>
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
		<!-- <div class="header row-fluid">
			<div class="span3">
			</div>
			<div class="span6" style="padding-top: 20px; margin-left: 0px;">
				<ul class="mainnavs" style="margin-left: 0px;">
					<li><a href="#" id="nav-index"
						class="youarehere">首页</a></li>
					<li><a href="#" id="nav-share">分享</a></li>
				</ul>
			</div>
		</div>
		<br/>
		<br/> -->

		<div class="row-fluid">
			<div class="span10">
				<div class="row-fluid" id="mood-textarea">
					<form id="publishMoodForm" name="publishMoodForm" onsubmit="return publishMood()"
						action="front/publishFrontMood.htm" method="post">
						<input type="text" id="publishContent" name="publishContent"
							class="input-large"
							style="width: 672px; height: 30px; float: left;"
							placeholder="发表心情"/>
						<input type="submit" class="btn-large btn-primary"
							style="float: left; margin-top: 1px; margin-left: 20px;" value="发表"/>
					</form>
				</div>


				<br clear="all">
				<div class="module" id="signin" style="width: 96%;">
					<header class="module-hd">
						<h1>社区动态</h1>
					</header>
					<div class="module-bd">
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
				<br clear="all"> <br clear="all">
				<div class="module" id="signin" style="width: 96%;">
					<header class="module-hd">
						<h1>社区动态</h1>
					</header>
					<div class="module-bd">
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>

				<br clear="all">
				<div class="module" id="signin" style="width: 96%;">
					<header class="module-hd">
						<h1>社区动态</h1>
					</header>
					<div class="module-bd">
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						<table style="padding: 15px;">
							<tbody>
								<tr>
									<td rowspan="4" width="60px"><img alt=""
										src="images/logo.png" width="90" height="63"></td>
								</tr>
								<tr>
									<td>
										<div class="event_desc">
											<a href="#" class="">zhangsan</a><span></span><span>回家</span><span
												style="float: right">3 天 前</span>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="title">
											<h4>
												<a href="#"> 回家过年咯</a>
											</h4>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="span2">

				<div>
					<h3>最新心情</h3>
					<c:forEach items="${frontMoods}" var="fm">
						<div class="margin-bottom10 mood">
							<img alt="${fm.frontUser.id}的心情" width="16" height="16"
								src="demo/index_files/heart.png"><span>${fm.publishContent}</span>
							<p>
								<a href="#"><font color="green">${fm.frontUser.userName}</font></a>发表于<span
									class="comment-age"><fmt:formatDate
										value="${fm.publishDatetime}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
							</p>
						</div>
					</c:forEach>
				</div>

				<!-- <div>
					<h3>最热分类</h3>
					<div class="categories">
						<a class="category" href="#">ShareTea</a><b>×184</b>
					</div>
					<div class="categories">
						<a class="category" href="#">2013</a><b>×124</b>
					</div>
				</div>
				<div>
					<h3>最热标签</h3>
					<div>
						<a class="post-tag" href="#">抢票</a><b>×207</b>
					</div>
					<div>
						<a class="post-tag" href="#">新年</a><b>×46</b>
					</div>
				</div> -->
			</div>
		</div>
	</div>


	<footer id="footer">
		<div></div> 
		<div class="inner cf">
			<p id="copyright">
				<img src="images/nuli.gif"/>
				<br/>© 2013
			</p>
		</div>
	</footer>
</body>
</html>
