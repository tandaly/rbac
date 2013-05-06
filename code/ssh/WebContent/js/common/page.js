var myPagination;
$(function(){
	/*遮罩层 */
	var _queryMask= '<div id="_queryMask" class="editor_mask opa50Mask " style="z-index: 98; display: none;" tabindex="0"></div>';
	$("body").append(_queryMask);
	/*查询提示*/
	var _queryTip = '<div id="_queryTip"  style="position: absolute;z-index: 1120;cursor: wait;left: 382px;top: 154px;width: auto;height: 16px;padding: 12px 5px 10px 30px;background: #fff no-repeat scroll 5px 10px;border: 2px solid #6593CF;color: #222;display: none;font-size:12px;">正在查询，请稍候！</div>';
	$("body").append(_queryTip);

});

/*初始化分页*/
function initPage(url, callback)
{

	var formData = $("#queryForm").serialize(); //序列化表单
    formData = decodeURIComponent(formData, true);	//解码
	myPagination = $("#pageDiv").myPagination({
		ajax: 
		{
		  on: true,
		  url: url,
		  dataType: 'json',
		  param:formData,
		  ajaxStart:function(){
			  $("#_queryMask").css("display", "block");
			  $("#_queryTip").css("display", "block");
		  },onClick:function(page){
			  $.fn.debug(page);
		  },
		  callback:function(data){
			 $("#_queryMask").css("display", "none");
			 $("#_queryTip").css("display", "none");
			 
			 var result = data.result;
			 $.fn.debug(data.result);
			 var tableDataHtml = "";
			
			if(result.length == 0)
			{
				tableDataHtml = "<tr><td colspan='5' style='text-align:center;color:red;'>查询无记录</td></tr>";
			}else
			{
				if(typeof(callback) == "function")
					tableDataHtml += callback(result);
			}
			 
			 $("#tablePage > tbody").html(tableDataHtml);//填充表格数据
			 $('#tablePage > tbody > tr:even').addClass('a1'); //奇偶变色，添加样式 
		  }
		}
	});
}