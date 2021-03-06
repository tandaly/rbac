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
			<title>修改用户</title>
			<!-- 自定义公共js -->
			<script type="text/javascript" src="js/admin/application.js"></script>
			
			<!-- bootstrap -->
			<link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet"
				type="text/css" />
			<script src="plugins/bootstrap/js/bootstrap.js" type="text/javascript"></script>
			
			<script type="text/javascript">
				function ajaxSubmitForm()
				{
					$.ajax({
						type: "post",
						url: "admin/system/popedom/user/updateUser.do",
						data: $("#form").serialize(),
						dataType: "json",
						success: function(data){
							var result = data.msg;
							if(result == "hasNull")
							{
								alert("用户名或者密码不能为空");
							}else if(result == "password")
							{
								alert("两次密码不一致");
							}else if(result == "exist")
							{
								alert("该用户名已存在");
							}else if(result == "success")
							{
								alert("成功");
								location.href="admin/system/popedom/user/toUserList.do";
							}else
							{
								alert("失败");
							}
						}
					});
					return false;
				}
			</script>
	</head>
	<body>
		<div class="txt_title">
			系统管理&gt;用户管理&gt;用户列表&gt;修改用户 <span id="_ut"
				class="f_size normal black"> (页面响应时间: <font color="red"
				id="responseTime">${responseTime}</font>秒 )
			</span>
		</div>
	
		<div style="height: 100%; _overflow-y: hidden;" class="bd" id="box">
			<div class="tipstitle_title bd settingtable bold"
				style="border-width: 0 0 1px 0; padding-top: 5px; padding-left: 8px; padding-right: 8px; height: 23px;">
				<span id="todaybarTitle" style="display: block;"><a href="">修改用户</a>&nbsp;</span>
			</div>
			<div style="padding: 12px;">
				<form name="form" id="form" class="form-horizontal" onsubmit="return ajaxSubmitForm()">
					<fieldset>
						<div class="control-group" >
							<label class="control-label" for="input01">用户名</label>
							<div class="controls">
								<span class="input-xlarge uneditable-input">${user.userName}</span>
								<input type="hidden" readonly="readonly" name="id" value="${user.id}">
								<input type="hidden" readonly="readonly" name="userName" value="${user.userName}">
							</div>
						</div>
	
						<!-- <div class="control-group">
							<label class="control-label" for="input01">旧密码</label>
							<div class="controls">
								<input type="password" name="oldPassword" class="input-xlarge"> 
							</div>
						</div> -->
						
						<div class="control-group">
							<label class="control-label" for="input01">新密码</label>
							<div class="controls">
								<input type="password" name="password" class="input-xlarge"> <span
									class="help-inline">请输入六位以上的密码</span>
							</div>
						</div>
	
						<div class="control-group">
							<label class="control-label" for="input01">确认密码</label>
							<div class="controls">
								<input type="password" name="confirmPassword" class="input-xlarge">
							</div>
						</div>
	
						<div style="margin-left:180px;">
							<input type="submit" class="btn btn-primary" value="确定" /> <input
								type="reset" class="btn" value="重    置" /> <a class="btn"
								href="admin/system/popedom/user/toUserList.do">返回列表</a>
						</div>
	
					</fieldset>
				</form>
			</div>
		</div>
	</body>
</html>