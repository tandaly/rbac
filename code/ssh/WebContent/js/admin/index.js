//加载js
app_checkloadjscssfile("js/admin/changeSkin.js", "js"); 

/* 本页自定义css */
app_checkloadjscssfile("css/admin/index.css", "css");

//app_checkloadjscssfile("plugins/ztree/js/jquery.ztree.core-3.2.js", "js");
//app_checkloadjscssfile("plugins/ztree/css/zTreeStyle.css", "css");


//初始化皮肤
//app_initWebSkin();


$(function(){
	showAppTime();
	setInterval(showAppTime,1000);
});

//显示系统当前日期
function showAppTime()
{
	$('#app_time').html(new Date().toLocaleString());
	//+' 星期'+'日一二三四五六'.charAt(new Date().getDay()));
}

/*使用iframe标签，延迟加载跨域JS文件*/
$(window).load(function(){	
	var defaultHome = "admin/home.do";
	$("#mainFrame").attr("src",defaultHome);
	$("#mainFrame").show();
	
});


function turnPage(url)
{
	$("#mainFrame").attr("src",url);
	//$("#mainFrame").show();
}

/*菜单切换*/
function switchFolder(ad)
{
	$("#"+ ad).parent().parent().children().attr("class", "fs");
	$("#"+ ad).parent().attr("class", "fn");
}

function clickMenu(obj)
{
	$(obj).parent().parent().children().attr("id", "");
	$(obj).parent().attr("id", "current");
}

function previousChange(_asId)
{
	var _self = arguments.callee;

	if ( !_self.lock )
	{
		_self.lock = true;

		_self.waitId = -1;

				if (_asId > 1000000)
		{
			changeStyle(_asId, "javascript:;");
		}
		else
		{
			changeStyle(_asId);
		}

		setTimeout(function()
		{ 
			_self.lock = false; 
			if (_self.waitId != -1)
			{
				previousChange(_self.waitId);
			}
		}, 500);
	}
	else
	{
		_self.waitId = _asId;
	}
}


$(function(){
	addTopMenuEvent();//添加顶级菜单样式切换单击监听事件
});

/*顶级菜单操作*/
function addTopMenuEvent()
{
	var $topMenuUl = $("#topMenuUl li a");
	
	$topMenuUl.each(function(){
		this.setAttribute("target", "mainFrame");//指定连接显示目标
		this.setAttribute("title", $.trim($(this).children().text()));
	});
	
	$topMenuUl.click(function(){
		$(this).parent().siblings().attr("id", "");//设置所有菜单id为空
		$(this).parent().attr("id", "current");
	});
}