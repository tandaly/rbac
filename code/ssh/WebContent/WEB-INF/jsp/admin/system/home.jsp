<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<base href="${pageContext.request.scheme}${'://'}${pageContext.request.serverName}${':'}${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="pragma" content="no-cache">
<title>首页</title>
<!-- 自定义公共js -->
<script type="text/javascript" src="js/admin/application.js"></script>
<link href="css/admin/home.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="toolbg toolbgline toolheight nowrap">
		<h1>当前位置: 首页 - 欢迎页</h1>
	</div>
	<div class="body-box">
		<div class="welcom-con">
			<div class="we-txt">
				<p>
					登陆人：${user_in_session.userName }<br /> 角 色：${user.roles[0].roleName}<br />
					欢迎使用RBAC系统！<br /> 程序版本： 2013-开发版 【<a href="javascript(0);"
						target="_blank">查看最新版本</a>】<br /> 您上次登录的时间是：<br /> 已用内存：<span
						style="color: #0078ff;">0MB</span>&nbsp;&nbsp;&nbsp;&nbsp;剩余内存： <span
						style="color: #ff8400;">0MB </span> &nbsp;&nbsp;&nbsp;&nbsp;最大内存：<span
						style="color: #00ac41;">0MB</span>
				</p>
			</div>
			<ul class="ms">
				<li class="wxx">访问量</li>
				<li class="attribute">系统属性</li>
			</ul>
			<div class="ms-xx">
				<div class="xx-xx"></div>
				<div class="attribute-xx" style="float: left">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="30%" height="30" align="right">操作系统版本：</td>
							<td height="30"><span class="black">
									<%
										out.print(System.getProperty("os.name"));
									%>
							</span></td>
						</tr>
						<tr>
							<td width="30%" height="30" align="right">操作系统类型：</td>
							<td height="30"><span class="black">32位</span></td>
						</tr>
						<tr>
							<td width="30%" height="30" align="right">用户、目录、临时目录：</td>
							<td height="30"><span class="black">
									<%
										out.print(System.getProperty("java.io.tmpdir"));
									%>
							</span></td>
						</tr>
						<tr>
							<td width="30%" height="30" align="right">JAVA运行环境：</td>
							<td height="30"><span>jdk<%
								out.print(System.getProperty("java.version"));
							%></span></td>
						</tr>
						<tr>
							<td width="30%" height="30" align="right">JAVA虚拟机：</td>
							<td height="30"><span>
									<%
										out.print(System.getProperty("java.runtime.name"));
									%>
							</span></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>