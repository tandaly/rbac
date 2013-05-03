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
			<title>添加菜单</title>
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
						url: "admin/system/popedom/menu/addMenu.do",
						data: $("#form").serialize(),
						dataType: "json",
						success: function(data){
							var msgTip = "";
							var result = data.msg;
							if(result == "hasNull")
							{
								msgTip = "菜单名不能为空!";
							}else if(result == "exist")
							{
								msgTip = "该菜单已存在!";
							}else if(result == "success")
							{
								var newNode = {treeId:$("#menuNo").val(), parentId:$("#parentNo2").val(), name:$("#menuName").val()};
								parent.treeObj.addNodes(parent.selectTreeNode, newNode);
								location.href="${pageContext.request.contextPath}/admin/system/popedom/menu/toMenuList.do?parentNo=${parentNo}";
							}else
							{
								msgTip = "添加菜单失败!";
							}
							if("" != msgTip)
							{
								$("#msg").css("display", "block").html(msgTip);
							}
							
						}
					});
					return false;
				}
			</script>
	</head>
	<body>
		<div style="height: 100%; _overflow-y: hidden;" class="bd" id="box">
			<div class="tipstitle_title bd settingtable bold"
				style="border-width: 0 0 1px 0; padding-top: 5px; padding-left: 8px; padding-right: 8px; height: 23px;">
				<span id="todaybarTitle" style="display: block;">新增菜单&nbsp;</span>
			</div>
			<div style="padding: 12px;">
				<form name="form" id="form" class="form-horizontal" onsubmit="return ajaxSubmitForm()">
					<fieldset>
						<div id="msg" class="alert alert-error" style="display:none;"></div>
						<div class="control-group" >
							<label class="control-label" for="input01">父菜单编号</label>
							<div class="controls">
								<span class="input-xlarge uneditable-input">${parentNo}</span>
								<input type="hidden" id="parentNo2" name="parentNo" value="${parentNo}" />
							</div>
						</div>
						<div class="control-group" >
							<label class="control-label" for="input01">菜单编号</label>
							<div class="controls">
								<span class="input-xlarge uneditable-input">${menuNo}</span>
								<input type="hidden" id="menuNo" name="menuNo" value="${menuNo}" />
							</div>
						</div>
						<div class="control-group" >
							<label class="control-label" for="input01">菜单名</label>
							<div class="controls">
								<input type="text" id="menuName" name="menuName" class="input-xlarge" placeholder="请输入菜单名...">
								<span class="help-inline">字母，数字，汉字皆可</span>
							</div>
						</div>
			
						<div class="control-group" >
							<label class="control-label" for="input01">请求路径</label>
							<div class="controls">
								<input type="text" name="menuUrl" class="input-xlarge">
							</div>
						</div>
	
						<div style="margin-left:180px;">
							<input type="submit" class="btn btn-primary" value="确  定" /> <input
								type="reset" class="btn" value="重    置" /> <a class="btn"
								href="admin/toMenuList.do?parentNo=${parentNo}">返回列表</a>
						</div>
	
					</fieldset>
				</form>
			</div>
		</div>
	</body>
</html>