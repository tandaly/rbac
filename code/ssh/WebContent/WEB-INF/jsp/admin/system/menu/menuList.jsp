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
					  url: "frame/ajaxMenuList.do",
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
				if(null != obj.parentNo)
				{
					tr += "<td>"+obj.parentNo+"</td>";
				}else
				{
					tr += "<td>--</td>";
				}
				tr += "<td>"+obj.menuNo+"</td>";
				tr += "<td>"+obj.menuName+"</td>";
				if(null != obj.menuUrl)
				{
					tr += "<td>"+obj.menuUrl+"</td>";
				}else
				{
					tr += "<td>--</td>";
				}
				tr += "<td>"+obj.orderNo+"</td>";
				if(null != obj.remark)
				{
					tr += "<td>"+obj.remark+"</td>";
				}else
				{
					tr += "<td>--</td>";
				}
				tr += "<td style=\"text-align: center;\" width=\"160px;\">"
					+"<a href=\"frame/toUpdateMenu.do?id="+obj.id+"\">修改</a>&nbsp;&nbsp;<a href=\"javascript:deleteMenu("+obj.id+")\">删除</a>"
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
			
			function deleteMenu(id)
			{
				if(confirm('你是否要删除该记录?'))
				{
					$.ajax({
						type: "post",
						url: "frame/deleteMenu.do?id="+id,
						success: function(data)
						{
							var result = data;
							if("success" == result)
							{
								alert("删除菜单成功！");
								location.href=location.href;
							}
							else
							{
								alert("删除菜单失败！");
							}
						},
						error: function()
						{
							alert("删除菜单失败");
						}
					});
				}
			}
		</script>
	</head>
	<body>
		<div class="toolbg toolbgline toolheight nowrap">
			<div class="nowrap left">
				<a class="btn_gray btn_space" href="javascript:location.href='${pageContext.request.contextPath}/frame/toAddMenu.do?parentNo='+$('#parentNo').val();">新增</a>
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
					<input type="hidden" name="parentNo" id="parentNo" value="${parentNo}"/> 
					菜单名：<input name="menuName" /> 
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
					<th class="o_title2">父菜单编号</th>
					<th class="o_title2">菜单编号</th>
					<th class="o_title2">菜单名</th>
					<th class="o_title2">请求路径</th>
					<th class="o_title2">排序号</th>
					<th class="o_title2">备注</th>
					<th style="text-align: center;" width="160px;">操作</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
		<div id="pageDiv"></div>
	<div>
		
	</div>
	
	<!-- 遮罩层 -->
	<div id="_queryMask" class="editor_mask opa50Mask "
		style="z-index: 98; display: none;" tabindex="0">
			
	</div>
	<div id="_queryTip"  style="position: absolute;z-index: 1120;cursor: wait;left: 382px;top: 154px;width: auto;height: 16px;padding: 12px 5px 10px 30px;background: #fff no-repeat scroll 5px 10px;border: 2px solid #6593CF;color: #222;display: none;font-size:12px;">正在查询，请稍候！</div>
	
	
	
</body>
</html>