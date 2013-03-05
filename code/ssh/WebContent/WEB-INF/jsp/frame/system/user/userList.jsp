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
		<title>用户列表</title>
		<!-- 自定义公共js -->
		<script type="text/javascript" src="js/frame/application.js"></script>
		
		<!-- bootstrap -->
		<link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
		<script src="plugins/bootstrap/js/bootstrap.js" type="text/javascript"></script>
		
		
		<!-- 分页控件 -->
		<link href="plugins/page/css/page.css" rel="stylesheet" type="text/css" />
		<script src="plugins/page/js/jquery.myPagination.js" type="text/javascript"></script>
		
		<script type="text/javascript">
			var myPagination;
			$(function(){
				var formData = $("#queryForm").serialize(); //序列化表单
		        formData = decodeURIComponent(formData, true);	//解码
				myPagination = $("#pageDiv").myPagination({
					ajax: 
					{
					  on: true,
					  url: "frame/ajaxUserList.do",
					  dataType: 'json',
					  param:formData,
					  ajaxStart:function(){
						  //ZENG.msgbox.show(" 正在加载中，请稍后...", 6, 10000);
						  $("#_queryMask").css("display", "block");
						  $("#_queryTip").css("display", "block");
					  },onClick:function(page){
						  $.fn.debug(page);
					  },
					  callback:function(data){
						 $("#_queryMask").css("display", "none");
						 $("#_queryTip").css("display", "none");
						//ZENG.msgbox.hide(); //隐藏加载提示
						var result = data.result;
						$.fn.debug(data.result);
						var insetViewData = "";
						
						if(result.length == 0)
						{
							insetViewData = "<tr><td colspan='5' style='text-align:center;color:red;'>查询无记录</td></tr>";
						}else
						{
							 $.each(result, function(i) {
									insetViewData += createTR(i+1, result[i]);
								 });	
						}
						
						 
						 $("#table > tbody").html(insetViewData);
						 //$('#mytab > tbody > tr:even').addClass('a1'); //奇偶变色，添加样式 
					  }
					}
				});
		        
				
				
			});
			
			function createTR(no, obj)
			{
				var tr = "<tr>";
				tr += "<td><input type=\"checkbox\"></td>";
				tr += "<td style='text-align:center;'>"+no+"</td>";
				tr += "<td>"+obj.userName+"</td>";
				tr += "<td>"+obj.password+"</td>";
				tr += "<td style=\"text-align: center;\" width=\"160px;\">"
					+"<a href='' >授权</a>"
					+"<a href=\"frame/toUpdateUser.do?id="+obj.id+"\">修改</a>&nbsp;&nbsp;<a href=\"javascript:deleteUser("+obj.id+")\">删除</a>"
					+"</td>";
				return tr;
				
			}
			
			function queryFrom(){
				var formData = $("#queryForm").serialize(); //序列化表单
	            formData = decodeURIComponent(formData, true);	//解码
				$.fn.debug("开始指定加载");
				myPagination.onLoad({param:formData});
				$.fn.debug("结束指定加载");
				return false;
			};
			
			function deleteUser(id)
			{
				if(confirm('你是否要删除该记录?'))
				{
					$.ajax({
						type: "post",
						url: "frame/deleteUser.do?id="+id,
						success: function(data)
						{
							var result = data;
							if("success" == result)
							{
								alert("删除用户成功！");
								location.href=location.href;
							}
							else
							{
								alert("删除用户失败！");
							}
						},
						error: function()
						{
							alert("删除用户失败");
						}
					});
				}
			}
		</script>
	</head>
	<body>
		<div class="txt_title">
				系统管理&gt;用户管理&gt;用户列表 
				<span id="_ut" class="f_size normal black">
					(页面响应时间: <font color="red" id="responseTime">${responseTime}</font>秒 )
				</span>
			</div>
			
		<div class="toolbg toolbgline toolheight nowrap">
			<div class="nowrap left">
				<a class="btn_gray btn_space" href="frame/toAddUser.do">新增</a>
				<a class="btn_gray btn_space" href="javascript:;">修改</a>
				<a class="btn_gray btn_space" href="javascript:;">删除</a>
				<a class="btn_gray btn_space" href="javascript:void(0);" onclick="javascript:$(this).text($('#queryDiv').css('display') == 'none'?'隐藏查询':'显示查询');$('#queryDiv').toggle();">显示查询</a>
			</div>
		</div>
		<div id="queryDiv" style="display:none;height: 100%; _overflow-y: hidden;" class="bd"
			>
			<div style="padding-left:2px;padding-top:5px;text-align:center;">
				<form id="queryForm" name="queryForm" onsubmit="return queryFrom()">
					<input type="hidden" name="pageSize" value="10"/>
					用户名：<input name="userName" /> 
					&nbsp;
					密码：<input name="password" /> 
					<input value="查询" type="submit" class="btn_gray btn_space"/>
					<input value="清空" type="reset" class="btn_gray btn_space"/>
				</form>
			</div>
		</div>
		<table id="table" class="table table-striped table-bordered table-condensed" 
		style="table-layout: fixed; width: 100%; * width: auto;margin-bottom: 2px;">
			<thead>
				<tr >
					<th style="padding: 1px 0 6px 5px;" width="27">
							<input type="checkbox"
								title="选中/取消选中">
					</th>
					<th style="text-align: center;" width="60px;">序号</th>
					<th class="o_title2">用户名</th>
					<th class="o_title2">密码</th>
					<th style="text-align: center;" width="160px;">操作</th>
				</tr>
			</thead>
			<tbody>
				<%-- <c:forEach items="${pages.list}" var="user" varStatus="st">
				<tr>
					<td>
					<input type="checkbox">
					</td>
					<td>${st.count}</td>
					<td>${user.userName}</td>
					<td>${user.password }</td>
					<td style="text-align: center;" width="160px;">
						<a href="">修改</a>
						<a href="">删除</a>
					</td>
				</tr>
				</c:forEach> --%>
			</tbody>
		</table>
		<div id="pageDiv"></div>
	<div>
		
		<%-- <div style="display:none;">当前页：${pages.pageNo}  当前显示数：${pages.pageSize} 
			总数：${pages.totalCount }  响应时间: ${responseTime}秒 <br /> 
		</div>
		<div>
			<a href="frame/userList.do?pageNo=${pages.prePage}">上一页</a> 
			<a href="frame/userList.do?pageNo=${pages.nextPage}">下一页</a>
		</div> --%>
	</div>
	
	<!-- 遮罩层 -->
	<div id="_queryMask" class="editor_mask opa50Mask "
		style="z-index: 98; display: none;" tabindex="0">
			
	</div>
	<div id="_queryTip"  style="position: absolute;z-index: 1120;cursor: wait;left: 382px;top: 154px;width: auto;height: 16px;padding: 12px 5px 10px 30px;background: #fff no-repeat scroll 5px 10px;border: 2px solid #6593CF;color: #222;display: none;font-size:12px;">正在查询，请稍候！</div>
	
	
	
</body>
</html>