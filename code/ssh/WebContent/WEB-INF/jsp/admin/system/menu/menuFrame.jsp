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
		<title>菜单列表</title>
		<!-- 自定义公共js -->
		<script type="text/javascript" src="js/frame/application.js"></script>
		
		<!-- bootstrap -->
		<link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
		<script src="plugins/bootstrap/js/bootstrap.js" type="text/javascript"></script>
		
			
	<link rel="stylesheet" href="plugins/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="plugins/ztree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="plugins/ztree/js/jquery.ztree.core-3.2.js"></script>
	
		<script type="text/javascript">
			var treeObj;//菜单树
			var selectTreeNode;//选中的结点
			
			var setting = {
				data: {
					simpleData: {
						enable: true,	//设置是否使用简单数据模式(Array)
						idKey: "treeId",	//设置节点唯一标识属性名称
						pIdKey: "parentId"		//设置父节点唯一标识属性名称
					},
					key: {
						name: "name",
						title: "name"				
					}
				},
				async: {
					enable: false,//开启异步加载
					url:"frame/ajaxGetSysLeftMenuTreeChild.do",//设置异步获取节点的 URL 地址
					autoParam:["treeId"]//设置父节点数据需要自动提交的参数
				},
				callback: {
					onClick: function (event, treeId, treeNode){
						selectTreeNode = treeNode;
						//turnPage(treeNode.linkUrl);
						var obj = $("#rightFrame").contents().find("#parentNo");
						if(obj.val())
						{
							obj.val(treeNode.treeId == null?"1":treeNode.treeId);
							$("#rightFrame").contents().find("#queryForm").submit();
						}
						else
						{
							$("#rightFrame").attr("src", "frame/toMenuList.do?parentNo="+(treeNode.treeId == null?"1":treeNode.treeId));
						}
						
					}
				}
			};
			
			//初始化树
			function initTree() {
				$.ajax({  
			   		type: 'POST',  
			   		dataType : "json",
			   		async:false,
			   		url: "frame/ajaxGetMenusTree.do",//请求的action路径
			   		data: {"flag":true},  
			   		error: function () {//请求失败处理函数  
			       		alert('请求失败');  
			   		},
			   		success:function(data){ //请求成功后处理函数。  
			       		treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes    
			       		treeObj = $.fn.zTree.init($("#menusTree"), setting, treeNodes);		
			   		}  
			   		
				});   				
			}
	
			$(document).ready(function(){
				initTree();
			});
		</script>
		
	</head>
	<body>
		<div class="txt_title">
				系统管理&gt;权限管理&gt;菜单管理&gt;菜单列表 
				<span id="_ut" class="f_size normal black">
					(页面响应时间: <font color="red" id="responseTime">${responseTime}</font>ms )
				</span>
		</div>
		
		<div style="width:100%;height:100%;">
			<div style="float:left; overflow-y: auto; overflow-x: auto;">
				<ul id="menusTree" class="ztree"></ul>
			</div>
			<div id="rightFrameContainer">
				<iframe onload="" name="rightFrame" id="rightFrame"
					style="display: ;" src="frame/toMenuList.do?parentNo=1" frameborder="no" scrolling="auto"
					hidefocus=""></iframe>
			</div>
		</div>
	<style type="text/css">
		
#rightFrameContainer {
	/*position: absolute;*/
	height: 500px;
	top: 30px;
	left: 192px;
	bottom: 0;
	right: 0;
	overflow: hidden;
	z-index: 4;
}

#rightFrame {
	width: 100%;
	_width: expression(document.body.offsetWidth -   192 +   'px');
	height: 100%;
	*height: expression(document.body.offsetHeight -   76 +   'px');
	z-index: 5;
}
	</style>
</body>
</html>